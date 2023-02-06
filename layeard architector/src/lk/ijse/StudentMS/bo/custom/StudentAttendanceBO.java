package lk.ijse.StudentMS.bo.custom;

import lk.ijse.StudentMS.bo.SuperBO;
import lk.ijse.StudentMS.model.StudentAttendanceDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentAttendanceBO extends SuperBO {
    public ArrayList<StudentAttendanceDTO> getAllStudentAttendance() throws SQLException, ClassNotFoundException ;

    public boolean addStudentAttendance(StudentAttendanceDTO dto) throws SQLException, ClassNotFoundException ;

    public boolean updateStudentAttendance(StudentAttendanceDTO dto) throws SQLException, ClassNotFoundException ;

    public boolean existStudentAttendance(String id) throws SQLException, ClassNotFoundException;

    public String generateNewIDStudentAttendance() throws SQLException, ClassNotFoundException ;

    public boolean deleteStudentAttendance(String id) throws SQLException, ClassNotFoundException;

    public StudentAttendanceDTO searchStudentAttendance(String id) throws SQLException, ClassNotFoundException ;
}
