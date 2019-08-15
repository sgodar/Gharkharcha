package DatabBase;
import java.sql.DriverManager;
import java.sql.Connection;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
//import lib.java.jdbc.Connection;
//import lib.mysql.jdbc.Gharkharcha;

//import week4.model.Vertex;

//import week2.main.Vertex;
public class Database {
	// connection string
	String url = "jdbc:mysql://localhost:3306/gharkharcha";
	String username = "root";
	String password = "";
	String sql = "";
	Statement stmt;
	private PreparedStatement preparedStatement = null;
	Connection con;
	public Database() throws SQLException {
		con = (Connection) DriverManager.getConnection(url, username, password);
	}
	
	
	//	public void addRent( int RentPrice, Date Month, Date PaidDate, boolean Status) throws Exception  {
	//		
	//		String query = "INSERT INTO `" + "Rent" + " (`RentPrice`, `Month`, `PaidDate`, `PaidStatus`)"
	//				+ "VALUES (NULL, ?, ?, ?, ? )";
	//		try {
	//			preparedStatement = con.prepareStatement( query );
	//			preparedStatement.setInt(1, RentPrice );
	//			preparedStatement.setDate(2, (java.sql.Date) Month );
	//			preparedStatement.setDate(3, (java.sql.Date) PaidDate);
	//			preparedStatement.setBoolean(4, Status );
	//			preparedStatement.executeUpdate();
	//
	//		} catch ( Exception e) {
	//			throw e;
	//		}
	//	}

	public void addRent(int RentPrice, Date Month, Date PaidDate, boolean Status) throws SQLException {
		sql ="INSERT INTO `\" + \"Rent\" + \" (`RentPrice`, `Month`, `PaidDate`, `PaidStatus`)\"\r\n" + 
				"//				+ \"VALUES (NULL, ?, ?, ?, ? )";
		//		sql = "Insert into vertex (name,latitude,longitude) " + "values('" + v.getName() + "', " + v.getLatitude()
		//				+ ", " + v.getLongitude() + ")";
		// System.out.println(sql);
		stmt = (Statement) con.createStatement();
		try {
		stmt.executeUpdate(sql);
		stmt.close();
		} catch (Exception e) {
			throw e;
		}
	}
	
}

