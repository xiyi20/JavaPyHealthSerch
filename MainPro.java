package git.JavaPyHealthSerch;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;


public class MainPro {
    public static void main(String[] args) {
        new UserHome();
    }
}

class UserHome {
    public UserHome(){
        InnerPy innerpy=new InnerPy();
        JFrame f=new JFrame("用户界面");
        f.setBounds(600, 200, 600, 400);
        JPanel p1=new JPanel(new FlowLayout());
        JTextArea tarea=new JTextArea(20, 40);
        JToggleButton xiaoshou=new JToggleButton("消瘦");
        JToggleButton xiuke=new JToggleButton("休克");
        

        JButton b1=new JButton("确定");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                tarea.setText("");
                String result="";
                if (xiaoshou.isSelected()) {
                    result=result+"1";
                }
                if (xiuke.isSelected()) {
                    result=result+",2";
                }
                tarea.setText(innerpy.getdata(result));
            }
        });


        p1.add(xiaoshou);
        p1.add(xiuke);
        p1.add(b1);
        p1.add(tarea);

        f.add(p1);
        f.setVisible(true);
        f.setDefaultCloseOperation(3);
    }
}

class InnerPy {
    public InnerPy(){}
    public String getdata(String sendin){
        try {
            ProcessBuilder pb = new ProcessBuilder("python", "git\\JavaPyHealthSerch\\Getdata.py");
            Process process = pb.start();
            // 获取进程的输入流和输出流
            InputStream inputStream = process.getInputStream();
            OutputStream outputStream = process.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "gbk"));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream));
 
            writer.println(sendin);
            writer.flush();
            
            // 读取python的输出
            String line;String res="";
            int exitCode = process.waitFor();
            int flag=1;
            while ((line = reader.readLine())!=null) {
                if(flag%2==0)res+=line+"\n\n";
                else res+=line+"\n";
                flag++;
            }
            if (exitCode==0) System.out.println("Python程序执行完成");
            else System.out.println("Python程序执行异常,退出码:"+exitCode);
            return res;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return "好像有问题";
    }
}