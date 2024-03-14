import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    JButton view, add, developer, remove;

    public Home() {

        getContentPane().setBackground(Color.CYAN);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Backgroundimage/Aesthetic-01.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1090, 600);
        add(image);

        JLabel heading = new JLabel("Gandhi Hospital, Bhubaneswar");
        heading.setBounds(40, 30, 800, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 50));
        heading.setForeground(Color.darkGray);
        image.add(heading);

        add = new JButton("New Patient");
        add.setBounds(650, 420, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.green);
        add.setForeground(Color.BLACK);
        image.add(add);

        view = new JButton("View Patients");
        view.setBounds(650, 480, 150, 40);
        view.addActionListener(this);
        view.setBackground(Color.green);
        view.setForeground(Color.BLACK);
        image.add(view);

        remove = new JButton("Remove Patients");
        remove.setBounds(850, 420, 150, 40);
        remove.addActionListener(this);
        remove.setBackground(Color.green);
        remove.setForeground(Color.BLACK);
        image.add(remove);

        developer = new JButton("Developer Details");
        developer.setBounds(850, 480, 150, 40);
        developer.addActionListener(this);
        developer.setBackground(Color.green);
        developer.setForeground(Color.BLACK);
        image.add(developer);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1100, 630);
        setLocation(80, 30);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new NewPatient();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewPatients();
        } else if (ae.getSource() == developer) {
            setVisible(false);
            new developer();
        } else {
            setVisible(false);
            new RemovePatient();
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
