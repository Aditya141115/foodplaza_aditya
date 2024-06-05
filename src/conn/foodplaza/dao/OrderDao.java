package conn.foodplaza.dao;
import java.util.List;
import conn.foodplaza.pojo.*;
public interface OrderDao {
	boolean placeOrder(String customerEmailId);

	List<Order> showOrder() ;

}
