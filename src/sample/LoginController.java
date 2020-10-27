package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class LoginController implements Initializable
{
    static Main application;
    @FXML
    TextField name_t;
    @FXML
    PasswordField password_p;
    @FXML
    Label prompt_l;
    public void setApp(Main application)
    {
        this.application=application;
    }
    public void exit()
    {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void signupPage(ActionEvent event)  {
        application.gotoSignup();
//        System.out.println(application.toString());
    }
    public void homePage(ActionEvent event) throws Exception
    {     
        
        String query="SELECT * FROM admins WHERE user='"+name_t.getText()+"' AND password='"+password_p.getText()+"'";
        if(Database.checkLogin(query))
        {
            prompt_l.setText("Sign in Successfull");
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
                    pause.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        application.gotoHomepage();
                        
                    }
                });
                    pause.play();
        }
        else
        {
            prompt_l.setText("Username or password is not correct.");
        }
            
    }
}
