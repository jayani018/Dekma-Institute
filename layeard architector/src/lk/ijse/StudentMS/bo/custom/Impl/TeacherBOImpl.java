package lk.ijse.StudentMS.bo.custom.Impl;

import lk.ijse.StudentMS.bo.custom.TeacherBO;
import lk.ijse.StudentMS.dao.custom.TeacherModelDAO;
import lk.ijse.StudentMS.dao.custom.impl.TeacherModelDAOImpl;
import lk.ijse.StudentMS.model.TeacherDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherBOImpl implements TeacherBO {

    TeacherModelDAO teacherModelDAO = new TeacherModelDAOImpl();
    @Override
    public ArrayList<TeacherDTO> getAll() throws SQLException, ClassNotFoundException {
        return teacherModelDAO.getAll();
    }

    @Override
    public boolean add(TeacherDTO dto) throws SQLException, ClassNotFoundException {
        return teacherModelDAO.add(dto);
    }

    @Override
    public boolean update(TeacherDTO dto) throws SQLException, ClassNotFoundException {
        return teacherModelDAO.update(dto);
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
        return teacherModelDAO.delete(id);
    }

    @Override
    public TeacherDTO search(String id) throws SQLException, ClassNotFoundException {
        return teacherModelDAO.search(id);
    }
}
