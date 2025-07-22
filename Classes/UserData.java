package Classes;
import Interfaces.*;
import Interfaces.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.io.*;
import java.nio.file.*;


public class UserData extends JFrame {

    private Container c;
    private ImageIcon icon,backIcon;
    private JLabel label1;
    private Font f1, f2, f3;
    private JScrollPane scroll;
    private JTable table;
    private DefaultTableModel model;
    private JButton btn1, btn2, btn3, btn4, btn5;
    private Cursor cu1;
    private String username;
    // Declare 'file' as a class-level variable
    private String file = "/Elitejersey/Files/login.txt";
    
    private String[] column = { "User Name", "Full name", "Password", "Phone", "Email"};

    public UserData(String username) {

        this.username=username;
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("User Data");
        this.setSize(1280, 720); // Adjusted size
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(28,103,87));

        // Icon
        icon = new ImageIcon("/Elitejersey/IMAGES/logo.jpeg");
        this.setIconImage(icon.getImage());

        backIcon=new ImageIcon("/Elitejersey/IMAGES/back1.png");

      

        // Fonts
        f1 = new Font("Dialog", Font.BOLD, 60);
        f2 = new Font("Helvetica", Font.BOLD, 25);
        f3 = new Font("Segoe UI", Font.PLAIN, 20);

        // Cursor for JButtons
        cu1= new Cursor(Cursor.HAND_CURSOR);

        // Title
        label1 = new JLabel();
        label1.setText("User Data");
        label1.setForeground(Color.decode("#F4DA9B"));
        label1.setBounds(470, 10, 400, 80); // Adjusted position
        label1.setFont(f1);
        c.add(label1);

        // JButtons
        btn1 = new JButton("Refresh");
        btn1.setBounds(400, 520, 140, 50); // Adjusted position
        btn1.setFont(f2);
        btn1.setCursor(cu1);
        btn1.setForeground(Color.decode("#FEE3E0"));
        btn1.setBackground(Color.decode("#0B473A"));
        c.add(btn1);

        btn2 = new JButton("Delete");
        btn2.setBounds(590, 520, 140, 50); // Adjusted position
        btn2.setFont(f2);
        btn2.setCursor(cu1);
        btn2.setForeground(Color.decode("#FEE3E0"));
        btn2.setBackground(Color.decode("#0B473A"));
        c.add(btn2);

        btn3 = new JButton("Add");
        btn3.setBounds(770, 520, 140, 50); // Adjusted position
        btn3.setFont(f2);
        btn3.setCursor(cu1);
        btn3.setForeground(Color.decode("#FEE3E0"));
        btn3.setBackground(Color.decode("#0B473A"));
        c.add(btn3);

       

        btn5=new JButton(backIcon);
        btn5.setCursor(cu1);
        btn5.setBorder(null);
        btn5.setBorderPainted(false);
        btn5.setContentAreaFilled(false);
        btn5.setBounds(45,590,55,55);
        btn5.setToolTipText("Previous");
        c.add(btn5);


        // JTable Layout
        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(column);

        table.setModel(model);
        table.setFont(f3);
        table.setSelectionBackground(new Color(116,196,157));
        table.setBackground(new Color(169,241,226));
        table.setRowHeight(30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // Set preferred widths for columns dynamically
        for (int i = 0; i < column.length; i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(250); // Adjusted width
        }

        scroll = new JScrollPane(table);
        scroll.setBounds(5, 96, 1255, 400); // Adjusted size and position
        //scroll.setBackground(Color.MAGENTA);
        c.add(scroll);

        readDataFromFile(file);

        // Refresh Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                UserData frame = new UserData(username);
                frame.setVisible(true);
            }
        });

        // Delete Button
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int selectedRow = table.getSelectedRow(); // Use 'table' instead of 'dataTable'
                if (selectedRow != -1) {
                    String usernameToDelete = (String) model.getValueAt(selectedRow, 0); // Use 'model' instead of 'tableModel'
                    model.removeRow(selectedRow); // Use 'model' instead of 'tableModel'
                    updateFileWithoutUsername(usernameToDelete);
                } else {
                    JOptionPane.showMessageDialog(UserData.this, "Please select a row to delete", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                AdminAdd frame = new AdminAdd(username);
                frame.setVisible(true);
            }
        });


        // Back Button
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                AdminHome1 frame = new AdminHome1(username);
                frame.setVisible(true);
            }
        });
    }

    private void readDataFromFile(String file) {
        // Clear existing rows in the model
        model.setRowCount(0);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 5) {
                    model.addRow(parts);
                }
                
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading data from file", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateFileWithoutUsername(String username) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < model.getRowCount(); i++) { // Use 'model' instead of 'tableModel'
                for (int j = 0; j < model.getColumnCount(); j++) { // Use 'model' instead of 'tableModel'
                    writer.write(model.getValueAt(i, j).toString()); // Use 'model' instead of 'tableModel'
                    if (j < model.getColumnCount() - 1) {
                        writer.write("\t");
                    }
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error updating data in file", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        String username="admin";
        UserData frame = new UserData(username);
        frame.setVisible(true);
    }
}
