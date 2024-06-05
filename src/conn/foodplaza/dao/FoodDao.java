package conn.foodplaza.dao;
import java.util.List;
import conn.foodplaza.pojo.*;
public interface FoodDao {
	//addFood,updateFood,deleteFood,displayFoodById,displayAllFood
boolean addFood(Food f);
boolean updateFood(Food f);
boolean deleteFood(int FoodId);
Food displayFoodById(int foodId);
List<Food>displayAllFood();

}
