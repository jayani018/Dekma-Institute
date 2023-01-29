package lk.ijse.StudentMS.dao.custom.impl;

import lk.ijse.StudentMS.dao.SqlUtil;
import lk.ijse.StudentMS.dao.custom.TeacherModelDAO;
import lk.ijse.StudentMS.model.TeacherDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherModelDAOImpl implements TeacherModelDAO {


    @Override
    public ArrayList<TeacherDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<TeacherDTO> Teacher = new ArrayList<>();
        ResultSet rst = SqlUtil.execute("SELECT * FROM Teacher");
        while (rst.next()){
            TeacherDTO teacherDTO = new TeacherDTO(rst.getString("TID"), rst.getString("SUBID"), rst.getString("NIC"), rst.getString("name"), rst.getString("address"), rst.getString("Contact"), rst.getString("email"), rst.getDouble("salary"));
            Teacher.add(teacherDTO);
        }
        return Teacher;
    }

    @Override
    public boolean add(TeacherDTO dto) throws SQLException, ClassNotFoundException {
       return SqlUtil.execute("INSERT INTO Teacher VALUES (?,?,?,?,?,?,?,?)",dto.getTID(),dto.getSUBID(),dto.getNIC(),dto.getName(),dto.getAddress(),dto.getContact(),dto.getEmail(),dto.getSalary());

    }

    @Override
    public boolean update(TeacherDTO dto) throws SQLException, ClassNotFoundException {
       return SqlUtil.execute("UPDATE Teacher SET  SubID=?,NIC=?,name=?,address=?,contact=?,email=?, salary=?  WHERE TId=?",dto.getSUBID(),dto.getNIC(),dto.getName(),dto.getAddress(),dto.getContact(),dto.getEmail(),dto.getSalary(),dto.getTID());
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
       return SqlUtil.execute("DELETE FROM Teacher  WHERE TId=?",id);
    }

    @Override
    public TeacherDTO search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtil.execute("SELECT * FROM Teacher WHERE TID=?", id);
        TeacherDTO teacherDTO = null;
        if (rst.next()){
             teacherDTO = new TeacherDTO(id, rst.getString("SUBID"), rst.getString("NIC"), rst.getString("name"), rst.getString("address"), rst.getString("Contact"), rst.getString("email"), rst.getDouble("salary"));
        }
        return teacherDTO;
    }
}
