package lk.ijse.StudentMS.dao.custom.impl;

import lk.ijse.StudentMS.dao.custom.ResultModelDAO;
import lk.ijse.StudentMS.model.ResultDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ResultModelDAOImpl implements ResultModelDAO {
    @Override
    public ArrayList<ResultDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(ResultDTO entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(ResultDTO entity) throws SQLException, ClassNotFoundException {
        return false;
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
        return false;
    }

    @Override
    public ResultDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
