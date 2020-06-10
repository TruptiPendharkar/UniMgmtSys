
package university.management.system;

import java.awt.*;
import javax.swing.*;


public class Splash  {
    
    public static void main(String[] args){
        
        Frame f=new Frame();
        f.setVisible(true);
        int i;
        int x=1;
        for(i=2;i<=600;i+=4,x+=1){
            f.setLocation((800-((i+x)/2)),500-(i/2));
            f.setSize(i+3*x, i+x/2);
            
            try{
                Thread.sleep(10);
            }
            
            catch(Exception e){}
        }
    
    }
}
class Frame extends JFrame implements Runnable{

    Thread T1;
    Frame(){
    
        super("University Management System");
        setLayout(new FlowLayout());
        ImageIcon I1=new ImageIcon(ClassLoader.getSystemResource("university/management/system/Icons/first.jpg"));
        Image i1=I1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon I2=new ImageIcon(i1);
        
        JLabel L1=new JLabel(I2);
        add(L1);
        T1=new Thread(this);
        T1.start();
        
    }
public void run(){

try{
   Thread.sleep(7000);
   this.setVisible(false);
   Login l1= new Login();
}
catch (Exception e){
e.printStackTrace();
}

}
}
