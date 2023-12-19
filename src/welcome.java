import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class welcome extends JFrame implements ActionListener {

    public welcome() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("HOSPITAL MANAGEMENT SYSTEM");
        heading.setBounds(55, 40, 1000, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 40));
        heading.setForeground(Color.RED);
        add(heading);

        JLabel h1 = new JLabel("HOSPITAL MANAGEMENT SYSTEM");
        h1.setBounds(55, 40, 800, 50);
        h1.setFont(new Font("SAN_SERIF", Font.BOLD, 40));
        h1.setForeground(Color.BLUE);
        add(h1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Backgroundimage/welcome.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 500);
        add(image);

        JButton login = new JButton("Login");
        login.setBounds(310, 350, 150, 35);
        login.setBackground(Color.RED);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 550);
        setLocation(150, 70);
        setVisible(true);

        while (true) {
            heading.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }

            heading.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String args[]) {
        new welcome();
    }
}
