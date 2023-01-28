package lk.ijse.StudentMS.dao.custom.impl;

import lk.ijse.StudentMS.dao.SqlUtil;
import lk.ijse.StudentMS.dao.custom.PaymentsModelDAO;
import lk.ijse.StudentMS.model.PaymentsDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentsModelDAOImpl implements PaymentsModelDAO {


    @Override
    public ArrayList<PaymentsDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<PaymentsDTO> Payments = new ArrayList<>();
        ResultSet rst = SqlUtil.execute("SELECT * FROM Payments");
        while (rst.next()){
            PaymentsDTO paymentsDTO = new PaymentsDTO(rst.getString("SID"), rst.getString("CarID"), rst.getString("amount"), rst.getString("payment_months"), rst.getString("time"));
            Payments.add(paymentsDTO);

        }
        return Payments;

    }

    @Override
    public boolean add(PaymentsDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.execute("INSERT INTO Payments VALUES (?,?,?,?,?)",dto.getSID(),dto.getCarID(),dto.getAmount(),dto.getPayment_months(),dto.getTime() );
    }

    @Override
    public boolean update(PaymentsDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.execute("UPDATE Payments SET SID=?, cardNo=?,amount=?, payment_months=?,time=? WHERE SId=?", dto.getCarID(),dto.getAmount(),dto.getPayment_months(),dto.getTime(),dto.getSID());

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
        return SqlUtil.execute("DELETE FROM Payments  WHERE SId=?",id);
    }

    @Override
    public PaymentsDTO search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtil.execute("SELECT * FROM Batch WHERE BID=?", id);
       PaymentsDTO paymentsDTO = null;
        if (rst.next()) {
           paymentsDTO = new PaymentsDTO(id, rst.getString("CarID"), rst.getString("amount"), rst.getString("payment_months"), rst.getString("time"));
        }
        return paymentsDTO;
    }
}
