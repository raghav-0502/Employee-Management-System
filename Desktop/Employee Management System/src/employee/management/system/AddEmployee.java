package employee.management.system;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {
    
    JTextField tfname, tffname, tfsalary, tfaddress, tfphone, tfemail, tfdesgination, tfaadhar ;
    JLabel heading, lbname, lbfname, lbdob, lbsalary, lbaddress, lbphone, lbemail, lbeducation, lbdesgination, lbaadhar, lbemployeeid, lbempid;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JButton add, back;
            
    AddEmployee() {
        
        Random ran = new Random();
        int number = ran.nextInt(999999);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
       
        heading = new JLabel("Add Employee Details");
        heading.setBounds(280,20,500,50);
        heading.setFont(new Font("RALEWAY", Font.BOLD, 25));
        add(heading);
        
        lbname = new JLabel("Name");
        lbname.setBounds(25,120,150,50);
        lbname.setFont(new Font("serif", Font.BOLD, 17));
        add(lbname);
        tfname = new JTextField();
        tfname.setBounds(140, 130, 200,30);
        add(tfname);
        
        lbfname = new JLabel("Father's Name");
        lbfname.setBounds(370,120,150,50);
        lbfname.setFont(new Font("serif", Font.BOLD, 17));
        add(lbfname);
        tffname = new JTextField();
        tffname.setBounds(510, 130, 200,30);
        add(tffname);

        lbdob = new JLabel("Date of Birth");
        lbdob.setBounds(25,170,150,50);
        lbdob.setFont(new Font("serif", Font.BOLD, 17));
        add(lbdob);
        dcdob = new JDateChooser();
        dcdob.setBounds(140, 180, 200,30);
        add(dcdob);
        
        lbsalary = new JLabel("Salary");
        lbsalary.setBounds(370,170,150,50);
        lbsalary.setFont(new Font("serif", Font.BOLD, 17));
        add(lbsalary);
        tfsalary = new JTextField();
        tfsalary.setBounds(510, 180, 200,30);
        add(tfsalary);
        
        lbaddress = new JLabel("Address");
        lbaddress.setBounds(25,220,150,50);
        lbaddress.setFont(new Font("serif", Font.BOLD, 17));
        add(lbaddress);
        tfaddress = new JTextField();
        tfaddress.setBounds(140, 230, 200,30);
        add(tfaddress);
        
        lbphone = new JLabel("Phone Number");
        lbphone.setBounds(370,220,150,50);
        lbphone.setFont(new Font("serif", Font.BOLD, 17));
        add(lbphone);
        tfphone = new JTextField();
        tfphone.setBounds(510, 230, 200,30);
        add(tfphone);
        
        lbemail = new JLabel("Email ID");
        lbemail.setBounds(25,270,150,50);
        lbemail.setFont(new Font("serif", Font.BOLD, 17));
        add(lbemail);
        tfemail = new JTextField();
        tfemail.setBounds(140, 280, 200,30);
        add(tfemail);
        
        lbeducation = new JLabel("Highest Education");
        lbeducation.setBounds(370,270,150,50);
        lbeducation.setFont(new Font("serif", Font.BOLD, 17));
        add(lbeducation);
        
        String courses[] = {"BBA", "BCA", "B. COM", "B.E", "B.TECH", "B.SC", "CA", "MBA", "M.TECH"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(510, 280, 200,30);
        add(cbeducation);
        
        lbdesgination = new JLabel("Designation");
        lbdesgination.setBounds(25,320,150,50);
        lbdesgination.setFont(new Font("serif", Font.BOLD, 17));
        add(lbdesgination);
        tfdesgination = new JTextField();
        tfdesgination.setBounds(140, 330, 200,30);
        add(tfdesgination);
        
        lbaadhar = new JLabel("Aadhar No.");
        lbaadhar.setBounds(370,320,150,50);
        lbaadhar.setFont(new Font("serif", Font.BOLD, 17));
        add(lbaadhar);
        tfaadhar = new JTextField();
        tfaadhar.setBounds(510, 330, 200,30);
        add(tfaadhar);
        
        lbemployeeid = new JLabel("Employee ID");
        lbemployeeid.setBounds(25,370,150,50);
        lbemployeeid.setFont(new Font("serif", Font.BOLD, 17));
        add(lbemployeeid);
        lbempid = new JLabel("" + number);
        lbempid.setBounds(200,370,200,50);
        lbempid.setFont(new Font("serif", Font.BOLD, 17));
        add(lbempid);
        
        add = new JButton("Save Details");
        add.setBounds(250,450,150,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
                
        back = new JButton("Back");
        back.setBounds(450,450,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
            
        
        setSize(800,600);
        setLocation(400,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) cbeducation.getSelectedItem();
            String designation = tfdesgination.getText();
            String aadhar = tfaadhar.getText();
            String empid = lbempid.getText();
            
            try {
                Conn conn = new Conn();
                String query = "insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+aadhar+"', '"+empid+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}