package lk.ijse.StudentMS.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.StudentMS.bo.custom.Impl.TimeSheduleBOImpl;

public class TimeSheduleFormController {
    public AnchorPane pane;
    public TableView TimeTable;
    public TableColumn Date;
    public TableColumn Time;
    public TableColumn Subject;
    public TableColumn Teacher;
    public TableColumn Availability;
    public JFXTextField txtDate;
    public JFXTextField txtTime;
    public JFXComboBox combSubject;
    public JFXComboBox combTeacher;

    TimeSheduleBOImpl timeSheduleBO = new TimeSheduleBOImpl();

    public void btnAddTSM(ActionEvent actionEvent) {
//        TimeSheduleBOImpl timeSheduleBO = new TimeSheduleBOImpl();


    }

    public void btnUpdateTSM(ActionEvent actionEvent) {
    }

    public void btnDeleteTSM(ActionEvent actionEvent) {
    }

    public void searchOnAction(ActionEvent actionEvent) {
    }

    public void btnSearch(ActionEvent actionEvent) {
    }
}
