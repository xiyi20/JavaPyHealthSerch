
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
        try {
            Statement s=c.createStatement();
            if(mode==0){
                String exec="select id,password,phone from users where username='"+username+"'";
                ResultSet r=s.executeQuery(exec);
                if (r.next()) {
                    id=r.getString("id");
                    password=r.getString("password");
                    phone=r.getString("phone");
                }
            }else if(mode==1){
                String exec1="update users set username='"+username+"' where id="+MainPro.id;
                s.executeUpdate(exec1);
            }else if(mode==2){
                String exec2="update users set password='"+password+"' where id="+MainPro.id;
                s.executeUpdate(exec2);
            }else{
                String exec3="update users set phone='"+phone+"' where id="+MainPro.id;
                s.executeUpdate(exec3);
            }
        } catch (Exception e) {
            e.printStackTrace();
            exitcode="2";
        }
        String[] result={exitcode,id,password,phone};
        return result;
    }
    public String[] Forgetpw(int mode,String username, String anwser, String password){
        String exitcode="0";
        String question="";
        String anwser_="";
        try {
            Statement s=c.createStatement();
            if(mode==0){
                String exec1="select question,anwser from users where username='"+username+"'";
                ResultSet r=s.executeQuery(exec1);
                if(r.next()){
                    question=r.getString(1);
                    anwser_=r.getString(2);
                }else exitcode="1";//用户不存在
            }else if(mode==1){
                if(anwser.equals(MainPro.useranwser)){
                    String exec2="update users set password='"+password+"' where username='"+username+"'";
                    s.executeUpdate(exec2);
                }else exitcode="2";//答案错误
            }
            
        } catch (Exception e) {
           exitcode="3";
        }
        String[] result={exitcode,question,anwser_};
        return result;
    }
}
