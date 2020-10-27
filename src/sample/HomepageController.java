package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class HomepageController implements Initializable
{
    Main application;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void addStudent(ActionEvent event)
    {
        application.gotoAddstudent();
    }
    public void exit(ActionEvent event)
    {
        System.exit(0);
    }
    public void delete(ActionEvent event)
    {
        application.gotoDelete();
    }
    public void students(ActionEvent event)
    {
        application.gotoStudents();
    }
    public void update(ActionEvent event)
    {
        application.gotoUpdate();
    }
}
