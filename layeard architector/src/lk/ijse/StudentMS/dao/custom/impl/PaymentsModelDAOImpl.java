package lk.ijse.StudentMS.dao.custom.impl;

import lk.ijse.StudentMS.dao.custom.PaymentsModelDAO;
import lk.ijse.StudentMS.model.PaymentsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentsModelDAOImpl implements PaymentsModelDAO {


    @Override
    public ArrayList<PaymentsDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(PaymentsDTO entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(PaymentsDTO entity) throws SQLException, ClassNotFoundException {
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
    public PaymentsDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
