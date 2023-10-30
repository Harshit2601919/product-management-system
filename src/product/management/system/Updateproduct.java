package product.management.system;
import java.awt.*;//background color
import javax.swing.*;//frame add karne ke liyaa
import java.awt.event.*;
import java.sql.*;
public class Updateproduct extends JFrame implements ActionListener{
    
    
    
    
    JLabel proidname;
    JTextField pname,catname,subname,sellingname,costname,quantityname;
    JButton add,back;        
    String id;
    
    
   Updateproduct(String id){
       this.id=id;
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
       JLabel heading=new JLabel("UPDATE NEW PRODUCT");
       heading.setBounds(320,30,500,50);
       heading.setFont(new Font("SAN SERIF",Font.BOLD,25));
       add(heading);
       
       JLabel labelid=new JLabel("PRODUCT ID");
       labelid.setBounds(50,150,150,30);
       labelid.setFont(new Font("serif",Font.PLAIN,20));
       add(labelid);
       
       proidname=new JLabel();
       proidname.setBounds(200,150,150,30);
       proidname.setFont(new Font("serif",Font.PLAIN,20));
       add(proidname);
       
      /* try{
           Conn c=new Conn();
           String query="select * from product where id ='"+id+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                
                lblname.setText(rs.getString("name"));
                catname.setText(rs.getString("cname"));
            }
       }catch(Exception e){
           e.printStackTrace();
       }*/
       
       
       
       
       JLabel labelname=new JLabel("NAME");
       labelname.setBounds(400,150,150,30);
       labelname.setFont(new Font("serif",Font.PLAIN,20));
       add(labelname);
       
       JLabel lblname=new JLabel();
       lblname.setBounds(600,150,150,30);
       add(lblname);
       
       
       JLabel labelcname=new JLabel("CATEGORY");
       labelcname.setBounds(50,200,150,30);
       labelcname.setFont(new Font("serif",Font.PLAIN,20));
       add(labelcname);
       
       catname=new JTextField();
       catname.setBounds(200,200,150,30);
       add(catname);
       
       JLabel labelsname=new JLabel("SUB CATEGORY");
       labelsname.setBounds(400,200,150,30);
       labelsname.setFont(new Font("serif",Font.PLAIN,20));
       add(labelsname);
       
       subname=new JTextField();
       subname.setBounds(600,200,150,30);
       add(subname);
       
       JLabel labelsellname=new JLabel("SELLING PRICE");
       labelsellname.setBounds(50,250,150,30);
       labelsellname.setFont(new Font("serif",Font.PLAIN,20));
       add(labelsellname);
       
       sellingname=new JTextField();
       sellingname .setBounds(200,250,150,30);
       add(sellingname);
       
       JLabel labelconame=new JLabel("COST PRICE");
       labelconame.setBounds(400,250,150,30);
       labelconame.setFont(new Font("serif",Font.PLAIN,20));
       add(labelconame);
       
      costname=new JTextField();
       costname.setBounds(600,250,150,30);
       add(costname);
       
       JLabel labelquname=new JLabel("QUANTITY");
       labelquname.setBounds(50,300,150,30);
       labelquname.setFont(new Font("serif",Font.PLAIN,20));
       add(labelquname);
       
      quantityname=new JTextField();
      quantityname.setBounds(200,300,150,30);
       add(quantityname);
       
       try{
           Conn c=new Conn();
           String query="select * from product where id ='"+id+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                
                lblname.setText(rs.getString("name"));
                catname.setText(rs.getString("cname"));
                subname.setText(rs.getString("sname"));
                sellingname.setText(rs.getString("sellname"));
                costname.setText(rs.getString("coname"));
                quantityname.setText(rs.getString("quname"));
                proidname.setText(rs.getString("id"));
                
            }
       }catch(Exception e){
           e.printStackTrace();
       }
      add = new JButton("UPDATE DETAILS");
      add.setBounds(250, 400, 150, 40);
      add.addActionListener(this);
      add.setBackground(Color.BLACK);
      add.setForeground(Color.WHITE);
      add(add);
        
        back = new JButton("BACK");
        back.setBounds(450, 400, 150, 40);
        back.addActionListener(this);
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
        add(back);
       
       setSize(900,700);
       setLocation(300,50);
       setVisible(true);
   }
   
   
   public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==add){
           
          // String name=pname.getText();
           String cname=catname.getText();
           String sname=subname.getText();
           String sellname=sellingname.getText();
           String coname=costname.getText();
           String quname=quantityname.getText();
           //String id=proidname.getText();
           
           try{
               Conn conn=new Conn();
               String query="update product set cname='"+cname+"',sname='"+sname+"',sellname='"+sellname+"',coname='"+coname+"',quname='"+quname+"'where id='"+id+"'";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"DETAILS UPDATED SUCCESSFULL");
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
       new Updateproduct("");
   }
    
}
