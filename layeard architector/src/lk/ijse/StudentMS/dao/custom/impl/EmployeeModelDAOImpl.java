package lk.ijse.StudentMS.dao.custom.impl;

import lk.ijse.StudentMS.dao.custom.EmployeeModelDAO;
import lk.ijse.StudentMS.model.EmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeModelDAOImpl implements EmployeeModelDAO {

    @Override
    public ArrayList<EmployeeDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(EmployeeDTO entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(EmployeeDTO entity) throws SQLException, ClassNotFoundException {
        return false;
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
        return false;
    }

    @Override
    public EmployeeDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}


