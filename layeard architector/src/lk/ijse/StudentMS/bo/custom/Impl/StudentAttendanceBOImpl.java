package lk.ijse.StudentMS.bo.custom.Impl;

import lk.ijse.StudentMS.bo.custom.StudentAttendanceBO;
import lk.ijse.StudentMS.dao.custom.StudentAttendanceModelDAO;
import lk.ijse.StudentMS.dao.custom.impl.StudentAttendanceModelDAOImpl;
import lk.ijse.StudentMS.model.StudentAttendanceDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentAttendanceBOImpl implements StudentAttendanceBO {

    StudentAttendanceModelDAO studentAttendanceModelDAO = new StudentAttendanceModelDAOImpl();
    @Override
    public ArrayList<StudentAttendanceDTO> getAll() throws SQLException, ClassNotFoundException {
        return studentAttendanceModelDAO.getAll();
    }

    @Override
    public boolean add(StudentAttendanceDTO dto) throws SQLException, ClassNotFoundException {
        return studentAttendanceModelDAO.add(dto);
    }

    @Override
    public boolean update(StudentAttendanceDTO dto) throws SQLException, ClassNotFoundException {
        return studentAttendanceModelDAO.update(dto);
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
        return studentAttendanceModelDAO.delete(id);
    }

    @Override
    public StudentAttendanceDTO search(String id) throws SQLException, ClassNotFoundException {
        return studentAttendanceModelDAO.search(id);
    }
}
