package lk.ijse.StudentMS.dao.custom.impl;

import lk.ijse.StudentMS.dao.SqlUtil;
import lk.ijse.StudentMS.dao.custom.SubjectModelDAO;
import lk.ijse.StudentMS.model.SubjectDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import lk.ijse.StudentMS.model.Student;

public class SubjectModelDAOImpl implements SubjectModelDAO {

    @Override
    public ArrayList<SubjectDTO> getAll() throws SQLException, ClassNotFoundException {
      ArrayList<SubjectDTO> Subject= new ArrayList<>();
        ResultSet rst = SqlUtil.execute("SELECT * FROM Subject");
        while (rst.next()){
            SubjectDTO subjectDTO = new SubjectDTO(rst.getString("SUBID"), rst.getString("SubName"));
            Subject.add(subjectDTO);
        }
        return Subject;
    }

    @Override
    public boolean add(SubjectDTO dto) throws SQLException, ClassNotFoundException {
       return SqlUtil.execute("INSERT INTO Subject VALUES (?,?)",dto.getSUBID(),dto.getSubName());
    }

    @Override
    public boolean update(SubjectDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.execute("UPDATE Subject SET SubName=?  WHERE SUBID=?",dto.getSubName(),dto.getSUBID());
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
       return SqlUtil.execute("DELETE FROM Subject  WHERE SUBID=?",id);
    }

    @Override
    public SubjectDTO search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtil.execute("SELECT * FROM Subject WHERE SUBID=?", id);
        SubjectDTO subjectDTO=null;
        if (rst.next()){
             subjectDTO = new SubjectDTO(id, rst.getString("SubName"));
        }
        return subjectDTO;
    }
}
