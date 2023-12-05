import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Regist {
    public Regist(){
        DBconnect d=new DBconnect();
        JFrame frame=new JFrame("用户注册");

        JPanel bg=new Bgpanel().getbg(0, 7, 1);

        JPanel banner=new JPanel();
        banner.setOpaque(false);
        JLabel banner1=new JLabel("欢迎注册");
        banner1.setOpaque(false);
        banner1.setFont(new Font("宋体",0,35));
        banner.add(banner1);

        JPanel p1=new JPanel();
        p1.setOpaque(false);
        JLabel t1=new JLabel("账号：");
        t1.setOpaque(false);
        JTextField t2=new JTextField(15);
        t2.setOpaque(false);
        p1.add(t1);p1.add(t2);

        JPanel p2=new JPanel();
        p2.setOpaque(false);
        JLabel t3=new JLabel("密码：");
        t3.setOpaque(false);
        JTextField t4=new JPasswordField(15);
        t4.setOpaque(false);
        p2.add(t3);p2.add(t4);

        JPanel p3=new JPanel();
        p3.setOpaque(false);
        JLabel t5=new JLabel("性别：");
        t5.setOpaque(false);
        ButtonGroup buttonGroup=new ButtonGroup();
        JRadioButton man=new JRadioButton("男");
        man.setOpaque(false);
        JRadioButton woman=new JRadioButton("女");
        woman.setOpaque(false);
        buttonGroup.add(man);buttonGroup.add(woman);
        p3.add(t5);p3.add(man);p3.add(woman);

        JPanel p4=new JPanel();
        p4.setOpaque(false);
        JLabel t7=new JLabel("手机号：");
        t7.setOpaque(false);
        JTextField t8=new JTextField(15);
        t8.setOpaque(false);
        p4.add(t7);p4.add(t8);

        Captcha px=new Captcha();
        px.setOpaque(false);
		JPanel p5=new JPanel(new FlowLayout(2));
        p5.setOpaque(false);
		JLabel t9=new JLabel("验证码：");
        t9.setOpaque(false);
		JTextField t10=new JTextField(4);
        t10.setOpaque(false);
		p5.add(t9);p5.add(t10);
		JPanel py=new JPanel(new GridLayout(1, 2));
        py.setOpaque(false);
		py.add(p5);py.add(px);

        JPanel p6=new JPanel();
        p6.setOpaque(false);
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
                    if (phone.length()!=11) {
                        JOptionPane.showMessageDialog(null, "手机号格式不规范");
                    }else{
                        try {
                            Integer.parseInt(phone);
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
                        } catch (Exception a) {
                            JOptionPane.showMessageDialog(null, "手机号格式不规范");
                        }
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

        bg.add(banner);
        bg.add(p1);
        bg.add(p2);
        bg.add(p3);
        bg.add(p4);
        bg.add(py);
        bg.add(p6);
        frame.add(bg);
        frame.setBounds(650,200,400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
    }
}
