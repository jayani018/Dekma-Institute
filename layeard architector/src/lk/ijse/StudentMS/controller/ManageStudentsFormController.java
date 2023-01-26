package lk.ijse.StudentMS.controller;

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

public class ManageStudentsFormController {


    public TableColumn Stream;
    public TableColumn StudentId;
    public TableColumn NIC;
    public TableColumn Name;
    public TableColumn Address;
    public TableColumn Email;
    public TableColumn CNumber;
    public TableColumn EY;
    public AnchorPane pane;
    public TableView Student;
    public JFXTextField Search;
    public JFXTextField txtID;
    public JFXTextField txtNIC;
    public JFXTextField txtName;
    public JFXTextField txtAdress;
    public JFXTextField txtEmail;
    public JFXTextField txtCNo;
    public JFXTextField txtEY;
    public JFXTextField txtStream;
    public JFXComboBox<String> combEmployeeId;
    public TextField text;
    LinkedHashMap<TextField, Pattern> map = new LinkedHashMap<>();

    public void initialize() {

        Pattern patternId = Pattern.compile("^(S0)[0-9]{2,4}$");
        Pattern patternName = Pattern.compile("^[A-z ]{3,}$");
        Pattern patternAddress = Pattern.compile("^[A-z0-9 ,/]{5,}$");
        Pattern patternContact = Pattern.compile("^(071|072|077|076|078|075)[0-9]{7}$");
        Pattern patternNic = Pattern.compile("^[0-9]{9}[v]$");
        Pattern patternStream = Pattern.compile("^[A-z0-9]{3,}$");
        Pattern patternEmail = Pattern.compile("^[A-z0-9 ,/]{3,}(@gmail.com)$");

        map.put(txtID, patternId);
        map.put(txtNIC, patternNic);
        map.put(txtName, patternName);
        map.put(txtAdress, patternAddress);
        map.put(txtEmail, patternEmail);
        map.put(txtCNo, patternContact);
        map.put(txtStream, patternStream);


        StudentId.setCellValueFactory(new PropertyValueFactory<>("SID"));
        NIC.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Address.setCellValueFactory(new PropertyValueFactory<>("address"));
        Email.setCellValueFactory(new PropertyValueFactory<>("email"));
        CNumber.setCellValueFactory(new PropertyValueFactory<>("contact"));
        EY.setCellValueFactory(new PropertyValueFactory<>("exam_year"));
        Stream.setCellValueFactory(new PropertyValueFactory<>("stream"));

        try {
            cmbLoadData();
            LoadTableData();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
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
//        btnModifyBooking.setDisable(true);
    }




    private void LoadTableData() {

    }


    public void btnUpdateStudent(ActionEvent actionEvent) {
    }

    private void cmbLoadData() throws SQLException, ClassNotFoundException {

    }


    public void btnSearch(ActionEvent actionEvent) {

    }

    public void btnAddStudent() {

    }

    public void btnDeleteStudent(ActionEvent actionEvent) {

    }


    public void stuOnKeyReleased(KeyEvent keyEvent) {


    }
}
