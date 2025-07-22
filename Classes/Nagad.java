package Classes;
import Interfaces.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Nagad extends JFrame implements ActionListener {
    private Container c;
    private JLabel j1, j2, img1;
    private Font f1, f2;
    private JButton b1, b2;
    private JTextField t1;
    private JPasswordField p1;
    private ImageIcon img, icon2, icon;
    private JPanel jp1, jp2;
    private String loggedInUsername;

    public Nagad(String loggedInUsername) {

        this.loggedInUsername = loggedInUsername;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(534, 463);
        this.setLocationRelativeTo(null);
        this.setTitle("Nagad");
        this.setResizable(false);

        initContainer();

        this.setVisible(true); // Move setVisible to the end
    }

    private void initContainer() {
        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.white);

        icon2 = new ImageIcon("/Elitejersey/IMAGES/logo.jpeg");
        this.setIconImage(icon2.getImage());

        jp1 = new JPanel();
        jp1.setLayout(null);
        jp1.setBounds(0, 111, 534, 352);
        jp1.setBackground(new Color(236, 94, 0));
        c.add(jp1);

        jp2 = new JPanel();
        jp2.setLayout(null);
        jp2.setBounds(0, 0, 534, 111);
        jp2.setBackground(Color.white);
        c.add(jp2);

        img = new ImageIcon("/Elitejersey/IMAGES/Nagad.png");
        img1 = new JLabel(img);
        img1.setSize(534, 111);
        jp2.add(img1);

        f2 = new Font("Abadi", Font.PLAIN, 20);
        j1 = new JLabel("NUMBER :");
        j1.setForeground(Color.WHITE);
        j1.setFont(f2);
        j1.setBounds(60, 20, 200, 100);
        jp1.add(j1);

        f2 = new Font("Abadi", Font.PLAIN, 20);
        j1 = new JLabel("PIN          :");
        j1.setForeground(Color.WHITE);
        j1.setFont(f2);
        j1.setBounds(60, 100, 200, 100);
        jp1.add(j1);

        f1 = new Font("Times New Roman", Font.PLAIN, 20);
        t1 = new JTextField() {
            @Override
            public void processKeyEvent(KeyEvent ev) {
                char c = ev.getKeyChar();
                if (Character.isDigit(c) || ev.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    // Allow only numeric characters or backspace
                    super.processKeyEvent(ev);
                } else {
                    // Ignore other characters
                    ev.consume();
                }
            }
        };
        t1.setFont(f1);
        t1.setForeground(Color.BLACK);
        t1.setBackground(Color.WHITE);
        t1.setBounds(170, 55, 200, 40);
        jp1.add(t1);

        p1 = new JPasswordField() {
            @Override
            public void processKeyEvent(KeyEvent ev) {
                char c = ev.getKeyChar();
                if (Character.isDigit(c) || ev.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    // Allow only numeric characters or backspace
                    super.processKeyEvent(ev);
                } else {
                    // Ignore other characters
                    ev.consume();
                }
            }
        };
        p1.setEchoChar('*');
        p1.setFont(f2);
        p1.setForeground(Color.black);
        p1.setBackground(Color.white);
        p1.setBounds(170, 135, 200, 40);
        jp1.add(p1);

        f2 = new Font("Abadi", Font.PLAIN, 16);
        b1 = new JButton("Paymnet");
        b1.setFont(f2);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.black);
        b1.setBounds(320, 250, 100, 30);
        jp1.add(b1);

        f2 = new Font("Abadi", Font.PLAIN, 16);
        b2 = new JButton("Back");
        b2.setFont(f2);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.black);
        b2.setBounds(125, 250, 100, 30);
        jp1.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        // Add MouseListener to the text field
        t1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle the event when the text field is clicked
                try (BufferedReader br = new BufferedReader(new FileReader("/Elitejersey/Files/login.txt"))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split("\t");
                        if (parts.length == 5 && parts[0].equals(loggedInUsername)) {
                            t1.setText(parts[3]); // Set the number in the text field
                            break;
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

    private void moveAndDeleteData() {
        try (BufferedReader br = new BufferedReader(new FileReader("/Elitejersey/Files/shoppingCard.txt"));
             FileWriter fwOrder = new FileWriter("/Elitejersey/Files/orderCard.txt", true);
             FileWriter fwTemp = new FileWriter("/Elitejersey/Files/shoppingCard_temp.txt")) {
    
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 6 && loggedInUsername.equals(parts[5])) {
                    // Move the information to orderCard.txt
                    fwOrder.write(parts[0] + "\t" + parts[1] + "\t" + parts[2] + "\t" + parts[3] + "\t" + parts[4] + "\t" + parts[5] + "\n");
                } else {
                    // Write non-matching lines to temporary file
                    fwTemp.write(line + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error reading or writing files.");
            return; // Exit method if an error occurs
        }
    
        // Delete shoppingCard.txt
        File shoppingCardFile = new File("/Elitejersey/Files/shoppingCard.txt");
        if (!shoppingCardFile.exists()) {
            System.err.println("Error: shoppingCard.txt does not exist.");
            return; // Exit method if the file does not exist
        }
    
        if (shoppingCardFile.delete()) {
            // Rename shoppingCard_temp.txt to shoppingCard.txt
            File tempFile = new File("/Elitejersey/Files/shoppingCard.txt");
            if (tempFile.renameTo(shoppingCardFile)) {
                System.out.println("Data moved and deleted successfully.");
            } else {
                System.err.println("successfully in moving and renaming data.");
            }
        } else {
            System.err.println("Error in deleting shoppingCard.txt.");
        }
    }

    private void moveAndDeleteData2() {
        try (BufferedReader br = new BufferedReader(new FileReader("/Elitejersey/Files/shoppingCard_temp.txt "));
             FileWriter fwOrder = new FileWriter("/Elitejersey/Files/orderCard.txt", true);
             FileWriter fwTemp = new FileWriter("/Elitejersey/Files/shoppingCard.txt")) {
    
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 6 && loggedInUsername.equals(parts[5])) {
                    // Move the information to orderCard.txt
                    fwOrder.write(parts[0] + "\t" + parts[1] + "\t" + parts[2] + "\t" + parts[3] + "\t" + parts[4] + "\t" + parts[5] + "\n");
                } else {
                    // Write non-matching lines to temporary file
                    fwTemp.write(line + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error reading or writing files.");
            return; // Exit method if an error occurs
        }
    
        // Delete shoppingCard.txt
        File shoppingCardFile = new File("/Elitejersey/Files/shoppingCard_temp.txt");
        if (!shoppingCardFile.exists()) {
            System.err.println("Error: shoppingCard_temp.txt does not exist.");
            return; // Exit method if the file does not exist
        }
    
        if (shoppingCardFile.delete()) {
            // Rename shoppingCard_temp.txt to shoppingCard.txt
            File tempFile = new File("/Elitejersey/Files/shoppingCard_temp.txt");
            if (tempFile.renameTo(shoppingCardFile)) {
                System.out.println("Data moved and deleted successfully.");
            } else {
                System.err.println("successfully in moving and renaming data.");
            }
        } else {
            System.err.println("Error in deleting shoppingCard_temp.txt.");
        }
    }
    
    

    public void actionPerformed(ActionEvent e) {
        String number = String.valueOf(t1.getText());
        String pin = String.valueOf(p1.getPassword());
        boolean numberEmpty = number.isEmpty();
        boolean pinEmpty = pin.isEmpty();

        if (e.getSource() == b1) {
            if (numberEmpty || pinEmpty) {
                JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    Long.parseLong(number); // Check if the phone is a valid number
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter your valid phone number.", "Warning!", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (number.length() != 11) {
                    JOptionPane.showMessageDialog(null, "Please enter your correct phone number.", "Warning!", JOptionPane.WARNING_MESSAGE);
                } else if (pin.length() != 4) {
                    JOptionPane.showMessageDialog(null, "Please enter your correct pin number.", "Warning!", JOptionPane.WARNING_MESSAGE);
                } else {
                    ImageIcon icon = new ImageIcon("/Elitejersey/IMAGES/verified.PNG");
                    JOptionPane.showMessageDialog(null, "Payment successfully.", "Success!",
                            JOptionPane.INFORMATION_MESSAGE, icon);
                    dispose();
                    moveAndDeleteData(); // Move and delete data
                    moveAndDeleteData2();

                }
            }
        } else if (e.getSource() == b2) {
            // Close the BkashPayment window
            dispose();
        }
    }

    public static void main(String[] args) {
        String loggedInUsername = "mohsin";
        Nagad log = new Nagad(loggedInUsername);
    }
}