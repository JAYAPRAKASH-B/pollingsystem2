package pollingsystem;

import java.sql.*;

public class Dbconnection {
	
	public static Connection con;
	
public Connection connectDb() {
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pollingsystem","root","10decoders");
	}catch(Exception e) {
		System.out.println(e);
}
	return con;
}

}