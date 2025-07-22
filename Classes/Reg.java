package Classes;
import Interfaces.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Reg extends JFrame implements ActionListener,MouseListener {
    private Container c;
    private JLabel j1, j2, j3, j4, j5, j6, j7, j8,j9,j10,showPassPolicy;
    private Font f1, f2;
    private JButton b1, b2,passPolicyButton;
    private JTextField t1, t2, t3,t4,t5;
    private JPasswordField p1, p2;
    private JToggleButton toggleButton1,toggleButton2;
    private ImageIcon on, off,icon2;
    private Cursor cursor;

    Reg() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setTitle("Register Page");
        this.setResizable(false);

        initializeContainer();
    }
    public void initializeContainer(){

        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(204, 255, 255));


        cursor=new Cursor(Cursor.HAND_CURSOR);
        
        icon2= new ImageIcon("/Elitejersey/IMAGES/logo.jpeg");
        this.setIconImage(icon2.getImage());

        f1=new Font ("Neue Haas Grotesk Text Pro",Font.BOLD,40);
        f2=new Font ("Times New Roman",Font.PLAIN,20);
        j1=new JLabel("Sign up and");
        j1.setFont(f1);
        j1.setBounds(800,230 ,500, 64);
        j1.setForeground(Color.black);
        c.add(j1);

        f1=new Font ("Neue Haas Grotesk Text Pro",Font.BOLD,40);
        j2=new JLabel("Explore best");
        j2.setFont(f1);
        j2.setBounds(800,280,500, 64);
        j2.setForeground(Color.black);
        c.add(j2);

        f1=new Font ("Neue Haas Grotesk Text Pro",Font.BOLD,40);
        j3=new JLabel("Qualities jersey");
        j3.setFont(f1);
        j3.setBounds(800,330,500, 64);
        j3.setForeground(Color.black);
        c.add(j3);

        f1=new Font ("Neue Haas Grotesk Text Pro",Font.BOLD,50);
        j4=new JLabel("Create Acoount");
        j4.setFont(f1);
        j4.setBounds(300,100,500, 64);
        j4.setForeground(Color.black);
        c.add(j4);

        f2=new Font ("Times New Roman",Font.PLAIN,20);
        j5=new JLabel("First name:");
        j5.setFont(f2);
        j5.setBounds(200,220,500,24);
        j5.setForeground(Color.black);
        c.add(j5);

        f2=new Font ("Times New Roman",Font.PLAIN,20);
        j6=new JLabel("Last name:");
        j6.setFont(f2);
        j6.setBounds(370,220,500,24);
        j6.setForeground(Color.black);
        c.add(j6);

        f2=new Font ("Times New Roman",Font.PLAIN,20);
        j7=new JLabel("Username:");
        j7.setFont(f2);
        j7.setBounds(200,320,500,24);
        j7.setForeground(Color.black);
        c.add(j7);
   
        f2=new Font ("Times New Roman",Font.PLAIN,20);
        j8=new JLabel("Create password:");
        j8.setFont(f2);
        j8.setBounds(200,420,500,24);
        j8.setForeground(Color.black);
        c.add(j8);

        f2=new Font ("Times New Roman",Font.PLAIN,20);
        j8=new JLabel("Confirm password:");
        j8.setFont(f2);
        j8.setBounds(200,520,500,24);
        j8.setForeground(Color.black);
        c.add(j8);


        f2=new Font ("Times New Roman",Font.PLAIN,20);
        j9=new JLabel("Mobile Number:");
        j9.setFont(f2);
        j9.setBounds(600,420,500,24);
        j9.setForeground(Color.black);
        c.add(j9);

        f2=new Font ("Times New Roman",Font.PLAIN,20);
        j10=new JLabel("Email address:");
        j10.setFont(f2);
        j10.setBounds(600,520,500,70);
        j10.setForeground(Color.black);
        c.add(j10);


        b1=new JButton("Sign up");
        b1.setCursor(cursor);
        b1.setBounds(300,600,100,30);
        c.add(b1);

        ImageIcon passpolicy=new ImageIcon("/Elitejersey/IMAGES/pass Policy/passPolicy.jpg");
         showPassPolicy=new JLabel(passpolicy);
        showPassPolicy.setBounds(1000,400,200,203);
        showPassPolicy.setVisible(false);
        c.add(showPassPolicy);

        passPolicyButton=new JButton("Password Policy");
        passPolicyButton.setBounds(1025,600,150,30);
        passPolicyButton.setCursor(cursor);
        passPolicyButton.setBorderPainted(false);
        passPolicyButton.setContentAreaFilled(false);
        passPolicyButton.setForeground(Color.BLUE);
        c.add(passPolicyButton);


        


        t1=new JTextField();
        t1.setFont(f2);
        t1.setForeground(Color.black);
        t1.setBackground(Color.WHITE);
        t1.setBounds(200,260,140,30);
        c.add(t1);

        t2=new JTextField();
        t2.setFont(f2);
        t2.setForeground(Color.black);
        t2.setBackground(Color.WHITE);
        t2.setBounds(370,260,140,30);
        c.add(t2);

        t3=new JTextField();
        t3.setFont(f2);
        t3.setForeground(Color.black);
        t3.setBackground(Color.WHITE);
        t3.setBounds(200,350,310,30);
        c.add(t3);

        t4=new JTextField();
        t4.setFont(f2);
        t4.setForeground(Color.black);
        t4.setBackground(Color.WHITE);
        t4.setBounds(600,450,310,30);
        c.add(t4);

        t5=new JTextField();
        t5.setFont(f2);
        t5.setForeground(Color.black);
        t5.setBackground(Color.WHITE);
        t5.setBounds(600,580,310,30);
        c.add(t5);
   
        p1=new JPasswordField();
        p1.setEchoChar('*');
        p1.setFont(f2);
        p1.setForeground(Color.black);
        p1.setBackground(Color.WHITE);
        p1.setBounds(200,450,310,30);
        c.add(p1);

        p2=new JPasswordField();
        p2.setEchoChar('*');
        p2.setFont(f2);
        p2.setForeground(Color.black);
        p2.setBackground(Color.WHITE);
        p2.setBounds(200,550,310,30);
        c.add(p2);

        b2=new JButton("Back");
        b2.setFont(f2);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.black);
        b2.setBounds(35,630,140,40);
        c.add(b2);

        on = new ImageIcon("/Elitejersey/IMAGES/eye.png");
        off = new ImageIcon("/Elitejersey/IMAGES/eyeoff.png");
        toggleButton1 = new JToggleButton(off);   
        toggleButton1.setBounds(515, 450, 30, 30);
        toggleButton1.setBorderPainted(false);
        toggleButton1.setContentAreaFilled(false);
        c.add(toggleButton1);

        toggleButton2 = new JToggleButton(off);   
        toggleButton2.setBounds(515, 550, 30, 30);
        toggleButton2.setBorderPainted(false);
        toggleButton2.setContentAreaFilled(false);
        c.add(toggleButton2);

        toggleButton1.addActionListener(this);
        toggleButton2.addActionListener(this);
        b2.addActionListener(this);
        b1.addActionListener(this);

        passPolicyButton.addMouseListener(this);
   



    }

    public void actionPerformed(ActionEvent e) {
        String firstName = t1.getText();
        String lastNmae = t2.getText();
        String userName = t3.getText();
        String phone = t4.getText();
        String mail = t5.getText();
        String fullname=firstName+" "+lastNmae;
        String pass1 = new String(p1.getPassword());
        String pass2 = new String(p2.getPassword());
    
        boolean firstNameEmpty = firstName.isEmpty();
        boolean lastNmaeEmpty = lastNmae.isEmpty();
        boolean userNameEmpty = userName.isEmpty();
        boolean phoneEmpty = phone.isEmpty();
        boolean mailEmpty = mail.isEmpty();
        boolean pass1Empty = pass1.isEmpty();
        boolean pass2Empty = pass2.isEmpty();
    
        if (e.getSource() == b1) {
            if (firstNameEmpty || lastNmaeEmpty || userNameEmpty || pass1Empty || pass2Empty || phoneEmpty || mailEmpty) {
                JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    Long.parseLong(phone); // Check if the phone is a valid number
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid phone number.", "Warning!", JOptionPane.WARNING_MESSAGE);
                    return;
                }
    
                if (phone.length() != 11) {
                    JOptionPane.showMessageDialog(null, "Please enter a correct phone number.", "Warning!", JOptionPane.WARNING_MESSAGE);
                } else if (!isValidEmail(mail)) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid email address.", "Warning!", JOptionPane.WARNING_MESSAGE);
                }
                else if (!isValidPassword(pass1)) {
                    JOptionPane.showMessageDialog(null, "Password does not meet the policy requirements. \n            Check out the Password Policy", "Warning!", JOptionPane.WARNING_MESSAGE);
                    
                   


                } 
                 else if (!pass1.equals(pass2)) {
                    JOptionPane.showMessageDialog(null, "Passwords do not match.", "Warning!", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (isUsernameExists(userName)) {
                        JOptionPane.showMessageDialog(null, "Username already exists. Please choose a different username.", "Warning!", JOptionPane.WARNING_MESSAGE);
                    } else {
                        try (FileWriter fw = new FileWriter("/Elitejersey/Files/login.txt", true)) {
                            fw.write(userName + "\t" + fullname +"\t" + pass1 + "\t" + phone + "\t" + mail + "\n");
                            fw.close();
                            JOptionPane.showMessageDialog(this, "Registration Completed");
                            Log frame = new Log();
                            dispose();
                            frame.setVisible(true);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        } else if (e.getSource() == b2) {
            Home ac = new Home();
            dispose();
            ac.setVisible(true);
        } else if (e.getSource() == toggleButton1) {
            if (toggleButton1.isSelected()) {
                toggleButton1.setIcon(on);
                p1.setEchoChar((char) 0);
            } else {
                toggleButton1.setIcon(off);
                p1.setEchoChar('*');
            }
        } else if (e.getSource() == toggleButton2) {
            if (toggleButton2.isSelected()) {
                toggleButton2.setIcon(on);
                p2.setEchoChar((char) 0);
            } else {
                toggleButton2.setIcon(off);
                p2.setEchoChar('*');
            }
        }
    }

    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == passPolicyButton) {
            passPolicyButton.setForeground(Color.RED);
            showPassPolicy.setVisible(true);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == passPolicyButton) {
            passPolicyButton.setForeground(Color.BLUE);
            showPassPolicy.setVisible(false);

        }
    }

   
    
    private boolean isValidPassword(String password) {
        // Password policy checks
        String uppercaseRegex = ".*[A-Z].*";
        String lowercaseRegex = ".*[a-z].*";
        String digitRegex = ".*\\d.*";
        String specialCharacterRegex = ".*[!@#$%^&*()_+\\-=\\[\\]{};':\",./<>?\\\\].*";
    
        boolean hasUppercase = password.matches(uppercaseRegex);
        boolean hasLowercase = password.matches(lowercaseRegex);
        boolean hasDigit = password.matches(digitRegex);
        boolean hasSpecialCharacter = password.matches(specialCharacterRegex);
        boolean isLengthValid = password.length() >= 8;
    
        return hasUppercase && hasLowercase && hasDigit && hasSpecialCharacter && isLengthValid;
    }
    

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

   private boolean isUsernameExists(String username) {
    boolean matched = false;
    try {
        FileReader fr = new FileReader("/Elitejersey/Files/login.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\t");
            if (parts.length == 5 && parts[0].equals(username)) {
                matched = true;
                break;
            }
        }
        fr.close();
    } catch (Exception exp) {
        exp.printStackTrace();
        JOptionPane.showMessageDialog(null, "Exception" + exp);
    }
    return matched;
}

    
    public static void main(String[] args) {
        Reg frame = new Reg();
        frame.setVisible(true);

    
    }
} 