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

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageSubjectController {
    public AnchorPane pane;
    public TableView tblStudents;
    public TableColumn SubId;
    public TableColumn Name;
    public JFXTextField Search;
    public JFXTextField txtSubId;
    public JFXTextField txtName;
    public TableColumn Name1;

    public void btnAddSubject(ActionEvent actionEvent) throws IOException {

    }

    public void btnUpdateSubject(ActionEvent actionEvent) {

    }

    public void btnDeleteSubject(ActionEvent actionEvent) {
    }

    public void txtSearchOnAction(ActionEvent actionEvent) {

    }

    public void btnSearch(ActionEvent actionEvent) {
    }
}
