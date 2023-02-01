package lk.ijse.StudentMS.bo.custom;

import lk.ijse.StudentMS.model.PaymentsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PaymentsBO {
    public ArrayList<PaymentsDTO> getAllPayments() throws SQLException, ClassNotFoundException ;

    public boolean addPayments(PaymentsDTO dto) throws SQLException, ClassNotFoundException;

    public boolean updatePayments(PaymentsDTO dto) throws SQLException, ClassNotFoundException ;


    public boolean existPayments(String id) throws SQLException, ClassNotFoundException ;

    public String generateNewIDPayments() throws SQLException, ClassNotFoundException ;

    public boolean deletePayments(String id) throws SQLException, ClassNotFoundException;

    public PaymentsDTO searchPayments(String id) throws SQLException, ClassNotFoundException;
}
