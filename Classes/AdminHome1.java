package Classes;
import Interfaces.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminHome1 extends JFrame {

    private Container c;
    private Cursor cursor;
    private JScrollPane scrollPane;
    private JPanel gridPanel;
    private HomePage HomePage;
    private ImageIcon icon,icon2;
    private Font f1;
    private JButton logout;
    private JLabel logoutLabel;
    private String userName;

    public AdminHome1(String userName) {

        this.userName=userName;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setTitle("Admin Home");
        this.setResizable(false);

        initContainer();
    }

    public void initContainer() {
        c = this.getContentPane();
        //c.setLayout(new FlowLayout(FlowLayout.CENTER));  // Set FlowLayout with center alignment
        c.setBackground(new Color(204, 255, 255));
        

        f1 = new Font("Neue Haas Grotesk Text Pro", Font.BOLD, 12);

        icon2 = new ImageIcon("/Elitejersey/IMAGES/logo.jpeg");
        this.setIconImage(icon2.getImage());

        gridPanel = new JPanel(new GridLayout(2, 2, 20, 10));
        gridPanel.setBackground(new Color(204, 255, 255));

        cursor = new Cursor(Cursor.HAND_CURSOR);

        // Use the array to set the initial values for enteredPrice
        gridPanel.add(createPanel("/Elitejersey/IMAGES/icon/user.png", "User Data"));
        gridPanel.add(createPanel("/Elitejersey/IMAGES/icon/product2.png", "PRODUCTS"));
        gridPanel.add(createPanel("/Elitejersey/IMAGES/icon/add.png", "ADD PRODUCTS"));
        gridPanel.add(createPanel("/Elitejersey/IMAGES/icon/Mail.png", "Mail Box"));

        icon = new ImageIcon("/Elitejersey/IMAGES/icon/logout.png");


        logout=new JButton(icon);
        logout.setLocation(200,300);
        logout.setSize(200,200);
        logout.setToolTipText("Log Out");
        logout.setCursor(cursor);
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logout.setBackground(Color.red);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logout.setBackground(Color.WHITE); // LightSkyBlue
            }
        });

        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Admin frame = new Admin();
                    frame.setVisible(true);
                    

                } catch (Exception ex) {
                    System.out.print(ex);
                }
            }
        });

        c.add(logout,BorderLayout.WEST);


        // Add other panels as needed

        scrollPane = new JScrollPane(gridPanel);
        c.add(scrollPane,BorderLayout.CENTER);
    }

    private JPanel createPanel(String imagePath, String name) {
        JPanel newPanel = new JPanel(new BorderLayout());
        newPanel.setPreferredSize(new Dimension(220, 250));

        ImageIcon buttonIcon = new ImageIcon(imagePath);

        JButton newButton = new JButton(buttonIcon);
        newButton.setCursor(cursor);
        newButton.setBackground(new Color(135, 206, 250));
       
        newButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newButton.setBackground(Color.lightGray);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newButton.setBackground(new Color(135, 206, 250)); // LightSkyBlue
            }
        });

        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));  // Use FlowLayout with center alignment
        panel1.setPreferredSize(new Dimension(250, 20));
        panel1.setBackground(new Color(204, 255, 255));

        JLabel UserData = new JLabel(name);
        UserData.setCursor(cursor);
        UserData.setFont(f1);
        UserData.setForeground(Color.BLUE);
        panel1.add(UserData);  // Add UserData label to panel1 with FlowLayout

        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if(name.equals("PRODUCTS")){
                        dispose();
                        Products frame = new Products(userName);
                        frame.setVisible(true);
                    }
                    else if(name.equals("ADD PRODUCTS")){
                        AddProduct frame = new AddProduct();
                        frame.setVisible(true);
                    }
                    else if(name.equals("User Data")){
                        dispose();
                        UserData frame = new UserData(userName);
                        frame.setVisible(true);
                    }

                    else if(name.equals("Mail Box")){
                        dispose();
                        MessageBox frame = new MessageBox(userName);
                        frame.setVisible(true);
                       
                    }
                    

                } catch (Exception ex) {
                    System.out.print(ex);
                }
            }
        });

        newPanel.add(newButton, BorderLayout.CENTER);
        newPanel.add(panel1, BorderLayout.SOUTH);

        return newPanel;
    }

    public static void main(String[] args) {
        String username="admin";
        AdminHome1 frame = new AdminHome1(username);
        frame.setVisible(true);
    }
}
