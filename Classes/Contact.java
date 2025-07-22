package Classes;
import Interfaces.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


 class Contact extends JFrame implements ActionListener{
    private Container c;
    private JLabel j1,j2,j3,j4,j5,j6,j7,j8,j9;
    private Font f1,f2;
    private JTextField t1,t2,t3;
    private JTextArea a1;
    private JButton b1,b2;
    private ImageIcon icon,icon2;
    private JScrollPane JScrollPane;
 


   public Contact(){
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setSize(1280, 720);
       this.setLocationRelativeTo(null);
       this.setTitle("Contact us");
       this.setResizable(false);


        intiContainer();
    }
    public void intiContainer(){
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(204, 255, 255));

        icon2= new ImageIcon("/Elitejersey/IMAGES/logo.jpeg");
        this.setIconImage(icon2.getImage());

   


        f1=new Font ("Neue Haas Grotesk Text Pro",Font.BOLD,75);
        j1=new JLabel("Have Some Question?");
        j1.setFont(f1);
        j1.setBounds(230,100,800,70);
        j1.setForeground(Color.BLACK);
        c.add(j1);
        
        f2=new Font ("Times New Roman",Font.PLAIN,25);
        j2=new JLabel("+880183354116");
        j2.setFont(f2);
        j2.setBounds(250,280 ,250 ,70);
        j2.setForeground(Color.black);
        c.add(j2);

        f2=new Font ("Times New Roman",Font.PLAIN,25);
        j3=new JLabel("10am to 8pm");
        j3.setFont(f2);
        j3.setBounds(250,310 ,250 ,70);
        j3.setForeground(Color.black);
        c.add(j3);
        
        f2=new Font ("Times New Roman",Font.PLAIN,25);
        j4=new JLabel("Bashundhara City");
        j4.setFont(f2);
        j4.setBounds(250,340 ,250 ,70);
        j4.setForeground(Color.black);
        c.add(j4);

        f2=new Font ("Times New Roman",Font.PLAIN,25);
        j5=new JLabel("23-A");
        j5.setFont(f2);
        j5.setBounds(250,370 ,250 ,70);
        j5.setForeground(Color.BLACK);
        c.add(j5);

        f2=new Font ("Times New Roman",Font.PLAIN,20);
        j6=new JLabel("Username:");
        j6.setFont(f2);
        j6.setBounds(750,180,500 ,70);
        j6.setForeground(Color.black);
        c.add(j6);

        f2=new Font ("Times New Roman",Font.PLAIN,20);
        j7=new JLabel("Phone Number:");
        j7.setFont(f2);
        j7.setBounds(750,250,500,70);
        j7.setForeground(Color.black);
        c.add(j7);

        f2=new Font ("Times New Roman",Font.PLAIN,20);
        j8=new JLabel("Email:");
        j8.setFont(f2);
        j8.setBounds(750,310,500,70);
        j8.setForeground(Color.black);
        c.add(j8);

        f2=new Font ("Times New Roman",Font.PLAIN,20);
        j9=new JLabel("Message:");
        j9.setFont(f2);
        j9.setBounds(750,400,500,70);
        j9.setForeground(Color.black);
        c.add(j9);

        t1=new JTextField();
        t1.setFont(f2);
        t1.setForeground(Color.BLACK);
        t1.setBackground(Color.WHITE);
        t1.setBounds(750,230,300,30);
        c.add(t1);

        t2=new JTextField();
        t2.setFont(f2);
        t2.setForeground(Color.BLACK);
        t2.setBackground(Color.WHITE);
        t2.setBounds(750,300,300,30);
        c.add(t2);

        t3=new JTextField();
        t3.setFont(f2);
        t3.setForeground(Color.BLACK);
        t3.setBackground(Color.WHITE);
        t3.setBounds(750,370,300,30);
        c.add(t3);
   

       
        a1=new JTextArea();
        a1.setFont(f2);
        a1.setForeground(Color.BLACK);
        a1.setBackground(Color.WHITE);
        a1.setBounds(750,450,300,60);
        a1.setLineWrap(true); // Enable line wrapping
        a1.setWrapStyleWord(true); // Wrap at word boundaries
        c.add(a1);

        JScrollPane=new JScrollPane(a1);
        JScrollPane.setBounds(750, 450, 300, 60);
        c.add(JScrollPane);


   
        b1=new JButton("Send message");
        b1.setFont(f2);
        b1.setForeground(Color.BLACK);
        b1.setBackground(new Color(98,184,34));
        b1.setBounds(770,560,260,40);
        c.add(b1);


        

        b2=new JButton("Back");
        b2.setFont(f2);
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.gray);
        b2.setBounds(150,560,80,30);
        c.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this); 
      


    }

    public void actionPerformed(ActionEvent e) {
        String username = t1.getText();
        String phone = t2.getText();
        String email = t3.getText();
        String message = a1.getText();
        boolean userEmpty = username.isEmpty();
        boolean phoneEmpty = phone.isEmpty();
        boolean emailEmpty = email.isEmpty();
        boolean messageEmpty = message.isEmpty();

        if (e.getSource() == b1) {
            if (userEmpty || phoneEmpty || emailEmpty || messageEmpty) {
                JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!", JOptionPane.WARNING_MESSAGE);
            } else {

                try {
                    Long.parseLong(phone); // Check if the phone is a valid number
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid phone number.", "Warning!", JOptionPane.WARNING_MESSAGE);
                    return;
                }
    
                if (phone.length() != 11) {
                    JOptionPane.showMessageDialog(null, "Please enter a correct phone number.", "Warning!", JOptionPane.WARNING_MESSAGE);
                } else if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid email address.", "Warning!", JOptionPane.WARNING_MESSAGE);
                } else if (isUsernameExists(username)) {
                    try (FileWriter fw = new FileWriter("/Elitejersey/Files/messageBox.txt", true)) {
                        LocalDateTime currentTime = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
                        String formattedTime = currentTime.format(formatter);

                        fw.write(username + "\t" + phone + "\t" + email + "\t" + message + "\t" + formattedTime + "\n");
                        fw.close();

                        icon = new ImageIcon("/Elitejersey/IMAGES/verified.PNG");
                        JOptionPane.showMessageDialog(null, "Your message has been successfully sent.", "Success!", JOptionPane.INFORMATION_MESSAGE, icon);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "              Username does not exist." + "\n" + "Check your user name or create accounts.", "Warning!", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else if (e.getSource() == b2) {
            Home ac = new Home();
            dispose();
            ac.setVisible(true);
        }
    }

    private boolean isUsernameExists(String username) {
        boolean matched = false;
        try {
            FileReader fr = new FileReader("/Elitejersey/Files/login.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 5 && parts[0].equals(username)) {
                    matched = true;
                    break;
                }
            }
            fr.close();
        } catch (Exception exp) {
            exp.printStackTrace();
            JOptionPane.showMessageDialog(null, "Exception" + exp);
        }
        return matched;
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }



    public static void main(String[] args) {
        Contact frame = new Contact();
        frame.setVisible(true);

    
    }
}