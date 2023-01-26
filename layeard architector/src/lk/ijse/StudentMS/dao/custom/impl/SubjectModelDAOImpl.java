package lk.ijse.StudentMS.dao.custom.impl;

import lk.ijse.StudentMS.dao.custom.SubjectModelDAO;
import lk.ijse.StudentMS.model.SubjectDTO;

import java.sql.SQLException;
import java.util.ArrayList;

//import lk.ijse.StudentMS.model.Student;

public class SubjectModelDAOImpl implements SubjectModelDAO {

    @Override
    public ArrayList<SubjectDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(SubjectDTO entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(SubjectDTO entity) throws SQLException, ClassNotFoundException {
        return false;
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
        return false;
    }

    @Override
    public SubjectDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
