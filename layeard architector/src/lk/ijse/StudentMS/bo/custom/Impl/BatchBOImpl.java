package lk.ijse.StudentMS.bo.custom.Impl;

import lk.ijse.StudentMS.bo.custom.BatchBO;
import lk.ijse.StudentMS.dao.DAOFactory;
import lk.ijse.StudentMS.dao.custom.BatchModelDAO;
import lk.ijse.StudentMS.model.BatchDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class BatchBOImpl implements BatchBO {
//    StudentModelDAOImpl studentModelDAO = new StudentModelDAOImpl();
//    BatchModelDAO batchModelDAO = new BatchModelDAOImpl();
//BatchModelDAO batchModelDAO = (BatchModelDAO) BOFactory.getBoFactory().getBO(BOFactory.BOType.BATCH);

    BatchModelDAO batchModelDAO = (BatchModelDAO) DAOFactory.getDoFactory().getDAO(DAOFactory.DAOType.BATCH);

    public ArrayList<BatchDTO> getAllBatch() throws SQLException, ClassNotFoundException {
        return batchModelDAO.getAll();
    }

    @Override
    public boolean addBatch(BatchDTO dto) throws SQLException, ClassNotFoundException {
        return batchModelDAO.add(dto);
        }

    @Override
    public boolean updateBatch(BatchDTO dto) throws SQLException, ClassNotFoundException {
        return batchModelDAO.update(dto);
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
    public boolean deleteBatch(String id) throws SQLException, ClassNotFoundException {
      return batchModelDAO.delete(id);
    }

    @Override
    public BatchDTO searchBatch(String id) throws SQLException, ClassNotFoundException {
       return batchModelDAO.search(id);
    }



}
