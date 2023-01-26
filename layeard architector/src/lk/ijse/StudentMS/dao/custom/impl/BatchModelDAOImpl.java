package lk.ijse.StudentMS.dao.custom.impl;

import lk.ijse.StudentMS.dao.SqlUtil;
import lk.ijse.StudentMS.dao.custom.BatchModelDAO;
import lk.ijse.StudentMS.model.BatchDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BatchModelDAOImpl implements BatchModelDAO {

    @Override
    public ArrayList<BatchDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<BatchDTO> Batch = new ArrayList<>();
        ResultSet rst = SqlUtil.execute("SELECT * FROM Batch");
        while (rst.next()){
            BatchDTO batchDTO = new BatchDTO(rst.getString("BID"), rst.getString("SID"), rst.getString("year"));
            Batch.add(batchDTO);
        }

        return Batch;

    }

    @Override
    public boolean add(BatchDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.execute("INSERT INTO Batch VALUES (?,?,?)", dto.getBID(), dto.getYear(), dto.getSID());
    }

    @Override
    public boolean update(BatchDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.execute("UPDATE Batch SET SID=?,year=?  WHERE BId=?", dto.getSID(), dto.getYear(), dto.getBID());
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
        return SqlUtil.execute(" DELETE FROM Batch  WHERE BId=?", id);
    }

    @Override
    public BatchDTO search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtil.execute("SELECT * FROM Batch WHERE BID=?", id);
        BatchDTO batchDTO = null;
        if (rst.next()) {
            batchDTO = new BatchDTO(id, rst.getString("SID"), rst.getString("year"));
        }
        return batchDTO;
    }
}
