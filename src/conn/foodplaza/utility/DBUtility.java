package conn.foodplaza.utility;
import java.sql.*;
public class DBUtility {
public static Connection establishConnection() throws SQLException,ClassNotFoundException
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodplaza_aditya","root","root");
return conn;
}
}
