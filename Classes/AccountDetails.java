package Classes;
import Interfaces.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.File;

public class AccountDetails extends JFrame implements MouseListener, ActionListener {

    private Container c;
    private JLabel l1, l2, l3, l4, l5, l6, l7, myacc, s1, s2, s3, s4;
    private JTextField number, firstname, lastname, displayname, mail;
    private JButton dashboard, order, download, address, acountdetail, wishlist, logout, save, back;
    private Cursor cu1;
    private String userName;
    private String pass;

    public AccountDetails(String userName) {

        this.userName = userName;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setTitle("Account Details");
        this.setResizable(false);
        intContainer();
        loadProfileData(userName);

    }

    public void intContainer() {

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(204, 255, 255));

        cu1 = new Cursor(Cursor.HAND_CURSOR);
        ImageIcon icon = new ImageIcon("/Elitejersey/IMAGES/logo.jpeg");
        this.setIconImage(icon.getImage());

        // labels

        myacc = new JLabel("My Account");
        myacc.setFont(new Font("Times New Roman", Font.BOLD, 25));
        myacc.setForeground(Color.BLACK);
        myacc.setBounds(130, 110, 150, 50);
        c.add(myacc);

        /*
         * l1=new JLabel("________________________________");
         * l1.setForeground(Color.BLACK);
         * l1.setBounds(125, 125,300, 50);
         * c.add(l1);
         */

        JSeparator separator1 = new JSeparator(SwingConstants.HORIZONTAL);
        separator1.setBounds(125, 160, 200, 15);
        separator1.setBackground(Color.BLACK);
        c.add(separator1);

        // Add JSeparator
        JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
        separator.setBounds(360, 40, 10, 600);
        separator.setBackground(Color.BLACK);
        c.add(separator);

        l2 = new JLabel("Mobile Number");
        l2.setFont(new Font("Times New Roman", Font.BOLD, 17));
        l2.setForeground(Color.BLACK);
        l2.setBounds(400, 80, 150, 50);
        c.add(l2);

        s1 = new JLabel(" *");
        s1.setFont(new Font("Times New Roman", Font.BOLD, 17));
        s1.setForeground(Color.RED);
        s1.setBounds(515, 80, 150, 50);
        c.add(s1);

        l3 = new JLabel("First Name");
        l3.setFont(new Font("Times New Roman", Font.BOLD, 17));
        l3.setForeground(Color.BLACK);
        l3.setBounds(400, 180, 150, 50);
        c.add(l3);

        s2 = new JLabel("*");
        s2.setFont(new Font("Times New Roman", Font.BOLD, 17));
        s2.setForeground(Color.RED);
        s2.setBounds(485, 180, 150, 50);
        c.add(s2);

        l4 = new JLabel("Last Name");
        l4.setFont(new Font("Times New Roman", Font.BOLD, 17));
        l4.setForeground(Color.BLACK);
        l4.setBounds(400, 280, 150, 50);
        c.add(l4);

        s3 = new JLabel("*");
        s3.setFont(new Font("Times New Roman", Font.BOLD, 17));
        s3.setForeground(Color.RED);
        s3.setBounds(485, 280, 150, 50);
        c.add(s3);

        l5 = new JLabel("Display Name");
        l5.setFont(new Font("Times New Roman", Font.BOLD, 17));
        l5.setForeground(Color.BLACK);
        l5.setBounds(400, 380, 150, 50);
        c.add(l5);

        s4 = new JLabel("*");
        s4.setFont(new Font("Times New Roman", Font.BOLD, 17));
        s4.setForeground(Color.RED);
        s4.setBounds(500, 380, 150, 50);
        c.add(s4);

        l6 = new JLabel("(This will be how your name displayed in the account section and in reviews)");
        l6.setFont(new Font("Times New Roman", Font.ITALIC, 13));
        l6.setForeground(Color.DARK_GRAY);
        l6.setBounds(400, 445, 500, 50);
        c.add(l6);

        l7 = new JLabel("Email Address");
        l7.setFont(new Font("Times New Roman", Font.BOLD, 17));
        l7.setForeground(Color.BLACK);
        l7.setBounds(400, 483, 150, 50);
        c.add(l7);

