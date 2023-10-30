package product.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class Viewproduct extends JFrame implements ActionListener {
    
    JTable table;
    Choice cproductid;
    JButton search,print,update,back;    
    
    Viewproduct(){
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
    JLabel searchlbl=new JLabel("Search by Product Id");
    searchlbl.setBounds(180,20,150,20);
    add(searchlbl);
    
    
    
    cproductid=new Choice();
    cproductid.setBounds(330,20,150,20);
    add(cproductid);
    
    try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from product");
            while(rs.next()) {
                cproductid.add(rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    table=new JTable();
    try{
        Conn c=new Conn();
        ResultSet rs=c.s.executeQuery("Select * from product");
        table.setModel(DbUtils.resultSetToTableModel(rs));
        
                
    }catch(Exception e){
        e.printStackTrace();
        
    }
    
    JScrollPane jsp=new JScrollPane(table);
    jsp.setBounds(0,100,900,600);
    add(jsp);
    
    
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);
        
        
    setSize(900,700);
    setLocation(300,100);
    setVisible(true);
}
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == search) {
            String query = "select * from product where id = '"+cproductid.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            setVisible(false);
            new Updateproduct(cproductid.getSelectedItem());
        } else {
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String[] args){
        new Viewproduct();
    }
}

