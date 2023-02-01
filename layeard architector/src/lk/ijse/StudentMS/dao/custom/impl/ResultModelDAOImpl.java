package lk.ijse.StudentMS.dao.custom.impl;

import lk.ijse.StudentMS.dao.SqlUtil;
import lk.ijse.StudentMS.dao.custom.ResultModelDAO;
import lk.ijse.StudentMS.model.ResultDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResultModelDAOImpl implements ResultModelDAO {
    @Override
    public ArrayList<ResultDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList <ResultDTO> Results = new ArrayList<>();
        ResultSet rst = SqlUtil.execute("SELECT * FROM  student_result");
        while (rst.next()){
            ResultDTO resultDTO = new ResultDTO(rst.getString("RID"),rst.getString("SID"), rst.getString("SUBID"), rst.getString("result"));
           Results.add(resultDTO);
        }
    return Results;
    }

    @Override
    public boolean add(ResultDTO dto) throws SQLException, ClassNotFoundException {
       return SqlUtil.execute("INSERT INTO student_result VALUES (?,?,?,?)",dto.getTID(),dto.getSID(),dto.getSUBID(),dto.getResult());
    }

    @Override
    public boolean update(ResultDTO dto) throws SQLException, ClassNotFoundException {
      return SqlUtil.execute("UPDATE student_result SET SID=?,SUBID=?,result=?  WHERE TID=?");
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
        return SqlUtil.execute(" DELETE FROM student_result  WHERE RId=?",id);
    }

    @Override
    public ResultDTO search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtil.execute("SELECT * FROM student_result WHERE RID=?", id);
        ResultDTO resultDTO = null;
        if (rst.next()) {
             new ResultDTO(id,rst.getString("SID"),rst.getString("SUBID"),rst.getString("result"));
        }
        return resultDTO;
    }
}
