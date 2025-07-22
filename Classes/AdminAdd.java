package Classes;
import Interfaces.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminAdd extends JFrame {

    private Container c;
    private ImageIcon icon, backIcon;
    private JLabel label1;
    private Font f1, f2, f3, f4, f5, f6;
    private JTextField tf1, tf3, tf4, tf5, tf6;
    private JComboBox securityQsn;
    private JButton btn1, btn2, nBtn;
    private JPasswordField tf2;
    private Cursor cursor;
    private String userName;

    AdminAdd(String userName) {
        this.userName = userName;
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Add User");
        this.setSize(510, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(28, 103, 87));

        // Icon
        icon = new ImageIcon("/Elitejersey/IMAGES/logo.jpeg");
        this.setIconImage(icon.getImage());

        backIcon = new ImageIcon("/Elitejersey/IMAGES/back1.png");

        // Fonts
        f1 = new Font("Segoe UI Black", Font.PLAIN, 35);
        f2 = new Font("Helvetica", Font.BOLD, 25);
        f3 = new Font("Segoe UI Semibold", Font.PLAIN, 35);
        f4 = new Font("Segoe UI", Font.PLAIN, 25);
        f5 = new Font("Segoe UI", Font.PLAIN, 19);
        f6 = new Font("Segoe UI", Font.PLAIN, 25);

        label1 = new JLabel();
        label1.setText("Enter Information");
        label1.setBounds(100, 25, 500, 50);
        label1.setFont(f1);
        label1.setForeground(Color.decode("#F4DA9B"));
        c.add(label1);

        label1 = new JLabel();
        label1.setText("User Name");
        label1.setBounds(45, 75, 500, 50);
        label1.setFont(f4);
        label1.setForeground(Color.WHITE);
        c.add(label1);

        tf1 = new JTextField();
        tf1.setBounds(185, 85, 260, 30);
        tf1.setFont(f5);
        tf1.setBackground(Color.decode("#4FB59E"));
        c.add(tf1);

        label1 = new JLabel();
        label1.setText("Password");
        label1.setBounds(45, 110, 500, 50);
        label1.setFont(f4);
        label1.setForeground(Color.WHITE);
        c.add(label1);

        tf2 = new JPasswordField();
        tf2.setBounds(185, 120, 260, 30);
        tf2.setFont(f2);
        tf2.setBackground(Color.decode("#4FB59E"));
        tf2.setEchoChar('*');
        c.add(tf2);

        label1 = new JLabel();
        label1.setText("Full name");
        label1.setBounds(45, 145, 500, 50);
        label1.setFont(f4);
        label1.setForeground(Color.WHITE);
        c.add(label1);

        tf3 = new JTextField();
        tf3.setBounds(185, 155, 260, 30);
        tf3.setFont(f5);
        tf3.setBackground(Color.decode("#4FB59E"));
        c.add(tf3);

        label1 = new JLabel();
        label1.setText("phone");
        label1.setBounds(45, 180, 500, 50);
        label1.setFont(f4);
        label1.setForeground(Color.WHITE);
        c.add(label1);

        tf4 = new JTextField();
        tf4.setBounds(185, 190, 259, 30);
        tf4.setFont(f5);
        tf4.setBackground(Color.decode("#4FB59E"));
        c.add(tf4);

        label1 = new JLabel();
        label1.setText("Email");
        label1.setBounds(45, 215, 500, 50);
        label1.setFont(f4);
        label1.setForeground(Color.WHITE);
        c.add(label1);

        tf5 = new JTextField();
        tf5.setBounds(185, 225, 260, 30);
        tf5.setFont(f5);
        tf5.setBackground(Color.decode("#4FB59E"));
        c.add(tf5);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // JButtons

        btn1 = new JButton(backIcon);
        btn1.setCursor(cursor);
        btn1.setBorder(null);
        btn1.setBorderPainted(false);
        btn1.setContentAreaFilled(false);
        btn1.setBounds(25, 290, 55, 55);
        btn1.setToolTipText("Previous");
        c.add(btn1);

        btn2 = new JButton("Add");
        btn2.setBounds(345, 270, 100, 50); // Adjusted position
        btn2.setFont(f2);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.decode("#FEE3E0"));
        btn2.setBackground(Color.decode("#0B473A"));
        c.add(btn2);

        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        // Back Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                dispose();
                UserData frame = new UserData(userName);
                frame.setVisible(true);
            }
        });

        // Register Button
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String uname = tf1.getText().toLowerCase(); // User Name
                String pass1 = tf2.getText(); // Password
                String name = tf3.getText(); // Full name
                String phone = tf4.getText(); // phone
                String email = tf5.getText();// Email

                // String secQsn = String.valueOf(securityQsn.getSelectedItem()); //

                if (uname.isEmpty() || pass1.isEmpty() || name.isEmpty() || phone.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                }

                else {
                    try {
                        Long.parseLong(phone); // Check if the phone is a valid number
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid phone number.", "Warning!",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    if (phone.length() != 11) {
                        JOptionPane.showMessageDialog(null, "Please enter a correct phone number.", "Warning!",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (!isValidEmail(email)) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid email address.", "Warning!",
                                JOptionPane.WARNING_MESSAGE);
                    }

                    else if (isUsernameExists(uname)) {
                        JOptionPane.showMessageDialog(null,
                                "Username already exists. Please choose a different username.", "Warning!",
                                JOptionPane.WARNING_MESSAGE);
                    } else {

                        try (FileWriter fw = new FileWriter("/Elitejersey/Files/login.txt", true)) {
                            fw.write(uname + "\t" + name + "\t" + pass1 + "\t" + phone + "\t" + email + "\n");
                            fw.close();

                        } catch (IOException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, ex, "Warning!", JOptionPane.WARNING_MESSAGE);

                        }

                        JOptionPane.showMessageDialog(null, "User has been added.", "User Added",
                                JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        AdminAdd frame = new AdminAdd(userName);
                        frame.setVisible(true);
                    }
                }
            }
        });
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isUsernameExists(String uname) {
        boolean matched = false;
        try {
            FileReader fr = new FileReader("/Elitejersey/Files/login.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 5 && parts[0].equals(uname)) {
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
        String userName = "admin";
        AdminAdd frame = new AdminAdd(userName);
        frame.setVisible(true);
    }
}
