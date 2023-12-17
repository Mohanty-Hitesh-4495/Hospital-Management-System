import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class NewPatient extends JFrame implements ActionListener {

    JLabel jlP_name, jlAadhar, jlAge, jlB_grp, jlphn, jlGender, jlG_name, jldept, jlDOR, heading, jlAddress, jlG_phn;
    JTextField tfP_name, tfadhar, tfAge, tfB_grp, tfphn, tfG_name, tfG_phn, tfAddress;
    JDateChooser dcDOR;
    JComboBox<String> cbdept, cbGender;
    JButton add, back, clear;

    public NewPatient() {
        getContentPane().setBackground(Color.cyan);
        setLayout(null);

        heading = new JLabel("Register New Patient");
        heading.setBounds(320, 10, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        jlP_name = new JLabel("Patient Name");
        jlP_name.setBounds(50, 110, 150, 30);
        jlP_name.setFont(new Font("serif", Font.PLAIN, 20));
        heading.setForeground(Color.BLUE);
        add(jlP_name);
        tfP_name = new JTextField();
        tfP_name.setBounds(200, 110, 250, 30);
        add(tfP_name);

        jlAadhar = new JLabel(" Aadhar");
        jlAadhar.setBounds(46, 160, 150, 30);
        jlAadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(jlAadhar);
        tfadhar = new JTextField();
        tfadhar.setBounds(200, 160, 150, 30);
        add(tfadhar);

        jlAge = new JLabel("Age");
        jlAge.setBounds(480, 160, 150, 30);
        jlAge.setFont(new Font("serif", Font.PLAIN, 20));
        add(jlAge);
        tfAge = new JTextField();
        tfAge.setBounds(600, 160, 150, 30);
        add(tfAge);

        jlGender = new JLabel("Gender");
        jlGender.setBounds(50, 210, 150, 30);
        jlGender.setFont(new Font("serif", Font.PLAIN, 20));
        add(jlGender);
        String Gender[] = { "Male", "Female", "Others" };
        cbGender = new JComboBox<>(Gender);
        cbGender.setBackground(Color.WHITE);
        cbGender.setBounds(200, 210, 150, 30);
        add(cbGender);

        jlB_grp = new JLabel("Blood Group");
        jlB_grp.setBounds(480, 210, 150, 30);
        jlB_grp.setFont(new Font("serif", Font.PLAIN, 20));
        add(jlB_grp);
        tfB_grp = new JTextField();
        tfB_grp.setBounds(600, 210, 150, 30);
        add(tfB_grp);

        jlAddress = new JLabel("Address");
        jlAddress.setBounds(50, 260, 150, 30);
        jlAddress.setFont(new Font("serif", Font.PLAIN, 20));
        add(jlAddress);
        tfAddress = new JTextField();
        tfAddress.setBounds(200, 260, 150, 30);
        add(tfAddress);

        jlphn = new JLabel("Phone");
        jlphn.setBounds(480, 260, 150, 30);
        jlphn.setFont(new Font("serif", Font.PLAIN, 20));
        add(jlphn);
        tfphn = new JTextField();
        tfphn.setBounds(600, 260, 150, 30);
        add(tfphn);

        jldept = new JLabel("Department");
        jldept.setBounds(50, 310, 150, 30);
        jldept.setFont(new Font("serif", Font.PLAIN, 20));
        add(jldept);
        String dept[] = { "General Medicine", "Cardiology", "Neurology", "Surgery", "Dental", "Plastic Surgery",
                "Orthopaedics", "Psychology", "Optometrics" };
        cbdept = new JComboBox<>(dept);
        cbdept.setBackground(Color.WHITE);
        cbdept.setBounds(200, 310, 250, 30);
        add(cbdept);

        jlDOR = new JLabel("Date Of Registration");
        jlDOR.setBounds(590, 310, 300, 30);
        jlDOR.setFont(new Font("serif", Font.PLAIN, 20));
        add(jlDOR);
        dcDOR = new JDateChooser();
        dcDOR.setBounds(600, 350, 150, 30);
        add(dcDOR);

        jlG_name = new JLabel("Gurdian Name");
        jlG_name.setBounds(50, 370, 300, 30);
        jlG_name.setFont(new Font("serif", Font.PLAIN, 20));
        add(jlG_name);
        tfG_name = new JTextField();
        tfG_name.setBounds(200, 370, 250, 30);
        add(tfG_name);

        jlG_phn = new JLabel("Gurdian Phone no.");
        jlG_phn.setBounds(50, 420, 300, 30);
        jlG_phn.setFont(new Font("serif", Font.PLAIN, 20));
        add(jlG_phn);
        tfG_phn = new JTextField();
        tfG_phn.setBounds(200, 420, 150, 30);
        add(tfG_phn);

        clear = new JButton("Clear");
        clear.setBounds(170, 500, 150, 40);
        clear.addActionListener(this);
        clear.setBackground(Color.red);
        clear.setForeground(Color.black);
        add(clear);

        add = new JButton("Add Details");
        add.setBounds(370, 500, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.GREEN);
        add.setForeground(Color.BLACK);
        add(add);

        back = new JButton("Back");
        back.setBounds(570, 500, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.GRAY);
        back.setForeground(Color.BLACK);
        add(back);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocation(200, 30);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            tfP_name.setText("");
            tfadhar.setText("");
            tfAge.setText("");
            tfB_grp.setText("");
            tfphn.setText("");
            tfG_name.setText("");
            tfG_phn.setText("");
            tfAddress.setText("");
        } else if (ae.getSource() == add) {
            String P_name = tfP_name.getText();
            String aadhar = tfadhar.getText();
            String Age = tfAge.getText();
            String B_grp = tfB_grp.getText();
            String P_phn = tfphn.getText();
            String G_name = tfG_name.getText();
            String G_phn = tfG_phn.getText();
            String Address = tfAddress.getText();
            String DOR = ((JTextField) dcDOR.getDateEditor().getUiComponent()).getText();
            String Gender = (String) cbGender.getSelectedItem();
            String Dept = (String) cbdept.getSelectedItem();

            try {
                ConnectDB conn = new ConnectDB();
                String query = "insert into Patients values('" + aadhar + "', '" + P_name + "', '" + Age + "', '"
                        + Gender + "', '" + B_grp + "', '" + Address + "', '" + P_phn + "', '" + Dept + "','" + G_name
                        + "', '" + G_phn + "','" + DOR + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Enter Data Correctly");
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new NewPatient();
    }
}
