package lk.ijse.StudentMS.bo.custom;

import lk.ijse.StudentMS.model.StudentAttendanceDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentAttendanceBO {
    public ArrayList<StudentAttendanceDTO> getAll() throws SQLException, ClassNotFoundException ;

    public boolean add(StudentAttendanceDTO dto) throws SQLException, ClassNotFoundException ;

    public boolean update(StudentAttendanceDTO dto) throws SQLException, ClassNotFoundException ;

    public boolean exist(String id) throws SQLException, ClassNotFoundException;

    public String generateNewID() throws SQLException, ClassNotFoundException ;

    public boolean delete(String id) throws SQLException, ClassNotFoundException;

    public StudentAttendanceDTO search(String id) throws SQLException, ClassNotFoundException ;
}
