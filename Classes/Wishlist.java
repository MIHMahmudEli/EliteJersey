package Classes;
import Interfaces.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Wishlist extends JFrame implements MouseListener, ActionListener {

    private Container c;
    private JLabel l1, myacc,label1;
    private JButton dashboard, order, download, address, acountdetail, wishlist, logout, back;
    private Cursor cu1;
    private String userName;
    private Font f1;

    public Wishlist(String userName) {

        this.userName = userName;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setTitle("Wishlist");
        this.setResizable(false);
        intContainer();

    }

    public void intContainer() {

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(204, 255, 255));

        cu1 = new Cursor(Cursor.HAND_CURSOR);
        f1 = new Font("Dialog", Font.BOLD, 60);

        ImageIcon icon = new ImageIcon("/Elitejersey/IMAGES/logo.jpeg");
        this.setIconImage(icon.getImage());

        // labels

        myacc = new JLabel("My Account");
        myacc.setFont(new Font("Times New Roman", Font.BOLD, 25));
        myacc.setForeground(Color.BLACK);
        myacc.setBounds(130, 110, 150, 50);
        c.add(myacc);

        l1 = new JLabel("________________________________");
        l1.setForeground(Color.BLACK);
        l1.setBounds(125, 125, 300, 50);
        c.add(l1);

        label1 = new JLabel();
        label1.setText("Comming Soon...");
        label1.setForeground(Color.decode("#F4DA9C"));
        label1.setBounds(500, 10, 1000, 80); // Adjusted position
        label1.setFont(f1);
        c.add(label1);

        // Add JSeparator
        JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
        separator.setBounds(360, 40, 10, 600);
        separator.setBackground(Color.BLACK);
        c.add(separator);

        // buttons

        dashboard = new JButton("Dashboard");
        dashboard.setCursor(cu1);
        dashboard.setBorder(null);
        dashboard.setBounds(100, 160, 150, 60);
        dashboard.setBorderPainted(false);
        dashboard.setContentAreaFilled(false);
        dashboard.setForeground(Color.BLACK);
        dashboard.setFont(new Font("Serif", Font.BOLD, 20));
        c.add(dashboard);

        order = new JButton("Orders");
        order.setCursor(cu1);
        order.setBorder(null);
        order.setBounds(85, 200, 150, 60);
        order.setBorderPainted(false);
        order.setContentAreaFilled(false);
        order.setForeground(Color.BLACK);
        order.setFont(new Font("Serif", Font.BOLD, 20));
        c.add(order);

        download = new JButton("Cart");
        download.setCursor(cu1);
        download.setBorder(null);
        download.setBounds(75, 240, 150, 60);
        download.setBorderPainted(false);
        download.setContentAreaFilled(false);
        download.setForeground(Color.BLACK);
        download.setFont(new Font("Serif", Font.BOLD, 20));
        c.add(download);

        address = new JButton("Addresses");
        address.setCursor(cu1);
        address.setBorder(null);
        address.setBounds(97, 280, 150, 60);
        address.setBorderPainted(false);
        address.setContentAreaFilled(false);
        address.setForeground(Color.BLACK);
        address.setFont(new Font("Serif", Font.BOLD, 20));
        c.add(address);

        acountdetail = new JButton("Account details");
        acountdetail.setCursor(cu1);
        acountdetail.setBorder(null);
        acountdetail.setBounds(113, 320, 150, 60);
        acountdetail.setBorderPainted(false);
        acountdetail.setContentAreaFilled(false);
        acountdetail.setForeground(Color.BLACK);
        acountdetail.setFont(new Font("Serif", Font.BOLD, 20));
        c.add(acountdetail);

        wishlist = new JButton("Wishlist");
        wishlist.setCursor(cu1);
        wishlist.setBorder(null);
        wishlist.setBounds(87, 360, 150, 60);
        wishlist.setBorderPainted(false);
        wishlist.setContentAreaFilled(false);
        wishlist.setForeground(Color.BLACK);
        wishlist.setEnabled(false);
        wishlist.setFont(new Font("Serif", Font.BOLD, 20));
        c.add(wishlist);

        logout = new JButton("Logout");
        logout.setCursor(cu1);
        logout.setBorder(null);
        logout.setBounds(85, 400, 150, 60);
        logout.setBorderPainted(false);
        logout.setContentAreaFilled(false);
        logout.setForeground(Color.BLACK);
        logout.setFont(new Font("Serif", Font.BOLD, 20));
        c.add(logout);

        back = new JButton("HOME");
        back.setCursor(cu1);
        back.setBounds(85, 575, 160, 30);
        back.setBackground(new Color(223, 242, 218));
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Serif", Font.BOLD, 15));
        c.add(back);

        dashboard.addMouseListener(this);
        order.addMouseListener(this);
        download.addMouseListener(this);
        address.addMouseListener(this);
        acountdetail.addMouseListener(this);
        wishlist.addMouseListener(this);
        logout.addMouseListener(this);

        order.addActionListener(this);
        logout.addActionListener(this);
        acountdetail.addActionListener(this);
        download.addActionListener(this);
        address.addActionListener(this);
        wishlist.addActionListener(this);
        dashboard.addActionListener(this);
        back.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dashboard) {
            dispose();
            Dashboard frame = new Dashboard(userName);
            frame.setVisible(true);

        } else if (e.getSource() == order) {

            OrderPanel cart = new OrderPanel(userName);
            cart.setVisible(true);

        } else if (e.getSource() == download) {

            CartPanel cart = new CartPanel(userName);
            cart.setVisible(true);

        } else if (e.getSource() == address) {
            dispose();
            Addresses frame = new Addresses(userName);
            frame.setVisible(true);

        } else if (e.getSource() == acountdetail) {
            dispose();
            AccountDetails frame = new AccountDetails(userName);
            frame.setVisible(true);

        } else if (e.getSource() == wishlist) {

        } else if (e.getSource() == logout) {
            dispose();
            Home frame = new Home();
            frame.setVisible(true);
        } else if (e.getSource() == back) {
            dispose();
            HomePage frame = new HomePage(userName);
            frame.setVisible(true);
        }
    }

    @Override
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

        if (e.getSource() == dashboard) {
            dashboard.setForeground(Color.RED);
        }
        if (e.getSource() == order) {
            order.setForeground(Color.RED);
        }
        if (e.getSource() == download) {
            download.setForeground(Color.RED);
        }
        if (e.getSource() == address) {
            address.setForeground(Color.RED);
        }
        if (e.getSource() == acountdetail) {
            acountdetail.setForeground(Color.RED);
        }
        if (e.getSource() == wishlist) {
            wishlist.setForeground(Color.RED);
        }
        if (e.getSource() == logout) {
            logout.setForeground(Color.RED);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == dashboard) {
            dashboard.setForeground(Color.BLACK);
        }
        if (e.getSource() == order) {
            order.setForeground(Color.BLACK);
        }
        if (e.getSource() == download) {
            download.setForeground(Color.BLACK);
        }
        if (e.getSource() == address) {
            address.setForeground(Color.BLACK);
        }
        if (e.getSource() == acountdetail) {
            acountdetail.setForeground(Color.BLACK);
        }
        if (e.getSource() == wishlist) {
            wishlist.setForeground(Color.BLACK);
        }
        if (e.getSource() == logout) {
            logout.setForeground(Color.BLACK);
        }
    }

    public static void main(String[] args) {
        String userName = "mohsin";
        Wishlist frame = new Wishlist(userName);
        frame.setVisible(true);

    }

}
