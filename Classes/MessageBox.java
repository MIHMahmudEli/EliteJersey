package Classes;
import Interfaces.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.io.*;
import java.nio.file.*;

public class MessageBox extends JFrame {

    private Container c;
    private ImageIcon icon, backIcon;
    private JLabel label1;
    private Font f1, f2, f3, f4;
    private JScrollPane scroll;
    private JTable table;
    private DefaultTableModel model;
    private JButton btn1, btn2, btn3, btn4, btn5;
    private Cursor cu1;
    private String username;
    private String file = "/Elitejersey/Files/messageBox.txt";
    private String[] column = { "User Name", "Phone", "Email", "Messages", "Date & Time" };

    public MessageBox(String username) {
        this.username = username;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("User Message");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(28, 103, 87));

        icon = new ImageIcon("/Elitejersey/IMAGES/logo.jpeg");
        this.setIconImage(icon.getImage());

        backIcon = new ImageIcon("/Elitejersey/IMAGES/back1.png");

        f1 = new Font("Dialog", Font.BOLD, 60);
        f2 = new Font("Helvetica", Font.BOLD, 25);
        f3 = new Font("Segoe UI", Font.PLAIN, 20);
        f4 = new Font("Segoe UI", Font.PLAIN, 25);

        cu1 = new Cursor(Cursor.HAND_CURSOR);

        label1 = new JLabel();
        label1.setText("User Message");
        label1.setForeground(Color.decode("#F4DA9B"));
        label1.setBounds(470, 10, 1000, 80);
        label1.setFont(f1);
        c.add(label1);

        btn1 = new JButton("Refresh");
        btn1.setBounds(500, 520, 140, 50);
        btn1.setFont(f2);
        btn1.setCursor(cu1);
        btn1.setForeground(Color.decode("#FEE3E0"));
        btn1.setBackground(Color.decode("#0B473A"));
        c.add(btn1);

        btn2 = new JButton("Delete");
        btn2.setBounds(690, 520, 140, 50);
        btn2.setFont(f2);
        btn2.setCursor(cu1);
        btn2.setForeground(Color.decode("#FEE3E0"));
        btn2.setBackground(Color.decode("#0B473A"));
        c.add(btn2);

        btn5 = new JButton(backIcon);
        btn5.setCursor(cu1);
        btn5.setBorder(null);
        btn5.setBorderPainted(false);
        btn5.setContentAreaFilled(false);
        btn5.setBounds(45, 590, 55, 55);
        btn5.setToolTipText("Previous");
        c.add(btn5);

        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(column);

        table.setModel(model);
        table.setFont(f3);
        table.setSelectionBackground(new Color(116, 196, 157));
        table.setBackground(new Color(169, 241, 226));
        table.setRowHeight(30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int i = 0; i < column.length; i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(238);
        }

        // Set preferred width for the "Messages" column
        table.getColumnModel().getColumn(3).setPreferredWidth(300);

        // Create a custom cell renderer for the "Messages" column
        TableColumn messagesColumn = table.getColumnModel().getColumn(3);
        messagesColumn.setCellRenderer(new MultilineCellRenderer());

        scroll = new JScrollPane(table);
        scroll.setBounds(5, 96, 1255, 400);
        c.add(scroll);

        readDataFromFile(file);

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                MessageBox frame = new MessageBox(username);
                frame.setVisible(true);
            }
        });

        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String usernameToDelete = (String) model.getValueAt(selectedRow, 0);
                    model.removeRow(selectedRow);
                    updateFileWithoutUsername(usernameToDelete);
                } else {
                    JOptionPane.showMessageDialog(MessageBox.this, "Please select a row to delete", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                // Assuming you have an AdminHome1 class with the appropriate constructor
                AdminHome1 frame = new AdminHome1(username);
                frame.setVisible(true);
            }
        });
    }

    private void readDataFromFile(String file) {
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
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    writer.write(model.getValueAt(i, j).toString());
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

    class MultilineCellRenderer extends JTextArea implements TableCellRenderer {
        public MultilineCellRenderer() {
            setLineWrap(true);
            setWrapStyleWord(true);

            this.setBackground(new Color(169, 241, 226));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            setText(value != null ? value.toString() : "");
            setSize(table.getColumnModel().getColumn(column).getWidth(), getPreferredSize().height);

            if (isSelected) {
                setBackground(new Color(116, 196, 157)); // Set selection background
                setForeground(table.getSelectionForeground());
            } else {
                setBackground(table.getBackground());
                setForeground(table.getForeground());
                setFont(f4);
            }

            if (table.getRowHeight(row) != getPreferredSize().height) {
                table.setRowHeight(row, getPreferredSize().height);
            }
            return this;
        }

    }

    public static void main(String[] args) {
        String username = "admin";
        MessageBox frame = new MessageBox(username);
        frame.setVisible(true);
    }
}
