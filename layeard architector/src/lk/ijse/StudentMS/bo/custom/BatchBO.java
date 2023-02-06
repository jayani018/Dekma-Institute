package lk.ijse.StudentMS.bo.custom;

import lk.ijse.StudentMS.bo.SuperBO;
import lk.ijse.StudentMS.model.BatchDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BatchBO extends SuperBO {
    public ArrayList<BatchDTO> getAllBatch() throws SQLException, ClassNotFoundException ;


    public  boolean addBatch(BatchDTO dto) throws SQLException, ClassNotFoundException ;


    public boolean updateBatch(BatchDTO dto) throws SQLException, ClassNotFoundException ;


    public boolean exist(String id) throws SQLException, ClassNotFoundException;


    public String generateNewID() throws SQLException, ClassNotFoundException ;


    public boolean deleteBatch(String id) throws SQLException, ClassNotFoundException ;


    public BatchDTO searchBatch(String id) throws SQLException, ClassNotFoundException ;




}
