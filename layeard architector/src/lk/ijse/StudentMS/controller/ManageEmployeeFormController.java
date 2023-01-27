package lk.ijse.StudentMS.controller;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import lk.ijse.StudentMS.dao.custom.EmployeeModelDAO;
import lk.ijse.StudentMS.dao.custom.impl.EmployeeModelDAOImpl;
import lk.ijse.StudentMS.model.EmployeeDTO;

import java.io.IOException;
import java.sql.SQLException;

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
        EmployeeModelDAO employeeModelDAO = new EmployeeModelDAOImpl();
        try {
            boolean update = employeeModelDAO.update(
                    new EmployeeDTO(txtNIC.getText(),
                            txtName.getText(),
                            txtAddress.getText(),
                            txtContact.getText(),
                            txtEmail.getText(),
                            txtSalary.getText(),
                            txtId.getText()
                    ));
           // System.out.println(update);
            if (update) {
                new Alert(Alert.AlertType.INFORMATION, "Update Employee").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void btnDeleteEmployee(ActionEvent actionEvent) {
    }

    public void radioButtonOnActionTeacher(ActionEvent actionEvent) {

    }


    public void radioButtonOnActionManager(ActionEvent actionEvent) {

    }


    public void radioButtonOnActionOther(ActionEvent actionEvent) {

    }

    public void initialize() {


    }

    public void btnSearchEmployee(ActionEvent actionEvent) {
    }


    private void tableInit() {

    }

    public void initial() {
        tableInit();
    }

    public void searchOnActions(ActionEvent actionEvent) {

    }

    public void btnSearchEmployees(ActionEvent actionEvent) {
        EmployeeModelDAO employeeModelDAO = new EmployeeModelDAOImpl();
        try {
            EmployeeDTO search = employeeModelDAO.search(Search.getText());
            if (search==null){
                new Alert(Alert.AlertType.INFORMATION,"Not Employee").show();
            }else {
                txtId.setText(search.getEID());
                txtName.setText(search.getName());
                txtAddress.setText(search.getAddress());
                txtContact.setText(search.getContact());
                txtEmail.setText(search.getEmail());
                txtNIC.setText(search.getNIC());
                txtSalary.setText(String.valueOf(search.getSalary()));
            }



        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}

