package lk.ijse.StudentMS.bo.custom;

import lk.ijse.StudentMS.bo.SuperBO;
import lk.ijse.StudentMS.model.EmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBO extends SuperBO {
    public ArrayList<EmployeeDTO> getAllEmployee() throws SQLException, ClassNotFoundException ;

    public boolean addEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException ;

    public boolean updateEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException ;



    public boolean exist(String id) throws SQLException, ClassNotFoundException ;


    public String generateNewID() throws SQLException, ClassNotFoundException;


    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException;


    public EmployeeDTO searchEmployee(String id) throws SQLException, ClassNotFoundException ;
}
