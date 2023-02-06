package lk.ijse.StudentMS.bo.custom.Impl;

import lk.ijse.StudentMS.bo.BOFactory;
import lk.ijse.StudentMS.bo.custom.ResultsBO;
import lk.ijse.StudentMS.dao.custom.ResultModelDAO;
import lk.ijse.StudentMS.model.ResultDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ResultsBOImpl implements ResultsBO {
//    ResultModelDAO resultModelDAO = new ResultModelDAOImpl();
ResultModelDAO resultModelDAO = (ResultModelDAO) BOFactory.getBoFactory().getBO(BOFactory.BOType.RESULT);
    @Override
    public ArrayList<ResultDTO> getAllResult() throws SQLException, ClassNotFoundException {
        return resultModelDAO.getAll();
    }

    @Override
    public boolean addResult(ResultDTO dto) throws SQLException, ClassNotFoundException {
        return resultModelDAO.add(dto);
    }

    @Override
    public boolean updateResult(ResultDTO dto) throws SQLException, ClassNotFoundException {
        return resultModelDAO.update(dto);
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
    public boolean deleteResult(String id) throws SQLException, ClassNotFoundException {
        return resultModelDAO.delete(id);
    }

    @Override
    public ResultDTO searchResult(String id) throws SQLException, ClassNotFoundException {
        return resultModelDAO.search(id);
    }
}
