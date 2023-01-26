package lk.ijse.StudentMS.dao.custom.impl;

import lk.ijse.StudentMS.dao.custom.BatchModelDAO;
import lk.ijse.StudentMS.model.BatchDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class BatchModelDAOImpl implements BatchModelDAO {

    @Override
    public ArrayList<BatchDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(BatchDTO entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(BatchDTO entity) throws SQLException, ClassNotFoundException {
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
    public BatchDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
