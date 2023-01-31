package lk.ijse.StudentMS.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.StudentMS.dao.custom.PaymentsModelDAO;
import lk.ijse.StudentMS.dao.custom.impl.PaymentsModelDAOImpl;

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


    public void btnAddPayments(ActionEvent actionEvent) throws IOException {
        PaymentsModelDAO paymentsModelDAO = new PaymentsModelDAOImpl();
        paymentsModelDAO.add()
    }

    public void btnUpdatePayment(ActionEvent actionEvent) {

    }

    public void btnDeletePayment(ActionEvent actionEvent) {

    }

    private void cmbLoadData() throws SQLException, ClassNotFoundException {

    }

    public void initialize(){


    }

    private void tableLoad() {
    }
}
