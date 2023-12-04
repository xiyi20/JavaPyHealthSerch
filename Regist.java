import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Regist {
    public Regist(){
        DBconnect d=new DBconnect();
        JFrame frame=new JFrame("用户注册");
        frame.setLayout(new GridLayout(7, 1));

        JPanel p1=new JPanel();
        JLabel t1=new JLabel("账号：");
        JTextField t2=new JTextField(15);
        p1.add(t1);p1.add(t2);

        JPanel p2=new JPanel();
        JLabel t3=new JLabel("密码：");
        JTextField t4=new JPasswordField(15);
        p2.add(t3);p2.add(t4);

        JPanel p3=new JPanel();
        JLabel t5=new JLabel("性别：");
        ButtonGroup buttonGroup=new ButtonGroup();
        JRadioButton man=new JRadioButton("男");
        JRadioButton woman=new JRadioButton("女");
        buttonGroup.add(man);buttonGroup.add(woman);
        p3.add(t5);p3.add(man);p3.add(woman);

        JPanel p4=new JPanel();
        JLabel t7=new JLabel("手机号：");
        JTextField t8=new JTextField(15);
        p4.add(t7);p4.add(t8);

        Captcha px=new Captcha();
		JPanel p5=new JPanel(new FlowLayout(2));
		JLabel t9=new JLabel("验证码：");
		JTextField t10 = new JTextField(4);
		p5.add(t9);p5.add(t10);
		JPanel py=new JPanel(new GridLayout(1, 2));
		py.add(p5);py.add(px);

        JPanel p6=new JPanel();
        JButton b1=new JButton("注册");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String username=t2.getText();
                String password=t4.getText();
                String sex;
                if (man.isSelected()) sex="男";
                else sex="女";
                String phone=t8.getText();
                if (username.isEmpty()||password.isEmpty()||phone.isEmpty()||(!man.isSelected()&&!woman.isSelected())) {
                    JOptionPane.showMessageDialog(null,"检查是否空填!");
                }
                else{
                    if (!t10.getText().equals(px.captcha)) {
                        JOptionPane.showMessageDialog(null, "验证码错误,请重试");
                        px.repaint();
                    }else{
                        int result=d.regist(username, password, sex, phone);
                        if (result==0) {
                            JOptionPane.showMessageDialog(null, "注册成功,请登录");
                        }else if (result==1) {
                            JOptionPane.showMessageDialog(null, "已存在该账户,请直接登录");
                        }else JOptionPane.showMessageDialog(null, "注册失败,请重试");
                    }
                }   
            }
        });
        JButton b2=new JButton("去登录");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new Login();//////////////////////////////////////////////////
            }
        });
        p6.add(b1);p6.add(b2);

        frame.add(p1);
        frame.add(p2);
        frame.add(p3);
        frame.add(p4);
        frame.add(py);
        frame.add(p6);
        frame.setBounds(650,200,400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
    }
}
