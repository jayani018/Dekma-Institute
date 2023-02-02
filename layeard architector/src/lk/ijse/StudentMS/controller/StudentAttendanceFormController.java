package lk.ijse.StudentMS.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.StudentMS.bo.custom.Impl.StudentAttendanceBOImpl;
import lk.ijse.StudentMS.dao.custom.impl.StudentModelDAOImpl;
import lk.ijse.StudentMS.model.StudentAttendanceDTO;
import lk.ijse.StudentMS.model.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentAttendanceFormController {
    public AnchorPane pane;
    public TableView tblStudentAttendance;
    public TableColumn Date;
    public TableColumn Time;
    public JFXComboBox combStudentId;
    public JFXTextField txtTime;
    public JFXTextField txtDate;
    public JFXTextField Search;
    public JFXDatePicker txtdate;

   // StudentAttendanceModelDAO studentAttendanceModelDAO = new StudentAttendanceModelDAOImpl();
    StudentAttendanceBOImpl studentAttendanceBO = new StudentAttendanceBOImpl();

    public void btnAddSA(ActionEvent actionEvent) {
//        StudentAttendanceBOImpl studentAttendanceBO = new StudentAttendanceBOImpl();
//        StudentAttendanceModelDAO studentAttendanceModelDAO = new StudentAttendanceModelDAOImpl();
        try {
            boolean add = studentAttendanceBO.addStudentAttendance(
                    new StudentAttendanceDTO((String) combStudentId.getValue(),
                            txtDate.getText(),
                            txtTime.getText()
                    ));
            if (add) {
                new Alert(Alert.AlertType.INFORMATION, "Add StudentAttendance").show();
            }
            cmbLoadData();
            loadTableData();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void btnUpdateSA(ActionEvent actionEvent) {
        try {
            studentAttendanceBO.updateStudentAttendance(new StudentAttendanceDTO(txtDate.getText(),
                    txtTime.getText(),
                    (String) combStudentId.getValue()
            ));
            cmbLoadData();
            loadTableData();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void btnDeleteSA(ActionEvent actionEvent) {
        Object value = combStudentId.getValue();
        try {
            boolean delete = studentAttendanceBO.deleteStudentAttendance((String) value);
            if (delete) {
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Delete is successful");
                alert.show();
            }else {
                Alert alert=new Alert(Alert.AlertType.ERROR,"Error");
                alert.show();
            }
            cmbLoadData();
            loadTableData();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    private void loadTableData() {
        ObservableList<StudentAttendanceDTO> studentAttendanceList = FXCollections.observableArrayList();
        try {
            ArrayList<StudentAttendanceDTO> studentAttendanceData = studentAttendanceBO.getAllStudentAttendance();
            for (StudentAttendanceDTO studentAttendance : studentAttendanceData) {
                studentAttendanceList.add(studentAttendance);
            }
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
        tblStudentAttendance.setItems(studentAttendanceList);
    }

    private void cmbLoadData() {
        try {
             StudentModelDAOImpl studentModelDAO = new StudentModelDAOImpl();
            ArrayList<StudentDTO> arrayList = studentModelDAO.getAll();

            String[] Student = new String[arrayList.size()];


            ObservableList obList= FXCollections.observableArrayList();
            for (int i = 0; i < Student.length; i++) {
                obList.add(arrayList.get(i).getSID());
            }
            combStudentId.setItems(obList);

        } catch (SQLException | ClassNotFoundException throwables) {
            System.out.println(throwables);
        }
    }


    public void initialize(){
        Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
        Time.setCellValueFactory(new PropertyValueFactory<>("Time"));
        cmbLoadData();
        loadTableData();
    }
}
