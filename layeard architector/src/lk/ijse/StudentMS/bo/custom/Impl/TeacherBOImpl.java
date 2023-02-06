package lk.ijse.StudentMS.bo.custom.Impl;

import lk.ijse.StudentMS.bo.BOFactory;
import lk.ijse.StudentMS.bo.custom.TeacherBO;
import lk.ijse.StudentMS.dao.custom.TeacherModelDAO;
import lk.ijse.StudentMS.model.TeacherDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherBOImpl implements TeacherBO {

//    TeacherModelDAO teacherModelDAO = new TeacherModelDAOImpl();
TeacherModelDAO teacherModelDAO = (TeacherModelDAO) BOFactory.getBoFactory().getBO(BOFactory.BOType.TEACHER);
    @Override
    public ArrayList<TeacherDTO> getAllTeacher() throws SQLException, ClassNotFoundException {
        return teacherModelDAO.getAll();
    }

    @Override
    public boolean addTeacher(TeacherDTO dto) throws SQLException, ClassNotFoundException {
        return teacherModelDAO.add(dto);
    }

    @Override
    public boolean updateTeacher(TeacherDTO dto) throws SQLException, ClassNotFoundException {
        return teacherModelDAO.update(dto);
    }

    @Override
    public boolean existTeacher(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewIDTeacher() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean deleteTeacher(String id) throws SQLException, ClassNotFoundException {
        return teacherModelDAO.delete(id);
    }

    @Override
    public TeacherDTO searchTeacher(String id) throws SQLException, ClassNotFoundException {
        return teacherModelDAO.search(id);
    }
}
