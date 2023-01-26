package lk.ijse.StudentMS.dao.custom.impl;

import lk.ijse.StudentMS.db.DBConnection;
import lk.ijse.StudentMS.model.StudentAttendanceDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentAttendanceModelDAOImpl {
    public static boolean addAttendance(StudentAttendanceDTO studentAttendanceDTO) throws ClassNotFoundException, SQLException {

        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("INSERT INTO student_attendance VALUES (?,?,?)");

        preparedStatement.setObject(1, studentAttendanceDTO.getSID());
        preparedStatement.setObject(2, studentAttendanceDTO.getDate());
        preparedStatement.setObject(3, studentAttendanceDTO.getTime());

        int executeUpdate = preparedStatement.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }

    public static boolean updateAttendance(StudentAttendanceDTO studentAttendanceDTO) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("UPDATE Employee SET UID=?, NIC=?,name=?,address=?,contact=?,email=?, salary=?  WHERE EId=?");

        preparedStatement.setObject(1, studentAttendanceDTO.getSID());
        preparedStatement.setObject(2, studentAttendanceDTO.getDate());
        preparedStatement.setObject(3, studentAttendanceDTO.getTime());


        int executeUpdate = preparedStatement.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }
    public static boolean deleteAttendance (StudentAttendanceDTO studentAttendanceDTO) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("DELETE FROM student_attendance  WHERE SID=?");
        preparedStatement.setObject(1, studentAttendanceDTO.getSID());

        int executeUpdate = preparedStatement.executeUpdate();
        if (executeUpdate > 0) {
            return true;
        }
        return false;
    }


    public static ArrayList<StudentAttendanceDTO> loadStudentAttendance() throws SQLException, ClassNotFoundException {
        ArrayList<StudentAttendanceDTO> arrayList=new ArrayList<>();
        PreparedStatement preparedStatement = DBConnection.getdBConnection().getConnection().prepareStatement("SELECT * FROM student_attendance");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            StudentAttendanceDTO studentAttendanceDTO = new StudentAttendanceDTO();
            studentAttendanceDTO.setSID(String.valueOf(resultSet.getObject(1)));
            studentAttendanceDTO.setDate(String.valueOf(resultSet.getObject(2)));
            studentAttendanceDTO.setTime(String.valueOf(resultSet.getObject(3)));

            arrayList.add(studentAttendanceDTO);
        }
        return arrayList;


    }

}
