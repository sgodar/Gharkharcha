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
//import com.mysql.jdbc.Connection;
//import lib.mysql.jdbc.Gharkharcha;

//import week2.main.Vertex;
public class Database {
	// connection string
	String url = "jdbc:mysql://localhost:3306/gharkharcha";
	String username = "root";
	String password = "root";
	String sql = "";
	private PreparedStatement preparedStatement = null;
	
	Connection con;
	
	public Database() throws SQLException {
		con = (Connection) DriverManager.getConnection(url, username, password);

	}
	public void addRent( int RentPrice, Date Month, Date PaidDate, boolean Status) throws Exception  {
		String query = "INSERT INTO `" + "Rent" + " (`RentPrice`, `Month`, `PaidDate`, `PaidStatus`)"
				      + "VALUES (NULL, ?, ?, ?, ? )";
		try {
			preparedStatement = con.prepareStatement( query );
			preparedStatement.setInt(1, RentPrice );
			preparedStatement.setDate(2, (java.sql.Date) Month );
			preparedStatement.setDate(3, (java.sql.Date) PaidDate);
			preparedStatement.setBoolean(4, Status );
			preparedStatement.executeUpdate();

		} catch ( Exception e) {
			throw e;
		}
	}
//	try {
//		// 1. get the connection object
//		con = (Connection) DriverManager.getConnection(url, username, password);
//		// 2. prepare sql string
//		sql = "SELECT * FROM vertex";
//		// 3. prepare sql statement to be executed
//		stmt = (Statement) con.createStatement();
//		// 4 get the resultset from execution
//		rs = stmt.executeQuery(sql);
//		/*
//		 * use rs.get... to get the data from result rs. next check if there is data on
//		 * next row also automatically moves the cursor to next row of data
//		 */
//		while (rs.next()) {
//			
//			  System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+
//			  rs.getDouble(3)+" "+rs.getDouble(4));
//			 
//
//			/*
//			 * int id = rs.getInt(1); String name = rs.getString(2); double latitude =
//			 * rs.getDouble(3); double longitude = rs.getDouble(4); v = new Vertex(id, name,
//			 * latitude, longitude); vList.add(v);
//			 */
//
//		}
//		/*
//		 * for(Vertex v1:vList) { System.out.println(v1); }
//		 */
//
//	} catch (SQLException e7) {
//		// TODO Auto-generated catch block
//		System.out.println(e7.getMessage());
//	}



}

