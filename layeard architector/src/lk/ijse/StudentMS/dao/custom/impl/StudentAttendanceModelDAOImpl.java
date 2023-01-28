package lk.ijse.StudentMS.dao.custom.impl;

import lk.ijse.StudentMS.dao.SqlUtil;
import lk.ijse.StudentMS.dao.custom.StudentAttendanceModelDAO;
import lk.ijse.StudentMS.model.StudentAttendanceDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentAttendanceModelDAOImpl implements StudentAttendanceModelDAO {
    @Override
    public ArrayList<StudentAttendanceDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<StudentAttendanceDTO> studentAttendance = new ArrayList<>();
        ResultSet rst = SqlUtil.execute("SELECT * FROM student_attendance");
        while (rst.next()){
            StudentAttendanceDTO studentAttendanceDTO = new StudentAttendanceDTO(rst.getString("SID"), rst.getString("date"), rst.getString("time"));
            studentAttendance.add(studentAttendanceDTO);
        }
        return studentAttendance;
    }

    @Override
    public boolean add(StudentAttendanceDTO dto) throws SQLException, ClassNotFoundException {
       return SqlUtil.execute("INSERT INTO student_attendance VALUES (?,?,?)",dto.getSID(),dto.getDate(),dto.getTime());
    }

    @Override
    public boolean update(StudentAttendanceDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.execute("UPDATE student_attendance SET date=?,time=?  WHERE=SID?",dto.getDate(),dto.getTime(),dto.getSID());
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
       return SqlUtil.execute("DELETE FROM student_attendance  WHERE SID=?",id);
    }

    @Override
    public StudentAttendanceDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
