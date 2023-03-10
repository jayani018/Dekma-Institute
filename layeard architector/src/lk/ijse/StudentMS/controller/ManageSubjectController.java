package lk.ijse.StudentMS.controller;

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
import lk.ijse.StudentMS.bo.custom.Impl.SubjectBOImpl;
import lk.ijse.StudentMS.model.SubjectDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageSubjectController {
    public AnchorPane pane;
    public TableView tblStudents;
    public TableColumn SubId;
    public TableColumn Name;
    public JFXTextField Search;
    public JFXTextField txtSubId;
    public JFXTextField txtName;
    public TableColumn Name1;

   // SubjectModelDAO subjectModelDAO = new SubjectModelDAOImpl();
    //SubjectBOImpl subjectBO = new SubjectBOImpl();
    SubjectBOImpl subjectBO = (SubjectBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOType.SUBJECT);

    public void btnAddSubject(ActionEvent actionEvent) throws IOException {
//        SubjectModelDAO subjectModelDAO = new SubjectModelDAOImpl();
        try {
            boolean add = subjectBO.addSubject(
                    new SubjectDTO(txtSubId.getText(),
                    txtName.getText()
            ));
            if (add) {
                new Alert(Alert.AlertType.INFORMATION, "Add Employee").show();
            }
            loadTableData();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void btnUpdateSubject(ActionEvent actionEvent) {
        try {
            boolean update = subjectBO.updateSubject(new SubjectDTO(
                    txtSubId.getText(),
                    txtName.getText()
            ));
            if (update) {
                new Alert(Alert.AlertType.INFORMATION, "Update Suject").show();
            }
            loadTableData();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void btnDeleteSubject(ActionEvent actionEvent) {
        String id = txtSubId.getText();
        try {
            boolean delete = subjectBO.deleteSubject(id);
            if (delete) {
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Delete is successful");
                alert.show();
            }else {
                Alert alert=new Alert(Alert.AlertType.ERROR,"Error");
                alert.show();
            }
            loadTableData();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void txtSearchOnAction(ActionEvent actionEvent) {


    }

    public void btnSearch(ActionEvent actionEvent) {
        try {
            SubjectDTO search = subjectBO.searchSubject(Search.getText());
            if (search==null){
                new Alert(Alert.AlertType.INFORMATION,"Not Employee").show();
            }else {
                txtSubId.setText(search.getSUBID());
                txtName.setText(search.getSubName());
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    private void loadTableData() {
        ObservableList<SubjectDTO> SubjectList = FXCollections.observableArrayList();
        try {
            ArrayList<SubjectDTO> subjectData = subjectBO.getAllSubject();
            for (SubjectDTO subject : subjectData) {
                SubjectList.add(subject);
            }
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
        tblStudents.setItems(SubjectList);

    }
    public void initialize() {
        SubId.setCellValueFactory(new PropertyValueFactory<>("SUBID"));
        Name.setCellValueFactory(new PropertyValueFactory<>("SubName"));

        loadTableData();
    }
}
