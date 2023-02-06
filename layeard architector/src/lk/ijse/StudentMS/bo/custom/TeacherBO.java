package lk.ijse.StudentMS.bo.custom;

import lk.ijse.StudentMS.bo.SuperBO;
import lk.ijse.StudentMS.model.TeacherDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TeacherBO extends SuperBO {
    public ArrayList<TeacherDTO> getAllTeacher() throws SQLException, ClassNotFoundException;

    public boolean addTeacher(TeacherDTO dto) throws SQLException, ClassNotFoundException;

    public boolean updateTeacher(TeacherDTO dto) throws SQLException, ClassNotFoundException;

    public boolean existTeacher(String id) throws SQLException, ClassNotFoundException;

    public String generateNewIDTeacher() throws SQLException, ClassNotFoundException;

    public boolean deleteTeacher(String id) throws SQLException, ClassNotFoundException;

    public TeacherDTO searchTeacher(String id) throws SQLException, ClassNotFoundException;
}