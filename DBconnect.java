
import java.sql.*;
 
public class DBconnect {
    String jdbc="com.mysql.cj.jdbc.Driver";
    String url=MainPro.url;
    String name=MainPro.name;
    String password=MainPro.password;
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
        String exec="select password from users where username='"+name+"'";
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
    public String[] usermodify(int mode,String username,String password,String phone){
        String exitcode="0";
        String id="";
        String exec="select id,password,phone from users where username='"+username+"'";
        String exec1="updata users set username='"+username+"' where id='"+MainPro.id+"'";
        String exec2="updata users set password='"+password+"' where id='"+MainPro.id+"'";
        String exec3="updata users set phone='"+phone+"' where id='"+MainPro.id+"'";
        try {
            Statement s=c.createStatement();
            if(mode==0){
                ResultSet r=s.executeQuery(exec);
                if (r.next()) {
                    id=r.getString("id");
                    password=r.getString("password");
                    phone=r.getString("phone");
                }
            }else if(mode==1){
                s.executeUpdate(exec1);
            }else if(mode==2){
                s.executeUpdate(exec2);
            }else{
                s.executeUpdate(exec3);
            }
        } catch (Exception e) {
            exitcode="2";
        }


        String[] result={exitcode,id,password,phone};
        return result;
    }
    public int Forgetpw(String username, String anwser, String password2) {
        return 0;
    }
}
