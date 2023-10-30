package product.management.system;
import java.awt.*;//background color
import javax.swing.*;//frame add karne ke liyaa
import java.util.*;
import java.awt.event.*;

public class Addproduct extends JFrame implements ActionListener{
    
    
    Random ran=new Random();
    int number=ran.nextInt(9999);
    
    JLabel proidname;
    JTextField pname,catname,subname,sellingname,costname,quantityname;
    JButton add,back;        
    
   Addproduct(){
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
       JLabel heading=new JLabel("ADD NEW PRODUCT");
       heading.setBounds(180,50,600,50);
       heading.setFont(new Font("SAN SERIF",Font.BOLD,30));
       add(heading);
       
       JLabel labelid=new JLabel("PRODUCT ID");
       labelid.setBounds(50,150,150,30);
       labelid.setFont(new Font("serif",Font.PLAIN,20));
       add(labelid);
       
       proidname=new JLabel("" + number);
       proidname.setBounds(200,150,150,30);
       add(proidname);
       
       
       JLabel labelname=new JLabel("NAME");
       labelname.setBounds(400,150,150,30);
       labelname.setFont(new Font("serif",Font.PLAIN,20));
       add(labelname);
       
       pname=new JTextField();
       pname.setBounds(600,150,150,30);
       add(pname);
       
       
       JLabel labelcname=new JLabel("CATEGORY");
       labelcname.setBounds(50,200,150,30);
       labelcname.setFont(new Font("serif",Font.PLAIN,20));
       add(labelcname);
       
       catname=new JTextField();
       catname.setBounds(200,200,150,30);
       add(catname);
       
       JLabel labelsname=new JLabel("SUBCATEGORY");
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
       sellingname.setBounds(200,250,150,30);
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
       
      add = new JButton("ADD DETAILS");
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
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/add.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);
       
       setSize(900,700);
       setLocation(300,50);
       setVisible(true);
   }
   
   
   public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==add){
           
           String name=pname.getText();
           String cname=catname.getText();
           String sname=subname.getText();
           String sellname=sellingname.getText();
           String coname=costname.getText();
           String quname=quantityname.getText();
           String id=proidname.getText();
           
           try{
               Conn conn=new Conn();
               String query="insert into product values('"+name+"','"+cname+"','"+sname+"','"+sellname+"','"+coname+"','"+quname+"','"+id+"')";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"DETAILS ADDED SUCCESSFULL");
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
       new Addproduct();
   }
    
}
