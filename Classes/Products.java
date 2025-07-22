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
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Products extends JFrame implements ActionListener {

    private Container c;
    private Cursor cursor;
    private JScrollPane scrollPane;
    private JPanel gridPanel,panel;
    private HomePage HomePage;
    private ImageIcon icon1,icon2;
    private String selectedImagePath;
    private String userName;
    private JButton backButton;
    private File destinationPath;

    private int count=0;

    private String[] productTitle = new String[100];
    private String[] productDetails = new String[100];
    private String[] productCategory = new String[100];
    private String[] classPrices = new String[100]; // Adjust the size based on the number of classes
    private String[] imagePaths = new String[100]; // Adjust the size based on the number of classes

    public Products(String userName) {

        this.userName=userName;



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setTitle("Admin Home");
        this.setResizable(false);

        // Initialize prices and image paths arrays and load existing values from the file
        loadFromFile();

        initContainer();
    }

    public void initContainer() {
        c = this.getContentPane();

        panel=new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(50, 30));
        c.add(panel,BorderLayout.SOUTH);

        icon1 = new ImageIcon("/Elitejersey/IMAGES/icon/backIcon.jpeg");
        backButton=new JButton(icon1);
        panel.add(backButton,BorderLayout.WEST);
 

        icon2 = new ImageIcon("/Elitejersey/IMAGES/logo.jpeg");
        this.setIconImage(icon2.getImage());

        for (int i = 0; i < classPrices.length; i++) {
            if (classPrices[i] != null && imagePaths[i] != null  && productTitle[i] != null  && productCategory[i]!=null)  {
                count++;
            }
        }

        
        if(count>=8){
        gridPanel = new JPanel(new GridLayout(0, 4, 5, 5));
        gridPanel.setBackground(new Color(204, 255, 255));
        cursor = new Cursor(Cursor.HAND_CURSOR);

        for (int i = 0; i < classPrices.length; i++) {
            if (classPrices[i] != null && imagePaths[i] != null  && productTitle[i] != null  && productCategory[i]!=null)  {
                gridPanel.add(createPanel(imagePaths[i], classPrices[i], productTitle[i], productCategory[i], i));
            }
        }

        scrollPane = new JScrollPane(gridPanel);
        c.add(scrollPane,BorderLayout.CENTER);
    }else{
        gridPanel = new JPanel();
        gridPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        gridPanel.setPreferredSize(new Dimension(800, 500)); // Adjust the size as needed
        gridPanel.setBackground(new Color(204, 255, 255));

        cursor = new Cursor(Cursor.HAND_CURSOR);

        for (int i = 0; i < classPrices.length; i++) {
            if (classPrices[i] != null && imagePaths[i] != null  && productTitle[i] != null  && productCategory[i]!=null)  {
                gridPanel.add(createPanel(imagePaths[i], classPrices[i], productTitle[i], productCategory[i], i));
            }
        }

        scrollPane = new JScrollPane(gridPanel);
        c.add(scrollPane,BorderLayout.CENTER);
    }


        backButton.addActionListener(this);
    }

    private JPanel createPanel(String imagePath, String price, String title, String Category, int classIndex) {
        JPanel newPanel = new JPanel(new BorderLayout());
        newPanel.setPreferredSize(new Dimension(220, 350));

        JPanel panel0 = new JPanel(new BorderLayout());
        panel0.setPreferredSize(new Dimension(50, 50));

        JPanel panel00 = new JPanel(new BorderLayout());
        panel00.setPreferredSize(new Dimension(50, 50));

        
        JPanel panel000 = new JPanel(new BorderLayout());
        panel000.setPreferredSize(new Dimension(50, 50));

        JPanel panel0000 = new JPanel(new BorderLayout());
        panel0000.setPreferredSize(new Dimension(50, 50));


        JLabel priceLabel = new JLabel("Price: " + price + " TK");
        priceLabel.setHorizontalAlignment(JLabel.CENTER);

        
        JLabel titleLabel = new JLabel("Title: " + title);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        JLabel CategoryLabel = new JLabel("Category: " + Category);
        CategoryLabel.setHorizontalAlignment(JLabel.CENTER);

        ImageIcon buttonIcon = resizeImage(imagePath, 315, 200);

        JButton newButton = new JButton(buttonIcon);
        newButton.setCursor(cursor);

        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setPreferredSize(new Dimension(50, 20));

        JTextField textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.CENTER);
        panel1.add(textField, BorderLayout.CENTER);

        JButton updateButton = new JButton("Update Price");
        updateButton.setCursor(cursor);
        panel1.add(updateButton, BorderLayout.WEST);

        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setPreferredSize(new Dimension(50, 20));

        JTextField textField2 = new JTextField();
        textField2.setHorizontalAlignment(JTextField.CENTER);
        panel2.add(textField2, BorderLayout.CENTER);

        JButton updateButton2 = new JButton("Update Titel");
        updateButton2.setCursor(cursor);
        panel2.add(updateButton2, BorderLayout.WEST);

        JPanel panel3 = new JPanel(new BorderLayout());
        panel3.setPreferredSize(new Dimension(50, 20));

        String[] categories = {"LALIGA", "Bundesliga", "Serie A", "Premeir League", "International", "Other League"};
        JComboBox categoryComboBox = new JComboBox(categories);
        panel3.add(categoryComboBox, BorderLayout.CENTER);

        JButton updateButton3 = new JButton("Update Categories");
        updateButton3.setCursor(cursor);
        panel3.add(updateButton3, BorderLayout.WEST);


        JPanel panel4 = new JPanel(new BorderLayout());
        panel4.setPreferredSize(new Dimension(50, 20));



        JButton updateButton4 = new JButton("Update Image");
        updateButton4.setCursor(cursor);
        panel4.add(updateButton4, BorderLayout.CENTER);

        JButton updateButton5 = new JButton("Delete");
        updateButton5.setCursor(cursor);
        panel4.add(updateButton5, BorderLayout.WEST);

       




       
       


        
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String priceString=textField.getText();
                boolean priceStringEmpty=priceString.isEmpty();


                if(priceStringEmpty){
                    JOptionPane.showMessageDialog(null, "Please Enter the Price", "Warning!", JOptionPane.WARNING_MESSAGE);
                }
                else{
                    try {
                        Long.parseLong(priceString); // Check if the productPrice is a valid number
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid  Price.", "Warning!", JOptionPane.WARNING_MESSAGE);
                        return;
                    }


                try {
                    String enteredPrice = textField.getText();
                    priceLabel.setText("Price: " + enteredPrice + " TK");

                    classPrices[classIndex] = enteredPrice;

                    saveToFile();

                    JOptionPane.showMessageDialog(null, "Price Update Completed");

                } catch (Exception ex) {
                    System.out.print(ex);
                }
            }
            }
        });
        

        updateButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                String titleString=textField2.getText();
                boolean titleStringEmpty=titleString.isEmpty();


                if(titleStringEmpty){
                    JOptionPane.showMessageDialog(null, "Please Enter the title", "Warning!", JOptionPane.WARNING_MESSAGE);
                }
                else{
                try {
                    String enteredtitle = textField2.getText();
                    titleLabel.setText("Title: " + enteredtitle);
                  

                    productTitle[classIndex] = enteredtitle;

                    saveToFile();

                    JOptionPane.showMessageDialog(null, "Title Update Completed");

                } catch (Exception ex) {
                    System.out.print(ex);
                }
            }
            }
        });

        updateButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                  String enteredCategory =categoryComboBox.getSelectedItem().toString();
                  CategoryLabel.setText("Category: " + enteredCategory);
        
                    productCategory[classIndex] = enteredCategory; // Add this line to update the 'Category' variable
        
                    saveToFile();
        
                    JOptionPane.showMessageDialog(null, "Category Update Completed");
        
                } catch (Exception ex) {
                    System.out.print(ex);
                }
            }
        });

        updateButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    chooseImage();
                    String enteredImage = selectedImagePath;  // Use the class-level variable
                    buttonIcon.setImage(resizeImage(enteredImage, 315, 200).getImage());
                    
                    String enteredSubmitImage = destinationPath.getPath();  // Use the class-level variable
                    imagePaths[classIndex] = enteredSubmitImage;

        
                    saveToFile();
        
                    JOptionPane.showMessageDialog(null, "Image Update Completed");
                    dispose();
                    Products frame = new Products(userName);
                    frame.setVisible(true);

        
                } catch (Exception ex) {
                    System.out.print(ex);
                }
            }
        });

        updateButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Delete product information
                    productTitle[classIndex] = null;
                    productDetails[classIndex] = null;
                    classPrices[classIndex] = null;
                    productCategory[classIndex] = null;
                    imagePaths[classIndex] = null;
        
                    // Update the file
                    saveToFile();
        
                    // Refresh the UI
                    dispose();
                    Products frame = new Products(userName);
                    frame.setVisible(true);
        
                    JOptionPane.showMessageDialog(null, "Product Deleted");
        
                } catch (Exception ex) {
                    System.out.print(ex);
                }
            }
        });
        
        
        


        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    HomePage f1 = new HomePage(userName);
                    f1.setVisible(true);

                } catch (Exception ex) {
                    System.out.print(ex);
                }
            }
        });

        panel000.add(titleLabel, BorderLayout.NORTH);
        panel000.add(priceLabel, BorderLayout.CENTER);
        panel000.add(panel1 , BorderLayout.SOUTH);


        //panel00.add(updateButton5, BorderLayout.NORTH);
        panel00.add( panel3 , BorderLayout.CENTER);
        panel00.add(panel4, BorderLayout.SOUTH); 

        panel0.add(CategoryLabel, BorderLayout.NORTH);
        panel0.add(panel000, BorderLayout.CENTER);
        panel0.add(panel2, BorderLayout.SOUTH); 

        newPanel.add(newButton, BorderLayout.NORTH);
        newPanel.add(panel0, BorderLayout.CENTER);
        newPanel.add(panel00, BorderLayout.SOUTH);



        return newPanel;
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==backButton){
            dispose();
            AdminHome1 frame = new AdminHome1(userName);
            frame.setVisible(true);
        }
    }

    private ImageIcon resizeImage(String imagePath, int width, int height) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(imagePath));
            if (originalImage != null) {
                Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                return new ImageIcon(resizedImage);
            } else {
                System.err.println("Failed to read the image from file: " + imagePath);
                // Return a default image or handle the error appropriately
                return getDefaultImageIcon();
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Return a default image or handle the error appropriately
            return getDefaultImageIcon();
        }
    }
    
    private ImageIcon getDefaultImageIcon() {
        // Provide a default image or handle the error as needed
        return new ImageIcon(); // You can replace this with your default image icon
    }
    
    

    private void chooseImage() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "png", "jpg", "jpeg"));

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            selectedImagePath = selectedFile.getAbsolutePath();
    
            // Resize and display the selected image
            ImageIcon resizedImageIcon = resizeImage(selectedImagePath, 315, 200);
            //selectedFileLabel.setIcon(resizedImageIcon);
            //selectedFileLabel.setText(""); // Clear text
    
            // Specify the destination folder
            String destinationFolder = "/Elitejersey/IMAGES/gersey/";
    
            // Create a File object for the destination path
             destinationPath = new File(destinationFolder + selectedFile.getName());
    
            // Copy the selected image to the destination folder if it doesn't exist
            try {
                copyFile(selectedFile, destinationPath);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error copying the image to the destination folder.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void copyFile(File source, File destination) throws IOException {
        // Check if the destination file already exists
        if (!destination.exists()) {
            try (InputStream in = new FileInputStream(source);
                 OutputStream out = new FileOutputStream(destination)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
            }
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
                    productDetails[index]= parts[1];
                    classPrices[index] = parts[2];
                    productCategory[index]= parts[3];
                    imagePaths[index] = parts[4];
                    index++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("/Elitejersey/Files/Product.txt"))) {
            for (int i = 0; i < classPrices.length; i++) {
                if (classPrices[i] != null && imagePaths[i] != null  && productTitle[i] != null  && productCategory[i]!=null) {
                    bw.write( productTitle[i] + "\t" + productDetails[i] + "\t" + classPrices[i] + "\t" + productCategory[i] + "\t" + imagePaths[i]);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String userName="admin" ;
        Products frame = new Products(userName);
        frame.setVisible(true);
    }
}