        // buttons

        dashboard = new JButton("Dashboard");
        dashboard.setCursor(cu1);
        dashboard.setBorder(null);
        dashboard.setBounds(100, 160, 150, 60);
        dashboard.setBorderPainted(false);
        dashboard.setContentAreaFilled(false);
        dashboard.setForeground(Color.BLACK);
        dashboard.setFont(new Font("Serif", Font.BOLD, 20));
        c.add(dashboard);

        order = new JButton("Orders");
        order.setCursor(cu1);
        order.setBorder(null);
        order.setBounds(85, 200, 150, 60);
        order.setBorderPainted(false);
        order.setContentAreaFilled(false);
        order.setForeground(Color.BLACK);
        order.setFont(new Font("Serif", Font.BOLD, 20));
        c.add(order);

        download = new JButton("Cart");
        download.setCursor(cu1);
        download.setBorder(null);
        download.setBounds(75, 240, 150, 60);
        download.setBorderPainted(false);
        download.setContentAreaFilled(false);
        download.setForeground(Color.BLACK);
        download.setFont(new Font("Serif", Font.BOLD, 20));
        c.add(download);

        address = new JButton("Addresses");
        address.setCursor(cu1);
        address.setBorder(null);
        address.setBounds(97, 280, 150, 60);
        address.setBorderPainted(false);
        address.setContentAreaFilled(false);
        address.setForeground(Color.BLACK);
        address.setFont(new Font("Serif", Font.BOLD, 20));
        c.add(address);

        acountdetail = new JButton("Account details");
        acountdetail.setCursor(cu1);
        acountdetail.setBorder(null);
        acountdetail.setBounds(113, 320, 150, 60);
        acountdetail.setBorderPainted(false);
        acountdetail.setContentAreaFilled(false);
        acountdetail.setForeground(Color.BLACK);
        acountdetail.setEnabled(false);
        acountdetail.setFont(new Font("Serif", Font.BOLD, 20));
        c.add(acountdetail);

        wishlist = new JButton("Wishlist");
        wishlist.setCursor(cu1);
        wishlist.setBorder(null);
        wishlist.setBounds(87, 360, 150, 60);
        wishlist.setBorderPainted(false);
        wishlist.setContentAreaFilled(false);
        wishlist.setForeground(Color.BLACK);
        wishlist.setFont(new Font("Serif", Font.BOLD, 20));
        c.add(wishlist);

        logout = new JButton("Logout");
        logout.setCursor(cu1);
        logout.setBorder(null);
        logout.setBounds(85, 400, 150, 60);
        logout.setBorderPainted(false);
        logout.setContentAreaFilled(false);
        logout.setForeground(Color.BLACK);
        logout.setFont(new Font("Serif", Font.BOLD, 20));
        c.add(logout);

        save = new JButton("SAVE CHANGES");
        save.setCursor(cu1);
        save.setBounds(400, 575, 160, 30);
        save.setBackground(new Color(223, 242, 218));
        save.setForeground(Color.BLACK);
        save.setFont(new Font("Serif", Font.BOLD, 15));
        c.add(save);

        back = new JButton("HOME");
        back.setCursor(cu1);
        back.setBounds(85, 575, 160, 30);
        back.setBackground(new Color(223, 242, 218));
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Serif", Font.BOLD, 15));
        c.add(back);

        // Text field

        number = new JTextField();
        number.setFont(new Font("Times New Roman", Font.BOLD, 18));
        number.setBorder(new LineBorder(Color.BLACK));
        number.setBounds(400, 125, 400, 30);
        number.setBackground(new Color(214, 220, 229));
        c.add(number);

        firstname = new JTextField();
        firstname.setFont(new Font("Times New Roman", Font.BOLD, 18));
        firstname.setBorder(new LineBorder(Color.BLACK));
        firstname.setBounds(400, 230, 400, 30);
        firstname.setBackground(new Color(214, 220, 229));
        c.add(firstname);

        lastname = new JTextField();
        lastname.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lastname.setBorder(new LineBorder(Color.BLACK));
        lastname.setBounds(400, 330, 400, 30);
        lastname.setBackground(new Color(214, 220, 229));
        c.add(lastname);

