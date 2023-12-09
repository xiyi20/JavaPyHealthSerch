
import javax.swing.*;
import java.awt.event.*;;

class Identity {
    public Identity(){
    JPanel bg=new Bgpanel().getbg(0, 3, 1);
    JFrame frame=new JFrame("确定身份");
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
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
    p1.setOpaque(false);
    p2.setOpaque(false);
    p2.add(b1);p2.add(b2);
    bg.add(p1);
    bg.add(p2);
    frame.add(bg);
    frame.setBounds(650, 200, 400, 200);
    frame.setDefaultCloseOperation(3);
    frame.setVisible(true);
    }
}