package lk.ijse.StudentMS.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class ManageTeacherFormController {
    public AnchorPane pane;
    public TableColumn TID;
    public TableColumn NIC;
    public TableColumn Name;
    public TableColumn Address;
    public TableColumn Email;
    public TableColumn Salary;
    public JFXTextField Search;
    public JFXTextField txtId;
    public JFXTextField txtNIC;
    public JFXTextField txtSalary;
    public JFXTextField txtName;
    public JFXTextField txtEmail;
    public JFXTextField txtContactNo;
    public JFXTextField txtAddress;
    public JFXComboBox combSubId;
    public TableColumn SUBID;
    public TableColumn CNNumber;
    public TableView tblTeacher;
    public JFXButton btnDelete;
    public JFXButton btnSearch;
    LinkedHashMap<TextField, Pattern> map = new LinkedHashMap<>();


    public void initialize() {

        Pattern patternId = Pattern.compile("^(T0)[0-9]{2,4}$");
        Pattern patternName = Pattern.compile("^[A-z ]{3,}$");
        Pattern patternAddress = Pattern.compile("^[A-z0-9 ,/]{5,}$");
        Pattern patternContact = Pattern.compile("^(071|072|077|076|078|075)[0-9]{7}$");
        Pattern patternNic = Pattern.compile("^[0-9]{9}(v)$");
        Pattern patternSalary = Pattern.compile("^[0-9]{2,}(.00)$");
        Pattern patternEmail = Pattern.compile("^[A-z0-9 ,/]{5,}(@gmail.com)$");

        map.put(txtId, patternId);
        map.put(txtNIC, patternNic);
        map.put(txtName, patternName);
        map.put(txtAddress, patternAddress);
        map.put(txtEmail, patternEmail);
        map.put(txtContactNo, patternContact);
        map.put(txtSalary, patternSalary);


        TID.setCellValueFactory(new PropertyValueFactory<>("TID"));
        SUBID.setCellValueFactory(new PropertyValueFactory<>("SUBID"));
        NIC.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        CNNumber.setCellValueFactory(new PropertyValueFactory<>("Contact"));
        Email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        Salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));


        try {
            cmbLoadData();
            loadTableData();
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    private Object validate() {
        for (TextField key : map.keySet()) {
            Pattern pattern = map.get(key);
            if (!pattern.matcher(key.getText()).matches()) {
                addError(key);
                return key;
            } else
                removeError(key);
        }
        return true;
    }

    public void removeError(TextField text) {
        text.setStyle("-fx-border-color: green");
//        btnModifyBooking.setDisable(false);
    }

    public void addError(TextField text) {
        if (text.getText().length() > 0) {
            text.setStyle("-fx-border-color: red");
        }

    }

    private void loadTableData() {

    }

    private void cmbLoadData() throws SQLException, ClassNotFoundException {

    }

    public void btnAdd(ActionEvent actionEvent) {
        String subId = String.valueOf(combSubId.getValue());
        String id = txtId.getText();
        String NIC = txtNIC.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contactNo = txtContactNo.getText();
        String email = txtEmail.getText();
        double salary = Double.parseDouble(txtSalary.getText());




    }

    public void btnSearch(ActionEvent actionEvent) {
    }

    public void txtSearchOnAction(ActionEvent actionEvent) {

    }

    public void btnUpdate(ActionEvent actionEvent) {

        String subId = String.valueOf(combSubId.getValue());
        String id = txtId.getText();
        String NIC = txtNIC.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contactNo = txtContactNo.getText();
        String email = txtEmail.getText();
        double salary = Double.parseDouble(txtSalary.getText());


    }

    public void btnDelete(ActionEvent actionEvent) {
        String subId = String.valueOf(combSubId.getValue());
        String id = txtId.getText();
        String NIC = txtNIC.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contactNo = txtContactNo.getText();
        String email = txtEmail.getText();
        double salary = Double.parseDouble(txtSalary.getText());
    }
          public void clear() {
        txtId.clear();
        txtNIC.clear();
        txtSalary.clear();
        txtEmail.clear();
        txtName.clear();
        txtAddress.clear();
        txtContactNo.clear();
        combSubId.getSelectionModel().clearSelection();
    }

    public void TextOnKeyRelease(KeyEvent keyEvent) {
        validate();

        if (keyEvent.getCode() == KeyCode.ENTER) {
            Object responds = validate();

            if (responds instanceof TextField) {
                TextField textField = (TextField) responds;
                textField.requestFocus();
            } else {
//                btnAdd();
            }
        }
    }
}