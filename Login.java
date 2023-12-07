
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Login {
    public Login(){
        DBconnect d=new DBconnect();
        JFrame frame=new JFrame("登录界面");
        
        JPanel bg=new Bgpanel().getbg(0,4,1);

        JPanel banner=new JPanel();
        JLabel banner1=new JLabel("欢迎登录");
        banner1.setFont(new Font("宋体",0,35));
        banner.setOpaque(false);
        banner.add(banner1);

        JPanel p1=new JPanel();
        p1.setOpaque(false);
        JLabel t1=new JLabel("账号：");
        t1.setOpaque(false);
        JTextField textField1=new JTextField(15);
        textField1.setOpaque(false);
        p1.add(t1);
        p1.add(textField1);

        JPanel p2=new JPanel();
        p2.setOpaque(false);
        JLabel t2=new JLabel("密码：");
        t2.setOpaque(false);
        JTextField textField2=new JPasswordField(15);
        textField2.setOpaque(false);
        p2.add(t2);
        p2.add(textField2);

        JPanel p3=new JPanel();
        p3.setOpaque(false);
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
                        JOptionPane.showMessageDialog(null,"登陆成功");
                        MainPro.username=name;
                        String[] userinfo=d.usermodify(0, name, "", "");
                        MainPro.userpassword=userinfo[1];
                        MainPro.userphone=userinfo[2];
                        frame.dispose();
                        new UserHome();
                    }
                    else if (result==1) JOptionPane.showMessageDialog(null,"密码有误请重新填写");
                    else if (result==2) JOptionPane.showMessageDialog(null,"请先创建用户");
                    else if (result==3) JOptionPane.showMessageDialog(null,"数据库有误,请重试");
                }
            }
        });
        JButton b2=new JButton("去注册");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new Regist();
            }
        });
        JButton b3=new JButton("忘记密码");
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new Forgetpw();
            }
        });
        p3.add(b1);
        p3.add(b3);
        p3.add(b2);

        bg.add(banner);
        bg.add(p1);
        bg.add(p2);
        bg.add(p3);
        frame.add(bg);
        frame.setBounds(650,200,400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
    }
}
