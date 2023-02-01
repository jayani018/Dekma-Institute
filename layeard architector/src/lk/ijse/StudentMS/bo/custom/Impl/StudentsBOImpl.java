package lk.ijse.StudentMS.bo.custom.Impl;

import lk.ijse.StudentMS.bo.custom.StudentsBO;
import lk.ijse.StudentMS.dao.custom.StudentModelDAO;
import lk.ijse.StudentMS.dao.custom.impl.StudentModelDAOImpl;
import lk.ijse.StudentMS.model.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentsBOImpl implements StudentsBO {

   StudentModelDAO studentModelDAO = new StudentModelDAOImpl();

    public ArrayList<StudentDTO> getAll() throws SQLException, ClassNotFoundException {
        return studentModelDAO.getAll();
    }

    @Override
    public boolean add(StudentDTO dto) throws SQLException, ClassNotFoundException {
        return studentModelDAO.add(dto);
    }

    @Override
    public boolean update(StudentDTO dto) throws SQLException, ClassNotFoundException {
        return studentModelDAO.update(dto);
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
        return studentModelDAO.delete(id);
    }

    @Override
    public StudentDTO search(String id) throws SQLException, ClassNotFoundException {
        return studentModelDAO.search(id);
    }
}
