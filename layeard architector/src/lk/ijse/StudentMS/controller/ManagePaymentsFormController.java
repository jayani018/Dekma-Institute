package lk.ijse.StudentMS.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.StudentMS.dao.custom.PaymentsModelDAO;
import lk.ijse.StudentMS.dao.custom.impl.PaymentsModelDAOImpl;
import lk.ijse.StudentMS.model.PaymentsDTO;

import java.io.IOException;
import java.sql.SQLException;

public class ManagePaymentsFormController {
    public AnchorPane pane;
    public TableView Payments;
    public TableColumn cardNo;
    public TableColumn PaymentsM;
    public TableColumn Amount;
    public TableColumn Date;
    public TableColumn Time;
    public JFXTextField txtCardNo;
    public JFXTextField txtPaymentsMonth;
    public JFXTextField txtAmount;
    public JFXTextField txtDate;
    public JFXTextField txtTime;
    public JFXComboBox combStudentId;

    PaymentsModelDAO paymentsModelDAO = new PaymentsModelDAOImpl();

    public void btnAddPayments(ActionEvent actionEvent) throws IOException {
//        PaymentsModelDAO paymentsModelDAO = new PaymentsModelDAOImpl();
        try {
            boolean add = paymentsModelDAO.add(
                    new PaymentsDTO(txtCardNo.getText(),
                            (String) combStudentId.getValue(),
                            txtAmount.getText(),
                            txtPaymentsMonth.getText(),
                            txtTime.getText()
                    ));
            if (add) {
                new Alert(Alert.AlertType.INFORMATION, "Update Employee").show();
            }
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
                            txtCardNo.getText()
                    ));
            if (update) {
                new Alert(Alert.AlertType.INFORMATION, "Update Employee").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void btnDeletePayment(ActionEvent actionEvent) {
        String cardNo = txtCardNo.getText();
        try {
            boolean delete = paymentsModelDAO.delete(cardNo);
            if (delete){
                new Alert(Alert.AlertType.INFORMATION, "Delete Payments").show();
            }else {
                new Alert(Alert.AlertType.ERROR, "Error").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private void cmbLoadData() throws SQLException, ClassNotFoundException {

    }

    public void initialize() {

        tableLoad();
    }

    private void tableLoad() {
    }
}
