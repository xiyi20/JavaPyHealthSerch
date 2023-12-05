
import java.awt.*;
import javax.swing.*;

class Bgpanel extends JPanel{
    public JPanel getbg(int bgcode,int row,int col){
        JPanel bg=new JPanel(new GridLayout(row,col)){
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                String bgAdress="";
                if (bgcode==0) {
                    bgAdress=MainPro.bg1;
                }else bgAdress=MainPro.bg2;
                ImageIcon imageicon=new ImageIcon(bgAdress);
                Image image=imageicon.getImage();
                g.drawImage(image, 0, 0,getWidth(),getHeight(),this);
            }
        };
        return bg;
    }
}
