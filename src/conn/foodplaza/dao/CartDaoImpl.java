package conn.foodplaza.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import conn.foodplaza.pojo.Cart;
import conn.foodplaza.pojo.Customer;
import conn.foodplaza.utility.DBUtility;

public  class CartDaoImpl implements CartDao {
	String query;
	PreparedStatement ps;
	Connection conn;
	ResultSet rs;
	Cart c = new Cart();
	@Override
	
	public boolean addCart(Cart c) {
		// TODO Auto-generated method stub
		String foodIdQuery="select foodId,foodPrice from food where foodName=?";
		query = "insert into Cart(foodQty,customerEmailId,foodId,foodPrice,foodName) values(?,?,?,?,?) ";
		
		try
		 {	Connection conn=DBUtility. establishConnection();
		    	PreparedStatement ps=conn.prepareStatement(foodIdQuery);
		    	ps.setString(1,c.getFoodName());
				ResultSet rs=ps.executeQuery();
				if(rs.next())

				{
					int foodId=rs.getInt(1);
					Double foodPrice=rs.getDouble(2);
					ps=conn.prepareStatement(query);
					ps.setDouble(1, c.getFoodQty());
					ps.setString(2, c.getCustomerEmailId());
					ps.setInt(3, foodId);
					ps.setDouble(4, foodPrice);
					ps.setString(5, c.getFoodName());
				int row=ps.executeUpdate();
		    	if(row>0)
		    	{
		    	     return true;
		    	}
		    	else
		    	{
		    		return false;
		    	}
		      }
				else
				{
					System.out.println("Entered Food not available");
				}
		    }
		    catch(ClassNotFoundException e)
		    {
		    	e.printStackTrace(); 
		    }
		    catch(SQLException e)
		    {
		    	e.printStackTrace();
		    }
			return true;
		}

	
		@Override
		
		public List<Cart> showCart(String customerEmailId) 
		{
			query="select f.foodName,f.foodPrice,c.foodQty from food AS f INNER "
					+ "JOIN cart AS c where f.foodId = c.foodId and c.customerEmailId=?";
			
				List<Cart> CartList = new ArrayList<Cart>();
				try 
				{

					conn = DBUtility. establishConnection();
					ps=conn.prepareStatement(query);
					ps.setString(1,customerEmailId);
					ResultSet  rs = ps.executeQuery();
					while(rs.next())
					{
						Cart ct=new Cart();
						ct.setFoodName(rs.getString(1));
						ct.setFoodPrice(rs.getDouble(2));
						ct.setFoodQty(rs.getDouble(3));
						CartList.add(ct);
					}
					return CartList;
				}
				catch (ClassNotFoundException | SQLException e) 
				{
					e.printStackTrace();
				}
				return CartList;
		}

		@Override
		
		public boolean deletetoCart(int CartId) {
			
		
			query="delete from Cart where CartId=?";
			try
		    {
		    	 conn=DBUtility. establishConnection();
		    	 ps=conn.prepareStatement(query);
		    	ps.setInt(1,  CartId);
		    	int row =ps.executeUpdate();
		    	if(row>0)
		    	{
		    	     return true;
		    	}
		    	else
		    	{
		    		return false;
		    	}
		    }
		    catch(ClassNotFoundException e)
		    {
		    	e.printStackTrace(); 
		    }
		    catch(SQLException e)
		    {
		    	e.printStackTrace();
		    }
			return false;
		}


		



}

	



