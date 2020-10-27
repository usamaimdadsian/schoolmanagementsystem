package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database
{

    public static Connection getConnection() throws Exception {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/fa16bcea011";
        String username = "root";
        String password = "";
        Class.forName(driver);
        System.out.println("connecting to the database");
//        try(Connection conn = DriverManager.getConnection(url, username, password))
//        {
//            System.out.println("database is connected");
//        }catch
//        (Exception e)
//        {
//            throw new IllegalStateException("Cannot connect the database!", e);
//        }
        Connection conn = DriverManager.getConnection(url, username, password);
        return  conn;
//        return null;
    }

    public static ResultSet selectQuery(String query) throws Exception
    {
        Connection con = getConnection();

        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(query);
        return rs;
    }
    public static void tableCreator() throws Exception {
        boolean temp;
        String query= "CREATE TABLE students IF NOT EXISTS(\n";
                query+=" id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,\n";
                query+=" serial INT(5) NOT NULL,\n";
                query+=" name VARCHAR(50) NOT NULL,\n";
                query+=" fathername VARCHAR(50) NOT NULL,\n";
                query+=" gender VARCHAR(10) NOT NULL,\n";
                query+=" cnic VARCHAR(50) NOT NULL,\n";
                query+=" class VARCHAR(10) NOT NULL,\n";
                query+=" roll INT(5) NOT NULL,\n";
                query+=" dob VARCHAR(50) NOT NULL,\n";
                query+=" cell VARCHAR(50) NOT NULL,\n";
                query+=" fprofession VARCHAR(100) NOT NULL,\n";
                query+=" religion VARCHAR(80) NOT NULL,\n";
                query+=" address TEXT NOT NULL\n";
                query+=" )";
                temp=insertQuery(query);
        System.out.println("one gone");
                query="CREATE TABLE admins IF NOT EXISTS(";
                query+=" id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,";
                query+=" user VARCHAR(50) NOT NULL,";
                query+=" password VARCHAR(50) NOT NULL";
                query+=" )";
                temp=insertQuery(query);
    }
    
    public static boolean checkLogin(String query) throws Exception
    {
        boolean result;
        Connection con = getConnection();

        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(query);
        result=rs.absolute(1);
        con.close();
        
        return result;
    }
    public static boolean insertQuery(String query) throws Exception
    {
        boolean result;
        int temp;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= getConnection();
        Statement statement = con.createStatement();

        // insert the data
        temp=statement.executeUpdate(query);
        result=(temp>0)? true:false;
        con.close();
        return result;
    }
}
