package conn.foodplaza.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import conn.foodplaza.pojo.Order;
import conn.foodplaza.pojo.Customer;
import conn.foodplaza.utility.DBUtility;
 
public class OrderDaoImpl  implements OrderDao{
	String query;
    Connection conn;
	PreparedStatement ps;
	@Override
	public boolean placeOrder(String customerEmailId)
	{

		double totalBill = 0;
		String OrderDate = new Date().toString();
		try {
			Connection con = DBUtility.establishConnection();
			String foodNameQuery = "SELECT foodName FROM Cart WHERE customerEmailId = ?";
	        // Calculate totalBill
	        String querytotalBill = "SELECT SUM(f.foodPrice * c.foodQty) AS totalBill " +
	                "FROM food AS f INNER JOIN Cart AS c ON f.foodId = c.foodId " +
	                "WHERE customerEmailId = ?";
	        ps = con.prepareStatement(foodNameQuery);
	         ps.setString(1, customerEmailId);
	         ResultSet rs = ps.executeQuery();
	         
	         if(rs.next())
	         {
	        	 String foodName = rs.getString(1);
	        
	        try (PreparedStatement pstotalBill = con.prepareStatement(querytotalBill)) {
	            pstotalBill.setString(1, customerEmailId);
	            try (ResultSet rstotalBill = pstotalBill.executeQuery()) {
	                if (rstotalBill.next()) {
	                    totalBill = rstotalBill.getDouble("TotalBill");
	                }
	            }
	        }
	        String queryInsertOrder = "INSERT INTO  Order1(totalBill,customer_EmailId, orderDate,foodName) VALUES (?,?,?,?)";
	        try (PreparedStatement psInsertOrder = con.prepareStatement(queryInsertOrder)) {
	            psInsertOrder.setDouble(1, totalBill);
	            //psInsertOrder.setDouble(2, totalBill);
	            psInsertOrder.setString(2, customerEmailId);
	            psInsertOrder.setString(3, OrderDate);
	            psInsertOrder.setString(4, foodName);
	            int row = psInsertOrder.executeUpdate();
	            return row > 0;
	        }
	     catch (SQLException e) {
	        e.printStackTrace(); // Consider logging the exception instead
	    }
	    }
	    return false;
	    } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return false;
	}
	@Override
	public List<Order> showOrder() {
		// TODO Auto-generated method 
		query="select * from  Order1";
		 Connection conn;
			ArrayList<Order> OrderList = new ArrayList<Order>();
			try 
			{
				conn = DBUtility. establishConnection();
				ps=conn.prepareStatement(query);
				//Statement st =  conn.createStatement();
				ResultSet  rs = ps.executeQuery();

				while(rs.next())
				{
					Order o = new Order();
					o.setOrderId(rs.getInt(1));
					o.setFoodName(rs.getString(2));
					o.setTotalBill(rs.getDouble(3));
					o.setCustomer_EmailId(rs.getString(4));
					o.setOrderDate(rs.getString(5));
					OrderList.add(o);
				}
			}
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
					
		return OrderList;

		
	}

}
