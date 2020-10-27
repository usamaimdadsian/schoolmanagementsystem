package sample;

import javafx.animation.PauseTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Duration;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AddstudentController implements Initializable
{
    Student st;
    String religion="";

    Main application;
    @FXML
    TextField serial_t,name_t,fatherName_t,cnic_t,roll_t,cell_t,profession_t;
    @FXML
    TextArea address_ta;
    @FXML
    ComboBox class_c;
    @FXML
    RadioButton male_r,female_r,islam_r,christian_r,hindu_r,sikh_r;
    @FXML
    DatePicker dob;
    @FXML
    Label prompt_l;
    @FXML
    private ToggleGroup gender;
    @FXML
    private Label gender_l;
    @FXML
    private Label cnic_l;
    @FXML
    private Label class_l;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        serial_t.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(!newValue.matches("\\d*"))
                {
                    serial_t.setText(newValue.replaceAll("[^\\d]",""));
                }
            }
        });

        cnic_t.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(!newValue.matches("\\d*"))
                {
                    cnic_t.setText(newValue.replaceAll("[^\\d]",""));
                }
            }
        });

        roll_t.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(!newValue.matches("\\d*"))
                {
                    roll_t.setText(newValue.replaceAll("[^\\d]",""));
                }
            }
        });

        cell_t.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(!newValue.matches("\\d*"))
                {
                    cell_t.setText(newValue.replaceAll("[^\\d]",""));
                }
            }
        });
        class_c.getItems().addAll("Nursery","Prep","One","Two","Three","Four","Five","Six","Seven","Eight");
    }

    @FXML
    public void homePage(ActionEvent event)
    {
       application.gotoHomepage();
    }

    @FXML
    public  void save(ActionEvent event)
    {
        LocalDate temp=dob.getValue();
        if(serial_t.getText().isEmpty())
        {
            prompt_l.setText("Serial Number can't be empty");
        }
        else if(name_t.getText().isEmpty())
        {
            prompt_l.setText("Name can't be empty");
        }
        else if(fatherName_t.getText().isEmpty())
        {
            prompt_l.setText("Father name can't be empty");
        }
        else if(cnic_t.getText().isEmpty())
        {
            prompt_l.setText("Cnic can't be empty");
        }
        else if(class_c.getValue()==null)
        {
            prompt_l.setText("You did not select any class");
        }
        else if(roll_t.getText().isEmpty())
        {
            prompt_l.setText("You did't enter roll number.");
        }
        else if(temp==null)
        {
            prompt_l.setText("You did't Select date of birth");
        }
        else if(cell_t.getText().isEmpty())
        {
            prompt_l.setText("You did't enter cell phone number");
        }
        else if(profession_t.getText().isEmpty())
        {
            prompt_l.setText("You did't enter father profession");
        }
        else if(address_ta.getText().isEmpty())
        {
            prompt_l.setText("You forgot to enter address");
        }
        else
        {
            String male;
            male=(male_r.isSelected())? "Male":"Female";
            if(islam_r.isSelected())
            {
                religion="Islam";
            }
            else if(hindu_r.isSelected())
            {
                religion="Hindu";
            }
            else if(sikh_r.isSelected())
            {
                religion="Sikh";
            }
            else if(christian_r.isSelected())
            {
                religion="Christian";
            }
            st=new Student(Integer.parseInt(serial_t.getText()),name_t.getText(),fatherName_t.getText(),male,cnic_t.getText(),class_c.getValue().toString(),Integer.parseInt(roll_t.getText()),temp,cell_t.getText(),profession_t.getText(),religion,address_ta.getText());
            String query="INSERT INTO students(serial,name,fathername,gender,cnic,class,roll,dob,cell,fprofession,religion,address) VALUES('"+st.getSerial()+"','"+st.getName()+"','"+st.getFatherName()+"','"+st.getGender()+"','"+st.getCnic()+"','"+st.getClassname()+"','"+st.getRollno()+"','"+st.getBirthday().toString()+"','"+st.getPhoneNumber()+"','"+st.getFatherwork()+"','"+st.getReligion()+"','"+st.getAddress()+"')";
            try {
                Database.insertQuery(query);
                prompt_l.setText("Successfully Added");
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        application.gotoHomepage();
                    }
                });
                pause.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    public  void reset(ActionEvent event)
    {
        serial_t.setText("");
        name_t.setText("");
        fatherName_t.setText("");
        cnic_t.setText("");
        class_c.setValue(null);
        roll_t.setText("");
        cell_t.setText("");
        dob.setValue(null);
        profession_t.setText("");
        address_ta.setText("");
        islam_r.isSelected();
        male_r.isSelected();
        address_ta.setText("");
    }
}
