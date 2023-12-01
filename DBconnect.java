package git.JavaPyHealthSerch;
import java.sql.*;

public class DBconnect {
    String jdbc="com.mysql.cj.jdbc.driver";
    String url="jdbc:mysql//localhost:3306/healthserch";
    String name="root";
    String password="324254";
    Connection c;
    public DBconnect(){
        try {
            Class.forName(jdbc);
            c=DriverManager.getConnection(url, name, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
