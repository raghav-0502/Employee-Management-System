package employee.management.system;

import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JTextField tfusername, tfpassword;
    
    Login() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,20,100,30);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 200,30);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40,80,100,30);
        add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(150, 80, 200,30);
        add(tfpassword);
        
        JButton Login = new JButton("Login");
        Login.setBounds(150,140,200,30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(365,0,200,200);
        add(image); 
                
        setSize(600,250);
        setLocation(500,275);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        try {
            
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            Conn c = new Conn();
            String query = "select * from login where username = '"+username+"' and password = '"+password+"' ";
                      
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
                new Home();
            }
            else {
             JOptionPane.showMessageDialog(null, " Bad Credentials");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
            
    }

    
    public static void main(String[] args) {
        new Login();
    }
}
