package git.JavaPyHealthSerch;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;


public class MainPro {
    public static String result;
    public static void main(String[] args) {
        new UserHome();
    }
}

class UserHome {
    public UserHome(){
        JFrame f=new JFrame("用户界面");
        f.setBounds(600, 400, 400, 400);
        JPanel p1=new JPanel(new FlowLayout());
        
        JToggleButton xiaoshou=new JToggleButton("消瘦");
        JToggleButton xiuke=new JToggleButton("休克");
        

        JButton b1=new JButton("确定");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String result="";
                if (xiaoshou.isSelected()) {
                    result=result+"1";
                }
                if (xiuke.isSelected()) {
                    result=result+",2";
                }
                MainPro.result=result;
                new InnerPy();
            }
        });


        p1.add(xiaoshou);
        p1.add(xiuke);
        p1.add(b1);
        f.add(p1);
        f.setVisible(true);
        f.setDefaultCloseOperation(3);
    }
}

class InnerPy {
    public InnerPy(){
        try {
            ProcessBuilder pb = new ProcessBuilder("python", "git\\JavaPyHealthSerch\\getdata.py");
            Process process = pb.start();
            
            // 获取进程的输入流和输出流
            InputStream inputStream = process.getInputStream();
            OutputStream outputStream = process.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream));
 
            writer.println(MainPro.result);
            writer.flush();
            
            // 读取python的输出
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            // 等待进程执行完成
            int exitCode = process.waitFor();
            System.out.println("Python程序执行完成,退出码:" + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}