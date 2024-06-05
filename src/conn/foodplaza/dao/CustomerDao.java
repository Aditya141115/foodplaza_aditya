package conn.foodplaza.dao;

import java.util.List;
import conn.foodplaza.pojo.Customer;

public interface CustomerDao {
	boolean addCustomer(Customer c);
	boolean updateCustomer(Customer c);
	boolean deleteCustomer(int customerId);
	Customer displayCustomerById(int customerId);
	List<Customer>displayAllCustomer();


}
