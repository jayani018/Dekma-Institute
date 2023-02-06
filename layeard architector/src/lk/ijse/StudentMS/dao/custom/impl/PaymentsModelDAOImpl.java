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
            PaymentsDTO paymentsDTO = new PaymentsDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5),rst.getString(6));
            Payments.add(paymentsDTO);

        }
        return Payments;

    }

    @Override
    public boolean add(PaymentsDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.execute("INSERT INTO Payments VALUES (?,?,?,?,?,?)",dto.getCarID(),dto.getSID(),dto.getAmount(),dto.getDate(),dto.getPayment_months(),dto.getTime() );
    }

    @Override
    public boolean update(PaymentsDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.execute("UPDATE Payments SET SID=?, amount=?,date=?, payment_months=?,time=? WHERE cardNo=? ",dto.getSID(),dto.getAmount(),dto.getDate(),dto.getPayment_months(),dto.getTime(),dto.getCarID());

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
        return SqlUtil.execute("DELETE FROM Payments  WHERE CarID=?",id);
    }

    @Override
    public PaymentsDTO search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtil.execute("SELECT * FROM Payments WHERE CarID=?", id);
       PaymentsDTO paymentsDTO = null;
        if (rst.next()) {
           paymentsDTO = new PaymentsDTO( rst.getString("SID"),id, rst.getString("amount"),rst.getString("date"), rst.getString("payment_months"), rst.getString("time"));
        }
        return paymentsDTO;
    }
}
