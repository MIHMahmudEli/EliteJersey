package Classes;
import Interfaces.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


public class LALIGA extends JFrame implements MouseListener, ActionListener {

    private Container c;
    private Cursor cursor;
    private JScrollPane scrollPane;
    private JPanel panel1, panel2, panel3, gridPanel;
    private JButton button1, button2, button3, button4, button5, button6, button7;
    private ImageIcon icon, icon2;
    private String userName;

    private String[] productTitle = new String[100];
    private String[] productDetails = new String[100];
    private String[] productCategory = new String[100];
    private String[] classPrices = new String[100];
    private String[] imagePaths = new String[100];

    private boolean foundProductsInCategory = false;
    private int count=0;

    public LALIGA(String userName) {

        this.userName = userName;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setTitle("LALIGA");
        this.setResizable(false);

        loadFromFile();
        initContainer();

        this.setVisible(true);
        if (!foundProductsInCategory) {
            JOptionPane.showMessageDialog(this, "No products found in the Serie A category.");

        }
    }

    public void initContainer() {
        c = this.getContentPane();
        c.setLayout(new BorderLayout(5, 5));
        c.setBackground(new Color(204, 255, 255));

        cursor = new Cursor(Cursor.HAND_CURSOR);

        icon2 = new ImageIcon("/Elitejersey/IMAGES/logo.jpeg");
        this.setIconImage(icon2.getImage());

        icon = new ImageIcon("/Elitejersey/IMAGES/in previous.png");

        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setBackground(new Color(204, 255, 255));
        panel1.setPreferredSize(new Dimension(50, 50));
        c.add(panel1, BorderLayout.NORTH);

        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(204, 255, 255));
        panel2.setPreferredSize(new Dimension(50, 30));
        panel1.add(panel2, BorderLayout.CENTER);

        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(204, 255, 255));
        panel3.setPreferredSize(new Dimension(100, 30));
        panel1.add(panel3, BorderLayout.WEST);

        button1 = new JButton("Premeir League");
        button1.setBorderPainted(false);
        button1.setContentAreaFilled(false);
        button1.setBackground(new Color(204, 255, 255));
        button1.setCursor(cursor);
        panel2.add(button1);

        button2 = new JButton("LALIGA");
        button2.setBorderPainted(false);
        button2.setContentAreaFilled(false);
        button2.setBackground(new Color(204, 255, 255));
        button2.setCursor(cursor);
        button2.setEnabled(false);
        panel2.add(button2);

        button3 = new JButton("Bundesliga");
        button3.setBorderPainted(false);
        button3.setContentAreaFilled(false);
        button3.setBackground(new Color(204, 255, 255));
        button3.setCursor(cursor);
        panel2.add(button3);

        button4 = new JButton(" Serie A");
        button4.setBorderPainted(false);
        button4.setContentAreaFilled(false);
        button4.setBackground(new Color(204, 255, 255));
        button4.setCursor(cursor);
        panel2.add(button4);

        button5 = new JButton("Other Leagues");
        button5.setBorderPainted(false);
        button5.setContentAreaFilled(false);
        button5.setBackground(new Color(204, 255, 255));
        button5.setCursor(cursor);
        panel2.add(button5);

        button6 = new JButton("International");
        button6.setBorderPainted(false);
        button6.setContentAreaFilled(false);
        button6.setBackground(new Color(204, 255, 255));
        button6.setCursor(cursor);
        panel2.add(button6);

        button7 = new JButton(icon);
        button7.setBorderPainted(false);
        button7.setContentAreaFilled(false);
        button7.setBackground(new Color(204, 255, 255));
        button7.setCursor(cursor);
        button7.setToolTipText("previous page");
        panel3.add(button7);

        for ( int i = 0; i < imagePaths.length; i++) {
            if (productTitle[i] != null && imagePaths[i] != null && classPrices[i] != null && productCategory[i] != null
                    && productCategory[i].equals("LALIGA")) {
               count++;
            }
        }

        // Use a panel to hold the grid layout
        if(count<=8){
        gridPanel = new JPanel();
        gridPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        gridPanel.setPreferredSize(new Dimension(800, 500)); // Adjust the size as needed
        gridPanel.setBackground(new Color(204, 255, 255));

        // Add panels to the gridPanel
        for (int i = 0; i < imagePaths.length; i++) {
            if (productTitle[i] != null && imagePaths[i] != null && classPrices[i] != null && productCategory[i] != null
                    && productCategory[i].equals("LALIGA")) {
                gridPanel.add(createPanel(productTitle[i], imagePaths[i], classPrices[i]));
                foundProductsInCategory = true;
            }
        }

        // Set the gridPanel as the view for the scrollPane
        scrollPane = new JScrollPane(gridPanel);
        c.add(scrollPane, BorderLayout.CENTER);

        cursor = new Cursor(Cursor.HAND_CURSOR);
    }
    else{
        // Use a panel to hold the grid layout
        gridPanel = new JPanel(new GridLayout(0, 4, 5, 5));
        gridPanel.setBackground(new Color(204, 255, 255));

        cursor = new Cursor(Cursor.HAND_CURSOR);


        // Add panels to the gridPanel
    for ( int i = 0; i < imagePaths.length; i++) {
        if (productTitle[i] != null && imagePaths[i] != null && classPrices[i] != null && productCategory[i] != null && productCategory[i].equals("LALIGA")) {
                gridPanel.add(createPanel(productTitle[i], imagePaths[i], classPrices[i]));
                foundProductsInCategory = true;
            }
        }

        scrollPane = new JScrollPane(gridPanel);
        c.add(scrollPane, BorderLayout.CENTER);
    }


        button1.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);

        button1.addMouseListener(this);
        button3.addMouseListener(this);
        button3.addMouseListener(this);
        button4.addMouseListener(this);
        button5.addMouseListener(this);
        button6.addMouseListener(this);
    }

    private JPanel createPanel(String productTitle, String imagePath, String classPrices) {
        JPanel newPanel = new JPanel(new BorderLayout());
        newPanel.setPreferredSize(new Dimension(305, 250));

        JLabel name = new JLabel(productTitle);
        name.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel price = new JLabel("Price: " + classPrices + " TK");
        price.setHorizontalAlignment(SwingConstants.CENTER);

        JButton newButton = new JButton();
        newButton.setCursor(cursor);

        ImageIcon buttonIcon = resizeImage(imagePath, 315, 200); // Adjust width and height as needed
        newButton.setIcon(buttonIcon);

        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LeaguePanel targetPanel = (LeaguePanel) new ProductClass6(productTitle, imagePath, classPrices,
                        userName);
                targetPanel.showPanel(productTitle, imagePath, classPrices);
                dispose();
            }
        });

        newPanel.add(newButton, BorderLayout.NORTH);
        newPanel.add(price, BorderLayout.CENTER);
        newPanel.add(name, BorderLayout.SOUTH);

        return newPanel;
    }

    private ImageIcon resizeImage(String imagePath, int width, int height) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(imagePath));
            Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(resizedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("/Elitejersey/Files/Product.txt"))) {
            String line;
            int index = 0;
            while ((line = br.readLine()) != null && index < classPrices.length) {
                String[] parts = line.split("\t");
                if (parts.length == 5) {
                    productTitle[index] = parts[0];
                    productDetails[index] = parts[1];
                    classPrices[index] = parts[2];
                    productCategory[index] = parts[3];
                    imagePaths[index] = parts[4];
                    index++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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
        if (e.getSource() == button1) {
            button1.setForeground(Color.RED);
        } else if (e.getSource() == button3) {
            button3.setForeground(Color.RED);
        }

        else if (e.getSource() == button4) {
            button4.setForeground(Color.RED);
        } else if (e.getSource() == button5) {
            button5.setForeground(Color.RED);
        } else if (e.getSource() == button6) {
            button6.setForeground(Color.RED);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == button1 || e.getSource() == button3 || e.getSource() == button4 || e.getSource() == button5
                || e.getSource() == button6) {
            button1.setForeground(Color.black);
            button3.setForeground(Color.black);
            button4.setForeground(Color.black);
            button5.setForeground(Color.black);
            button6.setForeground(Color.black);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button7) {
            HomePage frame = new HomePage(userName);
            this.dispose();
            frame.setVisible(true);

        } else if (e.getSource() == button1) {
            PremeirLeague frame = new PremeirLeague(userName);
            frame.setVisible(true);
            dispose();
        } else if (e.getSource() == button3) {
            Bundesliga frame = new Bundesliga(userName);
            frame.setVisible(true);
            dispose();
        } else if (e.getSource() == button4) {
            SerieA frame = new SerieA(userName);
            frame.setVisible(true);
            dispose();
        } else if (e.getSource() == button5) {
            OtherLeagues frame = new OtherLeagues(userName);
            frame.setVisible(true);
            dispose();
        } else if (e.getSource() == button6) {
            International frame = new International(userName);
            frame.setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        String userName = "Mohsin";
        LALIGA frame = new LALIGA(userName);
    }
}
