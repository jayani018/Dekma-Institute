package lk.ijse.StudentMS.dao.custom.impl;

import lk.ijse.StudentMS.dao.SqlUtil;
import lk.ijse.StudentMS.dao.custom.EmployeeModelDAO;
import lk.ijse.StudentMS.model.EmployeeDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeModelDAOImpl implements EmployeeModelDAO {

    @Override
    public ArrayList<EmployeeDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<EmployeeDTO> employee = new ArrayList<>();
        ResultSet rst = SqlUtil.execute("SELECT * FROM Employee");
        while (rst.next()){
            EmployeeDTO employeeDTO = new EmployeeDTO(rst.getString("EID"), rst.getString("NIC"), rst.getString("name"), rst.getString("address"), rst.getString("contact"), rst.getString("email"), rst.getDouble("salary"));
            employee.add(employeeDTO);
        }
        return employee;
    }

    @Override
    public boolean add(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
       return SqlUtil.execute("INSERT INTO Employee VALUES (?,?,?,?,?,?,?)",dto.getEID(),dto.getNIC(),dto.getName(),dto.getAddress(),dto.getContact(),dto.getEmail(),dto.getSalary());
    }

    @Override
    public boolean update(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
       return SqlUtil.execute("UPDATE Employee SET NIC=?,name=?,address=?,contact=?,email=?,salary=?  WHERE EId=?",dto.getNIC(),dto.getName(),dto.getAddress(),dto.getContact(),dto.getEmail(),dto.getSalary(),dto.getEID());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SqlUtil.execute(" DELETE FROM Employee  WHERE EId=?", id);

    }

    @Override
    public EmployeeDTO search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtil.execute("SELECT * FROM Employee WHERE EID = ?", id);
       EmployeeDTO employeeDTO = null;
        if (rst.next()) {
            employeeDTO = new EmployeeDTO(id, rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getDouble(7));
        }
        return employeeDTO;
    }
}


