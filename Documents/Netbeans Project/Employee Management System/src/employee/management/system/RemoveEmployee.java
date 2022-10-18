package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class RemoveEmployee extends JFrame implements ActionListener{
    
    JLabel lbempid, lbname, lblname, lbphone, lblphone, lbemail, lblemail;
    Choice cempid;
    JButton delete, back;
    
    RemoveEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        lbempid = new JLabel("Employee ID");      
        lbempid.setBounds(40,20,100,30);
        lbempid.setFont(new Font("sans_serif", Font.BOLD, 15));
        add(lbempid);       
        cempid = new Choice();
        cempid.setBounds(160, 25, 150, 22);
        add(cempid);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee";
            ResultSet rs= c.s.executeQuery(query);
            while(rs.next()){
                cempid.add(rs.getString("empid"));
            }
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        lbname = new JLabel("Name");      
        lbname.setBounds(40,80,100,30);
        lbname.setFont(new Font("sans_serif", Font.BOLD, 15));
        add(lbname);
        lblname = new JLabel();      
        lblname.setBounds(160,80,120,30);
        add(lblname);
        
        lbphone = new JLabel("Phone");      
        lbphone.setBounds(40,140,100,30);
        lbphone.setFont(new Font("sans_serif", Font.BOLD, 15));
        add(lbphone);
        lblphone = new JLabel();      
        lblphone.setBounds(160,140,120,30);
        add(lblphone);
        
        lbemail = new JLabel("Email");      
        lbemail.setBounds(40,200,100,30);
        lbemail.setFont(new Font("sans_serif", Font.BOLD, 15));
        add(lbemail);
        lblemail = new JLabel();      
        lblemail.setBounds(160,200,120,30);
        add(lblemail);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee where empid = '"+cempid.getSelectedItem()+"'";
            ResultSet rs= c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            }
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        cempid.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from employee where empid = '"+cempid.getSelectedItem()+"'";
                    ResultSet rs= c.s.executeQuery(query);
                    while(rs.next()){
                        lblname.setText(rs.getString("name"));
                        lblphone.setText(rs.getString("phone"));
                        lblemail.setText(rs.getString("email"));
                    }

                }
                catch (Exception e){
                    e.printStackTrace();
                }
                
            }
        });
    
        delete = new JButton("Delete");
        delete.setBounds(50,300,120,20);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(200,300,120,20);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(350, 233, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(320,50,350,233);
        add(image); 
        
        setSize(700,400);
        setVisible(true);
        setLocation(450,200);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == delete){
            try {
                Conn c = new Conn();
                String query = "delete from employee where empid = '"+cempid.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Information deleted successfully");
                setVisible(false);
                new Home();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String [] args){
        
        new RemoveEmployee();
    
}
}
