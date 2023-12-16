
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class MainPro {
    public static int id;
    public static String username;
    public static String userpassword;
    public static String userphone;
    public static String userquestion;
    public static String useranwser;

    public static String url;
    public static String name;
    public static String password;
    public static String pysrc;
    public static String bg1;
    public static String bg2;
    public static void main(String[] args) {
        try {
            //获取配置文件
            Properties properties=new Properties();
            ClassLoader classLoader=MainPro.class.getClassLoader();
            InputStream inputStream=classLoader.getResourceAsStream("config.properties");
            properties.load(inputStream);
            inputStream.close();
            MainPro.url=properties.getProperty("db.url");
            MainPro.name=properties.getProperty("db.name");
            MainPro.password=properties.getProperty("db.password");
            MainPro.bg1=properties.getProperty("bg.bg1");
            MainPro.bg2=properties.getProperty("bg.bg2");
            MainPro.pysrc=properties.getProperty("py.src");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"找不到配置文件config.properties,或配置文件出错");
        }
        new Identity();
    }
}
