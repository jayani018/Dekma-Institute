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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.StudentMS.bo.custom.Impl.StudentsBOImpl;
import lk.ijse.StudentMS.dao.custom.impl.EmployeeModelDAOImpl;
import lk.ijse.StudentMS.model.EmployeeDTO;
import lk.ijse.StudentMS.model.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class ManageStudentsFormController {


    // public TableColumn Stream;
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
    // public JFXTextField txtStream;
    public JFXComboBox<String> combEmployeeId;
    public TextField text;
    public JFXTextField txtSubject;
    public TableColumn Subject;
    LinkedHashMap<TextField, Pattern> map = new LinkedHashMap<>();

    public void initialize() {

        Pattern patternId = Pattern.compile("^(S0)[0-9]{2,4}$");
        Pattern patternName = Pattern.compile("^[A-z ]{3,}$");
        Pattern patternAddress = Pattern.compile("^[A-z0-9 ,/]{5,}$");
        Pattern patternContact = Pattern.compile("^(071|072|077|076|078|075)[0-9]{7}$");
        Pattern patternNic = Pattern.compile("^[0-9]{9}[v]$");
        Pattern patternSubject = Pattern.compile("^[A-z0-9]{3,}$");
        Pattern patternEmail = Pattern.compile("^[A-z0-9 ,/]{3,}(@gmail.com)$");

        map.put(txtID, patternId);
        map.put(txtNIC, patternNic);
        map.put(txtName, patternName);
        map.put(txtAdress, patternAddress);
        map.put(txtEmail, patternEmail);
        map.put(txtCNo, patternContact);
        map.put(txtSubject, patternSubject);


        StudentId.setCellValueFactory(new PropertyValueFactory<>("SID"));
        NIC.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Address.setCellValueFactory(new PropertyValueFactory<>("address"));
        Email.setCellValueFactory(new PropertyValueFactory<>("email"));
        CNumber.setCellValueFactory(new PropertyValueFactory<>("contact"));
        EY.setCellValueFactory(new PropertyValueFactory<>("exam_year"));
        Subject.setCellValueFactory(new PropertyValueFactory<>("subject"));

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

   private final EmployeeModelDAOImpl employeeModelDAO = new EmployeeModelDAOImpl();
   private final StudentsBOImpl studentsBO = new StudentsBOImpl();


    private void LoadTableData() {
        Student.getItems().clear();
        ObservableList<StudentDTO> StudentList = FXCollections.observableArrayList();
        try {
            ArrayList<StudentDTO> studentData = studentsBO.getAllStudent();
            for (StudentDTO student : studentData) {
                StudentList.add(student);
            }
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
        Student.setItems(StudentList);
    }


    public void btnUpdateStudent(ActionEvent actionEvent) {
        try {
            boolean update = studentsBO.updateStudent(
                    new StudentDTO(
                            txtID.getText(),
                            combEmployeeId.getValue(),
                            txtNIC.getText(),
                            txtSubject.getText(),
                            txtEY.getText(),
                            txtName.getText(),
                            txtAdress.getText(),
                            txtCNo.getText(),
                            txtEmail.getText()
                    ));
            if (update) {
                new Alert(Alert.AlertType.INFORMATION, "Update Employee").show();
            }
            LoadTableData();
            cmbLoadData();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }


    }

    private void cmbLoadData() throws SQLException, ClassNotFoundException {
            try {
//                EmployeeModelDAOImpl employeeModelDAO = new EmployeeModelDAOImpl();
                ArrayList<EmployeeDTO> arrayList =employeeModelDAO.getAll();

                String[] Employee = new String[arrayList.size()];


                ObservableList obList= FXCollections.observableArrayList();
                for (int i = 0; i < Employee.length; i++) {
                    obList.add(arrayList.get(i).getEID());
                }
                combEmployeeId.setItems(obList);

            } catch (SQLException | ClassNotFoundException throwables) {
                System.out.println(throwables);
            }
        }

    public void stuOnKeyReleased(KeyEvent keyEvent) {
    }

    public void btnAddStudent(ActionEvent actionEvent) {
//        SubjectModelDAO subjectModelDAO = new SubjectModelDAOImpl();
            try {
                boolean add = studentsBO.addStudent(
                        new StudentDTO(txtID.getText(),
                                combEmployeeId.getValue(),
                                txtNIC.getText(),
                                txtSubject.getText(),
                                txtEY.getText(),
                                txtName.getText(),
                                txtAdress.getText(),
                                txtCNo.getText(),
                                txtEmail.getText()
                        ));
                if (add) {
                    new Alert(Alert.AlertType.INFORMATION, "Add Employee").show();
                }
               LoadTableData();
                cmbLoadData();
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
    }

    public void btnDeleteStudent(ActionEvent actionEvent) {
        String id = txtID.getText();
        try {
            boolean delete = studentsBO.deleteStudent(id);
            if (delete) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Delete is successful");
                alert.show();
                LoadTableData();
                cmbLoadData();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error");
                alert.show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void btnSearch() {
        try {
            StudentDTO search =studentsBO.searchStudent(Search.getText());
            if (search == null) {
                new Alert(Alert.AlertType.INFORMATION, "Not Student").show();
            } else {
                txtID.setText(search.getSID());
                combEmployeeId.setValue(search.getEID());
                txtNIC.setText(search.getNIC());
                txtSubject.setText(search.getsubject());
                txtEY.setText(search.getExam_year());
                txtName.setText(search.getName());
                txtAdress.setText(search.getAddress());
                txtCNo.setText(search.getContact());
                txtEmail.setText(search.getEmail());
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void searchOnAction(ActionEvent actionEvent) {
        btnSearch();
    }
}
