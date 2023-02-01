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
import lk.ijse.StudentMS.dao.custom.PaymentsModelDAO;
import lk.ijse.StudentMS.dao.custom.impl.PaymentsModelDAOImpl;
import lk.ijse.StudentMS.dao.custom.impl.StudentModelDAOImpl;
import lk.ijse.StudentMS.model.PaymentsDTO;
import lk.ijse.StudentMS.model.StudentDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManagePaymentsFormController {
    public AnchorPane pane;
    public TableView Payments;
    public TableColumn cardNo;
    public TableColumn PaymentsM;
    public TableColumn Amount;
    public TableColumn Time;
    public JFXTextField txtCardNo;
    public JFXTextField txtPaymentsMonth;
    public JFXTextField txtAmount;
    public JFXTextField txtTime;
    public JFXComboBox combStudentId;
    public JFXTextField txtDate;
    public TableColumn Date;

    PaymentsModelDAO paymentsModelDAO = new PaymentsModelDAOImpl();
    StudentModelDAOImpl studentModelDAO = new StudentModelDAOImpl();

    public void btnAddPayments(ActionEvent actionEvent) throws IOException {
//        PaymentsModelDAO paymentsModelDAO = new PaymentsModelDAOImpl();
        try {
            boolean add = paymentsModelDAO.add(
                    new PaymentsDTO(
                            (String) combStudentId.getValue(),
                            txtCardNo.getText(),
                            txtAmount.getText(),
                            txtPaymentsMonth.getText(),
                            txtTime.getText(),
                            txtDate.getText()
                    ));
            if (add) {
                new Alert(Alert.AlertType.INFORMATION, "Add Payments").show();
            }
            tableLoad();
            loadComboBox();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void btnUpdatePayment(ActionEvent actionEvent) {
        try {
            boolean update = paymentsModelDAO.update(
                    new PaymentsDTO((String) combStudentId.getValue(),
                            txtAmount.getText(),
                            txtPaymentsMonth.getText(),
                            txtTime.getText(),
                            txtCardNo.getText(),
                            txtDate.getText()
                    ));
            if (update) {
                new Alert(Alert.AlertType.INFORMATION, "Update Payments").show();
            }
            tableLoad();
            loadComboBox();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void btnDeletePayment(ActionEvent actionEvent) {
        String id = txtCardNo.getText();
        try {
            boolean delete = paymentsModelDAO.delete(id);
            if (delete){
                new Alert(Alert.AlertType.INFORMATION, "Delete Payments").show();
            }else {
                new Alert(Alert.AlertType.ERROR, "Error").show();
            }
            tableLoad();
            loadComboBox();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private void cmbLoadData() throws SQLException, ClassNotFoundException {

    }

    public void initialize() {
        cardNo.setCellValueFactory(new PropertyValueFactory<>("CarNo"));
        Amount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        PaymentsM.setCellValueFactory(new PropertyValueFactory<>("payment_months"));
        Time.setCellValueFactory(new PropertyValueFactory<>("Time"));
        Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
        tableLoad();
        loadComboBox();
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
//        ArrayList<String> arrayList = new ArrayList<>();
//            combStudentId.getItems().add("S001");

    }

    private void tableLoad() {
        ObservableList<PaymentsDTO> PaymentsList = FXCollections.observableArrayList();
        try {
            ArrayList<PaymentsDTO> paymentsData = paymentsModelDAO.getAll();
            for (PaymentsDTO payments : paymentsData) {
                PaymentsList.add(payments);
            }
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
        Payments.setItems(PaymentsList);

    }
}
