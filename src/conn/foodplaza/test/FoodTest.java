package conn.foodplaza.test;
import java.util.Scanner;
import conn.foodplaza.dao.FoodDaoImpl;
import conn.foodplaza.pojo.Food;
public class FoodTest {
public static void main(String[] args) {
	int choice;
	int foodId;
	String foodName,foodCategory,foodType;
	double foodPrice;
	Food f = new Food();
	Food f1=new Food();
	FoodDaoImpl fd = new FoodDaoImpl();
	do
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Add Food\n2.Update Food\n3.Delete Food\n4.DisplayFoodById\n5.DisplayAllFood\n6.Exit ");
		System.out.println("Enter Your Choice:");
	choice= sc.nextInt();
	switch (choice)
	{
	case 1:
		System.out.println("Enter Food Name:");
		foodName=sc.next();
		System.out.println("Enter Food Category:");
		foodCategory = sc.next();
		System.out.println("Enter Food Type:");
		foodType= sc.next();
		System.out.println("Enter Food Price:");
		foodPrice=sc.nextDouble();
		//Food f = new Food();
		f.setFoodName(foodName);
		f.setFoodCategory(foodCategory);
		f.setFoodType(foodType);
		f.setFoodPrice(foodPrice);
	//FoodDaoImpl fd = new FoodDaoImpl();
	boolean flag = fd.addFood(f);
	if(flag==true)
	{
		System.out.println("Food Added...");
	}
	else
	{
		System.out.println("Food Adding Failed...");
	}
		break;
	case 2:
		System.out.println("Enter FoodId to Update Food:");
		foodId=sc.nextInt();
		System.out.println("Enter Updated Food Name:");
		foodName=sc.next();
		System.out.println("Enter Updated Food Category:");
		foodCategory = sc.next();
		System.out.println("Enter Updated  Food Type:");
		foodType= sc.next();
		System.out.println("Enter Updated Food Price:");
		foodPrice=sc.nextDouble();
		//Food f = new Food();
		f.setFoodId(foodId);
		f.setFoodName(foodName);
		f.setFoodCategory(foodCategory);
		f.setFoodType(foodType);
		f.setFoodPrice(foodPrice);
		boolean flag1 = fd.updateFood(f);
		if(flag1==true)
		{
			System.out.println("Food Updated...");
		}
		else
		{
			System.out.println("Food Updated Failed...");
		}
		
	
		break;
	case 3:
		System.out.println("Enter foodId to delete Food:");
		foodId=sc.nextInt();
		f1.setFoodId(foodId);
		boolean flag2 = fd.deleteFood(foodId);
		if(flag2==true)
		{
			System.out.println("Food Deleted...");
		}
		else
		{
			System.out.println("Food Deletion Failed...");
		}
		
		break;
	case 4:
		System.out.println("Enter foodId to Display Food:");
		foodId=sc.nextInt();
		f1.setFoodId(foodId);
	f= fd.displayFoodById(foodId);
	System.out.println(f.getFoodId()+""+ f.getFoodName()+""+f.getFoodCategory()+""+f.getFoodType()+""+f.getFoodPrice());
		break;
	case 5:
		
		break;
	case 6:
		break;
		default:
			
	}
	}while(choice<6);
}
}
