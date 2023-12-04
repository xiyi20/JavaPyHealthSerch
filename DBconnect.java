
import java.sql.*;
 
public class DBconnect {
    String jdbc="com.mysql.cj.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/healthserch";
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
    public int login(String name,String pw){
        int exitcode=0;
        String exec="select password from paintinfo where name='"+name+"'";
        try {
            Statement s=c.createStatement();
            ResultSet r=s.executeQuery(exec);
            if(r.next()){
                if (pw.equals(r.getString("password"))==false) {
                    exitcode=1;//密码错误
                }
            }
            else exitcode=2;//不存在此用户
        } catch (Exception e) {
            exitcode=3;//程序错误退出
            e.printStackTrace();
        }
        return exitcode;
    }
    public int regist(String username,String password,String sex,String phone){
        int exitcode=0;
        String exec1=String.format("select username from users where username='%s'",username);
        String exec2=String.format("insert into users (username,password,sex,phone) values ('%s','%s','%s','%s')",username,password,sex,phone);
        try {
            Statement s=c.createStatement();
            ResultSet r=s.executeQuery(exec1);
            if(r.next()) exitcode=1;//已存在此用户
            else{
                try {
                    s.executeUpdate(exec2);
                } catch (Exception e) {
                    e.printStackTrace();
                    exitcode=2;//sql报错
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exitcode;
    }
}
