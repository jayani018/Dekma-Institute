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
import lk.ijse.StudentMS.dao.custom.TeacherModelDAO;
import lk.ijse.StudentMS.dao.custom.impl.SubjectModelDAOImpl;
import lk.ijse.StudentMS.dao.custom.impl.TeacherModelDAOImpl;
import lk.ijse.StudentMS.model.SubjectDTO;
import lk.ijse.StudentMS.model.TeacherDTO;

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
    TeacherModelDAO teacherModelDAO = new TeacherModelDAOImpl();

    private void loadTableData() {
        ObservableList<TeacherDTO> TeacherList = FXCollections.observableArrayList();
        try {
            ArrayList<TeacherDTO> teacherData = teacherModelDAO.getAll();
            for (TeacherDTO teacher : teacherData) {
                TeacherList.add(teacher);
            }
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
        tblTeacher.setItems(TeacherList);
    }

    private void cmbLoadData() throws SQLException, ClassNotFoundException {
        try {
            // StudentModelDAOImpl studentModelDAO = new StudentModelDAOImpl();
            SubjectModelDAOImpl subjectModelDAO = new SubjectModelDAOImpl();
            ArrayList<SubjectDTO> arrayList = subjectModelDAO.getAll();

            String[] Subject = new String[arrayList.size()];


            ObservableList obList= FXCollections.observableArrayList();
            for (int i = 0; i < Subject.length; i++) {
                obList.add(arrayList.get(i).getSUBID());
            }
            combSubId.setItems(obList);

        } catch (SQLException | ClassNotFoundException throwables) {
            System.out.println(throwables);
        }
    }

    public void btnAdd(ActionEvent actionEvent) {
//        TeacherModelDAO teacherModelDAO = new TeacherModelDAOImpl();
        try {
            boolean add = teacherModelDAO.add(new TeacherDTO(txtId.getText(),
                    combSubId.getValue(),
                    txtNIC.getText(),
                    txtName.getText(),
                    txtAddress.getText(),
                    txtContactNo.getText(),
                    txtEmail.getText(),
                    txtSalary.getText()
            ));
            if (add) {
                new Alert(Alert.AlertType.INFORMATION, "Add Teacher").show();
                loadTableData();
                cmbLoadData();
            } else {
                new Alert(Alert.AlertType.ERROR, "Something Wrong").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }


    }

    public void btnSearch(ActionEvent actionEvent) {
        try {
            TeacherDTO search = teacherModelDAO.search(Search.getText());
            if (search==null){
                new Alert(Alert.AlertType.INFORMATION,"Not Teacher").show();
            }else {
                txtId.setText(search.getTID());
                combSubId.setValue(search.getSUBID());
                txtNIC.setText(search.getNIC());
                txtName.setText(search.getName());
                txtAddress.setText(search.getAddress());
                txtContactNo.setText(search.getContact());
                txtEmail.setText(search.getEmail());
                txtSalary.setText(String.valueOf(search.getSalary()));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void txtSearchOnAction(ActionEvent actionEvent) {

    }

    public void btnUpdate(ActionEvent actionEvent) {
        try {
            boolean update = teacherModelDAO.update(new TeacherDTO((String) combSubId.getValue(),
                    txtNIC.getText(),
                    txtName.getText(),
                    txtAddress.getText(),
                    txtContactNo.getText(),
                    txtEmail.getText(),
                    txtSalary.getText(),
                    txtId.getText()
            ));
            if (update) {
                new Alert(Alert.AlertType.INFORMATION, "Update Employee").show();
            }
            loadTableData();
            cmbLoadData();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void btnDelete(ActionEvent actionEvnt) {
        String id = txtId.getText();
        try {
            boolean delete = teacherModelDAO.delete(id);
            if (delete) {
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Delete is successful");
                alert.show();
            }else {
                Alert alert=new Alert(Alert.AlertType.ERROR,"Error");
                alert.show();
            }
            loadTableData();
            cmbLoadData();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
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