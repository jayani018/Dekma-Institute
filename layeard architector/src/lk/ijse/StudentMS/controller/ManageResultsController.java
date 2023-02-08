package lk.ijse.StudentMS.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.StudentMS.bo.BOFactory;
import lk.ijse.StudentMS.bo.custom.Impl.ResultsBOImpl;
import lk.ijse.StudentMS.dao.custom.impl.StudentModelDAOImpl;
import lk.ijse.StudentMS.dao.custom.impl.SubjectModelDAOImpl;
import lk.ijse.StudentMS.model.ResultDTO;
import lk.ijse.StudentMS.model.StudentDTO;
import lk.ijse.StudentMS.model.SubjectDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageResultsController {
    public AnchorPane pane;
    public TableView Results;
    public TableColumn SID;
    public TableColumn SubID;
    public TableColumn Result;
    public TableColumn PassORFail;
    public JFXTextField Search;
    public JFXComboBox combStudentId;public JFXComboBox combSubId;
    public JFXTextField txtResult;
    public JFXTextField txtPF;
    public JFXTextField txtRID;


   // ResultsBOImpl resultsBO = new ResultsBOImpl();
    ResultsBOImpl resultsBO = (ResultsBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOType.RESULT);

   public void btnAddResult(ActionEvent actionEvent) throws IOException {
        //PaymentsModelDAO paymentsModelDAO = new PaymentsModelDAOImpl();
       try {
            boolean add = resultsBO.addResult(new ResultDTO(txtRID.getText(),
                    combStudentId.getValue(),
                    combSubId.getValue(),
                    txtResult.getText()
            ));
            if (add) {
                new Alert(Alert.AlertType.INFORMATION, "Add Employee").show();
                loadTableData();
                loadComboBox();
            } else {
                new Alert(Alert.AlertType.ERROR, "Something Wrong").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }


   }

    public void btnUpdateResult(ActionEvent actionEvent) {
        try {
            boolean update = resultsBO.updateResult(new ResultDTO(txtRID.getText(),combStudentId.getValue(),
                    combSubId.getValue(),
                    txtResult.getText()
            ));
            if (update) {
                new Alert(Alert.AlertType.INFORMATION, "Update Employee").show();
                loadTableData();
                loadComboBox();
            }else {
                new Alert(Alert.AlertType.ERROR, "Something Wrong").show();
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void btnDeleteResult(ActionEvent actionEvent) {
        String id = txtRID.getText();
        try {
            boolean delete = resultsBO.deleteResult(id);
            if (delete) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Delete is successful");
                alert.show();
                loadTableData();
                loadComboBox();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error");
                alert.show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void searchOnAction(ActionEvent actionEvent) {

    }

    public void btnSearch(ActionEvent actionEvent) {
        try {
            ResultDTO search =resultsBO.searchResult(Search.getText());
            if (search == null) {
                new Alert(Alert.AlertType.INFORMATION, "Not Employee").show();
            } else {
                txtRID.setText(search.getTID());
                combStudentId.setValue(search.getSID());
                combSubId.setValue(search.getSUBID());
                txtResult.setText(search.getResult());
            }
            loadComboBox();
            loadTableData();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    private void loadTableData() {
        ObservableList<ResultDTO> ResultList = FXCollections.observableArrayList();
        try {
            ArrayList<ResultDTO> resultData = resultsBO.getAllResult();
            for (ResultDTO result : resultData) {
                ResultList.add(result);
            }
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
        Results.setItems(ResultList);

    }
    private void loadComboBox() {
        try {
            StudentModelDAOImpl studentModelDAO = new StudentModelDAOImpl();
            SubjectModelDAOImpl subjectModelDAO = new SubjectModelDAOImpl();
            ArrayList<StudentDTO> arrayList = studentModelDAO.getAll();
            ArrayList<SubjectDTO> arrayList1 = subjectModelDAO.getAll();

            String[] Student = new String[arrayList.size()];
            String[] Subject = new String[arrayList1.size()];


            ObservableList obList= FXCollections.observableArrayList();
            for (int i = 0; i < Student.length; i++) {
                obList.add(arrayList.get(i).getSID());
                for (int j = 0; j < Subject.length; j++) {
                    obList.add(arrayList1.get(j).getSUBID());
                }
            }
            combStudentId.setItems(obList);
            combSubId.setItems(obList);

        } catch (SQLException | ClassNotFoundException throwables) {
            System.out.println(throwables);
        }
    }
    public void initialize() {
        SID.setCellValueFactory(new PropertyValueFactory<>("SID"));
        SubID.setCellValueFactory(new PropertyValueFactory<>("Sub ID"));
        Result.setCellValueFactory(new PropertyValueFactory<>("Result"));
        PassORFail.setCellValueFactory(new PropertyValueFactory<>("year"));

        loadComboBox();
        loadTableData();
    }
}
