package lk.ijse.StudentMS.bo.custom;

import lk.ijse.StudentMS.model.ResultDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ResultsBO {
    public ArrayList<ResultDTO> getAllResult() throws SQLException, ClassNotFoundException ;

    public boolean addResult(ResultDTO dto) throws SQLException, ClassNotFoundException;

    public boolean updateResult(ResultDTO entity) throws SQLException, ClassNotFoundException ;

    public boolean exist(String id) throws SQLException, ClassNotFoundException ;

    public String generateNewID() throws SQLException, ClassNotFoundException ;

    public boolean deleteResult(String id) throws SQLException, ClassNotFoundException ;

    public ResultDTO searchResult(String id) throws SQLException, ClassNotFoundException ;
}
