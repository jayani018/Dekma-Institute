package lk.ijse.StudentMS.dao.custom.impl;

import lk.ijse.StudentMS.dao.custom.TeacherModelDAO;
import lk.ijse.StudentMS.model.TeacherDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherModelDAOImpl implements TeacherModelDAO {


    @Override
    public ArrayList<TeacherDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(TeacherDTO entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(TeacherDTO entity) throws SQLException, ClassNotFoundException {
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
    public TeacherDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
