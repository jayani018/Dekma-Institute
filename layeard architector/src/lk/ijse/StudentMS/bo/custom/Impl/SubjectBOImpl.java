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
    public ArrayList<SubjectDTO> getAll() throws SQLException, ClassNotFoundException {
        return subjectModelDAO.getAll();
    }

    @Override
    public boolean add(SubjectDTO dto) throws SQLException, ClassNotFoundException {
        return subjectModelDAO.add(dto);
    }

    @Override
    public boolean update(SubjectDTO dto) throws SQLException, ClassNotFoundException {
        return subjectModelDAO.update(dto);
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
        return subjectModelDAO.delete(id);
    }

    @Override
    public SubjectDTO search(String id) throws SQLException, ClassNotFoundException {
        return subjectModelDAO.search(id);
    }
}
