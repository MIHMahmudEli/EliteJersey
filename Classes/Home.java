package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Home extends JFrame implements ActionListener {
    private Container c;
    private JLabel j1,j2,j3,j4,img1;
    private Font f1;
    private JButton b1,b2,b3;
    private ImageIcon img,icon2;
    private Cursor cu1;


   public Home(){
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setSize(1280, 720);
       this.setLocationRelativeTo(null);
       this.setTitle("Home");
       this.setResizable(false);


        intiContainer();
    }
    public void intiContainer(){
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(204, 255, 255));


        img=new ImageIcon ("/Elitejersey/IMAGES/h2.jpeg");

        img1=new JLabel(img);
        img1.setBounds(0,120, img.getIconWidth(), img.getIconHeight());
        c.add(img1);

        icon2= new ImageIcon("/Elitejersey/IMAGES/logo.jpeg");
        this.setIconImage(icon2.getImage());
        
        
   


        f1=new Font ("Neue Haas Grotesk Text Pro",Font.BOLD,80);
        j1=new JLabel("Elite");
        j1.setFont(f1);
        j1.setBounds(15,5 ,250 , 72);
        j1.setForeground(Color.BLACK);
        c.add(j1);
        
        f1=new Font ("Neue Haas Grotesk Text Pro",Font.BOLD,62);
        j2=new JLabel("Jersey");
        j2.setFont(f1);
        j2.setBounds(180,30,400 ,90);
        j2.setForeground(Color.BLACK);
        c.add(j2);



        f1=new Font ("Neue Haas Grotesk Text Pro",Font.BOLD,16);
        j3=new JLabel("User");
        j3.setFont(f1);
        j3.setBounds(880,80,400 ,30);
        j3.setForeground(Color.BLACK);
        c.add(j3);

        f1=new Font ("Neue Haas Grotesk Text Pro",Font.BOLD,16);
        j4=new JLabel("Admin");
        j4.setFont(f1);
        j4.setBounds(1030,80 ,400 ,30);
        j4.setForeground(Color.BLACK);
        c.add(j4);

        cu1=new Cursor(Cursor.HAND_CURSOR);

        img=new ImageIcon ("/Elitejersey/IMAGES/user.png");

        b1=new JButton(img);
        b1.setForeground(Color.WHITE);
        b1.setCursor(cu1);
        b1.setBackground(new Color(123,50,250));
        b1.setBounds(850,15,100,70);
        b1.setBorderPainted(false);
        b1.setContentAreaFilled(false);
        c.add(b1);


        f1=new Font ("Neue Haas Grotesk Text Pro",Font.BOLD,14);
        b2=new JButton("Contact");
        b2.setForeground(Color.RED);
        b2.setFont(f1);
        b2.setCursor(cu1);
        b2.setBackground(new Color(123,50,250));
        b2.setBounds(1180,0,100,40);
        b2.setBorderPainted(false);
        b2.setContentAreaFilled(false);
        c.add(b2);

        img=new ImageIcon ("/Elitejersey/IMAGES/admin.png");
        b3=new JButton(img);
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(123,50,250));
        b3.setBounds(1000,15,100,70);
        b3.setCursor(cu1);
        b3.setBorderPainted(false);
        b3.setContentAreaFilled(false);
        c.add(b3);
        

        b2.addActionListener(this);
        b1.addActionListener(this);
        b3.addActionListener(this);



    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b2){

        
        Contact dc=new Contact();
        dispose();
        dc.setVisible(true);
        }
    else if(e.getSource()==b1){

        Log dc1= new Log();
        dispose();
        dc1.setVisible(true);
    }
    else{
        Admin ad=new Admin();
        dispose();
        ad.setVisible(true);  

    }
}
    
 

    public static void main(String[] args) {
        Home frame = new Home();
        frame.setVisible(true);

    
    }
}