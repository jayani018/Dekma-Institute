package lk.ijse.StudentMS.dao.custom.impl;

import lk.ijse.StudentMS.dao.custom.StudentModelDAO;
import lk.ijse.StudentMS.model.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentModelDAOImpl implements StudentModelDAO {

    @Override
    public ArrayList<StudentDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(StudentDTO entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(StudentDTO entity) throws SQLException, ClassNotFoundException {
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
    public StudentDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
