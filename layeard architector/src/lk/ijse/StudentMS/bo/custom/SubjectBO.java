package lk.ijse.StudentMS.bo.custom;

import lk.ijse.StudentMS.bo.SuperBO;
import lk.ijse.StudentMS.model.SubjectDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SubjectBO extends SuperBO {
    public ArrayList<SubjectDTO> getAllSubject() throws SQLException, ClassNotFoundException;

    public boolean addSubject(SubjectDTO dto) throws SQLException, ClassNotFoundException;

    public boolean updateSubject(SubjectDTO dto) throws SQLException, ClassNotFoundException ;

    public boolean existSubject(String id) throws SQLException, ClassNotFoundException;

    public String generateNewIDSubject() throws SQLException, ClassNotFoundException ;

    public boolean deleteSubject(String id) throws SQLException, ClassNotFoundException;

    public SubjectDTO searchSubject(String id) throws SQLException, ClassNotFoundException ;
}
