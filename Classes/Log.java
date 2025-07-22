package Classes;
import Interfaces.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Log extends JFrame implements ActionListener {
    private Container c;
    private JLabel j1, j2, j3, img1;
    private Font f1, f2;
    private JButton r, l, ca;
    private JTextField t1;
    private JPasswordField p1;
    private ImageIcon img, on, off,icon2;
    private Cursor cu1,cu2;
    private JToggleButton toggleButton;

   public Log() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setTitle("Log in Page");
        setResizable(false);

        initContainer();
        setVisible(true);
    }

    private void initContainer() {
        c = getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(204, 255, 255));

        img = new ImageIcon("/Elitejersey/IMAGES/log12.jpeg");

        img1 = new JLabel(img);
        img1.setBounds(750, 0, img.getIconWidth(), img.getIconHeight());
        c.add(img1);

        icon2= new ImageIcon("/Elitejersey/IMAGES/logo.jpeg");
        this.setIconImage(icon2.getImage());

        cu1=new Cursor(Cursor.HAND_CURSOR);
        cu2=new Cursor(Cursor.HAND_CURSOR);

        f1 = new Font("Arial", Font.PLAIN, 14);
        f2 = new Font("Abadi", Font.BOLD, 14);

        j1 = new JLabel("Don't have any account?");
        j1.setForeground(Color.black);
        j1.setFont(f2);
        j1.setBounds(550, 60, 200, 200);
        c.add(j1);

        j2 = new JLabel("User Name : ");
        j2.setForeground(Color.black);
        j2.setFont(f2);
        j2.setBounds(145, 215, 100, 55);
        c.add(j2);

        j3 = new JLabel("Password : ");
        j3.setForeground(Color.black);
        j3.setFont(f2);
        j3.setBounds(145, 265, 100, 55);
        c.add(j3);

        t1 = new JTextField();
        t1.setFont(f1);
        t1.setForeground(Color.black);
        t1.setBackground(Color.WHITE);
        t1.setBounds(230, 230, 270, 30);
        c.add(t1);

        p1 = new JPasswordField();
        p1.setEchoChar('*');
        p1.setFont(f2);
        p1.setForeground(Color.black);
        p1.setBackground(Color.WHITE);
        p1.setBounds(230, 280, 270, 30);
        c.add(p1);

        r = new JButton("Register");
        r.setForeground(Color.red);
        r.setCursor(cu2);
        r.setBorderPainted(false);
        r.setContentAreaFilled(false);
        r.setBounds(600, 180, 90, 25);
        c.add(r);

        l = new JButton("Login");
        l.setCursor(cu1);
        l.setBounds(230, 330, 270, 30);
        c.add(l);

        ca = new JButton("Clear");
        ca.setCursor(cu1);
        ca.setBounds(230, 380, 270, 30);
        c.add(ca);

        on = new ImageIcon("/Elitejersey/IMAGES/eye.png");
        off = new ImageIcon("/Elitejersey/IMAGES/eyeoff.png");
        toggleButton = new JToggleButton(off);
        toggleButton.setBounds(520, 280, 30, 30);
        toggleButton.setBorderPainted(false);
        toggleButton.setContentAreaFilled(false);
        c.add(toggleButton);

        toggleButton.addActionListener(this);
        r.addActionListener(this);
        l.addActionListener(this);
        ca.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String user = t1.getText();
        String pass = new String(p1.getPassword());
        boolean userEmpty = user.isEmpty();
        boolean passEmpty = pass.isEmpty();
        boolean matched=false;
        if (e.getSource()==l) {
            if (userEmpty || passEmpty) {
                JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!", JOptionPane.WARNING_MESSAGE);
            }
            else {
                try {
                    FileReader fr = new FileReader("/Elitejersey/Files/login.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split("\t");
                        if (parts.length == 5 && parts[0].equals(user) && parts[2].equals(pass) ) {
                            matched = true;
                            break;
                        }
                    }
                    fr.close();
                } catch (Exception exp) {
                    exp.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Exception" + exp);
                }
            if (matched) {
                JOptionPane.showMessageDialog(null, "Login successful");
                
                HomePage homePage = new HomePage(user);
                homePage.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password","Warning!", JOptionPane.WARNING_MESSAGE);
            }
           
            
           }
        } 
            
    
           else if (e.getSource() == toggleButton) {
                if (toggleButton.isSelected()) {
                    toggleButton.setIcon(on);
                    p1.setEchoChar((char) 0);
                } else {
                    toggleButton.setIcon(off);
                    p1.setEchoChar('*');
                }
            } else if (e.getSource() == r) {
                try {
                  
                    Reg regFrame = new Reg();
                    regFrame.setVisible(true);
                    dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error during registration: " ,"Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (e.getSource() == ca) {
                t1.setText("");
                p1.setText("");
            }
        }
    
        public static void main(String[] args) {
            Log log=new Log();
    }
}

