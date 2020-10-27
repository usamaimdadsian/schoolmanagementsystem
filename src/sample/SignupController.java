package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class SignupController implements Initializable
{
    static Main appliction;
    String msg="";
    @FXML
    TextField username_t;
    @FXML
    PasswordField password_p,repassword_p;
    @FXML
    Label prompt_l;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void exit()
    {
        System.exit(0);
    }

    public void signinPage(ActionEvent event)
    {
        appliction.gotoLogin();
    }

    public void signup(ActionEvent event) throws Exception {
        if(username_t.getText().isEmpty())
        {
            prompt_l.setText("username can't be empty");
        }
        else if(password_p.getText().length()<5)
        {
            prompt_l.setText("Password should be 5 characters long");
        }
        else if(!password_p.getText().equals(repassword_p.getText()))
        {
            prompt_l.setText("Your retype password is not same");
        }
        else
        {
            String query="INSERT INTO admins(user,password) VALUES('"+username_t.getText()+"','"+password_p.getText()+"')";
            if(Database.insertQuery(query))
            {
                prompt_l.setText("Successfully Signed Up.");
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                    pause.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        appliction.gotoLogin();
                    }
                });
                    pause.play();
            }
            else
            {
                prompt_l.setText("Something goes wrong.");
            }
//            System.out.println(query);
        }

    }
}
