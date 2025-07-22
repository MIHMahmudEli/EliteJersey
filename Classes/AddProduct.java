package Classes;
import Interfaces.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class AddProduct extends JFrame implements ActionListener{

    private Container container;
    private JTextField productTitleField, productPriceField;
    private JTextArea productDetailsField;
    private JComboBox categoryComboBox;
    private JButton chooseFileButton,addButton,closeButton;
    private JLabel selectedFileLabel;
    private String selectedImagePath;
    private ImageIcon icon;
    private File destinationPath;

    public AddProduct() {
        // Set frame properties
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Add Product");
        this.setSize(500, 600);
        this.setLocationRelativeTo(null);
        

        this.initContainer();

        // Display the frame
        
    }

    public void initContainer() {
        container = getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(204, 255, 255));


        icon = new ImageIcon("/Elitejersey/IMAGES/logo.jpeg");
        this.setIconImage(icon.getImage());


        // Add components to the container
        JLabel titleLabel = new JLabel("Product Title:");
        titleLabel.setBounds(10, 10, 100, 20);
        container.add(titleLabel);

        productTitleField = new JTextField();
        productTitleField.setBounds(120, 10, 150, 20);
        container.add(productTitleField);

        JLabel detailsLabel = new JLabel("Product Details:");
        detailsLabel.setBounds(10, 40, 100, 20);
        container.add(detailsLabel);

        productDetailsField = new JTextArea();
        productDetailsField.setBounds(120, 40, 150, 80);
        container.add(productDetailsField);

        JLabel priceLabel = new JLabel("Product Price:");
        priceLabel.setBounds(10, 130, 100, 20);
        container.add(priceLabel);

        productPriceField = new JTextField();
        productPriceField.setBounds(120, 130, 150, 20);
        container.add(productPriceField);

        JLabel categoryLabel = new JLabel("Select Category:");
        categoryLabel.setBounds(10, 160, 100, 20);
        container.add(categoryLabel);

        String[] categories = {"Please Select...","LALIGA", "Bundesliga", "Serie A","Premeir League", "International", "Other League"};
        categoryComboBox = new JComboBox(categories);
        categoryComboBox.setBounds(120, 160, 150, 20);
        container.add(categoryComboBox);

        // File chooser components
        chooseFileButton = new JButton("Choose Image");
        chooseFileButton.setBounds(10, 300, 150, 20);
        chooseFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseImage();
            }
        });
        container.add(chooseFileButton);

        selectedFileLabel = new JLabel("Selected Image: ");
        selectedFileLabel.setBounds(170, 190, 300, 240);
        container.add(selectedFileLabel);

        addButton=new JButton("ADD");
        addButton.setBounds(10, 430, 100, 30);
        container.add(addButton);

        closeButton=new JButton("Close");
        closeButton.setBounds(120, 430, 100, 30);
        container.add(closeButton);


        addButton.addActionListener(this);
        closeButton.addActionListener(this);


    }

    public void actionPerformed(ActionEvent e) {
        String productTitle = productTitleField.getText();
        String productDetails = productDetailsField.getText();
        String productPrice = productPriceField.getText();
        String category = categoryComboBox.getSelectedItem().toString();
        String ImagePath = selectedImagePath;
    
        boolean productTitleNotEmpty = !productTitle.isEmpty();
        boolean productDetailsNotEmpty = !productDetails.isEmpty();
        boolean productPriceNotEmpty = !productPrice.isEmpty();
        boolean categoryNotEmpty = !category.equals("Please Select...");
        boolean ImagePathNotEmpty = ImagePath != null && !ImagePath.isEmpty();
    
        if (e.getSource() == addButton) {
            if (productTitleNotEmpty && productDetailsNotEmpty && productPriceNotEmpty && categoryNotEmpty && ImagePathNotEmpty) {
    
                try {
                    Long.parseLong(productPrice); // Check if the productPrice is a valid number
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid  Price.", "Warning!", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                // Perform actions when all fields are not empty
                try (FileWriter fw = new FileWriter("/Elitejersey/Files/Product.txt", true)) {
                    fw.write(productTitle + "\t" + productDetails + "\t" + productPrice + "\t" + category + "\t" + destinationPath + "\n");
                    fw.close();
                    JOptionPane.showMessageDialog(this, "Added Completed");
                    clearFields();
    
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!", JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == closeButton) {
            this.dispose();
        }
    }
    

    private void clearFields() {
        // Reset text fields, text area, and selected file label
        productTitleField.setText("");
        productDetailsField.setText("");
        productPriceField.setText("");
        categoryComboBox.setSelectedIndex(0);
        selectedFileLabel.setText("Selected Image: ");
    
        // Reset selectedImagePath to null
        selectedImagePath = null;
    
        // Remove the displayed image icon
        selectedFileLabel.setIcon(null);
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
            selectedFileLabel.setIcon(resizedImageIcon);
            selectedFileLabel.setText(""); // Clear text
    
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


    private ImageIcon resizeImage(String imagePath, int width, int height) {
        ImageIcon originalImageIcon = new ImageIcon(imagePath);
        Image originalImage = originalImageIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
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
    

    
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AddProduct frame = new AddProduct();
            frame.setVisible(true);
        });
    }
}
