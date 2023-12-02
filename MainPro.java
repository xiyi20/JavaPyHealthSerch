package git.JavaPyHealthSerch;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
//eshi
public class MainPro {
    public static void main(String[] args) {
        new UserHome();
    }
}
class UserHome {
    public UserHome(){
        Pyhandler ph=new Pyhandler();
        JFrame f=new JFrame("用户界面");
        f.setLayout(new GridLayout(3,1));
        f.setBounds(400, 0,600, 800);
        
        //第一个分类的部分
        JPanel p1=new JPanel();
        JToggleButton p11Button=new JToggleButton("消瘦");
        JToggleButton p12Button=new JToggleButton("休克");
        JToggleButton p13Button=new JToggleButton("昏迷");
        JToggleButton p14Button=new JToggleButton("晕厥");
        JToggleButton p15Button=new JToggleButton("发热");
        JToggleButton p16Button=new JToggleButton("抽筋");
        JToggleButton p17Button=new JToggleButton("疲劳");
        JToggleButton p18Button=new JToggleButton("贫血");
        JToggleButton p19Button=new JToggleButton("猝死");
        JToggleButton p110Button=new JToggleButton("瘫痪");
        JToggleButton p111Button=new JToggleButton("脱水");
        JToggleButton p112Button=new JToggleButton("身痛");
        JToggleButton p113Button=new JToggleButton("腰背痛");
        JToggleButton p114Button=new JToggleButton("神经痛");
        JToggleButton p115Button=new JToggleButton("出汗异常");
        JToggleButton p116Button=new JToggleButton("体型异常");
        JToggleButton p117Button=new JToggleButton("癫痫和癫痫样发作");
        JToggleButton p118Button=new JToggleButton("肥胖症");
        JToggleButton p119Button=new JToggleButton("感觉障碍");
        JToggleButton p120Button=new JToggleButton("佝楼病");
        JToggleButton p121Button=new JToggleButton("毛发异常");
        JToggleButton p122Button=new JToggleButton("肌肉萎缩");
        JToggleButton p123Button=new JToggleButton("肌性肌无力");
        JToggleButton p124Button=new JToggleButton("脊柱和四肢畸形");
        //添加按键
        p1.add(p11Button);
        p1.add(p12Button);
        p1.add(p13Button);
        p1.add(p14Button);
        p1.add(p15Button);
        p1.add(p16Button);
        p1.add(p17Button);
        p1.add(p18Button);
        p1.add(p19Button);
        p1.add(p110Button);
        p1.add(p111Button);
        p1.add(p112Button);
        p1.add(p113Button);
        p1.add(p114Button);
        p1.add(p115Button);
        p1.add(p116Button);
        p1.add(p117Button);
        p1.add(p118Button);
        p1.add(p119Button);
        p1.add(p120Button);
        p1.add(p121Button);
        p1.add(p122Button);
        p1.add(p123Button);
        p1.add(p124Button);
        //第二个分类的部分
        JPanel p2=new JPanel();
        JToggleButton p21Button=new JToggleButton("血尿");
        JToggleButton p22Button=new JToggleButton("糖尿");
        JToggleButton p23Button=new JToggleButton("血尿");
        JToggleButton p24Button=new JToggleButton("糖尿");
        JToggleButton p25Button=new JToggleButton("糖尿");
        //添加按键
        p2.add(p21Button);
        p2.add(p22Button);
        p2.add(p23Button);
        p2.add(p24Button);
        p2.add(p25Button);
        //第三个分类的部分
        JPanel p3=new JPanel();
        JToggleButton p31Button=new JToggleButton("血尿");
        JToggleButton p32Button=new JToggleButton("糖尿");
        //添加按键
        p3.add(p31Button);
        p3.add(p32Button);
        //第四个分类的部分
        JPanel p4=new JPanel();
        JToggleButton p41Button=new JToggleButton("血尿");
        JToggleButton p42Button=new JToggleButton("糖尿");
        //添加按键
        p4.add(p41Button);
        p4.add(p42Button);
        //第五个分类的部分
        JPanel p5=new JPanel();
        JToggleButton p51Button=new JToggleButton("血尿");
        JToggleButton p52Button=new JToggleButton("糖尿");
        //添加按键
        p5.add(p51Button);
        p5.add(p52Button);
        //第六个分类的部分
        JPanel p6=new JPanel();
        JToggleButton p61Button=new JToggleButton("血尿");
        JToggleButton p62Button=new JToggleButton("糖尿");
        //添加按键
        p6.add(p61Button);
        p6.add(p62Button);
        //第七个分类的部分
        JPanel p7=new JPanel();
        JToggleButton p71Button=new JToggleButton("血尿");
        JToggleButton p72Button=new JToggleButton("糖尿");
        //添加按键
        p7.add(p71Button);
        p7.add(p72Button);
        //第八个分类的部分
        JPanel p8=new JPanel();
        JToggleButton p81Button=new JToggleButton("血尿");
        JToggleButton p82Button=new JToggleButton("糖尿");
        //添加按键
        p8.add(p81Button);
        p8.add(p82Button);
        //第九个分类的部分
        JPanel p9=new JPanel();
        JToggleButton p91Button=new JToggleButton("血尿");
        JToggleButton p92Button=new JToggleButton("糖尿");
        //添加按键
        p9.add(p91Button);
        p9.add(p92Button);
        //总的panel放确定按钮和文本框
        JPanel p=new JPanel();
        JTextArea tArea=new JTextArea(20,40);
        JButton queding =new JButton("确定");
        queding.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                tArea.setText("");
                String result="";
                if (p11Button.isSelected()) {
                    result=result+'1';
                }
                if (p12Button.isSelected()) {
                    result=result+",2";
                }
                if (p13Button.isSelected()) {
                    result=result+",3";
                }
                if (p14Button.isSelected()) {
                    result=result+",4";
                }
                if (p15Button.isSelected()) {
                    result=result+",5";
                }
                if (p16Button.isSelected()) {
                    result=result+",6";
                }
                if (p17Button.isSelected()) {
                    result=result+",7";
                }
                if (p18Button.isSelected()) {
                    result=result+",8";
                }
                if (p19Button.isSelected()) {
                    result=result+",9";
                }
                if (p110Button.isSelected()) {
                    result=result+",10";
                }
                if (p111Button.isSelected()) {
                    result=result+",11";
                }
                if (p112Button.isSelected()) {
                    result=result+",12";
                }
                if (p113Button.isSelected()) {
                    result=result+",13";
                }
                if (p114Button.isSelected()) {
                    result=result+",14";
                }
                if (p115Button.isSelected()) {
                    result=result+",15";
                }
                if (p116Button.isSelected()) {
                    result=result+",16";
                }
                if (p117Button.isSelected()) {
                    result=result+",17";
                }
                if (p118Button.isSelected()) {
                    result=result+",18";
                }
                if (p119Button.isSelected()) {
                    result=result+",19";
                }
                if (p120Button.isSelected()) {
                    result=result+",20";
                }
                if (p121Button.isSelected()) {
                    result=result+",21";
                }
                if (p122Button.isSelected()) {
                    result=result+",22";
                }
                if (p123Button.isSelected()) {
                    result=result+",23";
                }
                if (p124Button.isSelected()) {
                    result=result+",24";
                }
                if (p21Button.isSelected()) {
                    result=result+",26";
                }
                if (p22Button.isSelected()) {
                    result=result+",27";
                }
                if (p23Button.isSelected()) {
                    result=result+",28";
                }
                if (p24Button.isSelected()) {
                    result=result+",29";
                }
                if (p25Button.isSelected()) {
                    result=result+",30";
                }
                tArea.setText(ph.getdata(result));
            }
        });
        //添加按键
        p.add(queding);
        p.add(tArea);
        //在总的框架上添加按钮
        f.add(p1);
        f.add(p2);
        f.add(p3);
        f.add(p4);
        f.add(p5);
        f.add(p6);
        f.add(p7);
        f.add(p8);
        f.add(p9);
        f.add(p);
        f.setVisible(true);
        f.setDefaultCloseOperation(3);
    }
}

class Pyhandler {
    public Pyhandler(){}
    public String getdata(String sendin){
        try {
            ProcessBuilder pb = new ProcessBuilder("python", "getdata.py");
            Process process = pb.start();
            // 获取进程的输入流和输出流
            InputStream inputStream = process.getInputStream();
            OutputStream outputStream = process.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"gbk"));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream));
 
            writer.println(sendin);
            writer.flush();
            
            // 读取python的输出
            String line;String res="";
            int exitCode = process.waitFor();
            int flag=1;
            while ((line = reader.readLine()) !=null) {
                if(flag%2==0)res+=line+"\n\n";
                else res+=line+"\n";
                flag++;
            }
            if (res.isEmpty()) res="没有符合条件的结果";

            if (exitCode==0) System.out.println("Python程序执行完成");
            else System.out.println("Python程序执行异常,退出码:"+exitCode);
            return res;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return "好像有问题";
    }
}