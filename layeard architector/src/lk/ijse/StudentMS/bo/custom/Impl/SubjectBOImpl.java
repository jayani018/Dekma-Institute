package lk.ijse.StudentMS.bo.custom.Impl;

import lk.ijse.StudentMS.bo.custom.SubjectBO;
import lk.ijse.StudentMS.dao.custom.SubjectModelDAO;
import lk.ijse.StudentMS.dao.custom.impl.SubjectModelDAOImpl;
import lk.ijse.StudentMS.model.SubjectDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class SubjectBOImpl implements SubjectBO {

    SubjectModelDAO subjectModelDAO = new SubjectModelDAOImpl();
    @Override
    public ArrayList<SubjectDTO> getAllSubject() throws SQLException, ClassNotFoundException {
        return subjectModelDAO.getAll();
    }

    @Override
    public boolean addSubject(SubjectDTO dto) throws SQLException, ClassNotFoundException {
        return subjectModelDAO.add(dto);
    }

    @Override
    public boolean updateSubject(SubjectDTO dto) throws SQLException, ClassNotFoundException {
        return subjectModelDAO.update(dto);
    }

    @Override
    public boolean existSubject(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewIDSubject() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean deleteSubject(String id) throws SQLException, ClassNotFoundException {
        return subjectModelDAO.delete(id);
    }

    @Override
    public SubjectDTO searchSubject(String id) throws SQLException, ClassNotFoundException {
        return subjectModelDAO.search(id);
    }
}
