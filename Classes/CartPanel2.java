package Classes;
import Interfaces.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CartPanel2 extends JFrame implements ActionListener,MouseListener {

    private Container c;
    private JPanel jp1, jp2, jp3, jp4, jp5,jp6;
    private JLabel img, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15;
    private JButton b1, b2, b3;
    private JToggleButton pb;
    private Font f1;
    private Image scaledImage;
    private ImageIcon img1, icon2;
    private JSeparator j2, j1, j3, j4;
    private Cursor cu1;
    private String userName;
    private JScrollPane scrollPane;
    private boolean foundUserName = false;

    private String[] imagePaths = new String[100];
    private String[] productTitle = new String[100];
    private String[] classPrices = new String[100];
    private String[] productQuantati = new String[100];
    private String[] productSize = new String[100];
    private String[] userNameArray = new String[100];

    private ImageIcon scaledIcon;

    ImageIcon image = new ImageIcon("/Elitejersey/IMAGES/Arg2.png");
    String name = "Argentina Adidas Home Shirt 2023-24";
    String price = "100";
    String size = "XL";
    String quantity = "2";

    private double totalPrice = 0.0;

    public CartPanel2(String userName) {
        this.userName = userName;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1080, 520);
        this.setTitle("Shopping Cart");
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        loadFromFile();
        initCartPanel2();

        this.setVisible(true);
    }

    private void initCartPanel2() {
        c = this.getContentPane();
        c.setLayout(new BorderLayout());
        c.setBackground(new Color(204, 255, 255));

        icon2 = new ImageIcon("/Elitejersey/IMAGES/logo.jpeg");
        this.setIconImage(icon2.getImage());

        cu1 = new Cursor(Cursor.HAND_CURSOR);

        try {
            scaledImage = image.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            scaledIcon = new ImageIcon(scaledImage);

        } catch (Exception e) {
            e.printStackTrace();
        }

        jp1 = new JPanel(new BorderLayout());
        jp1.setBackground(new Color(204, 255, 255));
        c.add(jp1, BorderLayout.CENTER);

        jp4 = new JPanel(new GridLayout(0, 1, 5, 2));
        jp4.setBackground(new Color(204, 255, 255));

        scrollPane = new JScrollPane(jp4);
        scrollPane.setBackground(new Color(204, 255, 255));
        jp1.add(scrollPane, BorderLayout.CENTER);

        jp2 = new JPanel(new GridLayout(1, 3));
        jp2.setBackground(Color.BLUE);
        jp2.setVisible(false);
        c.add(jp2, BorderLayout.SOUTH);

        jp3 = new JPanel(new GridLayout(1, 5));
        jp3.setBackground(Color.cyan);
        jp3.setPreferredSize(new Dimension(50, 30));
        c.add(jp3, BorderLayout.NORTH);

        l10 = new JLabel("                                  PRODUCT");
        l10.setFont(new Font("Neue Haas Grotesk Text Pro", Font.BOLD, 14));
        jp3.add(l10);

        l11 = new JLabel("                                      PRICE");
        l11.setFont(new Font("Neue Haas Grotesk Text Pro", Font.BOLD, 14));
        jp3.add(l11);

        l12 = new JLabel("                           QUANTITY");
        l12.setFont(new Font("Neue Haas Grotesk Text Pro", Font.BOLD, 14));
        jp3.add(l12);

        l13 = new JLabel("              SIZE");
        l13.setFont(new Font("Neue Haas Grotesk Text Pro", Font.BOLD, 14));
        jp3.add(l13);

        l14 = new JLabel("    SUBTOTAL");
        l14.setFont(new Font("Neue Haas Grotesk Text Pro", Font.BOLD, 14));
        jp3.add(l14);

        img1 = new ImageIcon("/Elitejersey/IMAGES/bkash1.png");
        b1 = new JButton(img1);
        b1.setCursor(cu1);
        jp2.add(b1, BorderLayout.CENTER);

        img1 = new ImageIcon("/Elitejersey/IMAGES/Nagad.png");
        b2 = new JButton(img1);
        b1.setCursor(cu1);
        jp2.add(b2, BorderLayout.EAST);

        img1 = new ImageIcon("/Elitejersey/IMAGES/Rocket1.png");
        b3 = new JButton(img1);
        b3.setCursor(cu1);
        jp2.add(b3, BorderLayout.WEST);

        

        // Add panels to the gridPanel
        for (int i = 0; i < imagePaths.length; i++) {
            if (imagePaths[i] != null && productTitle[i] != null && classPrices[i] != null && productQuantati[i] != null
                    && productSize[i] != null && userNameArray[i].equals(userName)) {
                jp4.add(createPanel(imagePaths[i], productTitle[i], classPrices[i], productQuantati[i], productSize[i], i));
                foundUserName = true;
            }
        }

        

        jp5 = new JPanel(new BorderLayout());
        jp5.setBackground(Color.CYAN);
        jp5.setPreferredSize(new Dimension(50, 30));
        jp1.add(jp5, BorderLayout.SOUTH);

        JLabel totLabel = new JLabel("Total: ");
        totLabel.setFont(new Font("Neue Haas Grotesk Text Pro", Font.BOLD, 14));
        totLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jp5.add(totLabel, BorderLayout.CENTER);

        jp6 = new JPanel(new BorderLayout());
        jp6.setBackground(Color.CYAN);
        jp6.setPreferredSize(new Dimension(185, 30));
        jp5.add(jp6, BorderLayout.EAST);

        JLabel totPriceLabel = new JLabel(totalPrice + " TK");
        totPriceLabel.setFont(new Font("Neue Haas Grotesk Text Pro", Font.BOLD, 14));
        totPriceLabel.setForeground(Color.red);
        totPriceLabel.setHorizontalAlignment(SwingConstants.LEFT);
        jp6.add(totPriceLabel, BorderLayout.CENTER);
        

        pb = new JToggleButton("PROCEED TO CHECKOUT");
        pb.setCursor(cu1);
        pb.setBackground(Color.green);
        jp5.add(pb, BorderLayout.WEST);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        pb.addActionListener(this);
        //pb.addMouseListener(this);
    }

    private JPanel createPanel(String imagePath, String productTitle, String classPrices, String quantity,
            String size, int index) {
        JPanel newPanel = new JPanel(new BorderLayout());
        newPanel.setBackground(new Color(204, 255, 255));
        newPanel.setPreferredSize(new Dimension(1040, 50));

        JPanel panel0 = new JPanel(new BorderLayout());
        panel0.setBackground(new Color(204, 255, 255));
        panel0.setPreferredSize(new Dimension(350, 50));

        JPanel panel00 = new JPanel(new GridLayout(1, 2));
        panel00.setBackground(new Color(204, 255, 255));
        panel00.setPreferredSize(new Dimension(100, 50));

        JPanel panel000 = new JPanel(new GridLayout(1, 3));
        panel000.setBackground(new Color(204, 255, 255));
        panel000.setPreferredSize(new Dimension(200, 50));

        double priceValue = 0.0;
        double quantityValue = 0.0;

        try {
            priceValue = Double.parseDouble(classPrices);
            quantityValue = Double.parseDouble(quantity);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

        double totalPriceForProduct = priceValue * quantityValue;
        totalPrice += totalPriceForProduct;

        JLabel name = new JLabel(productTitle);
        name.setHorizontalAlignment(SwingConstants.LEFT);
        JLabel totalPricename = new JLabel(String.valueOf(totalPriceForProduct + " TK"));
        JLabel sizename = new JLabel(size);
        JLabel quantityname = new JLabel(quantity);
        JLabel price = new JLabel("Price: " + classPrices + " TK");

        JButton newButton = new JButton();
        newButton.setBorderPainted(false);
        newButton.setContentAreaFilled(false);
        newButton.setCursor(cu1);

        ImageIcon deButtonIcon = new ImageIcon("/Elitejersey/IMAGES/icon/delete.jpeg");

        JButton DeleteButton = new JButton(deButtonIcon);
        DeleteButton.setBorderPainted(false);
        DeleteButton.setContentAreaFilled(false);
        DeleteButton.setCursor(cu1);

        ImageIcon buttonIcon = resizeImage(imagePath, 50, 50);
        newButton.setIcon(buttonIcon);

        DeleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Delete product information
                    imagePaths[index] = null;
                    productQuantati[index] = null;
                    productSize[index] = null;
                    userNameArray[index] = null;

                    // Update the file
                    saveToFile();

                    // Refresh the UI
                    dispose();
                    CartPanel2 frame = new CartPanel2(userName);
                    frame.setVisible(true);

                } catch (Exception ex) {
                    System.out.print(ex);
                }
            }
        });

        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    seeProductPicture frame = new seeProductPicture(imagePath);
                    frame.setVisible(true);

                } catch (Exception ex) {
                    System.out.print(ex);
                }
            }
        });

        panel000.add(price);
        panel000.add(quantityname);
        panel000.add(sizename);
        panel000.add(totalPricename);

        panel00.add(DeleteButton);
        panel00.add(newButton);

        panel0.add(panel00, BorderLayout.WEST);
        panel0.add(name, BorderLayout.CENTER);

        newPanel.add(panel0, BorderLayout.WEST);
        newPanel.add(panel000, BorderLayout.CENTER);

        return newPanel;
    }

    private void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("/Elitejersey/Files/shoppingCard.txt"))) {
            String line;
            int index = 0;
            while ((line = br.readLine()) != null && index < classPrices.length) {
                String[] parts = line.split("\t");
                if (parts.length == 6) {
                    imagePaths[index] = parts[0];
                    productTitle[index] = parts[1];
                    classPrices[index] = parts[2];
                    productQuantati[index] = parts[3];
                    productSize[index] = parts[4];
                    userNameArray[index] = parts[5];

                    index++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("/Elitejersey/Files/shoppingCard.txt"))) {
            for (int i = 0; i < classPrices.length; i++) {
                if (imagePaths[i] != null && productTitle[i] != null && classPrices[i] != null
                        && productQuantati[i] != null && productSize[i] != null && userNameArray[i].equals(userName)) {
                    bw.write(imagePaths[i] + "\t" + productTitle[i] + "\t" + classPrices[i] + "\t" + productQuantati[i]
                            + "\t" + productSize[i] + "\t" + userNameArray[i]);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            Bkash log = new Bkash(userName);
            log.setVisible(true);
        } else if (e.getSource() == b2) {
            Nagad log = new Nagad(userName);
            log.setVisible(true);

        } else if (e.getSource() == b3) {
            Rocket log = new Rocket(userName);
            log.setVisible(true);

        } else if (e.getSource() == pb) {
            if(pb.isSelected()){ 

                jp2.setVisible(true);
            }
            else{
                jp2.setVisible(false);
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

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static void main(String[] args) {
        String userName = "mohsin";
        CartPanel2 cart = new CartPanel2(userName);
        
    }
}
