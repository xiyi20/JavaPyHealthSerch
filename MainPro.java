package git.JavaPyHealthSerch;
import java.awt.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class MainPro {
    public static void main(String[] args) {
        new UserHome();
    }
}
class UserHome{
    public UserHome(){
        Pyhandler ph=new Pyhandler();
        JFrame frame = new JFrame("自主诊断应用");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JPanel p1=new JPanel(new GridLayout(3,1));
        JPanel p1a=new JPanel();
        JPanel p1b=new JPanel();/////////////////////////////可以优化成自动添加//////////////////////////////
        JPanel p1c=new JPanel();
        p1.setBorder(new TitledBorder(null, "全身症状", 4, 2, null,Color.red));
        String[] p1buttonTexts = {"消瘦", "休克", "昏迷", "晕厥", "发热", "抽筋",
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
        p2.setSize(200, 300);
        JPanel p2a=new JPanel();
        JPanel p2b=new JPanel();
        JPanel p2c=new JPanel();
        JPanel p2d=new JPanel();
        JPanel p2e=new JPanel();
        JPanel p2f=new JPanel();
        p2.setBorder(new TitledBorder(null, "头颈部症状", 4, 2, null, Color.BLUE));
        String[] p2buttonTexts = {"鼻出血","鼻溢液","恶心与呕吐","耳痛","耳鸣","耳溢液",
            "呼吸异常","红眼","呼吸衰竭","颈肩痛","口腔痛","口臭","溃疡",
            "咳痰","咳嗽","声音嘶哑","食欲异常","色素异常","色觉异常","眼痛",
            "眼球震颤","眼球突出","眼球内陷","头痛","听力减退","瞳孔异常",
            "吞咽困难","呕血","颈静脉怒张","角膜混浊","咽痛","咽炎,舌炎,龈炎",
            "言语障碍","牙齿异常","眼球运动障碍","咽部异物感","呃逆","脑膜刺激症",
            "咯血","眩晕","腮腺区肿大","呼吸性酸中毒","呼吸性碱中毒","气息异常",
            "泪溢","啰音","视力障碍","急性呼吸窘迫综合征"};
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
        panel.add(

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
        frame.setSize(800, 700);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }
}

class Pyhandler {
    public Pyhandler(){}
    public String getdata(String sendin){
        try {
            ProcessBuilder pb;
            int user=1;
            if (user==0){pb=new ProcessBuilder("python","git\\JavaPyHealthSerch\\getdata.py");}
            else pb=new ProcessBuilder("python","getdata.py");
            Process process = pb.start();
            // 获取进程的输入流和输出流
            InputStream inputStream = process.getInputStream();
            OutputStream outputStream = process.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"gbk"));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream));
 
            writer.println(sendin);
            writer.flush();
            
            // 读取python的输出
            String line;String res="";
            int exitCode = process.waitFor();
            int flag=1;
            while ((line = reader.readLine())!=null) {
                if(flag%2==0)res+=line+"\n\n";
                else res+=line+"\n";
                flag++;
            }
            if (res.isEmpty()) res="没有符合条件的结果";

            if (exitCode!=0)System.out.println("Python程序执行异常,退出码:"+exitCode);
            return res;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return "好像有问题";
    }
}