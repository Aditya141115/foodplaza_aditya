//cartId, foodId,foodName, foodPrice, foodQty

//addToCart, updateCart, deleteCart, displayCart, displayAllCart - Customer, 
package conn.foodplaza.test;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import conn.foodplaza.dao.CartDaoImpl;
import conn.foodplaza.pojo.Cart;
public class Carttest {
	public static void main(String[] args) {
	
	 int cartId,foodId,choice;
		String customerEmailId,foodName;
		double foodPrice,foodQty;
		Cart c = new Cart();
		CartDaoImpl cd = new CartDaoImpl();
		do
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("1.Add to Cart\n2.Show Cart\n3.Delete Cart\n4.Exit ");
			System.out.println("Enter Your Choice:");
		choice= sc.nextInt();
		switch (choice)
		{
		case 1:
			System.out.println("Enter CustomerEmailId:");
			customerEmailId=sc.next();
			System.out.println("Enter foodName:");
			foodName=sc.next();
			System.out.println("Enter foodQty:");
			foodQty=sc.nextDouble();
			
			
			c.setCustomerEmailId(customerEmailId);
			c.setFoodName(foodName);
			c.setFoodQty(foodQty);
			
			boolean flag = cd.addCart(c);
			if(flag==true)
			{
				System.out.println("Item  Added to Cart..");
			}
			else
			{
				System.out.println("Item Adding Failed to Cart...");
			}
			break;
		case 2:
			List<Cart> ct = new ArrayList<Cart>();
			System.out.println("Enter your emailId:");
			customerEmailId = sc.next();
			ct = cd.showCart(customerEmailId);
			for(Cart cart : ct)
			{
				System.out.println(" "+cart.getFoodQty()+" "+cart.getFoodName()+" "+cart.getFoodPrice());
			}

				
			
			
			break;
		case 3:System.out.println("Enter the CartId");
		cartId=sc.nextInt();
		c.setCartId(cartId);
		boolean flag1=cd.deletetoCart(cartId);
		if(flag1==true)
		{
			System.out.println("Cart Delete successfully");
		}
		else
		{
			System.out.println("Cart Not Delete successfully");
		}
        break;
	case 4:
		System.out.println("Exit");
		break;
	default:
		System.out.println("Enter the invalid choice[1-4]");
		break;
	}
}while(choice<4);
}
}

