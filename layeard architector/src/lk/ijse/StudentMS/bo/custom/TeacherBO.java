package lk.ijse.StudentMS.bo.custom;

import lk.ijse.StudentMS.model.TeacherDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TeacherBO {
    public ArrayList<TeacherDTO> getAll() throws SQLException, ClassNotFoundException;

    public boolean add(TeacherDTO dto) throws SQLException, ClassNotFoundException;

    public boolean update(TeacherDTO dto) throws SQLException, ClassNotFoundException;

    public boolean exist(String id) throws SQLException, ClassNotFoundException;

    public String generateNewID() throws SQLException, ClassNotFoundException;

    public boolean delete(String id) throws SQLException, ClassNotFoundException;

    public TeacherDTO search(String id) throws SQLException, ClassNotFoundException;
}