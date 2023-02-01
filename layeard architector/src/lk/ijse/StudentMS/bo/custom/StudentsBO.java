package lk.ijse.StudentMS.bo.custom;

import lk.ijse.StudentMS.model.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentsBO {
    public ArrayList<StudentDTO> getAll() throws SQLException, ClassNotFoundException ;

    public boolean add(StudentDTO dto) throws SQLException, ClassNotFoundException ;

    public boolean update(StudentDTO dto) throws SQLException, ClassNotFoundException;

    public boolean exist(String id) throws SQLException, ClassNotFoundException ;

    public String generateNewID() throws SQLException, ClassNotFoundException ;

    public boolean delete(String id) throws SQLException, ClassNotFoundException;

    public StudentDTO search(String id) throws SQLException, ClassNotFoundException ;
}
