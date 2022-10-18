package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewEmployee extends JFrame implements ActionListener{

    JTable table;
    Choice cemployeeid;
    JButton search, print, update, back;
    
    ViewEmployee() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchlb = new JLabel("Search by Employee Id");
        searchlb.setFont(new Font("serif", Font.BOLD, 20));
        searchlb.setBounds(20, 20, 200, 20);
        add(searchlb);
        
        cemployeeid = new Choice();
        cemployeeid.setBounds(240, 22, 150, 20);
        add(cemployeeid);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next()) {
                cemployeeid.add(rs.getString("empid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 120, 900, 600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20,70,100,20);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        add(search);
        
        update = new JButton("Update");
        update.setBounds(150,70,100,20);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        print = new JButton("Print");
        print.setBounds(280,70,100,20);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        add(print);
                    
        back = new JButton("Back");
        back.setBounds(410,70,100,20);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select *  from employee where empid = '"+cemployeeid.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }       
            catch (Exception e) {
                e.printStackTrace();
            }        
        }
        else if (ae.getSource() == print) {
            try{
                table.print();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
           
        } 
        else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateEmployee(cemployeeid.getSelectedItem());
        }
        
        else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}