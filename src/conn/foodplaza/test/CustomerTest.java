package conn.foodplaza.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import conn.foodplaza.dao.CustomerDaoImpl;
import conn.foodplaza.pojo.Customer;

public class CustomerTest {
	public static void main(String[] args) {
		int choice,customerId;
		Long customerContact;
		String customerName,customerAddress,customerEmailId,customerPassword;
		
		Customer c = new Customer();
		CustomerDaoImpl cd = new CustomerDaoImpl();
		do
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("1.Add Customer\n2.Update Customer\n3.Delete Customer\n4.DisplayCustomerById\n5.DisplayAllCustomer\n6.Exit ");
			System.out.println("Enter Your Choice:");
		choice= sc.nextInt();
		switch (choice)
		
		{
		case 1:
			System.out.println("Enter Customer Name: ");
			customerName = sc.next();
			System.out.println("Enter Customer Contact: ");
			customerContact = sc.nextLong();
			System.out.println("Enter Customer Address: ");
			customerAddress = sc.next();
			System.out.println("Enter EmailId:");
			customerEmailId = sc.next();
			System.out.println("Enter Password: ");
			customerPassword = sc.next();
			
			c.setCustomerName(customerName);
			c.setCustomerContact(customerContact);
			c.setCustomerAddress(customerAddress);
			c.setCustomerEmailId(customerEmailId);
			c.setCustomerPassword(customerPassword);
			boolean flag = cd.addCustomer(c);
			if(flag==true)
			{
				System.out.println("Customer Added...");
			}
			else
			{
				System.out.println("Customer Adding Failed...");
			}
			
			break;
			
		case 2:
			System.out.println("Enter the customer id");
			customerId=sc.nextInt();
			System.out.println("Enter the customer name");
			customerName=sc.next();
			System.out.println("Enter the customer contact");
			customerContact=sc.nextLong();
			System.out.println("Enter the customer address");
			customerAddress=sc.next();
			System.out.println("Enter the customer emailid");
			customerEmailId=sc.next();
			System.out.println("Enter the customer password");
			customerPassword=sc.next();
			c.setCustomerName(customerName);
			c.setCustomerContact(customerContact);
			c.setCustomerAddress(customerAddress);
			c.setCustomerEmailId(customerEmailId);
			c.setCustomerPassword(customerPassword);
			c.setCustomerId(customerId);
			boolean flag2=cd.updateCustomer(c);
			if(flag2==true)
			{
				System.out.println("Customer update  successfully");
			}
			else
			{
				System.out.println("Customer not Update successfully");
			}
			

			break;
			
		case 3:
			System.out.println("Enter the customer id");
			customerId=sc.nextInt();
			c.setCustomerId(customerId);
			boolean flag3=cd.deleteCustomer(customerId);
			if(flag3==true)
			{
				System.out.println("Customer Delete successfully");
			}
			else
			{
				System.out.println("Customer Not Delete successfully");
			}

			break;	
			
		case 4:
			System.out.println("Enter the customer id");
			customerId=sc.nextInt();
			c.setCustomerId(customerId);
			c = cd.displayCustomerById(customerId);
			System.out.println(c.getCustomerId()+" "+c.getCustomerName()+" "+c.getCustomerContact()+" "+c.getCustomerAddress()+" "+c.getCustomerEmailId()+" "+c.getCustomerPassword());

			break;
			
		case 5:
			List<Customer> c1 = new ArrayList<Customer>();
			c1 = cd.displayAllCustomer();
			for(Customer customer : c1)
			{
				System.out.println(customer.getCustomerId()+" "+customer.getCustomerName()+" "+customer.getCustomerContact()+" "+customer.getCustomerAddress()+" "+customer.getCustomerEmailId()+" "+customer.getCustomerPassword());
			}

			
			
		case 6:
			System.out.println("Exit");

			break;	
		default:
			System.out.println("Enter the invalid choice[1-6]");
			break;

		}
		}while(choice<6);
	}
}
