
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.TitledBorder;

class table{
    private DBconnect d;
    private String[] tittle;
    public table(){
        d=new DBconnect();
        tittle=new String[]{"id","用户名","密码","性别","手机号"};
    }
    public JScrollPane gettable(int mode,String username,JTextField t1,JTextField t2,JTextField t3,JTextField t4,JTextField t5){
        String[][] data=d.userinfo(mode,username);
        DefaultTableModel tableModel=new DefaultTableModel(data, tittle);
        JTable table=new JTable(tableModel);
        table.addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent e){
                int row=table.getSelectedRow();
                t1.setText((String)table.getValueAt(row, 0));
                t2.setText((String)table.getValueAt(row, 1));
                t3.setText((String)table.getValueAt(row, 2));
                t4.setText((String)table.getValueAt(row, 3));
                t5.setText((String)table.getValueAt(row, 4));
           }
        });
        JScrollPane scroll=new JScrollPane(table);
        return scroll;
    }
}

class ManagerHome{
    public ManagerHome(){
        DBconnect d=new DBconnect();
        table t=new table();
        JPanel bg=new Bgpanel().getbg(0, 1, 1);
        bg.setLayout(new BorderLayout());
        CardLayout card=new CardLayout();
        JPanel content=new JPanel(card);

        JFrame frame=new JFrame("后台管理");
        JPanel p1=new JPanel();
        p1.setOpaque(false);
        p1.setBorder(new TitledBorder(null,"用户查询",4,2,null,Color.red));
        JLabel l1=new JLabel("用户名");
        JTextField t1=new JTextField(15);
        JButton b1=new JButton("确定");
        p1.add(l1);
        p1.add(t1);
        p1.add(b1);

        JPanel p2=new JPanel();
        p2.setOpaque(false);
        p2.setLayout(new GridLayout(3,1));
        p2.setBorder(new TitledBorder(null,"用户编辑",4,2,null,Color.red));
        JPanel p3=new JPanel();
        p3.setOpaque(false);
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
        p4.setOpaque(false);
        JLabel l5=new JLabel("密码");
        JTextField t5=new JTextField(15);
        JLabel l6=new JLabel("手机号");
        JTextField t6=new JTextField(15);
        p4.add(l5);
        p4.add(t5);
        p4.add(l6);
        p4.add(t6);
        content.add(t.gettable(0,"",t2,t3,t5,t4,t6),"default");
        JPanel p5=new JPanel();
        p5.setOpaque(false);
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
                        content.add(t.gettable(0,"",t2,t3,t5,t4,t6),"table");
                        card.show(content,"table");
                    }
                    else JOptionPane.showMessageDialog(null,"修改失败");
                }
            }
        });
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                content.add(t.gettable(1,t1.getText(),t2,t3,t5,t4,t6),"table");
                card.show(content, "table");
                if(t1.getText().isEmpty()){
                    card.show(content,"default");
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

        bg.add(p1,BorderLayout.NORTH);
        bg.add(content,BorderLayout.CENTER);
        bg.add(p2,BorderLayout.SOUTH);
        frame.add(bg);
        frame.setVisible(true);
        frame.setBounds(300,0,900, 700);
        frame.setDefaultCloseOperation(3);
    }
}
