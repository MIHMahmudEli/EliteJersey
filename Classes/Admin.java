package Classes;
import Interfaces.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
 class Admin extends JFrame implements ActionListener{
    private Container c;
    private JLabel j1,j2,j3;
    private Font f1;
    private JButton b1,b2;
    private JTextField t1;
    private JPasswordField p1;
    private ImageIcon icon2;



    public Admin(){
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setSize(1280, 720);
       this.setLocationRelativeTo(null);
       this.setTitle("Admin");
       this.setResizable(false);


        intiContainer();
    }
    public void intiContainer(){
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.black);
        
        icon2= new ImageIcon("/Elitejersey/IMAGES/logo.jpeg");
        this.setIconImage(icon2.getImage());

        f1=new Font ("Times New Roman",Font.PLAIN,25);
        j1=new JLabel("ADMIN NAME :");
        j1.setFont(f1);
        j1.setBounds(350,265 ,250 ,70);
        j1.setForeground(Color.white);
        c.add(j1);


       
        j2=new JLabel("Password            :");
        j2.setFont(f1);
        j2.setBounds(350,310 ,250 ,70);
        j2.setForeground(Color.white);
        c.add(j2);

        f1=new Font ("Times New Roman",Font.BOLD,60);
        j3=new JLabel("ADMIN");
        j3.setFont(f1);
        j3.setBounds(550,150 ,250 ,70);
        j3.setForeground(Color.white);
        c.add(j3);

        
        f1=new Font ("Times New Roman",Font.PLAIN,16);
        t1=new JTextField();
        t1.setFont(f1);
        t1.setForeground(Color.BLACK);
        t1.setBackground(Color.WHITE);
        t1.setBounds(560,285,300,30);
        c.add(t1);

        p1=new JPasswordField();
        p1.setFont(f1);
        p1.setEchoChar('*');
        p1.setForeground(Color.BLACK);
        p1.setBackground(Color.WHITE);
        p1.setBounds(560,330,300,30);
        c.add(p1);



        f1=new Font ("Times New Roman",Font.PLAIN,25);
        b1=new JButton("Log in");
        b1.setFont(f1);
        b1.setForeground(Color.BLACK);
        b1.setBackground(new Color(98,184,34));
        b1.setBounds(580,400,260,40);
        c.add(b1);

        b2=new JButton("Back");
        b2.setFont(f1);
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.gray);
        b2.setBounds(150,560,150,30);
        c.add(b2);


        b1.addActionListener(this);
        b2.addActionListener(this);


}
public void actionPerformed(ActionEvent e) {

    String user = t1.getText();
    String pass = new String(p1.getPassword());

    boolean matched=false;
    if (e.getSource()==b1) {
        if (  user.equals("admin") && pass.equals("admin")) {
            AdminHome1 frame = new AdminHome1(user);
            frame.setVisible(true);
            dispose();
            
        }
        else {
        
       JOptionPane.showMessageDialog(null, "username and passsword invalid");
        
       }
    } 
    if(e.getSource()==b2){
    Home ac=new Home();
    dispose();
    ac.setVisible(true);

    }
}
 

    public static void main(String[] args) {
     Admin frame = new Admin();
        frame.setVisible(true);

    
    }
}