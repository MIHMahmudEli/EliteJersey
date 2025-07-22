package Classes;
import Interfaces.*;
import javax.swing.*;
import java.awt.*;


public class Customize extends JFrame  {

private Container c;
private ImageIcon i1,icon2;
private JLabel j1;


Customize(){

    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setSize(640, 720);
    this.setTitle("Customize");
    this.setResizable(false);
    this.setLocationRelativeTo(null);

    initContainer();
}
public void initContainer() {
    c = this.getContentPane();
    c.setLayout(null);
    c.setBackground(Color.black);
    

    icon2= new ImageIcon("/Elitejersey/IMAGES/logo.jpeg");
    this.setIconImage(icon2.getImage());


    i1 = new ImageIcon("/Elitejersey/IMAGES/Customize2.jpeg");

    j1= new JLabel(i1);
    j1.setBounds(0,0, i1.getIconWidth(), i1.getIconHeight());
    c.add(j1);


}


public static void main(String[] args) {
    Customize frame = new Customize();
    frame.setVisible(true);
}  
} 

  
     





   
        



    


   