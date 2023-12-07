import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

class UserHome{
    public UserHome(){
        Pyhandler ph=new Pyhandler();
        JFrame frame=new JFrame("自主诊断应用");
        frame.setLayout(new BorderLayout());
        CardLayout card=new CardLayout();
        JPanel bg=new Bgpanel().getbg(1, 1, 1);
        bg.setLayout(card);
        bg.setOpaque(false);

        JMenuBar mb=new JMenuBar();
        JMenu m1=new JMenu("其他类型症状");
        mb.add(m1);
        JMenuItem m1a=new JMenuItem("全身症状");
        m1a.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                card.show(bg,"全身");
            }
        });
        JMenuItem m1b=new JMenuItem("头颈部症状");
        m1b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                card.show(bg,"头颈");
            }
        });
        JMenuItem m1c=new JMenuItem("胸部症状");
        m1c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                card.show(bg,"胸部");
            }
        });
        JMenuItem m1d=new JMenuItem("腹部症状");
        m1d.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                card.show(bg,"腹部");
            }
        });
        JMenuItem m1e=new JMenuItem("四肢症状");
        m1e.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                card.show(bg,"四肢");
            }
        });
        JMenuItem m1f=new JMenuItem("皮肤症状");
        m1f.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                card.show(bg,"皮肤");
            }
        });
        JMenuItem m1g=new JMenuItem("分泌排泄症状");
        m1g.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                card.show(bg,"分泌");
            }
        });
        JMenuItem m1h=new JMenuItem("两性症状");
        m1h.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                card.show(bg,"两性");
            }
        });
        JMenuItem m1i=new JMenuItem("其他症状");
        m1i.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                card.show(bg,"其他");
            }
        });
        m1.add(m1a);m1.add(m1b);m1.add(m1c);m1.add(m1d);
        m1.add(m1e);m1.add(m1f);m1.add(m1g);m1.add(m1h);m1.add(m1i);

        JMenu m2=new JMenu("个人中心");
        mb.add(m2);
        JMenuItem m2a=new JMenuItem("信息修改");
        m2a.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                card.show(bg,"修改");
            }
        });
        JMenuItem m2b=new JMenuItem("查询历史");
        m2.add(m2a);m2.add(m2b);



        JPanel p1=new JPanel(new GridLayout(3,1));
        p1.setOpaque(false);
        JPanel p1a=new JPanel();
        p1a.setOpaque(false);
        JPanel p1b=new JPanel();/////////////////////////////可以优化成自动添加//////////////////////////////
        p1b.setOpaque(false);
        JPanel p1c=new JPanel();
        p1c.setOpaque(false);
        p1.setBorder(new TitledBorder(null, "全身症状", 4, 2, null,Color.BLUE));
        String[] p1buttonTexts={
            "消瘦", "休克", "昏迷", "晕厥", "发热", "抽筋",
            "疲劳", "贫血", "猝死", "瘫痪", "脱水", "身痛", "腰背痛", "神经痛", "出汗异常",
            "体型异常", "癫痫和癫痫样发作", "肥胖症", "感觉障碍", "佝偻病", "毛发异常",
            "肌肉萎缩", "肌性肌无力", "脊柱和四肢畸形"};
        String p1results[]=new String[p1buttonTexts.length];
        JPanel[] p1son={p1a,p1b,p1c};
        JToggleButton[] p1buttons=new JToggleButton[p1buttonTexts.length];
        for (int i=0,j=0;i<p1buttonTexts.length;i++) {
            //定义按键
            p1buttons[i]=new JToggleButton(p1buttonTexts[i]);
            //添加按键
            p1son[j].add(p1buttons[i]);
            if (j<=p1son.length-1&&i%8==0&&i!=0) {
                j++;
            }
            //添加按键对应的id
            p1results[i]=","+(i+1);
        }
        for(int i=0;i<p1son.length;i++){
            p1.add(p1son[i]);
        }
        bg.add(p1,"全身");

        JPanel p2=new JPanel(new GridLayout(6, 1));
        p2.setOpaque(false);
        JPanel p2a=new JPanel();
        p2a.setOpaque(false);
        JPanel p2b=new JPanel();
        p2b.setOpaque(false);
        JPanel p2c=new JPanel();
        p2c.setOpaque(false);
        JPanel p2d=new JPanel();
        p2d.setOpaque(false);
        JPanel p2e=new JPanel();
        p2e.setOpaque(false);
        JPanel p2f=new JPanel();
        p2f.setOpaque(false);
        p2.setBorder(new TitledBorder(null, "头颈部症状", 4, 2, null, Color.BLUE));
        String[] p2buttonTexts={
            "鼻出血", "鼻溢液", "恶心与呕吐", "耳痛", "耳鸣", "耳溢液",
            "呼吸异常", "红眼", "呼吸衰竭", "颈肩痛", "口腔痛", "口臭", "溃疡",
            "咳痰", "咳嗽", "声音嘶哑", "食欲异常", "色素异常", "色觉异常", "眼痛",
            "眼球震颤", "眼球突出", "眼球内陷", "头痛", "听力减退", "瞳孔异常",
            "吞咽困难", "呕血", "颈静脉怒张", "角膜混浊", "咽痛", "咽炎,舌炎,龈炎",
            "言语障碍", "牙齿异常", "眼球运动障碍", "咽部异物感", "呃逆","脑膜刺激征","咯血","眩晕","腮腺区肿大","呼吸性酸中毒",
            "呼吸性碱中毒","气息异常","泪溢","啰音","视力障碍","急性呼吸窘迫综合征"};
        String p2results[]=new String[p2buttonTexts.length];
        JPanel[] p2son={p2a,p2b,p2c,p2d,p2e,p2f};
        JToggleButton[] p2buttons=new JToggleButton[p2buttonTexts.length];
        for (int i=0,j=0;i<p2buttonTexts.length;i++) {
            p2buttons[i]=new JToggleButton(p2buttonTexts[i]);
            p2son[j].add(p2buttons[i]);
            if (j<=p2son.length-1&&i%8==0&&i!=0) {
                j++;
            }
            p2results[i]=","+(i+25);
        }
        for(int i=0;i<p2son.length;i++){
            p2.add(p2son[i]);
        }
        bg.add(p2,"头颈");

        JPanel p3=new JPanel(new GridLayout(3, 1));
        p3.setOpaque(false);
        JPanel p3a=new JPanel();
        p3a.setOpaque(false);
        JPanel p3b=new JPanel();
        p3b.setOpaque(false);
        JPanel p3c=new JPanel();
        p3c.setOpaque(false);
        p3.setBorder(new TitledBorder(null, "胸部症状", 4, 2, null, Color.BLUE));
        String[] p3buttonTexts={
            "气胸","胸痛","心悸","男性乳房发育症","乳汁分泌减少","乳糜尿","乳溢一高泌乳素血症","心包积液", 
            "心力衰竭","心音异常","心脏震颤","心脏杂音","心律失常","心脏增大","胸廓异常","胸腔积液",
            "脾肿大"};
        String p3results[]=new String[p3buttonTexts.length];
        JPanel[] p3son={p3a,p3b,p3c};
        JToggleButton[] p3buttons=new JToggleButton[p3buttonTexts.length];
        for (int i=0,j=0;i<p3buttonTexts.length;i++) {
            p3buttons[i]=new JToggleButton(p3buttonTexts[i]);
            p3son[j].add(p3buttons[i]);
            if (j<=p3son.length-1&&i%8==0&&i!=0) {
                j++;
            }
            p3results[i]=","+(i+25+48);
        }
        for(int i=0;i<p3son.length;i++){
            p3.add(p3son[i]);
        }
        bg.add(p3,"胸部");

        JPanel p4=new JPanel(new GridLayout(2, 1));
        p4.setOpaque(false);
        JPanel p4a=new JPanel();
        p4a.setOpaque(false);
        JPanel p4b=new JPanel();
        p4b.setOpaque(false);
        p4.setBorder(new TitledBorder(null, "腹部症状", 4, 2, null, Color.BLUE));
        String[] p4buttonTexts={
            "腹痛","腹水","腹泻","肺水肿","腹部肿块","肝肿大","胃肠气胀","胃食管反流性疾病", 
            "肾病综合征","慢性肾衰竭","急性肾衰竭"};
        String p4results[]=new String[p4buttonTexts.length];
        JPanel[] p4son={p4a,p4b};
        JToggleButton[] p4buttons=new JToggleButton[p4buttonTexts.length];
        for (int i=0,j=0;i<p4buttonTexts.length;i++) {
            p4buttons[i]=new JToggleButton(p4buttonTexts[i]);
            p4son[j].add(p4buttons[i]);
            if (j<=p4son.length-1&&i%8==0&&i!=0) {
                j++;
            }
            p4results[i]=","+(i+25+48+17);
        }
        for(int i=0;i<p4son.length;i++){
            p4.add(p4son[i]);
        }
        bg.add(p4,"腹部");

        JPanel p5=new JPanel(new GridLayout(1, 1));
        p5.setOpaque(false);
        JPanel p5a=new JPanel();
        p5a.setOpaque(false);
        p5.setBorder(new TitledBorder(null, "四肢症状", 4, 2, null, Color.BLUE));
        String[] p5buttonTexts={"杵状指（趾）","步态异常","不自主运动","关节疼痛","指甲异常"};
        String p5results[]=new String[p5buttonTexts.length];
        JPanel[] p5son={p5a};
        JToggleButton[] p5buttons=new JToggleButton[p5buttonTexts.length];
        for (int i=0,j=0;i<p5buttonTexts.length;i++) {
            p5buttons[i] = new JToggleButton(p5buttonTexts[i]);
            p5son[j].add(p5buttons[i]);
            if (j<=p5son.length-1&&i%8==0&&i!=0) {
                j++;
            }
            p5results[i]=","+(i+25+48+17+11);
        }
        for(int i=0;i<p5son.length;i++){
            p5.add(p5son[i]);
        }
        bg.add(p5,"四肢");

        JPanel p6=new JPanel(new GridLayout(2, 1));
        p6.setOpaque(false);
        JPanel p6a=new JPanel();
        p6a.setOpaque(false);
        JPanel p6b=new JPanel();
        p6b.setOpaque(false);
        p6.setBorder(new TitledBorder(null, "皮肤症状", 4, 2, null, Color.BLUE));
        String[] p6buttonTexts={"斑疹","风团","黄疸","水肿","丘疹","皮肤硬化","疱疹","鳞屑","脓疱","瘙痒","紫绀"};
        String p6results[]=new String[p6buttonTexts.length];
        JPanel[] p6son={p6a,p6b};
        JToggleButton[] p6buttons=new JToggleButton[p6buttonTexts.length];
        for (int i=0,j=0;i<p6buttonTexts.length;i++) {
            p6buttons[i]=new JToggleButton(p6buttonTexts[i]);
            p6son[j].add(p6buttons[i]);
            if (j<=p6son.length-1&&i%8==0&&i!=0) {
                j++;
            }
            p6results[i]=","+(i+25+48+17+11+5);
        }
        for(int i=0;i<p6son.length;i++){
            p6.add(p6son[i]);
        }
        bg.add(p6,"皮肤");

        JPanel p7=new JPanel(new GridLayout(2, 1));
        p7.setOpaque(false);
        JPanel p7a=new JPanel();
        p7a.setOpaque(false);
        JPanel p7b=new JPanel();
        p7b.setOpaque(false);
        p7.setBorder(new TitledBorder(null, "分泌排泄症状", 4, 2, null, Color.BLUE));
        String[] p7buttonTexts={
            "血尿","糖尿","黑便","少尿","尿失禁与遗尿","尿频伴尿急和尿痛","排尿困难及尿潴留", 
            "脓尿","白带","便血","便秘","多尿","血红蛋白尿","蛋白尿"};
        String p7results[]=new String[p7buttonTexts.length];
        JPanel[] p7son={p7a,p7b};
        JToggleButton[] p7buttons=new JToggleButton[p7buttonTexts.length];
        for (int i=0,j=0;i<p7buttonTexts.length;i++) {
            p7buttons[i]=new JToggleButton(p7buttonTexts[i]);
            p7son[j].add(p7buttons[i]);
            if (j<=p7son.length-1&&i%8==0&&i!=0) {
                j++;
            }
            p7results[i]=","+(i+25+48+17+11+5+11);
        }
        for(int i=0;i<p7son.length;i++){
            p7.add(p7son[i]);
        }
        bg.add(p7,"分泌");

        JPanel p8=new JPanel(new GridLayout(2, 1));
        p8.setOpaque(false);
        JPanel p8a=new JPanel();
        p8a.setOpaque(false);
        JPanel p8b=new JPanel();
        p8b.setOpaque(false);
        p8.setBorder(new TitledBorder(null, "两性症状", 4, 2, null, Color.BLUE));
        String[] p8buttonTexts={"两性畸形","性早熟","性幼稚病","阴道出血","阴囊肿大","男子性功能障碍","囊肿","痛经","闭经","女性不孕","男性不育"};
        String p8results[]=new String[p8buttonTexts.length];
        JPanel[] p8son={p8a,p8b};
        JToggleButton[] p8buttons=new JToggleButton[p8buttonTexts.length];
        for (int i=0,j=0;i<p8buttonTexts.length;i++) {
            p8buttons[i]=new JToggleButton(p8buttonTexts[i]);
            p8son[j].add(p8buttons[i]);
            if (j<=p8son.length-1&&i%8==0&&i!=0) {
                j++;
            }
            p8results[i]=","+(i+25+48+17+11+5+11+14);
        }
        for(int i=0;i<p8son.length;i++){
            p8.add(p8son[i]);
        }
        bg.add(p8,"两性");

        JPanel p9=new JPanel(new GridLayout(4, 1));
        p9.setOpaque(false);
        JPanel p9a=new JPanel();
        p9a.setOpaque(false);
        JPanel p9b=new JPanel();
        p9b.setOpaque(false);
        JPanel p9c=new JPanel();
        p9c.setOpaque(false);
        JPanel p9d=new JPanel();
        p9d.setOpaque(false);
        p9.setBorder(new TitledBorder(null, "其他症状", 4, 2, null, Color.BLUE));
        String[] p9buttonTexts={
            "低血压","低镁血症","低钠血症","低钾血症","低钙血症","低血糖症","代谢性酸中毒","低颅压综合征", 
            "代谢性碱中毒","黏膜损害","无脉症","水中毒","盆腔肿块","混合型酸碱平衡紊乱","淋巴结肿大","雷诺现象","直肠与肛门狭窄", 
            "周围血管征","共济失调","高颅压综合征","高血压","高钙血症","高钾血症","高镁血症","骨质疏松","高钠血症","毛细血管扩张症", 
            "甲状腺肿","交替脉","结节"};
        String p9results[]=new String[p9buttonTexts.length];
        JPanel[] p9son={p9a,p9b,p9c,p9d};
        JToggleButton[] p9buttons=new JToggleButton[p9buttonTexts.length];
        for (int i=0,j=0;i<p9buttonTexts.length;i++) {
            p9buttons[i]=new JToggleButton(p9buttonTexts[i]);
            p9son[j].add(p9buttons[i]);
            if (j<=p9son.length-1&&i%8==0&&i!=0) {
                j++;
            }
            p9results[i]=","+(i+25+48+17+11+5+11+14+11);
        }
        for(int i=0;i<p9son.length;i++){
            p9.add(p9son[i]);
        }
        bg.add(p9,"其他");


        JPanel p10=new JPanel();
        p10.setLayout(new BoxLayout(p10, BoxLayout.Y_AXIS));
        p10.setBorder(new TitledBorder(null, "信息修改", 4, 2, null,Color.BLUE));
        JLabel t1=new JLabel("欢迎您,"+MainPro.username);
        t1.setFont(new Font("黑体", 0, 30));
        t1.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel p10a=new JPanel();
        JLabel t2=new JLabel("用户名:");
        JTextField xianshi1=new JTextField(15);
        xianshi1.setEditable(false);xianshi1.setText(MainPro.username);
        JButton xiugai1=new JButton("修改");
        p10a.add(t2);p10a.add(xianshi1);p10a.add(xiugai1);
        JPanel p10b=new JPanel();
        JLabel t3=new JLabel("密码:");
        JTextField xianshi2=new JTextField(16);
        xianshi2.setEditable(false);;xianshi2.setText(MainPro.userpassword);
        JButton xiugai2=new JButton("修改");
        p10b.add(t3);p10b.add(xianshi2);p10b.add(xiugai2);
        JPanel p10c=new JPanel();
        JLabel t4=new JLabel("手机号:");
        JTextField xianshi3=new JTextField(15);
        xianshi3.setEditable(false);xianshi3.setText(MainPro.userphone);
        JButton xiugai3=new JButton("修改");
        p10c.add(t4);p10c.add(xianshi3);p10c.add(xiugai3);
        p10.add(t1);p10.add(p10a);p10.add(p10b);p10.add(p10c);
        bg.add(p10,"修改");



        JPanel py=new JPanel(new BorderLayout());
        py.setBorder(new TitledBorder(null, "查询结果", 4, 2,null,Color.blue));
        JTextArea tArea=new JTextArea(50,0);
        JPanel py1=new JPanel();
        JButton queding =new JButton("确定");
        queding.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String result="";
                String result_name="";
                for(int i=0;i<p1buttons.length;i++){
                    if(p1buttons[i].isSelected()){
                        result+=p1results[i];
                        result_name+="•全身症状:"+p1buttonTexts[i]+"\n";
                    }
                }
                for(int i=0;i<p2buttons.length;i++){
                    if(p2buttons[i].isSelected()){
                        result+=p2results[i];
                        result_name+="•头颈部症状:"+p2buttonTexts[i]+"\n";
                    }
                }
                for(int i=0;i<p3buttons.length;i++){
                    if(p3buttons[i].isSelected()){
                        result+=p3results[i];
                        result_name+="•胸部症状:"+p3buttonTexts[i]+"\n";
                    }
                }
                for(int i=0;i<p4buttons.length;i++){
                    if(p4buttons[i].isSelected()){
                        result+=p4results[i];
                        result_name+="•腹部症状:"+p4buttonTexts[i]+"\n";
                    }
                }
                for(int i=0;i<p5buttons.length;i++){
                    if(p5buttons[i].isSelected()){
                        result+=p5results[i];
                        result_name+="•四肢症状:"+p5buttonTexts[i]+"\n";
                    }
                }
                for(int i=0;i<p6buttons.length;i++){
                    if(p6buttons[i].isSelected()){
                        result+=p6results[i];
                        result_name+="•皮肤症状:"+p6buttonTexts[i]+"\n";
                    }
                }
                for(int i=0;i<p7buttons.length;i++){
                    if(p7buttons[i].isSelected()){
                        result+=p7results[i];
                        result_name+="•分泌排泄症状:"+p7buttonTexts[i]+"\n";
                    }
                }
                for(int i=0;i<p8buttons.length;i++){
                    if(p8buttons[i].isSelected()){
                        result+=p8results[i];
                        result_name+="•两性症状:"+p8buttonTexts[i]+"\n";
                    }
                }
                for(int i=0;i<p9buttons.length;i++){
                    if(p9buttons[i].isSelected()){
                        result+=p9results[i];
                        result_name+="•其他症状:"+p9buttonTexts[i]+"\n";
                    }
                }
                int code=JOptionPane.showConfirmDialog(null,result_name+"确定查询?","您已选择:",JOptionPane.YES_NO_OPTION);
                if (code==JOptionPane.YES_OPTION) {
                    tArea.setText("");
                    tArea.setText(ph.getdata(result));
                }
            }
        });
        JButton quxiao=new JButton("重置选择");
        quxiao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                for(int i=0;i<p1buttons.length;i++){
                    p1buttons[i].setSelected(false);
                }
                for(int i=0;i<p2buttons.length;i++){
                    p2buttons[i].setSelected(false);
                }
                for(int i=0;i<p3buttons.length;i++){
                    p3buttons[i].setSelected(false);
                }
                for(int i=0;i<p4buttons.length;i++){
                    p4buttons[i].setSelected(false);
                }
                for(int i=0;i<p5buttons.length;i++){
                    p5buttons[i].setSelected(false);
                }
                for(int i=0;i<p6buttons.length;i++){
                    p6buttons[i].setSelected(false);
                }
                for(int i=0;i<p7buttons.length;i++){
                    p7buttons[i].setSelected(false);
                }
                for(int i=0;i<p8buttons.length;i++){
                    p8buttons[i].setSelected(false);
                }
                for(int i=0;i<p9buttons.length;i++){
                    p9buttons[i].setSelected(false);
                }
            }
        });
        py1.add(queding);py1.add(quxiao);
        ScrollPane areacroll=new ScrollPane();
        areacroll.add(tArea);
        py.setPreferredSize(new Dimension(0, 300));
        py.add(py1,BorderLayout.NORTH);py.add(areacroll,BorderLayout.CENTER);

        frame.add(mb,BorderLayout.NORTH);
        frame.add(bg,BorderLayout.CENTER);
        frame.add(py,BorderLayout.SOUTH);
        frame.setBounds(300,0,900, 700);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }
}