package lk.ijse.StudentMS.bo;

import lk.ijse.StudentMS.bo.custom.Impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getBoFactory() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }
    public enum BOType{
        BATCH,EMPLOYEE,PAYMENTS,RESULT,STUDENT_ATTENDANCE,STUDENT,SUBJECT,TEACHER
    }
    public SuperBO getBO(BOType type){
        switch (type){
            case BATCH:
                return new BatchBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case PAYMENTS:
               return new PaymentsBOImpl();
            case RESULT:
                return new ResultsBOImpl();
            case STUDENT_ATTENDANCE:
                return new StudentAttendanceBOImpl();
            case STUDENT:
                return new StudentsBOImpl();
            case SUBJECT:
                return new SubjectBOImpl();
            case TEACHER:
                return new TeacherBOImpl();
            default:
                return null;
        }
    }
}
