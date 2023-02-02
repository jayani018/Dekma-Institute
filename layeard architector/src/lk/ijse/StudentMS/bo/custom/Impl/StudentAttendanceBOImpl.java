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
    public ArrayList<StudentAttendanceDTO> getAllStudentAttendance() throws SQLException, ClassNotFoundException {
        return studentAttendanceModelDAO.getAll();
    }

    @Override
    public boolean addStudentAttendance(StudentAttendanceDTO dto) throws SQLException, ClassNotFoundException {
        return studentAttendanceModelDAO.add(dto);
    }

    @Override
    public boolean updateStudentAttendance(StudentAttendanceDTO dto) throws SQLException, ClassNotFoundException {
        return studentAttendanceModelDAO.update(dto);
    }

    @Override
    public boolean existStudentAttendance(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewIDStudentAttendance() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean deleteStudentAttendance(String id) throws SQLException, ClassNotFoundException {
        return studentAttendanceModelDAO.delete(id);
    }

    @Override
    public StudentAttendanceDTO searchStudentAttendance(String id) throws SQLException, ClassNotFoundException {
        return studentAttendanceModelDAO.search(id);
    }
}
