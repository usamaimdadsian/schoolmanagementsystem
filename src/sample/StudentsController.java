package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentsController implements Initializable
{
    ObservableList<Student> students_ob;
    ArrayList<Student> studentslist=new ArrayList<>();
    @FXML
    TableView<Student> students_tbl;
    @FXML
    TextField searchname_t;
    @FXML
    Label lable1;


    TableColumn<Student,String> name_col,fathername_col,address_col,gender_col,cnic_col,class_col,birthday_col,cell_col,profession_col,relegion_col;
    TableColumn<Student,Integer> roll_col,serial_col;

    Main application;


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }
    public ObservableList<Student> getRows(String query)
    {
        ObservableList<Student> students=FXCollections.observableArrayList();
        ResultSet rs;
        try {
            rs=Database.selectQuery(query);
            while(rs.next())
            {
                studentslist.add(new Student(rs.getInt("serial"),rs.getString("name"),rs.getString("fathername"),rs.getString("gender"),rs.getString("cnic"),rs.getString("class"),rs.getInt("roll"), LocalDate.parse(rs.getString("dob")),rs.getString("cell"),rs.getString("fprofession"),rs.getString("religion"),rs.getString("address")));
            }
            for(Student temp:studentslist)
            {
                students.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
    public void tableview(String query)
    {
        students_tbl.setEditable(true);
        students_ob=getRows(query);

        roll_col=new TableColumn<>("Roll");
        roll_col.setCellValueFactory(new PropertyValueFactory<Student,Integer>("rollno"));

        name_col=new TableColumn<>("Name");
        name_col.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));

        fathername_col=new TableColumn<>("Father Name");
        fathername_col.setCellValueFactory(new PropertyValueFactory<Student,String>("fatherName"));

        gender_col=new TableColumn<>("Gender");
        gender_col.setCellValueFactory(new PropertyValueFactory<Student,String>("gender"));

        cnic_col=new TableColumn<>("CNIC");
        cnic_col.setCellValueFactory(new PropertyValueFactory<Student,String>("cnic"));

        class_col=new TableColumn<>("Class");
        class_col.setCellValueFactory(new PropertyValueFactory<Student,String>("classname"));

        birthday_col=new TableColumn<>("Birthday");
        birthday_col.setCellValueFactory(new PropertyValueFactory<Student,String>("birthday"));

        profession_col=new TableColumn<>("Father Profession");
        profession_col.setCellValueFactory(new PropertyValueFactory<Student,String>("fatherwork"));

        relegion_col=new TableColumn<>("Relegion");
        relegion_col.setCellValueFactory(new PropertyValueFactory<Student,String>("religion"));


        cell_col=new TableColumn<>("Cell Number");
        cell_col.setCellValueFactory(new PropertyValueFactory<Student,String>("phoneNumber"));

        serial_col=new TableColumn<>("Serial");
        serial_col.setCellValueFactory(new PropertyValueFactory<Student,Integer>("serial"));

        address_col=new TableColumn<>("Address");
        address_col.setCellValueFactory(new PropertyValueFactory<Student,String>("Address"));

        students_tbl.setItems(students_ob);
        students_tbl.getColumns().addAll(roll_col,serial_col,name_col,fathername_col,cell_col,gender_col,cnic_col,class_col,birthday_col,profession_col,relegion_col,address_col);
    }
    public void search(ActionEvent event)
    {
        String query="SELECT * FROM students WHERE name='"+searchname_t.getText()+"'";
        tableview(query);
    }
    public void nursery(ActionEvent event)
    {
        String query="SELECT * FROM students WHERE class='Nursery'";
        tableview(query);
    }
    public void prep(ActionEvent event)
    {
        String query="SELECT * FROM students WHERE class='Prep'";
        tableview(query);
    }
    public void one(ActionEvent event)
    {
        String query="SELECT * FROM students WHERE class='One'";
        tableview(query);
    }
    public void two(ActionEvent event)
    {
        String query="SELECT * FROM students WHERE class='Two'";
        tableview(query);
    }
    public void three(ActionEvent event)
    {
        String query="SELECT * FROM students WHERE class='Three'";
        tableview(query);
    }
    public void four(ActionEvent event)
    {
        String query="SELECT * FROM students WHERE class='Four'";
        tableview(query);
    }
    public void five(ActionEvent event)
    {
        String query="SELECT * FROM students WHERE class='Five'";
        tableview(query);
    }
    public void six(ActionEvent event)
    {
        String query="SELECT * FROM students WHERE class='Six'";
        tableview(query);
    }
    public void seven(ActionEvent event)
    {
        String query="SELECT * FROM students WHERE class='Seven'";
        tableview(query);
    }
    public void eight(ActionEvent event)
    {
        String query="SELECT * FROM students WHERE class='Eight'";
        tableview(query);
    }
    public void homePage(ActionEvent event)
    {
        application.gotoHomepage();
    }

}
