package main;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.mysql.jdbc.Connection;
import DatabBase.Database;
import model.Electricity;
import model.Rent;
import model.Expenditure;

public class MainClass {

 public static void main(String[] args) throws Exception {
  Database db = new Database();
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  double bill;
  double total;
  int firstRead = 0;
  int startRead;
  int secondRead;
  int ebill;
  int unitPrice = 15;
  int itemPrice;
  String itemName;
  int rent;
  int ch;
  Scanner sc = new Scanner(System.in);
  Rent r = new Rent();
  Electricity ele = new Electricity();
  Expenditure exp = new Expenditure();
  GrandTotal gt = new GrandTotal();
  do {
   System.out.println("---Menu---");
   System.out.println("1.Rent");
   System.out.println("2.Electricity Meter");
   System.out.println("3.Daily Kharcha");
   System.out.println("4.Calcuate Rent amount");
   System.out.println("5.Calculation Total Expenditure");
   System.out.println("6.Exist");

   System.out.println("Enter your choice");
   ch = sc.nextInt();
   switch (ch) {
    case 1:
     System.out.println("Enter the rent amount");
     rent = sc.nextInt();
     r.setRent(rent);
     db.addRent(rent, "", "", true);
     break;

    case 2:
     startRead = ele.getFirstRead();
     if (startRead <= 0) {
      System.out.println("Enter the starting meter reading unit");
      firstRead = sc.nextInt();
      ele.setFirstRead(firstRead);
     }
     System.out.println("Enter the last meter reading unit");
     secondRead = sc.nextInt();
     ele.setLastRead(secondRead);
     db.addElectricity(firstRead, secondRead, "");
     break;

    case 3:
     System.out.println("Enter the item name: ");
     itemName = reader.readLine(); // this will read two words
     //itemName=sc.next();
     //sc.next();
     System.out.println("Enter the item price: ");
     itemPrice = sc.nextInt();
     exp.setItem(itemName, itemPrice);
     db.addExpDaily(exp);
     break;

    case 4:
     total = gt.getAllRead();
     rent = db.getRent();
     ebill = rent + (int)(total * unitPrice);
     System.out.println("totol amount= " + ebill);
     break;

    case 5:
     total = gt.TotalExpenses();
     System.out.println("totol expenses amount= " + total);
     break;

    case 6:System.exit(0);
     break;

    default:
     System.out.println("invalid input try again");
     break;
   }
  } while (ch != 6);
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
  //unitPrice = ele.getUnitPrice();
  totalUnit = lastRead - firstRead;
  int ebill = unitPrice * totalUnit;
  return ebill;
 }
 //	public  int Total(int ebill,int rent)
 //	{		
 //		
 //		expenditure=exp.getExpenditure();//getting exp obj from expenditure class
 //		expenses= expenditure.getItemPrice();//extracting expenditure obj
 //		int total = ebill+rent+expenses;
 //	
 //		return total;
 //	}
 public int getAllRead() throws SQLException {
  List < Electricity > eleList = new ArrayList < Electricity > ();
  Database db = new Database();
  try {
   eleList = db.getAllRead();
  } catch (SQLException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  int total = 0;
  //		Electricity ec= new Electricity();
  //		ec=eleList.get(0);
  //total= ec.getLastRead()-ec.getFirstRead();	
  total = eleList.get(0).getLastRead() - eleList.get(0).getFirstRead();
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