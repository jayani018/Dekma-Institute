package lk.ijse.StudentMS.dao.custom.impl;

import lk.ijse.StudentMS.dao.custom.StudentAttendanceModelDAO;
import lk.ijse.StudentMS.model.StudentAttendanceDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentAttendanceModelDAOImpl implements StudentAttendanceModelDAO {
    @Override
    public ArrayList<StudentAttendanceDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(StudentAttendanceDTO entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(StudentAttendanceDTO entity) throws SQLException, ClassNotFoundException {
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
    public StudentAttendanceDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
