
import java.awt.*;
import javax.swing.*;

class Bgpanel extends JPanel{
    public JPanel getbg(int bgcode,int row,int col){
        JPanel bg=new JPanel(new GridLayout(row,col)){
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                String bgAddress="";
                ImageIcon imageicon=null;
                if(bgcode==0){
                    bgAddress=MainPro.bg1;
                    if(MainPro.bgmode1==0) {
                        imageicon=new ImageIcon(getClass().getResource(bgAddress));
                    }else{
                        imageicon=new ImageIcon(bgAddress);
                    }
                }else if(bgcode==1){
                    bgAddress=MainPro.bg2;
                    if(MainPro.bgmode2==0) {
                        imageicon=new ImageIcon(getClass().getResource(bgAddress));
                    }else{
                        imageicon=new ImageIcon(bgAddress);
                    }
                }
                Image image=imageicon.getImage();
                g.drawImage(image, 0, 0,getWidth(),getHeight(),this);
            }
        };
        return bg;
    }
}
