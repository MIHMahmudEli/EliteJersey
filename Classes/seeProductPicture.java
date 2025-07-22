package Classes;
import Interfaces.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;  // Import the Image class
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class seeProductPicture extends JFrame {

    private Container c;
    private ImageIcon icon, back;
    private JLabel l1;
    private JPanel j1;
    private Cursor cu1;
    private Font f1;
    private String imagepath;

    public seeProductPicture(String imagepath) {
        this.imagepath = imagepath;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(550, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("Profile");
        this.setResizable(false);

        initContainer();
    }

    public void initContainer() {
        c = this.getContentPane();
        c.setLayout(null);

        ImageIcon appIcon = new ImageIcon("/Elitejersey/IMAGES/logo.jpeg");
        this.setIconImage(appIcon.getImage());

        j1 = new JPanel();
        j1.setSize(550, 500);
        j1.setBackground(Color.WHITE);
        c.add(j1);

        cu1 = new Cursor(Cursor.HAND_CURSOR);

        f1 = new Font("Arial", Font.PLAIN, 20);

        try {
            ImageIcon imgIcon = new ImageIcon(imagepath);
            Image scaledImage = imgIcon.getImage().getScaledInstance(550, 480, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            JLabel imageLabel = new JLabel(scaledIcon);
            imageLabel.setBounds(20, 20, scaledIcon.getIconWidth(), scaledIcon.getIconHeight());
            j1.add(imageLabel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String loggedInUsername = "F:/Elitejersey/IMAGES/gersey/AC1.png";
        seeProductPicture frame = new seeProductPicture(loggedInUsername);
        frame.setVisible(true);
    }
}
