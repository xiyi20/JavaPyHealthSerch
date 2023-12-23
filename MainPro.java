
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
    public static int bgmode1=9;
    public static int bgmode2=9;
    public static String bg1;
    public static String bg2;
    public static void main(String[] args) {
        try {
            //获取配置文件
            Properties properties=new Properties();
            FileInputStream inputStream=new FileInputStream(System.getenv("health_config"));
            Reader reader=new InputStreamReader(inputStream, "utf-8");
            properties.load(reader);
            inputStream.close();
            MainPro.url=properties.getProperty("db.url");
            MainPro.name=properties.getProperty("db.name");
            MainPro.password=properties.getProperty("db.password");
            String[] bg={"bg1","bg2"};
            String[] value={"image/bg1.jpg","image/bg2.jpg"};
            for(int i=0;i<2;i++){
                String bg_t=properties.getProperty("bg."+bg[i]);
                if(bg_t.isEmpty()){
                    bg_t=value[i];
                    if(i==0) MainPro.bgmode1=0;
                    else MainPro.bgmode2=0;
                }
                if(i==0) MainPro.bg1=bg_t;
                else MainPro.bg2=bg_t;    
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"找不到配置文件config.properties,或配置文件出错!\n请检查配置文件或定义环境变量:health_config");
            System.exit(1);
        }
        new Identity();
    }
}
