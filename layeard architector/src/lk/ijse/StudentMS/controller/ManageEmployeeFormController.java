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
import lk.ijse.StudentMS.bo.BOFactory;
import lk.ijse.StudentMS.bo.custom.Impl.EmployeeBOImpl;
import lk.ijse.StudentMS.model.EmployeeDTO;

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

    //EmployeeModelDAO employeeModelDAO = new EmployeeModelDAOImpl();
   // EmployeeBOImpl employeeBO = new EmployeeBOImpl();
    EmployeeBOImpl employeeBO = (EmployeeBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOType.EMPLOYEE);


    public void btnAddEmployee(ActionEvent actionEvent) throws IOException {
      //  EmployeeModelDAO employeeModelDAO = new EmployeeModelDAOImpl();
//        EmployeeBOImpl employeeBO = new EmployeeBOImpl();
        try {
            boolean add = employeeBO.addEmployee(
                    new EmployeeDTO(txtId.getText(),
                            txtNIC.getText(),
                            txtName.getText(),
                            txtAddress.getText(),
                            txtContact.getText(),
                            txtEmail.getText(),
                            Double.parseDouble(txtSalary.getText())

                    ));
            if (add) {
                new Alert(Alert.AlertType.INFORMATION, "Add Employee").show();
            }
            loadTableData();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void btnUpdateEmployee(ActionEvent actionEvent) {
       // EmployeeModelDAO employeeModelDAO = new EmployeeModelDAOImpl();
        try {
            boolean update = employeeBO.updateEmployee(
                    new EmployeeDTO(txtId.getText(),
                            txtNIC.getText(),
                            txtName.getText(),
                            txtAddress.getText(),
                            txtContact.getText(),
                            txtEmail.getText(),
                            Double.parseDouble(txtSalary.getText())

                    ));
           // System.out.println(update);
            if (update) {
                new Alert(Alert.AlertType.INFORMATION, "Update Employee").show();
            }
            loadTableData();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void btnDeleteEmployee(ActionEvent actionEvent) {
//        boolean delete = employeeModelDAO.delete(
//                new EmployeeDTO(txtId.getText()));

        String id = txtId.getText();
        try {
            boolean delete = employeeBO.deleteEmployee(id);
            if (delete) {
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Delete is successful");
                alert.show();
            }else {
                Alert alert=new Alert(Alert.AlertType.ERROR,"Error");
                alert.show();
            }
            loadTableData();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void radioButtonOnActionTeacher(ActionEvent actionEvent) {

    }


    public void radioButtonOnActionManager(ActionEvent actionEvent) {

    }


    public void radioButtonOnActionOther(ActionEvent actionEvent) {

    }

    public void initialize() {
        EID.setCellValueFactory(new PropertyValueFactory<>("EID"));
        NIC.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        CNumber.setCellValueFactory(new PropertyValueFactory<>("contact"));
        Email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        Salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        loadTableData();


    }

    public void btnSearchEmployee(ActionEvent actionEvent) {
    }


    private void tableInit() {
//        EID.setCellValueFactory(new PropertyValueFactory<>("EID"));
//        NIC.setCellValueFactory(new PropertyValueFactory<>("NIC"));
//        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
//        Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
//        CNumber.setCellValueFactory(new PropertyValueFactory<>("Contact NO"));
//        Email.setCellValueFactory(new PropertyValueFactory<>("Email"));
//        Salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
//        loadTableData();
    }

//    public void initial() {
//        tableInit();
//    }

    public void searchOnActions(ActionEvent actionEvent) {

    }

    public void btnSearchEmployees(ActionEvent actionEvent) {
       // EmployeeModelDAO employeeModelDAO = new EmployeeModelDAOImpl();
        try {
            EmployeeDTO search = employeeBO.searchEmployee(Search.getText());
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

    private void loadTableData() {
        ObservableList<EmployeeDTO> EmployeeList = FXCollections.observableArrayList();
        try {
            ArrayList<EmployeeDTO> employeeData = employeeBO.getAllEmployee();
            for (EmployeeDTO employee : employeeData) {
                EmployeeList.add(employee);
            }
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
        table.setItems(EmployeeList);

    }
}

