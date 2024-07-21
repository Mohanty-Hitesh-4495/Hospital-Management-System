import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField tfusername;
    JPasswordField pfpassword;

    public Login() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading = new JLabel("Login");
        heading.setBounds(230, 15, 300, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 35));
        heading.setForeground(Color.darkGray);
        add(heading);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 100, 100, 30);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(150, 100, 150, 30);
        add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 150, 100, 30);
        add(lblpassword);

        pfpassword = new JPasswordField();
        pfpassword.setBounds(150, 150, 150, 30);
        add(pfpassword);

        JButton login = new JButton("LOGIN");
        login.setBounds(150, 240, 150, 30);
        login.setBackground(Color.green);
        login.setForeground(Color.BLACK);
        login.addActionListener(this);
        add(login);

        ImageIcon i1 = new ImageIcon("./Backgroundimage/login.jpg");
        Image i2 = i1.getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(270, 0, 350, 300);
        add(image);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocation(340, 130);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String username = tfusername.getText();
            String password = new String(pfpassword.getPassword());
            ConnectDB c = new ConnectDB();
            String query = "select * from login where username = '" + username + "'and password = '" + password + "'";
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                tfusername.setText("");
                pfpassword.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
