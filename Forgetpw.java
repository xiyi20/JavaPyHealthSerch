import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Forgetpw{
    public Forgetpw(){
        DBconnect d=new DBconnect();
        JFrame frame=new JFrame("忘记密码");
        JPanel bg=new Bgpanel().getbg(0,4,1);
        frame.setBounds(650,200,400,400);

        JPanel p1=new JPanel();
        JLabel l1=new JLabel("用户名:");
        JTextField textField1=new JTextField(10);
        JButton yanzhen=new JButton("验证");
        p1.add(l1);
        p1.add(textField1);
        p1.add(yanzhen);

        JPanel p2=new JPanel();
        JLabel l2=new JLabel("新密码:");
        JTextField textField2=new JTextField(15);
        p2.add(l2);
        p2.add(textField2);

        JPanel p3=new JPanel(new GridLayout(2, 1));
        JPanel p3a=new JPanel();
        p3a.setOpaque(false);
        JLabel l3=new JLabel("这是问题");
        JPanel p3b=new JPanel();
        p3b.setOpaque(false);
        JTextField textField3=new JTextField(20);
        p3a.add(l3);
        p3b.add(textField3);
        p3.add(p3a);p3.add(p3b);
        yanzhen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String[] result=d.Forgetpw(0, textField1.getText(), null, null);
                if(result[0].equals("0")){
                    MainPro.userquestion=result[1];
                    MainPro.useranwser=result[2];
                    l3.setText("请回答:\t"+MainPro.userquestion);
                }else if(result[0].equals("1")){
                    JOptionPane.showMessageDialog(null, "用户名错误或不存在");
                }
            }
        });

        JPanel p4=new JPanel();
        JButton b1=new JButton("确定");
        b1.setOpaque(false);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String username=textField1.getText();
                String anwser=textField3.getText();
                String password=textField2.getText();
                if (username.isEmpty()||anwser.isEmpty()||password.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"检查是否空填");
                }
                else{
                    String[] result=d.Forgetpw(1,username,anwser,password);
                    if(result[0].equals("0")){
                        JOptionPane.showMessageDialog(null,"密码修改成功,请重新登录");
                    }else if(result[0].equals("2")) JOptionPane.showMessageDialog(null,"密保验证错误");
                    else JOptionPane.showMessageDialog(null,"修改失败,请重试");
                }
            }
        });
        JButton b2=new JButton("返回");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new Login();
            }
        });
        p4.add(b1);p4.add(b2);
       
        p1.setOpaque(false);
        p2.setOpaque(false);
        p3.setOpaque(false);
        p4.setOpaque(false);
        
        bg.add(p1);
        bg.add(p2);
        bg.add(p3);
        bg.add(p4);
        frame.add(bg);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
    }
}
