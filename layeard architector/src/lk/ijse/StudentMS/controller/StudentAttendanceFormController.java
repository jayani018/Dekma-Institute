package lk.ijse.StudentMS.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;


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


    public void btnAddSA(ActionEvent actionEvent) {



    }

    public void btnUpdateSA(ActionEvent actionEvent) {
    }

    public void btnDeleteSA(ActionEvent actionEvent) {
    }

    private void cmbLoadData() {}

    public void initialize(){
        cmbLoadData();
    }
}
