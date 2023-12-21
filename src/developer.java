import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class developer extends JFrame implements ActionListener {
    JLabel heading, d1, d2, d3, d4, d5;
    JButton back;

    developer() {
        getContentPane().setBackground(Color.CYAN);
        setLayout(null);

        heading = new JLabel("Developer Details");
        heading.setBounds(150, 30, 450, 70);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 47));
        heading.setForeground(Color.BLUE);
        add(heading);

        d1 = new JLabel("Name: Mohanty Hitesh");
        d1.setBounds(50, 200, 350, 30);
        d1.setFont(new Font("serif", Font.PLAIN, 25));
        d1.setForeground(Color.black);
        add(d1);

        d2 = new JLabel("Email: mohantyhitesh4495@gmail.com");
        d2.setBounds(50, 230, 350, 30);
        d2.setFont(new Font("serif", Font.PLAIN, 20));
        d2.setForeground(Color.BLACK);
        add(d2);
         

        back = new JButton("Back");
        back.setBounds(270, 350, 150, 30);
        back.addActionListener(this);
        back.setBackground(Color.GRAY);
        back.setForeground(Color.BLACK);
        add(back);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocation(300, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            new Home();
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    public static void main(String[] args) {
        new developer();
    }
}
