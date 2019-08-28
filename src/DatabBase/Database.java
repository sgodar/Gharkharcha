package DatabBase;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
//import java.util.List;
import model.Expenditure;
import model.Electricity;
//import model.Rent;

public class Database {
 // connection string
 String url = "jdbc:mysql://localhost:3306/gharkharcha";
 String username = "root";
 String password = "";
 String sql = "";
 Statement stmt;
 ResultSet rs;
 private PreparedStatement preparedStatement = null;
 Connection con;
 public Database() throws SQLException {
  con = (Connection) DriverManager.getConnection(url, username, password);
 }

 public void addRent(int RentPrice, String Month, String PaidDate, boolean Status) throws SQLException {
  sql = "INSERT INTO Rent (RentPrice,PaidStatus)" + "VALUES (?,?)";
  //		sql = "Insert into vertex (name,latitude,longitude) " + "values('" + v.getName() + "', " + v.getLatitude()
  //				+ ", " + v.getLongitude() + ")";
  // System.out.println(sql);

  try {
   preparedStatement = (PreparedStatement) con.prepareStatement(sql);
   preparedStatement.setInt(1, RentPrice);
   //preparedStatement.setString(2,  Month );
   //preparedStatement.setString(3,  PaidDate);
   preparedStatement.setBoolean(2, Status);
   preparedStatement.executeUpdate();
   preparedStatement.close();
  } catch (Exception e) {
   throw e;
  }
 }
 public void addElectricity(int firstRead, int lastRead, String AddedOn) throws SQLException {
  sql = "INSERT INTO Electricity (FirstRead,SecondRead)" + "VALUES (?,? )";
  try {
   preparedStatement = (PreparedStatement) con.prepareStatement(sql);
   preparedStatement.setInt(1, firstRead);
   preparedStatement.setInt(2, lastRead);
   preparedStatement.executeUpdate();
   preparedStatement.close();
  } catch (Exception e) {
   throw e;
  }
 }
 public void addExpDaily(String itemName, int itemPrice, String AddedOn) throws SQLException {
  sql = "INSERT INTO ExpDaily (CategoryName,CategoryPrice)" + "VALUES (?,? )";
  try {
   preparedStatement = (PreparedStatement) con.prepareStatement(sql);
   preparedStatement.setString(1, itemName);
   preparedStatement.setInt(2, itemPrice);
   preparedStatement.executeUpdate();
   preparedStatement.close();
  } catch (Exception e) {
   throw e;
  }
 }
 public void addExpDaily(Expenditure exp) throws SQLException {
  sql = "INSERT INTO ExpDaily (CategoryName,CategoryPrice)" + "VALUES (?,? )";
  try {
   preparedStatement = (PreparedStatement) con.prepareStatement(sql);
   preparedStatement.setString(1, exp.getItemName());
   preparedStatement.setInt(2, exp.getItemPrice());
   preparedStatement.executeUpdate();
   preparedStatement.close();
  } catch (Exception e) {
   throw e;
  }
 }
 public ArrayList < Expenditure > getAllExpenses() throws SQLException {
  Expenditure e;
  ArrayList < Expenditure > eList = new ArrayList < Expenditure > ();
  sql = "SELECT CategoryPrice FROM expDaily WHERE MONTH(AddedOn) = MONTH(CURRENT_DATE()) AND YEAR(AddedOn) = YEAR(CURRENT_DATE())";
  // 3. prepare sql statement to be executed
  stmt = (Statement) con.createStatement();
  // 4 get the resultset from execution
  rs = stmt.executeQuery(sql);
  while (rs.next()) {
   int Price = rs.getInt(1); // 1 indicate column 1st value
   e = new Expenditure();
   e.setItem(" ", Price);
   eList.add(e);
  }
  rs.close();
  stmt.close();
  return eList;
 }
// public ArrayList < Electricity > getAllRead() throws SQLException {
//  Electricity ele;
//  ArrayList < Electricity > eleList = new ArrayList < Electricity > ();
//  sql = "SELECT FirstRead,SecondRead FROM Electricity ORDER BY ElectricityID DESC LIMIT 1";
//  stmt = (Statement) con.createStatement();
//  rs = stmt.executeQuery(sql);
//  while (rs.next()) {
//   int firstRead = rs.getInt(1); // 1 indicate column 1st value
//   int secondRead = rs.getInt(2);
//   ele = new Electricity();
//   ele.setFirstRead(firstRead);
//   ele.setLastRead(secondRead);
//   eleList.add(ele);
//  }
//  rs.close();
//  stmt.close();
//  return eleList;
// }
 public Electricity getAllRead() throws SQLException {
	  Electricity   ele = new Electricity();
	  int firstRead=0;
	  //ArrayList < Electricity > eleList = new ArrayList < Electricity > ();
	  sql = "SELECT FirstRead,SecondRead FROM Electricity ORDER BY ElectricityID DESC LIMIT 1";
	  stmt = (Statement) con.createStatement();
	  rs = stmt.executeQuery(sql);
	  while (rs.next()) {
	    firstRead = rs.getInt(1); // 1 indicate column 1st value
	   int secondRead = rs.getInt(2);
	 
	   ele.setFirstRead(firstRead);
	   ele.setLastRead(secondRead);
	  }
	  rs.close();
	  stmt.close();
	  return ele;
	 }
 public int getRent() throws SQLException {
  //Rent r;
  int rent = 0;
  sql = "SELECT RentPrice FROM Rent ORDER BY RentID DESC LIMIT 1";
  stmt = (Statement) con.createStatement();
  rs = stmt.executeQuery(sql);
  while (rs.next()) {
   rent = rs.getInt(1);
  }
  rs.close();
  stmt.close();
  return rent;
 }
}