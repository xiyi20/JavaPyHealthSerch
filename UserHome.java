package git.JavaPyHealthSerch;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

class UserHome{
    public UserHome(){
        Pyhandler ph=new Pyhandler();
        JFrame frame = new JFrame("自主诊断应用");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 1));

        JPanel p1=new JPanel(new GridLayout(3,1));
        JPanel p1a=new JPanel();
        JPanel p1b=new JPanel();/////////////////////////////可以优化成自动添加//////////////////////////////
        JPanel p1c=new JPanel();
        p1.setBorder(new TitledBorder(null, "全身症状", 4, 2, null,Color.BLUE));
        String[] p1buttonTexts = {
            "消瘦", "休克", "昏迷", "晕厥", "发热", "抽筋",
            "疲劳", "贫血", "猝死", "瘫痪", "脱水", "身痛", "腰背痛", "神经痛", "出汗异常",
            "体型异常", "癫痫和癫痫样发作", "肥胖症", "感觉障碍", "佝偻病", "毛发异常",
            "肌肉萎缩", "肌性肌无力", "脊柱和四肢畸形"};
        String p1results[]=new String[p1buttonTexts.length];
        JPanel[] p1son={p1a,p1b,p1c};
        JToggleButton[] p1buttons = new JToggleButton[p1buttonTexts.length];
        for (int i=0,j=0;i<p1buttonTexts.length;i++) {
            //定义按键
            p1buttons[i] = new JToggleButton(p1buttonTexts[i]);
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
        panel.add(p1);

        JPanel p2 = new JPanel(new GridLayout(6, 1));
        JPanel p2a=new JPanel();
        JPanel p2b=new JPanel();
        JPanel p2c=new JPanel();
        JPanel p2d=new JPanel();
        JPanel p2e=new JPanel();
        JPanel p2f=new JPanel();
        p2.setBorder(new TitledBorder(null, "头颈部症状", 4, 2, null, Color.BLUE));
        String[] p2buttonTexts = {
            "鼻出血", "鼻溢液", "恶心与呕吐", "耳痛", "耳鸣", "耳溢液",
            "呼吸异常", "红眼", "呼吸衰竭", "颈肩痛", "口腔痛", "口臭", "溃疡",
            "咳痰", "咳嗽", "声音嘶哑", "食欲异常", "色素异常", "色觉异常", "眼痛",
            "眼球震颤", "眼球突出", "眼球内陷", "头痛", "听力减退", "瞳孔异常",
            "吞咽困难", "呕血", "颈静脉怒张", "角膜混浊", "咽痛", "咽炎,舌炎,龈炎",
            "言语障碍", "牙齿异常", "眼球运动障碍", "咽部异物感", "呃逆","脑膜刺激征","咯血","眩晕","腮腺区肿大","呼吸性酸中毒",
            "呼吸性碱中毒","气息异常","泪溢","啰音","视力障碍","急性呼吸窘迫综合征"};
        String p2results[]=new String[p2buttonTexts.length];
        JPanel[] p2son={p2a,p2b,p2c,p2d,p2e,p2f};
        JToggleButton[] p2buttons = new JToggleButton[p2buttonTexts.length];
        for (int i=0,j=0;i<p2buttonTexts.length;i++) {
            p2buttons[i] = new JToggleButton(p2buttonTexts[i]);
            p2son[j].add(p2buttons[i]);
            if (j<=p2son.length-1&&i%8==0&&i!=0) {
                j++;
            }
            p2results[i]=","+(i+25);
        }
        for(int i=0;i<p2son.length;i++){
            p2.add(p2son[i]);
        }
        panel.add(p2);

        JPanel p3 = new JPanel(new GridLayout(3, 1));
        JPanel p3a=new JPanel();
        JPanel p3b=new JPanel();
        JPanel p3c=new JPanel();
        p3.setBorder(new TitledBorder(null, "胸部症状", 4, 2, null, Color.BLUE));
        String[] p3buttonTexts = {
            "气胸","胸痛","心悸","男性乳房发育症","乳汁分泌减少","乳糜尿","乳溢一高泌乳素血症","心包积液", 
            "心力衰竭","心音异常","心脏震颤","心脏杂音","心律失常","心脏增大","胸廓异常","胸腔积液",
            "脾肿大"};
        String p3results[]=new String[p3buttonTexts.length];
        JPanel[] p3son={p3a,p3b,p3c};
        JToggleButton[] p3buttons = new JToggleButton[p3buttonTexts.length];
        for (int i=0,j=0;i<p3buttonTexts.length;i++) {
            p3buttons[i] = new JToggleButton(p3buttonTexts[i]);
            p3son[j].add(p3buttons[i]);
            if (j<=p3son.length-1&&i%8==0&&i!=0) {
                j++;
            }
            p3results[i]=","+(i+25+48);
        }
        for(int i=0;i<p3son.length;i++){
            p3.add(p3son[i]);
        }
        panel.add(p3);

        JPanel p4 = new JPanel(new GridLayout(2, 1));
        JPanel p4a=new JPanel();
        JPanel p4b=new JPanel();
        p4.setBorder(new TitledBorder(null, "腹部症状", 4, 2, null, Color.BLUE));
        String[] p4buttonTexts = {
            "腹痛","腹水","腹泻","肺水肿","腹部肿块","肝肿大","胃肠气胀","胃食管反流性疾病", 
            "肾病综合征","慢性肾衰竭","急性肾衰竭"};
        String p4results[]=new String[p4buttonTexts.length];
        JPanel[] p4son={p4a,p4b};
        JToggleButton[] p4buttons = new JToggleButton[p4buttonTexts.length];
        for (int i=0,j=0;i<p4buttonTexts.length;i++) {
            p4buttons[i] = new JToggleButton(p4buttonTexts[i]);
            p4son[j].add(p4buttons[i]);
            if (j<=p4son.length-1&&i%8==0&&i!=0) {
                j++;
            }
            p4results[i]=","+(i+25+48+17);
        }
        for(int i=0;i<p4son.length;i++){
            p4.add(p4son[i]);
        }
        panel.add(p4);

        JPanel p5 = new JPanel(new GridLayout(1, 1));
        JPanel p5a=new JPanel();
        p5.setBorder(new TitledBorder(null, "四肢症状", 4, 2, null, Color.BLUE));
        String[] p5buttonTexts = {"杵状指（趾）","步态异常","不自主运动","关节疼痛","指甲异常"};
        String p5results[]=new String[p5buttonTexts.length];
        JPanel[] p5son={p5a};
        JToggleButton[] p5buttons = new JToggleButton[p5buttonTexts.length];
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
        panel.add(p5);

        JPanel p6 = new JPanel(new GridLayout(2, 1));
        JPanel p6a=new JPanel();
        JPanel p6b=new JPanel();
        p6.setBorder(new TitledBorder(null, "皮肤症状", 4, 2, null, Color.BLUE));
        String[] p6buttonTexts = {"斑疹","风团","黄疸","水肿","丘疹","皮肤硬化","疱疹","鳞屑","脓疱","瘙痒","紫绀"};
        String p6results[]=new String[p6buttonTexts.length];
        JPanel[] p6son={p6a,p6b};
        JToggleButton[] p6buttons = new JToggleButton[p6buttonTexts.length];
        for (int i=0,j=0;i<p6buttonTexts.length;i++) {
            p6buttons[i] = new JToggleButton(p6buttonTexts[i]);
            p6son[j].add(p6buttons[i]);
            if (j<=p6son.length-1&&i%8==0&&i!=0) {
                j++;
            }
            p6results[i]=","+(i+25+48+17+11+5);
        }
        for(int i=0;i<p6son.length;i++){
            p6.add(p6son[i]);
        }
        panel.add(p6);

        JPanel p7 = new JPanel(new GridLayout(2, 1));
        JPanel p7a=new JPanel();
        JPanel p7b=new JPanel();
        p7.setBorder(new TitledBorder(null, "分泌排泄症状", 4, 2, null, Color.BLUE));
        String[] p7buttonTexts = {
            "血尿","糖尿","黑便","少尿","尿失禁与遗尿","尿频伴尿急和尿痛","排尿困难及尿潴留", 
            "脓尿","白带","便血","便秘","多尿","血红蛋白尿","蛋白尿"};
        String p7results[]=new String[p7buttonTexts.length];
        JPanel[] p7son={p7a,p7b};
        JToggleButton[] p7buttons = new JToggleButton[p7buttonTexts.length];
        for (int i=0,j=0;i<p7buttonTexts.length;i++) {
            p7buttons[i] = new JToggleButton(p7buttonTexts[i]);
            p7son[j].add(p7buttons[i]);
            if (j<=p7son.length-1&&i%8==0&&i!=0) {
                j++;
            }
            p7results[i]=","+(i+25+48+17+11+5+11);
        }
        for(int i=0;i<p7son.length;i++){
            p7.add(p7son[i]);
        }
        panel.add(p7);

        JPanel p8 = new JPanel(new GridLayout(2, 1));
        JPanel p8a=new JPanel();
        JPanel p8b=new JPanel();
        p8.setBorder(new TitledBorder(null, "两性症状", 4, 2, null, Color.BLUE));
        String[] p8buttonTexts = {"两性畸形","性早熟","性幼稚病","阴道出血","阴囊肿大","男子性功能障碍","囊肿","痛经","闭经","女性不孕","男性不育"};
        String p8results[]=new String[p8buttonTexts.length];
        JPanel[] p8son={p8a,p8b};
        JToggleButton[] p8buttons = new JToggleButton[p8buttonTexts.length];
        for (int i=0,j=0;i<p8buttonTexts.length;i++) {
            p8buttons[i] = new JToggleButton(p8buttonTexts[i]);
            p8son[j].add(p8buttons[i]);
            if (j<=p8son.length-1&&i%8==0&&i!=0) {
                j++;
            }
            p8results[i]=","+(i+25+48+17+11+5+11+14);
        }
        for(int i=0;i<p8son.length;i++){
            p8.add(p8son[i]);
        }
        panel.add(p8);

        JPanel p9 = new JPanel(new GridLayout(4, 1));
        JPanel p9a=new JPanel();
        JPanel p9b=new JPanel();
        JPanel p9c=new JPanel();
        JPanel p9d=new JPanel();
        p9.setBorder(new TitledBorder(null, "其他症状", 4, 2, null, Color.BLUE));
        String[] p9buttonTexts = {
            "低血压","低镁血症","低钠血症","低钾血症","低钙血症","低血糖症","代谢性酸中毒","低颅压综合征", 
            "代谢性碱中毒","黏膜损害","无脉症","水中毒","盆腔肿块","混合型酸碱平衡紊乱","淋巴结肿大","雷诺现象","直肠与肛门狭窄", 
            "周围血管征","共济失调","高颅压综合征","高血压","高钙血症","高钾血症","高镁血症","骨质疏松","高钠血症","毛细血管扩张症", 
            "甲状腺肿","交替脉","结节"};
        String p9results[]=new String[p9buttonTexts.length];
        JPanel[] p9son={p9a,p9b,p9c,p9d};
        JToggleButton[] p9buttons = new JToggleButton[p9buttonTexts.length];
        for (int i=0,j=0;i<p9buttonTexts.length;i++) {
            p9buttons[i] = new JToggleButton(p9buttonTexts[i]);
            p9son[j].add(p9buttons[i]);
            if (j<=p9son.length-1&&i%8==0&&i!=0) {
                j++;
            }
            p9results[i]=","+(i+25+48+17+11+5+11+14+11);
        }
        for(int i=0;i<p9son.length;i++){
            p9.add(p9son[i]);
        }
        panel.add(p9);

        JPanel px=new JPanel(new BorderLayout());
        JTextArea tArea=new JTextArea(50,0);
        JPanel px1=new JPanel();
        JButton queding =new JButton("确定");
        px1.add(queding);
        queding.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                tArea.setText("");
                String result="";
                for(int i=0;i<p1buttons.length;i++){
                    if(p1buttons[i].isSelected()){
                        result+=p1results[i];
                    }
                }
                for(int i=0;i<p2buttons.length;i++){
                    if(p2buttons[i].isSelected()){
                        result+=p2results[i];
                    }
                }
                for(int i=0;i<p3buttons.length;i++){
                    if(p3buttons[i].isSelected()){
                        result+=p3results[i];
                    }
                }
                for(int i=0;i<p4buttons.length;i++){
                    if(p4buttons[i].isSelected()){
                        result+=p4results[i];
                    }
                }
                for(int i=0;i<p5buttons.length;i++){
                    if(p5buttons[i].isSelected()){
                        result+=p5results[i];
                    }
                }
                for(int i=0;i<p6buttons.length;i++){
                    if(p6buttons[i].isSelected()){
                        result+=p6results[i];
                    }
                }
                for(int i=0;i<p7buttons.length;i++){
                    if(p7buttons[i].isSelected()){
                        result+=p7results[i];
                    }
                }
                for(int i=0;i<p8buttons.length;i++){
                    if(p8buttons[i].isSelected()){
                        result+=p8results[i];
                    }
                }
                for(int i=0;i<p9buttons.length;i++){
                    if(p9buttons[i].isSelected()){
                        result+=p9results[i];
                    }
                }
                tArea.setText(ph.getdata(result));
            }
        });
        ScrollPane areacroll=new ScrollPane();
        areacroll.add(tArea);
        px.add(px1,BorderLayout.NORTH);px.add(areacroll,BorderLayout.CENTER);
        panel.add(px);


        // 创建一个滚动条，并将Panel添加到滚动条的视口中
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.add(panel);
        // 将滚动条添加到Frame中
        frame.add(scrollPane);
        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }
}