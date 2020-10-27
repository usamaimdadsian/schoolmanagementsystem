package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DeletestudentController implements Initializable
{
    Main application;
    @FXML
    TextField searchname_t;
    @FXML
    Label label1;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void searchdelete(ActionEvent event) throws Exception {
        boolean temp;
        String query="DELETE FROM students WHERE name='"+searchname_t.getText()+"'";
        temp=Database.insertQuery(query);
        if(temp)
        {
            label1.setText("Successfully Deleted");
        }
        else
            label1.setText("Something wrong");
    }
    public void homePage(ActionEvent event)
    {
        application.gotoHomepage();
    }
}
