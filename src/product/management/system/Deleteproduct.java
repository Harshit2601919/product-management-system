package product.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class Deleteproduct extends JFrame implements ActionListener {
    
    Choice cid;
    JButton back,delete;
    
    Deleteproduct(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelid=new JLabel ("PRODUCT ID");
        labelid.setBounds(50,50,100,30);
        add(labelid);
        
        cid=new Choice();
        cid.setBounds(150,50,150,30);
        add(cid);
        
        try{
            Conn c =new Conn();
            String query="select * from product";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                cid.add(rs.getString("id"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        JLabel labelname=new JLabel ("PRODUCT NAME");
        labelname.setBounds(50,100,100,30);
        add(labelname);
        
        JLabel lblname=new JLabel ();
        lblname.setBounds(200,100,100,30);
        add(lblname);
        
        JLabel labelcategory=new JLabel ("CATEGORY");
        labelcategory.setBounds(50,150,100,30);
        add(labelcategory);
        
        JLabel lblcategory=new JLabel ();
        lblcategory.setBounds(200,150,100,30);
        add(lblcategory);
        
        JLabel labelsubcategory=new JLabel ("SUB CATEGORY");
        labelsubcategory.setBounds(50,200,100,30);
        add(labelsubcategory);
        
        JLabel lblsubcategory=new JLabel ();
        lblsubcategory.setBounds(200,200,100,30);
        add(lblsubcategory);
        
        
        try{
            Conn c =new Conn();
            String query="select * from product where id='"+cid.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblcategory.setText(rs.getString("cname"));
                lblsubcategory.setText(rs.getString("sname"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        cid.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
            Conn c =new Conn();
            String query="select * from product where id='"+cid.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblcategory.setText(rs.getString("cname"));
                lblsubcategory.setText(rs.getString("sname"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
            }
        });
        
        delete=new JButton("DELETE");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back=new JButton("BACK");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image);
       
            
        
        
        
        
        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==delete){
            try{
             Conn c=new Conn();
             String query ="delete from product where id= '"+cid.getSelectedItem()+"'";
             c.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null,"PRODUCT INFORMATION DELETED SUCCESFULLY");
             setVisible(false);
             new Home();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args){
        new Deleteproduct();
    }
    
}
