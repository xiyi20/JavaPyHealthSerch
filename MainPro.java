
import java.io.*;
import java.util.*;

public class MainPro {
    

    public static String url;
    public static String name;
    public static String password;
    public static int pycode;
    public static String bg1;
    public static String bg2;
    public static void main(String[] args) {
        try {
            Properties properties=new Properties();
            FileInputStream fileInputStream=new FileInputStream("E:\\workContact\\JavaPyHealthSerch\\config.properties");
            properties.load(fileInputStream);
            fileInputStream.close();
            MainPro.url=properties.getProperty("db.url");
            MainPro.name=properties.getProperty("db.name");
            MainPro.password=properties.getProperty("db.password");
            MainPro.pycode=Integer.parseInt(properties.getProperty("py.code"));
            MainPro.bg1=properties.getProperty("bg.bg1");
            MainPro.bg2=properties.getProperty("bg.bg2");
        } catch (Exception e) {
            System.out.println("找不到配置文件,或配置文件出错");
        }
        new Login();
    }
}
