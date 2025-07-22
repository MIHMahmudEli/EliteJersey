package Classes;
import Interfaces.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Dashboard extends JFrame implements MouseListener, ActionListener {

    private Container c;
    private JLabel l1, myacc, l2, l3, label1;
    private JButton dashboard, order, download, address, acountdetail, wishlist, back, logout, dashboard1, order1,
            download1, address1, acountdetail1, wishlist1, logout1;
    private Cursor cu1;
    private String userName;
    private JPanel panel;
    private Font f1;

    public Dashboard(String userName) {

        this.userName = userName;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setTitle("Dashboard");
        this.setResizable(false);
        intContainer();

    }

    public void intContainer() {

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(204, 255, 255));

        cu1 = new Cursor(Cursor.HAND_CURSOR);
        f1 = new Font("ARIAL", Font.BOLD, 15);

        ImageIcon icon = new ImageIcon("/Elitejersey/IMAGES/logo.jpeg");
        this.setIconImage(icon.getImage());

        // labels

        myacc = new JLabel("My Account");
        myacc.setFont(new Font("Times New Roman", Font.BOLD, 25));
        myacc.setForeground(Color.BLACK);
        myacc.setBounds(130, 110, 150, 50);
        c.add(myacc);

        l2 = new JLabel(
                "<html>From your account dashboard you can view your recent orders, manage your shipping and billing addresses, and edit <br> your password and account details.</html>");
        l2.setFont(new Font("Times New Roman", Font.BOLD, 15));
        l2.setForeground(Color.BLACK);
        l2.setBounds(400, 110, 800, 50);
        c.add(l2);

        myacc = new JLabel("Hello " + userName);
        myacc.setFont(new Font("Times New Roman", Font.BOLD, 25));
        myacc.setForeground(Color.BLACK);
        myacc.setBounds(400, 50, 150, 50);
        c.add(myacc);

        // Add JSeparator
        JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
        separator.setBounds(360, 40, 10, 600);
        separator.setBackground(Color.BLACK);
        c.add(separator);

        JSeparator separator1 = new JSeparator(SwingConstants.HORIZONTAL);
        separator1.setBounds(125, 160, 200, 15);
        separator1.setBackground(Color.BLACK);
        c.add(separator1);

        // panels
        panel = new JPanel(new FlowLayout());
        panel.setBounds(400, 250, 820, 350);
        panel.setBackground(new Color(204, 255, 255));
        c.add(panel);

        // imageicon
        ImageIcon img1 = new ImageIcon("/Elitejersey/IMAGES/icon/order.jpeg");
        ImageIcon img2 = new ImageIcon("/Elitejersey/IMAGES/icon/cart.jpeg");
        ImageIcon img3 = new ImageIcon("/Elitejersey/IMAGES/icon/address.jpeg");
        ImageIcon img4 = new ImageIcon("/Elitejersey/IMAGES/icon/ad.jpeg");
        ImageIcon img5 = new ImageIcon("/Elitejersey/IMAGES/icon/wishlist.png");
        ImageIcon img6 = new ImageIcon("/Elitejersey/IMAGES/icon/logout.jpeg");

        // buttons

        dashboard = new JButton("Dashboard");
        dashboard.setCursor(cu1);
        dashboard.setBorder(null);
        dashboard.setBounds(100, 160, 150, 60);
        dashboard.setBorderPainted(false);
        dashboard.setContentAreaFilled(false);
        dashboard.setForeground(Color.BLACK);
        dashboard.setEnabled(false);
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

        order1 = new JButton(img1);
        order1.setLayout(new BorderLayout());
        order1.setCursor(cu1);
        order1.setForeground(Color.BLACK);
        order1.setBackground(Color.CYAN);
        order1.setPreferredSize(new Dimension(250, 150));
        order1.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(order1);

        download1 = new JButton(img2);
        download1.setLayout(new BorderLayout());
        download1.setCursor(cu1);
        download1.setForeground(Color.BLACK);
        download1.setBackground(Color.CYAN);
        download1.setPreferredSize(new Dimension(250, 150));
        download1.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(download1);

        address1 = new JButton(img3);
        address1.setLayout(new BorderLayout());
        address1.setCursor(cu1);
        address1.setForeground(Color.BLACK);
        address1.setBackground(Color.CYAN);
        address1.setPreferredSize(new Dimension(250, 150));
        address1.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(address1);

        acountdetail1 = new JButton(img4);
        acountdetail1.setLayout(new BorderLayout());
        acountdetail1.setCursor(cu1);
        acountdetail1.setForeground(Color.BLACK);
        acountdetail1.setBackground(Color.CYAN);
        acountdetail1.setPreferredSize(new Dimension(250, 150));
        acountdetail1.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(acountdetail1);

        wishlist1 = new JButton(img5);
        wishlist1.setLayout(new BorderLayout());
        wishlist1.setCursor(cu1);
        wishlist1.setForeground(Color.BLACK);
        wishlist1.setBackground(Color.CYAN);
        wishlist1.setPreferredSize(new Dimension(250, 150));
        wishlist1.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(wishlist1);

        logout1 = new JButton(img6);
        logout1.setLayout(new BorderLayout());
        logout1.setCursor(cu1);
        logout1.setForeground(Color.BLACK);
        logout1.setBackground(Color.CYAN);
        logout1.setPreferredSize(new Dimension(250, 150));
        logout1.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(logout1);

        // lavels

        label1 = new JLabel("Orders");
        label1.setSize(200, 200);
        label1.setLocation(300, 400);
        order1.add(label1, BorderLayout.SOUTH);
        label1.setFont(f1);
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        label1 = new JLabel("Cart");
        label1.setSize(200, 200);
        label1.setLocation(300, 400);
        download1.add(label1, BorderLayout.SOUTH);
        label1.setFont(f1);
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        label1 = new JLabel("Addresses");
        label1.setSize(200, 200);
        label1.setLocation(300, 400);
        address1.add(label1, BorderLayout.SOUTH);
        label1.setFont(f1);
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        label1 = new JLabel("Account Details");
        label1.setSize(200, 200);
        label1.setLocation(300, 400);
        acountdetail1.add(label1, BorderLayout.SOUTH);
        label1.setFont(f1);
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        label1 = new JLabel("Wishlist");
        label1.setSize(200, 200);
        label1.setLocation(300, 400);
        wishlist1.add(label1, BorderLayout.SOUTH);
        label1.setFont(f1);
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        label1 = new JLabel("Logout");
        label1.setSize(200, 200);
        label1.setLocation(300, 400);
        logout1.add(label1, BorderLayout.SOUTH);
        label1.setFont(f1);
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        dashboard.addMouseListener(this);
        order.addMouseListener(this);
        download.addMouseListener(this);
        address.addMouseListener(this);
        acountdetail.addMouseListener(this);
        wishlist.addMouseListener(this);
        logout.addMouseListener(this);

        order1.addMouseListener(this);
        download1.addMouseListener(this);
        address1.addMouseListener(this);
        acountdetail1.addMouseListener(this);
        wishlist1.addMouseListener(this);
        logout1.addMouseListener(this);

        order.addActionListener(this);
        logout.addActionListener(this);
        acountdetail.addActionListener(this);
        download.addActionListener(this);
        address.addActionListener(this);
        wishlist.addActionListener(this);
        back.addActionListener(this);

        order1.addActionListener(this);
        logout1.addActionListener(this);
        acountdetail1.addActionListener(this);
        download1.addActionListener(this);
        address1.addActionListener(this);
        wishlist1.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dashboard) {

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
            dispose();
            Wishlist frame = new Wishlist(userName);
            frame.setVisible(true);

        } else if (e.getSource() == logout) {
            dispose();
            Home frame = new Home();
            frame.setVisible(true);
        }

        else if (e.getSource() == order1) {
            OrderPanel cart = new OrderPanel(userName);
            cart.setVisible(true);

        } else if (e.getSource() == download1) {

            CartPanel cart = new CartPanel(userName);
            cart.setVisible(true);

        } else if (e.getSource() == address1) {
            dispose();
            Addresses frame = new Addresses(userName);
            frame.setVisible(true);

        } else if (e.getSource() == acountdetail1) {
            dispose();
            AccountDetails frame = new AccountDetails(userName);
            frame.setVisible(true);

        } else if (e.getSource() == wishlist1) {
            dispose();
            Wishlist frame = new Wishlist(userName);
            frame.setVisible(true);

        } else if (e.getSource() == logout1) {
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
        } else if (e.getSource() == order) {
            order.setForeground(Color.RED);
        } else if (e.getSource() == download) {
            download.setForeground(Color.RED);
        } else if (e.getSource() == address) {
            address.setForeground(Color.RED);
        } else if (e.getSource() == acountdetail) {
            acountdetail.setForeground(Color.RED);
        } else if (e.getSource() == wishlist) {
            wishlist.setForeground(Color.RED);
        } else if (e.getSource() == logout) {
            logout.setForeground(Color.RED);
        } else if (e.getSource() == dashboard1) {
            dashboard1.setBackground(new Color(204, 255, 255));
        } else if (e.getSource() == order1) {
            order1.setBackground(new Color(204, 255, 255));
        } else if (e.getSource() == download1) {
            download1.setBackground(new Color(204, 255, 255));
        } else if (e.getSource() == address1) {
            address1.setBackground(new Color(204, 255, 255));
        } else if (e.getSource() == acountdetail1) {
            acountdetail1.setBackground(new Color(204, 255, 255));
        } else if (e.getSource() == wishlist1) {
            wishlist1.setBackground(new Color(204, 255, 255));
        } else if (e.getSource() == logout1) {
            logout1.setBackground(new Color(204, 255, 255));
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == dashboard) {
            dashboard.setForeground(Color.BLACK);
        } else if (e.getSource() == order) {
            order.setForeground(Color.BLACK);
        } else if (e.getSource() == download) {
            download.setForeground(Color.BLACK);
        } else if (e.getSource() == address) {
            address.setForeground(Color.BLACK);
        } else if (e.getSource() == acountdetail) {
            acountdetail.setForeground(Color.BLACK);
        } else if (e.getSource() == wishlist) {
            wishlist.setForeground(Color.BLACK);
        } else if (e.getSource() == logout) {
            logout.setForeground(Color.BLACK);
        } else if (e.getSource() == dashboard1) {
            dashboard1.setBackground(Color.cyan);
        } else if (e.getSource() == order1) {
            order1.setBackground(Color.cyan);
        } else if (e.getSource() == download1) {
            download1.setBackground(Color.cyan);
        } else if (e.getSource() == address1) {
            address1.setBackground(Color.cyan);
        } else if (e.getSource() == acountdetail1) {
            acountdetail1.setBackground(Color.cyan);
        } else if (e.getSource() == wishlist1) {
            wishlist1.setBackground(Color.cyan);
        } else if (e.getSource() == logout1) {
            logout1.setBackground(Color.cyan);
        }
    }

    public static void main(String[] args) {
        String userName = "mohsin";
        Dashboard frame = new Dashboard(userName);
        frame.setVisible(true);

    }

}
