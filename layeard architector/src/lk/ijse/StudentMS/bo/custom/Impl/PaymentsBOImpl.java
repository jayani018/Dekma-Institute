package lk.ijse.StudentMS.bo.custom.Impl;

import lk.ijse.StudentMS.bo.BOFactory;
import lk.ijse.StudentMS.bo.custom.PaymentsBO;
import lk.ijse.StudentMS.dao.custom.PaymentsModelDAO;
import lk.ijse.StudentMS.model.PaymentsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentsBOImpl implements PaymentsBO {

//    PaymentsModelDAO paymentsModelDAO = new PaymentsModelDAOImpl();
PaymentsModelDAO paymentsModelDAO = (PaymentsModelDAO) BOFactory.getBoFactory().getBO(BOFactory.BOType.PAYMENTS);
    @Override
    public ArrayList<PaymentsDTO> getAllPayments() throws SQLException, ClassNotFoundException {
        return paymentsModelDAO.getAll();
    }

    @Override
    public boolean addPayments(PaymentsDTO dto) throws SQLException, ClassNotFoundException {
        return paymentsModelDAO.add(dto);
    }

    @Override
    public boolean updatePayments(PaymentsDTO dto) throws SQLException, ClassNotFoundException {
        return paymentsModelDAO.update(dto);
    }

    @Override
    public boolean existPayments(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewIDPayments() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean deletePayments(String id) throws SQLException, ClassNotFoundException {
        return paymentsModelDAO.delete(id);
    }

    @Override
    public PaymentsDTO searchPayments(String id) throws SQLException, ClassNotFoundException {
        return paymentsModelDAO.search(id);
    }
}
