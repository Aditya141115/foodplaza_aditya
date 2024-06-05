package conn.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import conn.foodplaza.pojo.Food;
import conn.foodplaza.utility.DBUtility;
import com.mysql.cj.xdevapi.Statement;
import java.util.ArrayList;

public class FoodDaoImpl implements FoodDao {
String query;
PreparedStatement ps;
Connection conn;
ResultSet rs;
Food f1 = new Food();
	@Override
	public boolean addFood(Food f) {
		// TODO Auto-generated method stub
		query = "insert into Food(foodName,foodCategory,foodType,foodPrice)values(?,?,?,?)";
		try {
			conn =DBUtility.establishConnection();
			ps =conn.prepareStatement(query);
			ps.setString(1,f.getFoodName());
			ps.setString(2,f.getFoodCategory());
			ps.setString(3, f.getFoodType());
			ps.setDouble(4,f.getFoodPrice());
		
		
		
		int row =ps.executeUpdate();
		if(row>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return true   ;
	}

	@Override
	public boolean updateFood(Food f) {
		// TODO Auto-generated method stub
		query="Update food Set foodName=?,foodCategory=?,foodType=?,foodPrice=? where foodId=?";
		try {
			conn =DBUtility.establishConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1,f.getFoodName());
			ps.setString(2,f.getFoodCategory());
			ps.setString(3, f.getFoodType());
			ps.setDouble(4,f.getFoodPrice());
			ps.setInt(5,f.getFoodId());
			int i =ps.executeUpdate();
			if(i>0)
			{
				return true;
				
			}else
			{
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}

	@Override
	public boolean deleteFood(int FoodId) {
		// TODO Auto-generated method stub

		query="delete from food where foodId=?";
		try
		{
			Connection conn=DBUtility. establishConnection();
	    	PreparedStatement ps=conn.prepareStatement(query);
	    	//ps.setInt(1, f1.getFoodId());
	    	ps.setInt(1, FoodId);
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
		return true;
	}
  
	@Override
	public Food displayFoodById(int foodId) {
		// TODO Auto-generated method stub
		query="SELECT * from food WHERE foodId=?";
		try
		{
			Connection conn=DBUtility. establishConnection();
	    	PreparedStatement ps=conn.prepareStatement(query);
	    	ps.setInt(1, foodId);
	    	ResultSet  rs = ps.executeQuery();
			while(rs.next())
			{
				f1.setFoodId(rs.getInt(1));
				f1.setFoodName(rs.getString(2));
				f1.setFoodCategory(rs.getString(3));
				f1.setFoodType(rs.getString(4));
				f1.setFoodPrice(rs.getDouble(5));
			}
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}


		return f1;
	}

	@Override
	public List<Food> displayAllFood() {
		// TODO Auto-generated method stub
		
	        query="select * from Food";
	       
			Connection conn;
			List<Food> foodList = new ArrayList<Food>();
			try {
				conn = DBUtility. establishConnection();
				java.sql.Statement st =  conn.createStatement();
				ResultSet  rs = st.executeQuery(query);
				
				while(rs.next())
				{
					Food f = new Food();
					f.setFoodId(rs.getInt(1));
					f.setFoodName(rs.getString(2));
					f.setFoodPrice(rs.getDouble(3));
					f.setFoodCategory(rs.getString(4));
					f.setFoodType(rs.getString(5));
					
					
					foodList.add(f);
				}
				
			} catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			return foodList;
		}
	}
		