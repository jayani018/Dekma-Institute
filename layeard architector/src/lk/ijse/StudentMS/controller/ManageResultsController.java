package lk.ijse.StudentMS.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.StudentMS.bo.custom.Impl.ResultsBOImpl;
import lk.ijse.StudentMS.dao.custom.PaymentsModelDAO;
import lk.ijse.StudentMS.dao.custom.impl.PaymentsModelDAOImpl;

import java.io.IOException;

public class ManageResultsController {
    public AnchorPane pane;
    public TableView Results;
    public TableColumn SID;
    public TableColumn SubID;
    public TableColumn Result;
    public TableColumn PassORFail;
    public JFXTextField Search;

    PaymentsModelDAO paymentsModelDAO = new PaymentsModelDAOImpl();
    ResultsBOImpl resultsBO = new ResultsBOImpl();
    public void btnAddResult(ActionEvent actionEvent) throws IOException {
        //PaymentsModelDAO paymentsModelDAO = new PaymentsModelDAOImpl();


    }

    public void btnUpdateResult(ActionEvent actionEvent) {
    }

    public void btnDeleteResult(ActionEvent actionEvent) {
    }

    public void searchOnAction(ActionEvent actionEvent) {
    }

    public void btnSearch(ActionEvent actionEvent) {
    }
}
