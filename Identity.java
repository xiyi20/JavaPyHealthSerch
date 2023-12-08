import javax.swing.*;

import java.awt.event.*;;

class Identity {
    public Identity(){
        DBconnect d=new DBconnect();
        JPanel bg=new Bgpanel().getbg(0, 4, 1);
    JFrame frame=new JFrame("确定身份");
    JPanel p=new JPanel();
    JButton b1=new JButton("我是普通用户");
    b1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            frame.dispose();
            new Login();
        }

    });
    JButton b2=new JButton("我是管理员");
    b2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            frame.dispose();
            new ManagerLogin();
        }

    });
    b1.setOpaque(false);
    b2.setOpaque(false);
    bg.add(b1);
    bg.add(b2);
    frame.add(bg);
    frame.setBounds(650, 200, 400, 400);
    frame.setDefaultCloseOperation(3);
    frame.setVisible(true);
    }
}