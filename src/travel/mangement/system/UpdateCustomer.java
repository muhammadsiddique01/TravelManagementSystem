package travel.mangement.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpdateCustomer extends JFrame implements ActionListener {
    private JLabel labelusername, labelid, labelnumber, labelname, labelgender, labelcountry, labeladdress, labelphone, labelemail;
    private JTextField tfid, tfnumber, tfname, tfgender, tfcountry, tfaddress, tfphone, tfemail,tfusername;
    private JButton updateButton, backButton;

    public UpdateCustomer(String username) {
        setBounds(300, 80, 870, 625);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50, 0, 300, 25);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(text);

        labelusername = new JLabel("Username");
        labelusername.setBounds(30, 50, 150, 25);
        add(labelusername);
        tfusername = new JTextField();
        tfusername.setBounds(220, 50, 150, 25);
        add(tfusername);
        
        labelid = new JLabel("ID");
        labelid.setBounds(30, 90, 150, 25);
        add(labelid);
        tfid = new JTextField();
        tfid.setBounds(220, 90, 150, 25);
        add(tfid);

        labelnumber = new JLabel("Number");
        labelnumber.setBounds(30, 130, 150, 25);
        add(labelnumber);
        tfnumber = new JTextField();
        tfnumber.setBounds(220, 130, 150, 25);
        add(tfnumber);

        labelname = new JLabel("Name");
        labelname.setBounds(30, 170, 150, 25);
        add(labelname);
        tfname = new JTextField();
        tfname.setBounds(220, 170, 150, 25);
        add(tfname);

        labelgender = new JLabel("Gender");
        labelgender.setBounds(30, 210, 150, 25);
        add(labelgender);
        tfgender = new JTextField();
        tfgender.setBounds(220, 210, 150, 25);
        add(tfgender);

        labelcountry = new JLabel("Country");
        labelcountry.setBounds(30, 250, 150, 25);
        add(labelcountry);
        tfcountry = new JTextField();
        tfcountry.setBounds(220, 250, 150, 25);
        add(tfcountry);

        labeladdress = new JLabel("Address");
        labeladdress.setBounds(30, 290, 150, 25);
        add(labeladdress);
        tfaddress = new JTextField();
        tfaddress.setBounds(220, 290, 150, 25);
        add(tfaddress);

        labelphone = new JLabel("Phone");
        labelphone.setBounds(30, 330, 150, 25);
        add(labelphone);
        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);

        labelemail = new JLabel("Email");
        labelemail.setBounds(30, 370, 150, 25);
        add(labelemail);
        tfemail = new JTextField();
        tfemail.setBounds(220, 370, 150, 25);
        add(tfemail);

        updateButton = new JButton("Update");
        updateButton.setBackground(Color.BLACK);
        updateButton.setForeground(Color.WHITE);
        updateButton.setBounds(70, 430, 100, 25);
        updateButton.addActionListener(this);
        add(updateButton);

        backButton = new JButton("Back");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setBounds(220, 430, 100, 25);
        backButton.addActionListener(this);
        add(backButton);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 450, 420);
        add(image);

        try {
            Conn c = new Conn();
            var rs = c.s.executeQuery("SELECT * FROM customer WHERE username = '" + username + "'");
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfname.setText(rs.getString("name"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == updateButton) {
            // Perform update logic here
            String id = tfid.getText();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = tfgender.getText();
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();

            try {
                Conn c = new Conn();
                String query = "UPDATE customer SET id='" + id + "', number='" + number + "', name='" + name + "', gender='"
                        + gender + "', country='" + country + "', address='" + address + "', phone='" + phone + "', email='"
                        + email + "' WHERE username='" + labelusername.getText() + "'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Customer details updated successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == backButton) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateCustomer("sid");
    }
}