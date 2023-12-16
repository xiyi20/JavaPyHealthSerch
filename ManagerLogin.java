
import javax.swing.*;
import java.awt.event.*;

class ManagerLogin {
    public ManagerLogin(){
        DBconnect d=new DBconnect();
        JFrame frame=new JFrame("管理员登录");
        JPanel p1=new JPanel();
        JPanel bg=new Bgpanel().getbg(0,3,1);
        p1.setOpaque(false);
        JLabel t1=new JLabel("账号:");
        t1.setOpaque(false);
        JTextField textField1=new JTextField(15);
        p1.add(t1);
        p1.add(textField1);

        JPanel p2=new JPanel();
        p2.setOpaque(false);
        JLabel t2=new JLabel("密码:");
        t2.setOpaque(false);
        JTextField textField2=new JPasswordField(15);
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
                    int result=d.login(1,name, password);
                    if (result==0) {
                        JOptionPane.showMessageDialog(null,"登陆成功");
                        MainPro.username=name;
                        frame.dispose();
                        new ManagerHome();
                    }
                    else if (result==1) JOptionPane.showMessageDialog(null,"密码有误请重新填写");
                    else if (result==2) JOptionPane.showMessageDialog(null,"该账户没有管理员权限");
                    else JOptionPane.showMessageDialog(null,"数据库有误,请重试");
                }
            }
        });
        JButton b3=new JButton("返回");
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new Identity();
            }
        });
        p3.add(b1);
        p3.add(b3);
        bg.add(p1);
        bg.add(p2);
        bg.add(p3);
        frame.add(bg);
        frame.setBounds(650,200,400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
    }
}
