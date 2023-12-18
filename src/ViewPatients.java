import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewPatients extends JFrame implements ActionListener {

    JTable table;
    JTextField tfAadhar;
    JButton search, print, clear, back;

    public ViewPatients() {

        getContentPane().setBackground(Color.CYAN);
        setLayout(null);

        JLabel searchlbl = new JLabel("Search by Aadhar no. :");
        searchlbl.setBounds(20, 20, 250, 30);
        add(searchlbl);

        tfAadhar = new JTextField();
        tfAadhar.setBounds(180, 20, 250, 30);
        add(tfAadhar);

        table = new JTable();

        try {
            ConnectDB c = new ConnectDB();
            ResultSet rs = c.s.executeQuery("select * from Patients");
            ResultSetMetaData rsmd = rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int cols = rsmd.getColumnCount();
            String[] colname = new String[cols];
            for (int i = 0; i < cols; i++) {
                colname[i] = rsmd.getColumnName(i + 1);
                model.setColumnIdentifiers(colname);
                String Aadhar_no, Patient_Name, Age, Gender, Blood_Group, Address, Phone_no, Department, Gurdian_Name,
                        Gurdin_Phone_no, DOR;
                while (rs.next()) {
                    Aadhar_no = rs.getString(1);
                    Patient_Name = rs.getString(2);
                    Age = rs.getString(3);
                    Gender = rs.getString(4);
                    Blood_Group = rs.getString(5);
                    Address = rs.getString(6);
                    Phone_no = rs.getString(7);
                    Department = rs.getString(8);
                    Gurdian_Name = rs.getString(9);
                    Gurdin_Phone_no = rs.getString(10);
                    DOR = rs.getString(11);
                    String[] row = { Aadhar_no, Patient_Name, Age, Gender, Blood_Group, Address, Phone_no, Department,
                            Gurdian_Name, Gurdin_Phone_no, DOR };
                    model.addRow(row);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(400, 70, 80, 20);
        search.addActionListener(this);
        search.setBackground(Color.green);
        search.setForeground(Color.BLACK);
        add(search);

        print = new JButton("Print");
        print.setBounds(510, 70, 80, 20);
        print.addActionListener(this);
        print.setBackground(Color.green);
        print.setForeground(Color.BLACK);
        add(print);

        clear = new JButton("Clear");
        clear.setBounds(620, 70, 80, 20);
        clear.addActionListener(this);
        clear.setBackground(Color.red);
        clear.setForeground(Color.BLACK);
        add(clear);

        back = new JButton("Back");
        back.setBounds(730, 70, 80, 20);
        back.addActionListener(this);
        back.setBackground(Color.gray);
        back.setForeground(Color.BLACK);
        add(back);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(915, 600);
        setLocation(190, 40);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from patients where Aadhar_no = '" + tfAadhar.getText() + "'";
            try {
                String Aadhar_no = null, Patient_Name, Age, Gender, Blood_Group, Address, Phone_no, Department,
                        Gurdian_Name, Gurdin_Phone_no;
                ConnectDB c = new ConnectDB();
                ResultSet rs = c.s.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
                int cols = rsmd.getColumnCount();
                String[] colname = new String[cols];
                for (int i = 0; i < cols; i++) {
                    colname[i] = rsmd.getColumnName(i + 1);
                    model.setColumnIdentifiers(colname);
                    while (rs.next()) {
                        Aadhar_no = rs.getString(1);
                        Patient_Name = rs.getString(2);
                        Age = rs.getString(3);
                        Gender = rs.getString(4);
                        Blood_Group = rs.getString(5);
                        Address = rs.getString(6);
                        Phone_no = rs.getString(7);
                        Department = rs.getString(8);
                        Gurdian_Name = rs.getString(9);
                        Gurdin_Phone_no = rs.getString(10);
                        String[] row = { Aadhar_no, Patient_Name, Age, Gender, Blood_Group, Address, Phone_no,
                                Department, Gurdian_Name, Gurdin_Phone_no };
                        model.addRow(row);
                    }
                }
                if (Aadhar_no == null) {
                    JOptionPane.showMessageDialog(null, "Invalid Aadhar Number");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == clear) {
            tfAadhar.setText("");
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new ViewPatients();
    }
}
