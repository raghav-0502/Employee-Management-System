package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {
    
    JTextField tfeducation, tffname, tfsalary, tfaddress, tfphone, tfemail, tfdesgination;
    JLabel heading, lbfname, lbdob, lbsalary, lbaddress, lbphone, lbemail, lbeducation, lbdesgination, lbaadhar, lbemployeeid, lbempid;
    JButton add, back;
    String empid;
            
    UpdateEmployee(String empid) {
        
        this.empid=empid;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
       
        heading = new JLabel("Update Employee Details");
        heading.setBounds(280,20,500,50);
        heading.setFont(new Font("RALEWAY", Font.BOLD, 25));
        add(heading);
        
        JLabel lbname = new JLabel("Name");
        lbname.setBounds(25,120,150,50);
        lbname.setFont(new Font("serif", Font.BOLD, 17));
        add(lbname);
        JLabel lblname = new JLabel();
        lblname.setBounds(140, 130, 200,30);
        add(lblname);
        
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
        JLabel lbldob = new JLabel();
        lbldob.setBounds(140, 180, 200,30);
        add(lbldob);
        
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
        
        tfeducation = new JTextField();
        tfeducation.setBackground(Color.WHITE);
        tfeducation.setBounds(510, 280, 200,30);
        add(tfeducation);
        
        lbdesgination = new JLabel("Designation");
        lbdesgination.setBounds(25,320,150,50);
        lbdesgination.setFont(new Font("serif", Font.BOLD, 17));
        add(lbdesgination);
        tfdesgination = new JTextField();
        tfdesgination.setBounds(140, 330, 200,30);
        add(tfdesgination);
        
        lbaadhar = new JLabel("Aadhar No.");
        lbaadhar.setBounds(370,320,150,50);
        lbaadhar.setFont(new Font("serif", Font.BOLD, 18));
        add(lbaadhar);       
        JLabel lblaadhar = new JLabel();       
        lblaadhar.setBounds(510, 330, 200,30);
        add(lblaadhar);
        
        lbemployeeid = new JLabel("Employee ID");
        lbemployeeid.setBounds(25,370,150,50);
        lbemployeeid.setFont(new Font("serif", Font.BOLD, 17));
        add(lbemployeeid);
        lbempid = new JLabel();
        lbempid.setBounds(200,370,200,50);
        lbempid.setFont(new Font("serif", Font.BOLD, 17));
        add(lbempid);
        
        try{
            Conn c= new Conn();
            String query = "select * from employee where empid = '"+empid+"'";
            c.s.executeQuery(query);
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfsalary.setText(rs.getString("salary"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));                
                lblaadhar.setText(rs.getString("aadhar"));
                lbempid.setText(rs.getString("empid"));
                tfdesgination.setText(rs.getString("designation"));                           
            }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        add = new JButton("Update Details");
        add.setBounds(200,450,150,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
                
        back = new JButton("Back");
        back.setBounds(400,450,150,30);
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
            String fname = tffname.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesgination.getText();          
            
            try {
                Conn conn = new Conn();
                String query = "update employee set fname = '"+fname+"',salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where empid = '"+empid+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
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
        new UpdateEmployee("");
    }
}