package conn.foodplaza.dao;

import conn.foodplaza.pojo.Cart;
import conn.foodplaza.pojo.Customer;

import java.util.List;
public interface CartDao {

	boolean addCart(Cart c);
	//boolean showCart(Cart c);
	List<Cart> showCart(String customerEmailId);
	boolean deletetoCart(int CartId);
}
