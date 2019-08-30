package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import DataBase.Database;
import model.Electricity;
import model.Expenditure;

public class MainGUI extends JFrame implements ActionListener { // inheriting JFrame

 JLabel label;
 JButton button, btnRent, btnElectricity, btnExpenditure, btnTrent, btntExpenditure, btnExit;
 JTextField t;
 Database db;
 Expenditure exp = new Expenditure();
 GrandTotal gt = new GrandTotal();
 int unitPrice = 15;
 MainGUI() {
  db = new Database();
  btnRent = new JButton("Rent"); // create button
  btnRent.addActionListener(this);
  btnElectricity = new JButton("Electricity");
  btnElectricity.addActionListener(this);
  btnExpenditure = new JButton("Daily Kharcha");
  btnExpenditure.addActionListener(this);
  btnTrent = new JButton("Rent amount");
  btnTrent.addActionListener(this);
  btntExpenditure = new JButton("Total Expenditure");
  btntExpenditure.addActionListener(this);
  btnExit = new JButton("Exit");
  btnExit.addActionListener(this);

  JPanel p = new JPanel();
  p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
  p.add(btnRent);
  p.add(btnElectricity);
  p.add(btnExpenditure);
  p.add(btnTrent);
  p.add(btntExpenditure);
  p.add(btnExit);
  add(p);
  setSize(400, 500);
  setVisible(true);
 }

 @Override
 public void actionPerformed(ActionEvent e) {

  if (e.getSource().equals(btnRent)) {
   String input = JOptionPane.showInputDialog(this, "Enter Rent Amount");
   int rAmt = Integer.parseInt(input);
   db.addRent(rAmt, "", "", true);
   JOptionPane.showMessageDialog(this, " Rent Amount added successfully");
  } else if (e.getSource().equals(btnElectricity)) {
   int firstRead = 0;
   int secondRead;
   try {
    int startRead = db.getAllRead().getFirstRead();
    if (startRead <= 0) {
     String input = JOptionPane.showInputDialog(this, "Enter the starting meter reading unit");
     firstRead = Integer.parseInt(input);
    } else {
     firstRead = db.getAllRead().getLastRead();
    }
    String input = JOptionPane.showInputDialog(this, "Enter the second meter reading unit");
    secondRead = Integer.parseInt(input);
    db.addElectricity(firstRead, secondRead, "");
    JOptionPane.showMessageDialog(this, "Electricity meter reading added successfully");
   } catch (SQLException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
    JOptionPane.showMessageDialog(null, e1.toString());
   }
  }

  if (e.getSource().equals(btnExpenditure)) {
   int itemPrice;
   try {
   String itemName = JOptionPane.showInputDialog(this, "Enter the item name:");
   String inputPrice = JOptionPane.showInputDialog(this, "Enter the item price:");
   itemPrice = Integer.parseInt(inputPrice);
   exp.setItem(itemName, itemPrice);   
   db.addExpDaily(exp);
   JOptionPane.showMessageDialog(this, "Expenditure meter added successfully");
   } catch (SQLException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
   }
  }
  if (e.getSource().equals(btnTrent)) {
   try {
    int total = gt.getAllRead();
    int rent = db.getRent();
    int tRent = rent + (int)(total * unitPrice);
    JOptionPane.showMessageDialog(this, " Total Rent Amount is: "+tRent);
   } catch (SQLException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
   }

  }
  if (e.getSource().equals(btntExpenditure)) {
	   try {
	    int total = gt.TotalExpenses();
	    JOptionPane.showMessageDialog(this, " Total Expenditure ofcurrent month is: "+total);
	   } catch (SQLException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	   }

	  }
  if (e.getSource().equals(btntExpenditure)) {
	  System.exit(0);
	  }
  
 }

 public static void main(String[] args) {
  new MainGUI();
 }
}

class GrandTotal {
 int firstRead;
 int startRead;
 int lastRead;
 int unitPrice = 15;
 int totalUnit;
 int expenses;
 Expenditure expenditure;
 Electricity ele = new Electricity();
 Expenditure exp = new Expenditure();

 public int Total() {
  firstRead = ele.getFirstRead();
  lastRead = ele.getLastRead();

  totalUnit = lastRead - firstRead;
  int ebill = unitPrice * totalUnit;
  return ebill;
 }

 public int getAllRead() throws SQLException {
  Database db = new Database();
  int total = 0;
  total = db.getAllRead().getLastRead() - db.getAllRead().getFirstRead();
  return total;
 }

 public int TotalExpenses() throws SQLException {
  List < Expenditure > eList = new ArrayList < Expenditure > ();
  Database db = new Database();
  try {
   eList = db.getAllExpenses();
  } catch (SQLException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  int total = 0;
  for (int i = 0; i < eList.size(); i++) {
   total += eList.get(i).getItemPrice();
  }
  return total;
 }
}