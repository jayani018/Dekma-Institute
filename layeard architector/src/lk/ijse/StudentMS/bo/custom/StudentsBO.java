package lk.ijse.StudentMS.bo.custom;

import lk.ijse.StudentMS.bo.SuperBO;
import lk.ijse.StudentMS.model.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentsBO extends SuperBO {
    public ArrayList<StudentDTO> getAllStudent() throws SQLException, ClassNotFoundException ;

    public boolean addStudent(StudentDTO dto) throws SQLException, ClassNotFoundException ;

    public boolean updateStudent(StudentDTO dto) throws SQLException, ClassNotFoundException;

    public boolean existStudent(String id) throws SQLException, ClassNotFoundException ;

    public String generateNewIDStudent() throws SQLException, ClassNotFoundException ;

    public boolean deleteStudent(String id) throws SQLException, ClassNotFoundException;

    public StudentDTO searchStudent(String id) throws SQLException, ClassNotFoundException ;
}