        displayname = new JTextField();
        displayname.setFont(new Font("Times New Roman", Font.BOLD, 18));
        displayname.setBorder(new LineBorder(Color.BLACK));
        displayname.setBounds(400, 427, 400, 30);
        displayname.setBackground(Color.RED);
        displayname.setForeground(Color.RED);
        displayname.setEnabled(false);
        c.add(displayname);

        mail = new JTextField();
        mail.setFont(new Font("Times New Roman", Font.BOLD, 18));
        mail.setBorder(new LineBorder(Color.BLACK));
        mail.setBounds(400, 530, 400, 30);
        mail.setBackground(new Color(214, 220, 229));
        c.add(mail);

        dashboard.addMouseListener(this);
        order.addMouseListener(this);
        download.addMouseListener(this);
        address.addMouseListener(this);
        acountdetail.addMouseListener(this);
        wishlist.addMouseListener(this);
        logout.addMouseListener(this);

        order.addActionListener(this);
        save.addActionListener(this);
        logout.addActionListener(this);
        dashboard.addActionListener(this);
        download.addActionListener(this);
        address.addActionListener(this);
        wishlist.addActionListener(this);
        back.addActionListener(this);

    }

    public void loadProfileData(String userName) {
        try (BufferedReader br = new BufferedReader(new FileReader("/Elitejersey/Files/login.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 5 && parts[0].equals(userName)) {
                    // Set values in the fields
                    String fullname = parts[1];
                    String[] nameParts = fullname.split(" ");
                    if (nameParts.length == 2) {
                        String firstnameField = nameParts[0];
                        String lastnameField = nameParts[1];
                        firstname.setText(firstnameField);
                        lastname.setText(lastnameField);
                    } else if (nameParts.length == 3) {
                        String firstnameField1 = nameParts[0];
                        String firstnameField2 = nameParts[1];
                        String lastnameField = nameParts[2];
                        String firstnameField12 = firstnameField1 + " " + firstnameField2;
                        firstname.setText(firstnameField12);
                        lastname.setText(lastnameField);
                    } else if (nameParts.length == 4) {
                        String firstnameField1 = nameParts[0];
                        String firstnameField2 = nameParts[1];
                        String firstnameField3 = nameParts[2];
                        String lastnameField = nameParts[3];
                        String firstnameField12 = firstnameField1 + " " + firstnameField2 + " " + firstnameField3;
                        firstname.setText(firstnameField12);
                        lastname.setText(lastnameField);
                    } else if (nameParts.length == 5) {
                        String firstnameField1 = nameParts[0];
                        String firstnameField2 = nameParts[1];
                        String firstnameField3 = nameParts[2];
                        String lastnameField = nameParts[3];
                        String lastnameField1 = nameParts[4];
                        String firstnameField12 = firstnameField1 + " " + firstnameField2 + " " + firstnameField3;
                        firstname.setText(firstnameField12);
                        lastname.setText(lastnameField + " " + lastnameField1);
                    }
                    displayname.setText(parts[0]);
                    pass = parts[2];
                    number.setText(parts[3]);
                    mail.setText(parts[4]);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error reading profile data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dashboard) {
            dispose();
            Dashboard frame = new Dashboard(userName);
            frame.setVisible(true);

        } else if (e.getSource() == order) {
            OrderPanel cart = new OrderPanel(userName);
            cart.setVisible(true);

        } else if (e.getSource() == download) {

            CartPanel cart = new CartPanel(userName);
            cart.setVisible(true);

        } else if (e.getSource() == address) {
            dispose();
            Addresses frame = new Addresses(userName);
            frame.setVisible(true);

        } else if (e.getSource() == acountdetail) {

        } else if (e.getSource() == wishlist) {
            dispose();
            Wishlist frame = new Wishlist(userName);
            frame.setVisible(true);

        } else if (e.getSource() == logout) {
            dispose();
            Home frame = new Home();
            frame.setVisible(true);

        } else if (e.getSource() == back) {
            dispose();
            HomePage frame = new HomePage(userName);
            frame.setVisible(true);
        } else if (e.getSource() == save) {

            String newNumber = number.getText();
            String newFirstName = firstname.getText();
            String newLastName = lastname.getText();
            String newDisplayName = displayname.getText();
            String newMail = mail.getText();

            boolean newNumberEmpty = newNumber.isEmpty();
            boolean newFirstNameEmpty = newFirstName.isEmpty();
            boolean newLastNameEmpty = newLastName.isEmpty();
            boolean newDisplayNameEmpty = newDisplayName.isEmpty();
            boolean newMailEmpty = newMail.isEmpty();

            if (newNumberEmpty || newFirstNameEmpty || newLastNameEmpty || newDisplayNameEmpty || newMailEmpty) {
                JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    Long.parseLong(newNumber); // Check if the phone is a valid number
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid phone number.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (newNumber.length() != 11) {
                    JOptionPane.showMessageDialog(null, "Please enter a correct phone number.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else if (!isValidEmail(newMail)) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid email address.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    saveChanges();
                }
            }

            dispose();
            AccountDetails frame = new AccountDetails(userName);
            frame.setVisible(true);

        }

    }

    private void saveChanges() {
        // Retrieve the updated information from the text fields
        String newNumber = number.getText();
        String newFirstName = firstname.getText();
        String newLastName = lastname.getText();
        String newDisplayName = displayname.getText();
        String newMail = mail.getText();

        // Create a StringBuilder to store the updated line
        StringBuilder updatedLine = new StringBuilder();
        updatedLine.append(userName).append("\t");
        updatedLine.append(newFirstName).append(" ").append(newLastName).append("\t");
        updatedLine.append(pass).append("\t");
        updatedLine.append(newNumber).append("\t");
        updatedLine.append(newMail);

        // Read the file, update the line, and write the changes back to the file
        try (BufferedReader br = new BufferedReader(new FileReader("/Elitejersey/Files/login.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("/Elitejersey/Files/login_temp.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 5 && parts[0].equals(userName)) {

                    bw.write(updatedLine.toString());

                    // Replace the line with the updated line

                } else {
                    // Write the unchanged line to the temporary file
                    bw.write(line);
                }
                bw.newLine(); // Add a newline character after each line
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving changes", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Rename the temporary file to the original file
        File originalFile = new File("/Elitejersey/Files/login.txt");
        File tempFile = new File("/Elitejersey/Files/login_temp.txt");

        try {
            // Ensure the original file is deleted before renaming
            if (originalFile.exists() && originalFile.delete()) {
                if (tempFile.renameTo(originalFile)) {
                    JOptionPane.showMessageDialog(null, "Changes saved successfully", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error renaming temporary file to the original file", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error deleting the original file", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving changes", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
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

        if (e.getSource() == dashboard) {
            dashboard.setForeground(Color.RED);
        }
        if (e.getSource() == order) {
            order.setForeground(Color.RED);
        }
        if (e.getSource() == download) {
            download.setForeground(Color.RED);
        }
        if (e.getSource() == address) {
            address.setForeground(Color.RED);
        }
        if (e.getSource() == acountdetail) {
            acountdetail.setForeground(Color.RED);
        }
        if (e.getSource() == wishlist) {
            wishlist.setForeground(Color.RED);
        }
        if (e.getSource() == logout) {
            logout.setForeground(Color.RED);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == dashboard) {
            dashboard.setForeground(Color.BLACK);
        }
        if (e.getSource() == order) {
            order.setForeground(Color.BLACK);
        }
        if (e.getSource() == download) {
            download.setForeground(Color.BLACK);
        }
        if (e.getSource() == address) {
            address.setForeground(Color.BLACK);
        }
        if (e.getSource() == acountdetail) {
            acountdetail.setForeground(Color.BLACK);
        }
        if (e.getSource() == wishlist) {
            wishlist.setForeground(Color.BLACK);
        }
        if (e.getSource() == logout) {
            logout.setForeground(Color.BLACK);
        }
    }

    public static void main(String[] args) {
        String userName = "mohsin";
        AccountDetails frame = new AccountDetails(userName);
        frame.setVisible(true);

    }

}
