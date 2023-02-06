package lk.ijse.StudentMS.bo.custom.Impl;

import lk.ijse.StudentMS.bo.BOFactory;
import lk.ijse.StudentMS.bo.custom.StudentsBO;
import lk.ijse.StudentMS.dao.custom.StudentModelDAO;
import lk.ijse.StudentMS.model.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentsBOImpl implements StudentsBO {

//   StudentModelDAO studentModelDAO = new StudentModelDAOImpl();
StudentModelDAO studentModelDAO = (StudentModelDAO) BOFactory.getBoFactory().getBO(BOFactory.BOType.STUDENT);

    public ArrayList<StudentDTO> getAllStudent() throws SQLException, ClassNotFoundException {
        return studentModelDAO.getAll();
    }

    @Override
    public boolean addStudent(StudentDTO dto) throws SQLException, ClassNotFoundException {
        return studentModelDAO.add(dto);
    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws SQLException, ClassNotFoundException {
        return studentModelDAO.update(dto);
    }

    @Override
    public boolean existStudent(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewIDStudent() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean deleteStudent(String id) throws SQLException, ClassNotFoundException {
        return studentModelDAO.delete(id);
    }

    @Override
    public StudentDTO searchStudent(String id) throws SQLException, ClassNotFoundException {
        return studentModelDAO.search(id);
    }
}
