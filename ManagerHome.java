
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.TitledBorder;

class ManagerHome {
    public ManagerHome(){
        DBconnect d=new DBconnect();
        JFrame frame=new JFrame("后台管理");
        frame.setLayout(new BorderLayout());
        JPanel p1=new JPanel();
        p1.setBorder(new TitledBorder(null,"用户查询",4,2,null,Color.red));
        JLabel l1=new JLabel("用户名");
        JTextField t1=new JTextField(15);
        JButton b1=new JButton("确定");
        p1.add(l1);
        p1.add(t1);
        p1.add(b1);

        String[] tittle={"id","用户名","密码","性别","手机号"};
        String[][] data=d.userinfo();
        DefaultTableModel tableModel=new DefaultTableModel(data, tittle);
        JTable table=new JTable(tableModel);
        JScrollPane scroll=new JScrollPane(table);
        JPanel p2=new JPanel();
        p2.setLayout(new GridLayout(3,1));
        p2.setBorder(new TitledBorder(null,"用户编辑",4,2,null,Color.red));
        JPanel p3=new JPanel();
        JLabel l2=new JLabel("编号");
        JTextField t2=new JTextField(15);
        JLabel l3=new JLabel("用户名");
        JTextField t3=new JTextField(15);
        JLabel l4=new JLabel("性别");
        JTextField t4=new JTextField(15);
        p3.add(l2);
        p3.add(t2);
        p3.add(l3);
        p3.add(t3);
        p3.add(l4);
        p3.add(t4);

        JPanel p4=new JPanel();
        JLabel l5=new JLabel("密码");
        JTextField t5=new JTextField(15);
        JLabel l6=new JLabel("手机号");
        JTextField t6=new JTextField(15);
        p4.add(l5);
        p4.add(t5);
        p4.add(l6);
        p4.add(t6);
        JPanel p5=new JPanel();
        JButton b2=new JButton("修改");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int id=0;
                try {
                    id = Integer.parseInt(t2.getText());
                } catch (Exception E) {
                    JOptionPane.showMessageDialog(null,"编号不合理");
                }
                String name=t3.getText();
                String sex=t4.getText();
                String password=t5.getText();
                String phone=t6.getText();
                if(name.isEmpty()||sex.isEmpty()||password.isEmpty()||phone.isEmpty())
                JOptionPane.showMessageDialog(null,"检查是否为空");
                else{
                    if(d.shuju(id, name, sex, password, phone)==0){
                        JOptionPane.showMessageDialog(null,"修改成功");
                        
                    }
                    else JOptionPane.showMessageDialog(null,"修改失败");
                }

            }
        });
        JButton b3=new JButton("重置");
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                t2.setText(null);
                t3.setText(null);
                t4.setText(null);
                t5.setText(null);
                t6.setText(null);
            }
        });
        p5.add(b2);
        p5.add(b3);

        p2.add(p3);
        p2.add(p4);
        p2.add(p5);

        frame.add(p1,BorderLayout.NORTH);
        frame.add(scroll,BorderLayout.CENTER);
        frame.add(p2,BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.setBounds(300,0,900, 700);
        frame.setDefaultCloseOperation(3);
    }
}
