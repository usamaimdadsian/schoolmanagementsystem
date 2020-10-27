package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application
{
    static Stage window;
    Scene scene;
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.window=primaryStage;
        gotoLogin();
        window.setTitle("FXML Login Sample");
//        window.initStyle(StageStyle.UTILITY);
        window.show();
    }

    public static void gotoLogin()
    {
        try {
            LoginController login = (LoginController) replaceSceneContent("login.fxml");
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public static void gotoSignup()
    {
        try {
            SignupController signup = (SignupController) replaceSceneContent("signup.fxml");
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


//    Swithc to home page
    public static void gotoHomepage()
    {
        try {
            HomepageController hompage = (HomepageController) replaceSceneContent("homepage.fxml");
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gotoAddstudent()
    {
        try {
            AddstudentController addstudent = (AddstudentController) replaceSceneContent("addstudent.fxml");            
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gotoStudents()
    {
        try {
            StudentsController addstudent = (StudentsController) replaceSceneContent("students.fxml");
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void gotoDelete()
    {
        try {
            DeletestudentController deletestudent = (DeletestudentController) replaceSceneContent("deletestudent.fxml");
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void gotoUpdate()
    {
        try {
            updatestudentController deletestudent = (updatestudentController) replaceSceneContent("updatestudent.fxml");
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = Main.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }
        System.out.println(page.getLayoutX());
        Scene scene = new Scene(page, page.getPrefWidth(), page.getPrefHeight());
        window.setScene(scene);
        window.sizeToScene();
        return (Initializable) loader.getController();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
