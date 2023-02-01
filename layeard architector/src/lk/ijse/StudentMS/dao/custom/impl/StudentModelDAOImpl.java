package lk.ijse.StudentMS.dao.custom.impl;

import lk.ijse.StudentMS.dao.SqlUtil;
import lk.ijse.StudentMS.dao.custom.StudentModelDAO;
import lk.ijse.StudentMS.model.StudentDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentModelDAOImpl implements StudentModelDAO {

    @Override
    public ArrayList<StudentDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<StudentDTO> Student = new ArrayList<>();
        ResultSet rst = SqlUtil.execute("SELECT * FROM Student");
        while (rst.next()){
            StudentDTO studentDTO = new StudentDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9));
            Student.add(studentDTO);
        }
        return Student;
    }

    @Override
    public boolean add(StudentDTO dto) throws SQLException, ClassNotFoundException {
         return SqlUtil.execute("INSERT INTO Student VALUES (?,?,?,?,?,?,?,?,?)", dto.getSID(), dto.getEID(), dto.getNIC(), dto.getsubject(), dto.getExam_year(), dto.getName(), dto.getAddress(), dto.getContact(), dto.getEmail());
    }

    @Override
    public boolean update(StudentDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.execute( "UPDATE Student SET EId=?, NIC=?, subject=?,exam_year=?,name=?,address=?,contact=?,email=? WHERE SID=?",dto.getEID(),dto.getNIC(),dto.getsubject(),dto.getExam_year(),dto.getName(),dto.getAddress(),dto.getEmail(),dto.getSID());
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
       return SqlUtil.execute("DELETE FROM Student  WHERE SID=?",id);
    }

    @Override
    public StudentDTO search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtil.execute("SELECT * FROM Student WHERE SID=?", id);
        StudentDTO studentDTO = null;
        if (rst.next()){
            new StudentDTO(id,rst.getString("EID"),rst.getString("NIC"),rst.getString("subject"),rst.getString("exam_year"),rst.getString("name"),rst.getString("address"),rst.getString("contact"),rst.getString("email"));
        }
        return studentDTO;
    }
}
