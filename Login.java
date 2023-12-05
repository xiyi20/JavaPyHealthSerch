
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Login {
    public Login(){
        DBconnect d=new DBconnect();
        JFrame frame=new JFrame("登录界面");
        frame.setLayout(new GridLayout(4,1));
        JPanel p1=new JPanel(){
        };
        JLabel t1=new JLabel("账号:");
        JTextField textField1=new JTextField(15);
         p1.add(t1);
         p1.add(textField1);
        JPanel p2=new JPanel();
        JLabel t2=new JLabel("密码");
        JTextField textField2=new JTextField(15);
        p2.add(t2);
        p2.add(textField2);
        JPanel p3=new JPanel();
        JButton b2=new JButton("去注册");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new Regist();
            }
        });
        JButton b1=new JButton("登录");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String name=textField1.getText();
                String password=textField2.getText();
                if (name.isEmpty()||password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "请检查是否空填");
                }else{
                    int result=d.login(name, password);
                    if (result==0) {
                        JOptionPane.showMessageDialog(null,"欢迎登陆");
                        frame.dispose();
                        new UserHome();
                    }
                    else if (result==1) {
                        JOptionPane.showMessageDialog(null,"密码有误请重新填写");
                    }
                    else if (result==2) {
                        JOptionPane.showMessageDialog(null,"请先创建用户");
                    }
                    else if (result==3) {
                        JOptionPane.showMessageDialog(null,"数据库有误");
                        
                    }
                }
                
                
            }
        });
        p3.add(b2);
        p3.add(b1);
        frame.add(p1);
        frame.add(p2);
        frame.add(p3);
        frame.setBounds(650,200,400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
    }
}
