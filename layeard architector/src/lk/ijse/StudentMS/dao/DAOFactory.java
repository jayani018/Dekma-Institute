package lk.ijse.StudentMS.dao;

import lk.ijse.StudentMS.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getDoFactory() {
        if (daoFactory == null) {
           daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    public enum DAOType{
        BATCH,EMPLOYEE,PAYMENTS,RESULT,STUDENT_ATTENDANCE,STUDENT,SUBJECT,TEACHER
    }
    public SuperDAO getDAO(DAOFactory.DAOType type){
        switch (type){
            case BATCH:
                return new BatchModelDAOImpl();
            case EMPLOYEE:
                return new EmployeeModelDAOImpl();
            case PAYMENTS:
                return new PaymentsModelDAOImpl();
            case RESULT:
                return new ResultModelDAOImpl();
            case STUDENT_ATTENDANCE:
                return new StudentAttendanceModelDAOImpl();
            case STUDENT:
                return null;
            case SUBJECT:
                return null;
            case TEACHER:
                return null;
            default:
                return null;
        }
    }
}