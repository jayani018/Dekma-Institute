package lk.ijse.StudentMS.controller;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageEmployeeFormController {
    public AnchorPane pane;
    public TableView table;
    public TableColumn EID;
    public TableColumn NIC;
    public TableColumn Name;
    public TableColumn Address;
    public TableColumn Email;
    public TableColumn CNumber;
    public TableColumn Salary;
    public TableColumn cashOrCard;
    public TableColumn Role;
    public JFXTextField Search;
    public JFXTextField txtId;
    public JFXTextField txtNIC;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtEmail;
    public JFXTextField txtContact;
    public JFXTextField txtSalary;
    public JFXTextField txtCashOrCard;
    public JFXRadioButton RadioButtonTeacher;
    public ToggleGroup jobRole;
    public JFXRadioButton RadioButtonManager;
    public JFXRadioButton RadioButtonOther;
    public JFXTextField txtUserName;
    public JFXTextField txtPassword;
    private String role;



    public void btnAddEmployee(ActionEvent actionEvent) throws IOException {

    }

   public void btnUpdateEmployee(ActionEvent actionEvent) {

   }

    public void btnDeleteEmployee(ActionEvent actionEvent) {
    }
    public void radioButtonOnActionTeacher(ActionEvent actionEvent) {

    }


    public void radioButtonOnActionManager(ActionEvent actionEvent) {

    }


    public void radioButtonOnActionOther(ActionEvent actionEvent) {

    }

        public void initialize () {


        }

    public void btnSearchEmployee(ActionEvent actionEvent) {
    }
    public void searchOnAction(ActionEvent actionEvent) {
    }




    private void tableInit(){

    }
    public void initial(){
        tableInit();
    }

}

