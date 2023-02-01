package lk.ijse.StudentMS.bo.custom;

import lk.ijse.StudentMS.model.SubjectDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SubjectBO {
    public ArrayList<SubjectDTO> getAll() throws SQLException, ClassNotFoundException;

    public boolean add(SubjectDTO dto) throws SQLException, ClassNotFoundException;

    public boolean update(SubjectDTO dto) throws SQLException, ClassNotFoundException ;

    public boolean exist(String id) throws SQLException, ClassNotFoundException;

    public String generateNewID() throws SQLException, ClassNotFoundException ;

    public boolean delete(String id) throws SQLException, ClassNotFoundException;

    public SubjectDTO search(String id) throws SQLException, ClassNotFoundException ;
}
