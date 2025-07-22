package Classes;
import Interfaces.*;
import Interfaces.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class HomePage extends JFrame implements ActionListener, MouseListener {
    private Container c;
    private JPanel panel1, panel2, panel3, panel4, panel5, panel6,panel7,panel8;
    private JScrollPane scrollPane;
    private JButton button1, button2, button3, button4, button5, button6, button7,button8,button9;
    private JLabel imgLabel;
    private ImageIcon icon, icon2, icon3;
    private Cursor cursor;
    private int currentImageIndex = 0;
    private String[] slideshowImages = {
            "/Elitejersey/slideShowImage/img1.png",
            "/Elitejersey/slideShowImage/img2.jpg",
            "/Elitejersey/slideShowImage/img3.jpeg",
            "/Elitejersey/slideShowImage/img4.jpg",
            "/Elitejersey/slideShowImage/img5.jpg"
            // Add more image paths as needed
    };

    private Timer slideshowTimer;
    private String[] classPrices = new String[100]; 
    private String[] imagePaths = new String[100];
    private String[] productTitle = new String[100];
    private String userName;
    
    

    public HomePage(String userName) {
        this.userName=userName;


        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setTitle("Home Page");


        loadFromFile();
        initContainer();
        

        int slideshowDelay = 1000; // Delay in milliseconds (adjust as needed)
        slideshowTimer = new Timer(slideshowDelay, this);
        slideshowTimer.start();
    }

    public void initContainer() {
        c = this.getContentPane();
        c.setLayout(new BorderLayout(0, 0));

        cursor = new Cursor(Cursor.HAND_CURSOR);

        icon = new ImageIcon(slideshowImages[0]);
        icon2 = new ImageIcon("/Elitejersey/IMAGES/logo.jpeg");
        this.setIconImage(icon2.getImage());

        icon3 = new ImageIcon("/Elitejersey/IMAGES/in Exit.png");

        panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(50, 360));
        panel1.setBackground(Color.red);

        panel2 = new JPanel(new GridLayout(0, 4, 5, 5));
        panel2.setBackground(new Color(204, 255, 255));

        panel1.setLayout(new BorderLayout());

        panel3 = new JPanel();
        panel3.setBackground(new Color(204, 255, 255));
        panel3.setPreferredSize(new Dimension(50, 30));
        panel1.add(panel3, BorderLayout.NORTH);

        panel4 = new JPanel();
        panel4.setBackground(new Color(204, 255, 255));
        panel4.setPreferredSize(new Dimension(50, 20));
        panel1.add(panel4, BorderLayout.CENTER);

        scrollPane = new JScrollPane(panel2);
        c.add(scrollPane, BorderLayout.CENTER);

        c.add(panel1, BorderLayout.NORTH);

        panel3.setLayout(new BorderLayout());

        panel5 = new JPanel(new FlowLayout());
        panel5.setBackground(new Color(204, 255, 255));
        panel5.setPreferredSize(new Dimension(50, 30));
        panel3.add(panel5, BorderLayout.CENTER);

        panel6 = new JPanel(new FlowLayout());
        panel6.setBackground(new Color(204, 255, 255));
        panel6.setPreferredSize(new Dimension(100, 30));
        panel3.add(panel6, BorderLayout.WEST);

        panel7 = new JPanel(new FlowLayout());
        panel7.setBackground(new Color(204, 255, 255));
        panel7.setPreferredSize(new Dimension(180, 30));
        panel3.add(panel7, BorderLayout.EAST);

        panel8 = new JPanel(new FlowLayout());
        panel8.setBackground(Color.BLACK);
        panel8.setPreferredSize(new Dimension(180, 100));
        

        button1 = new JButton("Premeir League");
        button1.setBorderPainted(false);
        button1.setContentAreaFilled(false);
        button1.setBackground(new Color(204, 255, 255));
        button1.setCursor(cursor);
        panel5.add(button1);

        button2 = new JButton("LALIGA");
        button2.setBorderPainted(false);
        button2.setContentAreaFilled(false);
        button2.setBackground(new Color(204, 255, 255));
        button2.setCursor(cursor);
        panel5.add(button2);

        button3 = new JButton("Bundesliga");
        button3.setBorderPainted(false);
        button3.setContentAreaFilled(false);
        button3.setBackground(new Color(204, 255, 255));
        button3.setCursor(cursor);
        panel5.add(button3);

        button4 = new JButton("Serie A");
        button4.setBorderPainted(false);
        button4.setContentAreaFilled(false);
        button4.setBackground(new Color(204, 255, 255));
        button4.setCursor(cursor);
        panel5.add(button4);

        button5 = new JButton("Other Leagues");
        button5.setBorderPainted(false);
        button5.setContentAreaFilled(false);
        button5.setBackground(new Color(204, 255, 255));
        button5.setCursor(cursor);
        panel5.add(button5);

        button6 = new JButton("International");
        button6.setBorderPainted(false);
        button6.setContentAreaFilled(false);
        button6.setBackground(new Color(204, 255, 255));
        button6.setCursor(cursor);
        panel5.add(button6);

        button7 = new JButton(icon3);
        button7.setBorderPainted(false);
        button7.setContentAreaFilled(false);
        button7.setBackground(new Color(204, 255, 255));
        button7.setCursor(cursor);
        button7.setToolTipText("previous page");
        button7.setToolTipText("Exit");
        panel6.add(button7);

        button8 = new JButton("Welcome, "+ userName);
        button8.setBorderPainted(false);
        button8.setContentAreaFilled(false);
        button8.setBackground(new Color(204, 255, 255));
        button8.setCursor(cursor);
        button8.setToolTipText("previous page");
        button8.setToolTipText("profile");
        panel7.add(button8);

        

        /*button9 = new JButton("Orders");
        button9.setBorderPainted(false);
        button9.setContentAreaFilled(false);
        button9.setBackground(new Color(204, 255, 255));
        button9.setCursor(cursor);
        button9.setToolTipText("previous page");
        button9.setToolTipText("profile");
        panel7.add(button9);*/

        imgLabel = new JLabel(icon);
        panel4.add(imgLabel);

        for (int i = 0; i < imagePaths.length; i++) {
            if (productTitle[i] != null && imagePaths[i] != null && classPrices[i] != null) {
                panel2.add(createPanel(productTitle[i], imagePaths[i],classPrices[i]));
            }
        }

        


        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        
        button1.addMouseListener(this);
        button2.addMouseListener(this);
        button3.addMouseListener(this);
        button4.addMouseListener(this);
        button5.addMouseListener(this);
        button6.addMouseListener(this);
        button8.addMouseListener(this);
       

        

    }
    private JPanel createPanel(String productTitle, String imagePath, String classPrices) {
        JPanel newPanel = new JPanel(new BorderLayout());
        newPanel.setPreferredSize(new Dimension(200, 250));
    
        JLabel name = new JLabel(productTitle);
        name.setHorizontalAlignment(SwingConstants.CENTER);
    
        JLabel price = new JLabel("Price: " + classPrices + " TK");
        price.setHorizontalAlignment(SwingConstants.CENTER);
    
        JButton newButton = new JButton();
        newButton.setCursor(cursor);
    
        ImageIcon buttonIcon = resizeImage(imagePath, 315, 200);  // Adjust width and height as needed
        newButton.setIcon(buttonIcon);
    
        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LeaguePanel targetPanel = (LeaguePanel) new ProductClass(productTitle, imagePath, classPrices,userName);
                targetPanel.showPanel(productTitle, imagePath, classPrices);
                dispose();
            }
        });
    
        newPanel.add(newButton, BorderLayout.NORTH);
        newPanel.add(price, BorderLayout.CENTER);
        newPanel.add(name, BorderLayout.SOUTH);
    
        return newPanel;
    }
    

    private void updateSlideshowImage() {
        if (currentImageIndex < slideshowImages.length) {
            String imagePath = slideshowImages[currentImageIndex];
            icon = new ImageIcon(imagePath);
            imgLabel.setIcon(icon);
            
            currentImageIndex++;
        } else {
            // Restart the slideshow
            currentImageIndex = 0;
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

    private void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("/Elitejersey/Files/Product.txt"))) {
            String line;
            int index = 0;
            while ((line = br.readLine()) != null && index < imagePaths.length) {
                String[] parts = line.split("\t");
                if (parts.length == 5) {
                    classPrices[index] = parts[2];
                    productTitle[index] = parts[0]; // Assuming product title is at index 0
                    imagePaths[index] = parts[4];   // Assuming image path is at index 4
                    index++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == slideshowTimer) {
            updateSlideshowImage();
        } else if (e.getSource() == button1) {
            PremeirLeague frame = new PremeirLeague(userName);
            frame.setVisible(true);
            dispose();
        } else if (e.getSource() == button2) {
            LALIGA frame = new LALIGA(userName);
            frame.setVisible(true);
            dispose();
        }

        else if (e.getSource() == button3) {
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
        }else if (e.getSource() == button6) {
            International frame = new International(userName);
            frame.setVisible(true);
            dispose();
        }

        else if (e.getSource() == button7) {
            Home frame = new Home();
            frame.setVisible(true);
            dispose();
        }

        else if (e.getSource() == button8) {
            dispose();
            Dashboard frame = new Dashboard(userName);
            frame.setVisible(true);
            
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
        } else if (e.getSource() == button2) {
            button2.setForeground(Color.RED);
        } else if (e.getSource() == button3) {
            button3.setForeground(Color.RED);
        } else if (e.getSource() == button4) {
            button4.setForeground(Color.RED);
        } else if (e.getSource() == button5) {
            button5.setForeground(Color.RED);
        } else if (e.getSource() == button6) {
            button6.setForeground(Color.RED);
        }
        else if (e.getSource() == button8) {
            button8.setForeground(Color.BLUE);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == button1 || e.getSource() == button2 || e.getSource() == button3 || e.getSource() == button4
                || e.getSource() == button5  || e.getSource() == button6|| e.getSource() == button8) {
            button1.setForeground(Color.black);
            button2.setForeground(Color.black);
            button3.setForeground(Color.black);
            button4.setForeground(Color.black);
            button5.setForeground(Color.black);
            button6.setForeground(Color.black);
            button8.setForeground(Color.black);


        }
    }


    public static void main(String[] args) {

        String userName="mohsin";
        HomePage frame = new HomePage(userName);
        frame.setVisible(true);
    }
}
