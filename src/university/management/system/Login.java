
package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JFrame f;
    JLabel L1,L2;
    JTextField T1;
    JPasswordField T2;
    JButton B1,B2;
    
    Login(){
    
    super("Login");
    setBackground(Color.WHITE);
    setLayout(null);
    
    L1= new JLabel("Username");
    L1.setBounds(40,20,100,30);
    add(L1);
    
    L2= new JLabel("Password");
    L2.setBounds(40,70,100,30);
    add(L2);
    
    T1=new JTextField();
    T1.setBounds(170,20,100,30);
    add(T1);
    
    T2=new JPasswordField();
    T2.setBounds(170,70,100,30);
    add(T2);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/Icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,20,150,150);
        add(l3);
        
    B1=new JButton("Login");
    B1.setBounds(70,120,80,30);
    B1.setFont(new Font("serif",Font.BOLD,15));
    B1.setBackground(new Color(7,94,84));
    B1.setForeground(Color.BLACK);
    add(B1);
        B1
                
                
                .addActionListener(this);

    
    B2=new JButton("Cancel");
    B2.setBounds(190,120,90,30);
    B2.setFont(new Font("serif",Font.BOLD,15));
    B2.setBackground(new Color(7,94,84));
    B2.setForeground(Color.BLACK);
    add(B2);
    
    B2.addActionListener(this);
    
    getContentPane().setBackground(Color.WHITE);
    
    setVisible(true);
    setSize(600,300);
    setLocation(500,300);
    
    }
    
   public void actionPerformed(ActionEvent ae){ 
       if(ae.getSource()==B1){
       try{
           conn c1=new conn();
           String u=T1.getText();
           String v=T2.getText();
           
           String q="select * from login where username='"+u+"' and password='"+v+"'";
           ResultSet rs=c1.s.executeQuery(q);
           if(rs.next()){
               new Project().setVisible(true);
               setVisible(false);
           }else{
               JOptionPane.showMessageDialog(null, "Invalid login");
               setVisible(false);
               
       }
       }catch(Exception e){
               e.printStackTrace();
         }
       }else if(ae.getSource()==B2){
       System.exit(0);
       }
   }
    
    public static void main(String[] args){
        new Login();
    }
    
 }
