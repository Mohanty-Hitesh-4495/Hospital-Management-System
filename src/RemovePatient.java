import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class RemovePatient extends JFrame implements ActionListener {

    Choice cEmpId;
    JLabel jlAadhar, heading;
    JTextField tfAadhar;
    JButton delete, back, clear;

    public RemovePatient() {
        getContentPane().setBackground(Color.cyan);
        setLayout(null);

        heading = new JLabel("Remove Patient Details");
        heading.setBounds(100, 10, 350, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        heading.setForeground(Color.BLUE);
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Backgroundimage/remove.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(40, 80, 400, 100);
        add(image);

        jlAadhar = new JLabel(" Enter Valid Aadhar no.");
        jlAadhar.setBounds(50, 200, 250, 30);
        jlAadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(jlAadhar);
        tfAadhar = new JTextField();
        tfAadhar.setBounds(260, 200, 150, 30);
        add(tfAadhar);

        clear = new JButton("Clear");
        clear.setBounds(50, 300, 100, 30);
        clear.setBackground(Color.RED);
        clear.setForeground(Color.BLACK);
        clear.addActionListener(this);
        add(clear);

        delete = new JButton("Remove");
        delete.setBounds(180, 300, 100, 30);
        delete.setBackground(Color.GREEN);
        delete.setForeground(Color.BLACK);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(310, 300, 100, 30);
        back.setBackground(Color.GRAY);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocation(390, 120);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                ConnectDB c = new ConnectDB();
                String query = "delete from patients where Aadhar_no = '" + tfAadhar.getText() + "'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Patient Information Removed");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid Aadhar");
                tfAadhar.setText("");
            }
        } else if (ae.getSource() == clear) {
            tfAadhar.setText("");
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new RemovePatient();
    }
}
