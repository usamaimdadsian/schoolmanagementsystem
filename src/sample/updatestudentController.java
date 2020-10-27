/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.net.URL;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Usama Sian
 */
public class updatestudentController implements Initializable {

    Main application;
    int id;
    String religion="";
    Student st;
    @FXML
    Label prompt2_l;
    @FXML
    TextField searchname_t;
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
    private void save(ActionEvent event)
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
            String query="UPDATE students SET serial='"+st.getSerial()+"',name='"+st.getName()+"',fathername='"+st.getFatherName()+"',gender='"+st.getGender()+"',cnic='"+st.getCnic()+"',class='"+st.getClassname()+"',roll='"+st.getRollno()+"',dob='"+st.getBirthday().toString()+"',cell='"+st.getPhoneNumber()+"',fprofession='"+st.getFatherwork()+"',religion='"+st.getReligion()+"',address='"+st.getAddress()+"' WHERE id='"+id+"'";
            try {
                Database.insertQuery(query);
                prompt_l.setText("Successfully Updated");
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
    private void homePage(ActionEvent event) {
        application.gotoHomepage();
    }
    public void search(ActionEvent event) throws Exception {
        ResultSet rs;
        String query="SELECT * FROM students WHERE name='"+searchname_t.getText()+"'";
        rs=Database.selectQuery(query);
        if(rs.absolute(1))
        {
            id=rs.getInt("id");
            prompt2_l.setText("Data found");
        }
        else
        {
            prompt2_l.setText("Data not found");
        }
    }
    
}
