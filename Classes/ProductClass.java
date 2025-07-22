package Classes;
import Interfaces.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ProductClass extends JFrame implements ActionListener, LeaguePanel {
    private Container c;
    private JLabel j1, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14,j15,j16,img1, img2;
    private Font f1;
    private JButton b1, b2,b3,backButton; 
    private ImageIcon img,icon,icon2;
    private JToggleButton t1, t2, t3, t4, t5;
    private JComboBox jcb; 
    private ButtonGroup bg1;
    private JPanel jp1, jp2, jp3;
    private CartPanel cartPanel;
    private Cursor cu1;
    private String userName;

    private String[] quantity = {"            1", "            2", "            3", "            4", "            5"};

    //private String[] classPrices = new String[100];
    private String productTitle;
    private String imagePath;
    private String classPrice;


    public ProductClass(String productTitle, String imagePath, String classPrice, String userName) {

        this.productTitle=productTitle;
        this.imagePath=imagePath;
        this.classPrice=classPrice;
        this.userName=userName;
         
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setTitle("Product Details");
        this.setResizable(false);

        //loadPricesFromFile();

        //enteredPrice=new String (classPrices[0]);

        initContainer();
    }

    public void initContainer() {
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(204, 255, 255));

        bg1 = new ButtonGroup();

        cu1=new Cursor(Cursor.HAND_CURSOR);

        icon2= new ImageIcon("/Elitejersey/IMAGES/logo.jpeg");
        this.setIconImage(icon2.getImage());


        
        icon=new ImageIcon("/Elitejersey/IMAGES/verified.PNG");

        try {
            img = new ImageIcon(imagePath);
            Image scaledImage = img.getImage().getScaledInstance(550, 480, Image.SCALE_SMOOTH);
            img = new ImageIcon(scaledImage);
            img1 = new JLabel(img);
            img1.setBounds(20, 20, img.getIconWidth(), img.getIconHeight());
            c.add(img1);
        } catch (Exception e) {
            e.printStackTrace();

        }
        

        

        img = new ImageIcon("/Elitejersey/IMAGES/SC2.PNG");

        img2 = new JLabel(img);
        img2.setBounds(50, 535, img.getIconWidth(), img.getIconHeight());
        c.add(img2);

        jp1 = new JPanel();
        jp1.setLayout(null);
        jp1.setBounds(630, 180, 500, 200);
        jp1.setBackground(Color.LIGHT_GRAY);
        c.add(jp1);

        jp2 = new JPanel();
        jp2.setBounds(105, 13, 40, 25);
        jp2.setBackground(Color.LIGHT_GRAY);
        jp2.setVisible(false);
        jp1.add(jp2);

        jp3 = new JPanel();
        jp3.setLayout(null);
        jp3.setBounds(600, 0, 670, 720);
        c.add(jp3);

        f1 = new Font("Neue Haas Grotesk Text Pro", Font.BOLD, 30);
        j1 = new JLabel(productTitle);
        j1.setBounds(20, 30, 700, 40);
        j1.setFont(f1);
        j1.setForeground(Color.black);
        jp3.add(j1);

        f1 = new Font("Neue Haas Grotesk Text Pro", Font.BOLD, 16);
        j5 = new JLabel("In Stock");
        j5.setBounds(30, 80, 200, 30);
        j5.setFont(f1);
        j5.setForeground(Color.green);
        jp3.add(j5);

        f1 = new Font("Neue Haas Grotesk Text Pro", Font.BOLD, 16);
        j2 = new JLabel("Select Size");
        j2.setBounds(20, 10, 300, 30);
        j2.setFont(f1);
        j2.setForeground(Color.black);
        jp1.add(j2);

        f1 = new Font("Neue Haas Grotesk Text Pro", Font.BOLD, 20);
        j3 = new JLabel("Price "+ classPrice + " TK");
        j3.setBounds(20,150,150, 30);
        j3.setFont(f1);
        j3.setForeground(Color.black);
        jp3.add(j3);

        
        f1 = new Font("Neue Haas Grotesk Text Pro", Font.BOLD, 16);
        j4 = new JLabel("Quantity");
        j4.setBounds(20, 100, 100, 30);
        j4.setFont(f1);
        j4.setForeground(Color.black);
        jp1.add(j4);

        f1 = new Font("Neue Haas Grotesk Text Pro", Font.BOLD, 16);
        j6 = new JLabel("Shipping");
        j6.setBounds(20, 400, 300, 30);
        j6.setFont(f1);
        j6.setForeground(Color.black);
        jp3.add(j6);

        f1 = new Font("Neue Haas Grotesk Text Pro", Font.PLAIN, 14);
        j7 = new JLabel("- This item will ship within 5 business days");
        j7.setBounds(20, 430, 500, 45);
        j7.setFont(f1);
        j7.setForeground(Color.black);
        jp3.add(j7);

        f1 = new Font("Neue Haas Grotesk Text Pro", Font.BOLD, 16);
        j8 = new JLabel("Details");
        j8.setBounds(20, 480, 500, 45);
        j8.setFont(f1);
        j8.setForeground(Color.black);
        jp3.add(j8);

        f1 = new Font("Neue Haas Grotesk Text Pro", Font.PLAIN, 14);
        j9 = new JLabel("- Brand:Adidas");
        j9.setBounds(20, 510, 500, 45);
        j9.setFont(f1);
        j9.setForeground(Color.black);
        jp3.add(j9);

        f1 = new Font("Neue Haas Grotesk Text Pro", Font.PLAIN, 14);
        j10 = new JLabel("- Country of origin: Vietnam");
        j10.setBounds(20, 530, 500, 45);
        j10.setFont(f1);
        j10.setForeground(Color.black);
        jp3.add(j10);

        f1 = new Font("Neue Haas Grotesk Text Pro", Font.PLAIN, 14);
        j11 = new JLabel("- Regular fit,Short sleeve ");
        j11.setBounds(20, 550, 500, 45);
        j11.setFont(f1);
        j11.setForeground(Color.black);
        jp3.add(j11);

        f1 = new Font("Neue Haas Grotesk Text Pro", Font.BOLD, 16);
        j13 = new JLabel("Description");
        j13.setBounds(350, 480, 500, 45);
        j13.setFont(f1);
        j13.setForeground(Color.black);
        jp3.add(j13);

        f1 = new Font("Neue Haas Grotesk Text Pro", Font.PLAIN, 12);
        j12 = new JLabel("-A third star for the three-time World Champions, show ");
        j12.setBounds(350, 510, 500, 45);
        j12.setFont(f1);
        j12.setForeground(Color.black);
        jp3.add(j12);
        f1 = new Font("Neue Haas Grotesk Text Pro", Font.PLAIN, 12);
        j14 = new JLabel("off your love for La Albiceleste with this Argentina winners ");
        j14.setBounds(350, 530, 500, 45);
        j14.setFont(f1);
        j14.setForeground(Color.black);
        jp3.add(j14);
        f1 = new Font("Neue Haas Grotesk Text Pro", Font.PLAIN, 12);
        j14 = new JLabel("home shirt from adidas.");
        j14.setBounds(350, 550, 500, 45);
        j14.setFont(f1);
        j14.setForeground(Color.black);
        jp3.add(j14);

        t1 = new JToggleButton("XS");
        t1.setActionCommand("XS");
        t1.setBounds(20, 40, 60, 40);
        jp1.add(t1);
        bg1.add(t1);
        
        t2=new JToggleButton("S");
        t2.setActionCommand("S");
        t2.setBounds(100, 40, 60, 40);
        jp1.add(t2);
        bg1.add(t2);

        t3=new JToggleButton("M");
        t3.setActionCommand("M");
        t3.setBounds(180, 40, 60, 40);
        jp1.add(t3);
        bg1.add(t3);

        t4=new JToggleButton("L");
        t4.setActionCommand("L");
        t4.setBounds(260, 40, 60, 40);
        jp1.add(t4);
        bg1.add(t4);

        t5=new JToggleButton("XL");
        t5.setActionCommand("XL");
        t5.setBounds(340, 40, 60, 40);
        jp1.add(t5);
        bg1.add(t5);
        

        b1 = new JButton("Add to Cart");
        b1.setBounds(200, 140, 200, 30);
        b1.setBackground(Color.green);
        jp1.add(b1);

        b2 = new JButton("Customize");
        b2.setBounds(200, 100, 200, 30);
        b2.setBackground(Color.red);
        jp1.add(b2);


       img = new ImageIcon("/Elitejersey/IMAGES/button.PNG");
       backButton=new JButton(img);
       backButton.setBounds(30,620, 100,30);
       backButton.setBackground(Color.red);
       backButton.setCursor(cu1);
       backButton.setBorderPainted(false);
       backButton.setContentAreaFilled(false);
       jp3.add(backButton);

       img = new ImageIcon("/Elitejersey/IMAGES/button2.PNG");
       b3=new JButton(img);
       b3.setBounds(500,70,100,100);
       b3.setBackground(Color.red);
       b3.setCursor(cu1);
       b3.setBorderPainted(false);
       b3.setContentAreaFilled(false);
       jp3.add(b3);

        jcb = new JComboBox(quantity); 
        jcb.setSelectedIndex(0);
        jcb.setBounds(20, 140, 120, 30);
        jcb.setBackground(Color.WHITE);
        jp1.add(jcb);

        t1.addActionListener(this);
        t2.addActionListener(this);
        t3.addActionListener(this);
        t4.addActionListener(this);
        t5.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        backButton.addActionListener(this);
        
    }

    public void actionPerformed(ActionEvent e) {
        String size = "";
    
        if (e.getSource() == t1) {
            size = "XS";
        } else if (e.getSource() == t2) {
            size = "S";
        } else if (e.getSource() == t3) {
            size = "M";
        } else if (e.getSource() == t4) {
            size = "L";
        } else if (e.getSource() == t5) {
            size = "XL";
        }
        jp2.removeAll();
    
        JLabel newSizeLabel = new JLabel(size);
        jp2.add(newSizeLabel);
        jp2.setVisible(true);
        jp2.revalidate();
        jp2.repaint();
    
        if (e.getSource() == b1) {
           
            ButtonModel selectedModel = bg1.getSelection();
            if (selectedModel != null) {
                String selectedSize = selectedModel.getActionCommand();
                String selectedImage =imagePath;
                String itemName = j1.getText();
                String itemPrice = classPrice;
                String quantity = jcb.getSelectedItem().toString();

                try (FileWriter fw = new FileWriter("/Elitejersey/Files/shoppingCard.txt", true)) {
                    fw.write(selectedImage + "\t" + itemName +"\t" + itemPrice + "\t" + quantity + "\t" + selectedSize + "\t" + userName +"\n");
                    fw.close();
                    JOptionPane.showMessageDialog(null, "Added Successfuly", "Confirm",JOptionPane.PLAIN_MESSAGE,icon);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                
                
                
                
            } else {
                JOptionPane.showMessageDialog(null, "Select size", "Warning", JOptionPane.WARNING_MESSAGE);
            }
    }

    else if (e.getSource()==b3){
        cartPanel = new CartPanel(userName);
        cartPanel.setVisible(true);
    }
    else if (e.getSource()==b2){
        Customize frame = new Customize();
        frame.setVisible(true);
    }
       else  if (e.getSource() == backButton) {
            HomePage frame = new HomePage(userName);
            dispose();
            frame.setVisible(true);
        }
    
    }

    public void showPanel(String productTitle, String imagePath, String classPrices) {
        
        this.setVisible(true);
    }

    
    
    public static void main(String[] args) {

        String productTitle="bra";
        String imagePath="/Elitejersey/IMAGES/Bayern2.png";
        String classPrice="2000";
        String userName="mohsin";
        ProductClass frame = new ProductClass(productTitle,imagePath,classPrice,userName);
        frame.setVisible(true);

    }
}


