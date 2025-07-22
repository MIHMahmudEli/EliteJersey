package Classes;
import Interfaces.*;
import javax.swing.*;


public class Profile extends JFrame {

    private Container c;
    private ImageIcon icon,back;
    private JLabel l1,l2;
    private JPanel j1;
    private Cursor cu1;
    private Font f1;
    private  String imagepath;


   public Profile (String imagepath){
        this.imagepath=imagepath;



        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(550, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("Profile");
        this.setResizable(false);

        intContainer();
        //loadProfileData(imagepath);

    }


    public void intContainer() {
        c = this.getContentPane();
        c.setLayout(null);


        j1 = new JPanel();
        j1.setSize(550, 500);
        j1.setBackground(Color.WHITE);
        c.add(j1);

        cu1=new Cursor(Cursor.HAND_CURSOR);

        f1= new Font("Aria", Font.PLAIN, 20);

        back = new ImageIcon(imagepath);
        l1 = new JLabel(back);
        l1.setSize(550, 500);
        j1.add(l1);

        /*icon = new ImageIcon("/Elitejersey/IMAGES/Logo.png");
        this.setIconImage(icon.getImage());*/






    }

    public static void main(String[] args) {

        String loggedInUsername = "F:/Elitejersey/IMAGES/gersey/AC1.png";

        Profile frame = new Profile(loggedInUsername);
        frame.setVisible(true);
    }

}

