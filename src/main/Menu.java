package main;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.*;



//public class AddRent {
//	public static void main(String[] args) {  
//		JFrame frame=new JFrame();//creating instance of JFrame  
//		JButton r=new JButton("Add Rent");//creating instance of JButton  
//		r.setBounds(130,100,100, 40);//x axis, y axis, width, height		    
//		frame.add(r);//adding button in JFrame  		          
//		frame.setSize(400,500);//400 width and 500 height  
//		frame.setLayout(null);//using no layout managers  
//		frame.setVisible(true);//making the frame visible  
//	}  
//}  
import javax.swing.*;  
public class Menu extends JFrame{//inheriting JFrame  
JFrame frame;
JLabel label;
JButton button;
JTextField t;
Menu(){
JFrame frame = new JFrame("textfield");
JButton button=new JButton("Add Rent");//create button  
JPanel p = new JPanel(); 
button.setBounds(130,100,100, 40);  
JLabel label = new JLabel("rent");
t = new JTextField("enter the rent", 16); 
add(label);
add(button);//adding button on frame 
p.add(label);
p.add(button);
p.add(label);
frame.add(p);
frame.setSize(400,500);  
//setLayout(null);  
setVisible(true);  
}  

//@Override
public void actionPerformed(ActionEvent e) 
{ 
    String s = e.getActionCommand(); 
    if (s.equals("Add Rent")) { 
        // set the text of the label to the text of the field 
    	label.setText(t.getText()); 

        // set the text of field to blank 
        t.setText("  "); 
    } 
} 
public static void main(String[] args) {  
new Menu();  
}}


//import java.awt.*;
//import javax.swing.*;
//import java.awt.event.*;
//import java.util.ArrayList;
//import java.io.*;
  
//public class Sales extends JFrame
//{
//static JTextArea output;
//static ArrayList<Salesman> myList = new ArrayList<Salesman>();
//static JTextField name;
//static JComboBox product;
//static String [] productName = {"Product 1", "Product 2", "Product 3", "Product 4", "Product 5"};
//static JTextField sales;
//static JPanel panel1;
//static JButton done;
//static JButton total;
//static FileWriter file;
//static BufferedWriter buff;
//Handler handler = new Handler();
// 
//public Sales()
//{
//super("Monthly Sales");
//Container c = getContentPane();
// 
//try{
//file = new FileWriter("SalesData.txt");
//buff = new BufferedWriter(file);
//}
//catch(IOException ioe)
//{
//ioe.printStackTrace();
//}
//  
//name = new JTextField(400);
//product = new JComboBox(productName);
//sales = new JTextField(100);
//done = new JButton("Salesmen Entry Done");
//total = new JButton("Grand Total");
//panel1 = new JPanel();
//output = new JTextArea(150,150);
// 
//c.add(name, BorderLayout.NORTH);
//c.add(product, BorderLayout.EAST);
//c.add(sales, BorderLayout.WEST);
//c.add(output, BorderLayout.CENTER);
// 
//panel1.add(done);
//panel1.add(total);
//panel1.setLayout(new GridLayout(1,1));
//c.add(panel1, BorderLayout.SOUTH);
//done.addActionListener(handler);
//total.addActionListener(handler);
//product.addActionListener(handler);
//sales.addActionListener(handler);
//}
//  
//public static void main (String args[])
//{
//Sales sale = new Sales();
//sale.setSize(400,200);
//sale.setVisible(true);
//  
//sale.addWindowListener(new WindowAdapter(){
//public void windowClosing(WindowEvent e)
//{
//try
//{
////walk through arraylist and write to file
//buff.close();
//}
//catch(IOException ioe)
//{
//ioe.printStackTrace();
//}
//  
//System.exit(0);
//}});
//}
// 
//public static class Handler implements ActionListener
//{
//                //This is the section I am really confussed about.
//                //Do I need an actionlistener or itemlistener, or both?
//                //Also I know this is not set up right, but I wanted 
//                //to go a head and send what I had for now.
//public void actionPerformed(ActionEvent e)
//{
//String sname;
//double ssales;
//String sproduct;
//int samount;
//Salesman s1;
// 
//sname = name.getText();
//ssales = Double.parseDouble(sales.getText());
//sproduct = product.getText();
//s1 = new Salesman(sname, ssales, sproduct);
//  
//switch(sproduct)
//{
//case 1:  s1.setSales(samount * 2.98);
//break;
//  
//case 2:  s1.setSales(samount * 4.50);
//break;
// 
//case 3:  s1.setSales(samount * 9.98);
//break;
// 
//case 4: s1.setSales(samount * 4.49);
//break;
//  
//case 5: s1.setSales(samount * 6.87);
//break;
//  
//default: System.out.println("Invalid type");
//}
//myList.add(s1);
//output.append("\n"+s1.toString());
//output.setText(s1.toString());
//  
//try
//{
//buff.write(s1.toString());
//}
//  
//catch (IOException ioe)
//{
//ioe.printStackTrace();
//}
//}
//}
//}