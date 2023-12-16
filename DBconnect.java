
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
    public int login(int mode,String name,String pw){
        int exitcode=0;
        String exec="";
        if (mode==0) exec="select password from users where username='"+name+"'";
        else exec="select password from users_r where rootname='"+name+"'";
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
    public int regist(String username,String password,String sex,String phone,String question,String anwser){
        int exitcode=0;
        try {
            Statement s=c.createStatement();
            String exec1=String.format("select username from users where username='%s'",username);
            ResultSet r=s.executeQuery(exec1);
            if(r.next()) exitcode=1;//已存在此用户
            else{
                try {
                    String exec2=String.format("insert into users (username,password,sex,phone,question,anwser) values ('%s','%s','%s','%s','%s','%s')",username,password,sex,phone,question,anwser);
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
    public String[] usermodify(int mode,String username,String password,String phone,String question,String anwser){
        String exitcode="0";
        String id="";
        try {
            Statement s=c.createStatement();
            if(mode==0){
                String exec="select id,password,phone,question,anwser from users where username='"+username+"'";
                ResultSet r=s.executeQuery(exec);
                if (r.next()) {
                    id=r.getString(1);
                    password=r.getString(2);
                    phone=r.getString(3);
                    question=r.getString(4);
                    anwser=r.getString(5);
                }
            }else if(mode==1){
                String exec1="update users set username='"+username+"' where id="+MainPro.id;
                s.executeUpdate(exec1);
            }else if(mode==2){
                String exec2="update users set password='"+password+"' where id="+MainPro.id;
                s.executeUpdate(exec2);
            }else if(mode==3){
                String exec3="update users set phone='"+phone+"' where id="+MainPro.id;
                s.executeUpdate(exec3);
            }else if(mode==4){
                String exec4="update users set question='"+question+"' where id="+MainPro.id;
                s.executeUpdate(exec4);
            }else{
                String exec5="update users set anwser='"+anwser+"' where id="+MainPro.id;
                s.executeUpdate(exec5);
            }
        } catch (Exception e) {
            e.printStackTrace();
            exitcode="2";
        }
        String[] result={exitcode,id,password,phone,question,anwser};
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
    public String[][] history(int mode,String content,String time){
        String[][] table={};
        try {
            Statement s=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            if(mode==0){
                String exec1=String.format("insert into history values (%d,'%s','%s')",MainPro.id,content,time);
                s.executeUpdate(exec1);
            }else if(mode==1){
                String exec2="select * from history where id="+MainPro.id;
                ResultSet r=s.executeQuery(exec2);
                int col=3;
                int row=0;
                for(;r.next();row++);
                table=new String[row][col];
                r.beforeFirst();
                int y=0;
                while(r.next()){
                    String[] data={r.getString(1),r.getString(2),r.getString(3)};
                    for(int x=0;x<col;x++){
                        table[y][x]=data[x];
                    }
                    y++;
                }
            }else{
                String exec3="delete from history where id="+MainPro.id;
                s.executeUpdate(exec3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }
    public String[][] userinfo(int mode,String name){
        String[][] result={};
        int col=5;
        int row=0;
        try {
            String exec="";
            Statement s=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            if(mode==0) exec="select id,username,password,sex,phone from users";
            else if(mode==1) exec="select id,username,password,sex,phone from users where username='"+name+"'";
            ResultSet r=s.executeQuery(exec);
            for(;r.next();row++);
            result=new String[row][col];
            int y=0;
            r.beforeFirst();
            while (r.next()) {
                String id=r.getString("id");
                String username=r.getString("username");
                String password=r.getString("password");
                String sex=r.getString("sex");
                String phone=r.getString("phone");
                String[] data={id,username,password,sex,phone};
                for(int i=0;i<col;i++){
                    result[y][i]=data[i];  
                }
                y++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public int shuju(int id,String name,String sex,String pw,String phone){
        int exitcode=0;
        try {
            String exec="UPDATE users SET username='"+name+"',sex='"+sex+"',password='"+pw+"',phone='"+phone+"' where id="+id; 
            Statement s=c.createStatement();
            s.executeUpdate(exec);
        } catch (Exception e) {
            exitcode=1;
        }
        return exitcode;
    }
}
