package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import DatabBase.Database;

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

public class MainGUI extends JFrame implements ActionListener {// inheriting JFrame

	JLabel label;
	JButton button, btnRent, btnElectricity;
	JTextField t;
	Database db;

	MainGUI() {
		db = new Database();

		btnRent = new JButton("Add Rent");// create button
		btnRent.addActionListener(this);
		btnElectricity = new JButton("Add Electricity");
		btnElectricity.addActionListener(this);
		JButton btn_expenditure = new JButton("Add Daily Kharcha");
		JButton btn_tRent = new JButton("Rent amount");
		JButton btn_tExpenditure = new JButton("Total Expenditure");
		JButton btn_exit = new JButton("Exit");

		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.add(btnRent);
		p.add(btnElectricity);
		add(p);
		setSize(400, 500);
		setVisible(true);
	}

@Override
	public void actionPerformed(ActionEvent e) {
		// String s = e.getActionCommand();
		if (e.getSource().equals(btnRent)) {
			String input = JOptionPane.showInputDialog(this, "Enter Rent Amount");
			int rAmt = Integer.parseInt(input);
			db.addRent(rAmt, "", "", true);
		}
		else if (e.getSource().equals(btnElectricity)) {
			int firstRead = 0;
			int secondRead;
			
			try {
				int startRead = db.getAllRead().getFirstRead();
				if (startRead <= 0) {
					String input = JOptionPane.showInputDialog(this, "Enter the starting meter reading unit");
					 firstRead = Integer.parseInt(input);
				}
				else {
			    	  firstRead=db.getAllRead().getLastRead();
			      }
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String input = JOptionPane.showInputDialog(this, "Enter the second meter reading unit");
			secondRead = Integer.parseInt(input);
			try {
				db.addElectricity(firstRead, secondRead, "");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//db.addRent(eAmt, "", "", true);
		}
	}

	public static void main(String[] args) {
		new MainGUI();
	}
}

