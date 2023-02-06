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
import lk.ijse.StudentMS.bo.custom.Impl.BatchBOImpl;
import lk.ijse.StudentMS.dao.custom.impl.StudentModelDAOImpl;
import lk.ijse.StudentMS.model.BatchDTO;
import lk.ijse.StudentMS.model.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class BatchFormController {
    public AnchorPane pane;
    public TableView tblStudentBatch;
    public TableColumn BID;
    public TableColumn Year;
    public TableColumn SID;
    public JFXTextField Search;
    public JFXComboBox combStudentId;
    public JFXTextField txtBatchId;
    public JFXTextField txtYear;

   //BatchModelDAO batchModelDAO = new BatchModelDAOImpl();
    StudentModelDAOImpl studentModelDAO = new StudentModelDAOImpl();
//    BatchBOImpl batchBO = new BatchBOImpl();

    BatchBOImpl batchBO = (BatchBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOType.BATCH);

    public void btnAddBatch(ActionEvent actionEvent) {

//        BatchModelDAO batchModelDAO = new BatchModelDAOImpl();
        try {
            boolean add = batchBO.addBatch(new BatchDTO( txtBatchId.getText(),
                    (String) combStudentId.getValue(),
                    txtYear.getText()
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

    public void btnDeleteBatch(ActionEvent actionEvent) {
        String id = txtBatchId.getText();
        try {
            boolean delete = batchBO.deleteBatch(id);
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

    public void btnUpdateBatch(ActionEvent actionEvent) {
        try {
            boolean update = batchBO.updateBatch(new BatchDTO(txtBatchId.getText(),(String) combStudentId.getValue(),
                    txtYear.getText()
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

    public void btnSearch(ActionEvent actionEvent) {
        try {
            BatchDTO search =batchBO.searchBatch(Search.getText());
            if (search == null) {
                new Alert(Alert.AlertType.INFORMATION, "Not Employee").show();
            } else {
                combStudentId.setValue(search.getSID());
                txtBatchId.setText(search.getBID());
                txtYear.setText(search.getYear());
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }


    public void txtSearchOnAction(ActionEvent actionEvent) {
    }


    public void initialize() {
        BID.setCellValueFactory(new PropertyValueFactory<>("BID"));
        Year.setCellValueFactory(new PropertyValueFactory<>("year"));
        SID.setCellValueFactory(new PropertyValueFactory<>("SID"));
        loadComboBox();
        loadTableData();
    }

    private void loadTableData() {
        ObservableList<BatchDTO> BatchList = FXCollections.observableArrayList();
        try {
            ArrayList<BatchDTO> batchData = batchBO.getAllBatch();
            for (BatchDTO batch : batchData) {
                BatchList.add(batch);
            }
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
        tblStudentBatch.setItems(BatchList);

    }

    private void loadComboBox() {
        try {
           // StudentModelDAOImpl studentModelDAO = new StudentModelDAOImpl();
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
}
