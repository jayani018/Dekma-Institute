package lk.ijse.StudentMS.bo.custom.Impl;

import lk.ijse.StudentMS.bo.custom.EmployeeBO;
import lk.ijse.StudentMS.dao.DAOFactory;
import lk.ijse.StudentMS.dao.custom.EmployeeModelDAO;
import lk.ijse.StudentMS.model.EmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {
//    EmployeeModelDAO employeeModelDAO = new EmployeeModelDAOImpl();
//EmployeeModelDAO employeeModelDAO = (EmployeeModelDAO) BOFactory.getBoFactory().getBO(BOFactory.BOType.EMPLOYEE);
    EmployeeModelDAO employeeModelDAO = (EmployeeModelDAO) DAOFactory.getDoFactory().getDAO(DAOFactory.DAOType.EMPLOYEE);

    @Override
    public ArrayList<EmployeeDTO> getAllEmployee() throws SQLException, ClassNotFoundException {
        return employeeModelDAO.getAll();
    }

    @Override
    public boolean addEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeModelDAO.add(dto);
    }

    @Override
    public boolean updateEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeModelDAO.update(dto);
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
    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeModelDAO.delete(id);
    }

    @Override
    public EmployeeDTO searchEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeModelDAO.search(id);
    }
}
