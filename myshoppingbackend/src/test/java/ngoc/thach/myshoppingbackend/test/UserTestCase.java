package ngoc.thach.myshoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ngoc.thach.myshoppingbackend.dao.UserDAO;
import ngoc.thach.myshoppingbackend.dto.Address;
import ngoc.thach.myshoppingbackend.dto.Cart;
import ngoc.thach.myshoppingbackend.dto.User;

public class UserTestCase {
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("ngoc.thach.myshoppingbackend");
		context.refresh();
		
		userDAO = (UserDAO)context.getBean("userDAO");
	}
//	@Test
//	public void testAdd() {
//		user = new User();
//		user.setFirstName("Hrithik");
//		user.setLastName("Roshan");
//		user.setEmail("hr@gmail.com");
//		user.setContactNumber("1234512345");
//		user.setRole("USER");
//		user.setPassword("123456");
//		
//		//add the user
//		assertEquals("Failed to add user",true, userDAO.addUser(user));
//		
//		address = new Address();
//		address.setAddressLineOne("101/B Jaoo Society, Kressh Nager");
//		address.setAddressLineTwo("Near Kaabil Store");
//		address.setCity("Mumbai");
//		address.setState("Maharahtra");
//		address.setCountry("India");
//		address.setPostalCode("400001");
//		address.setBilling(true);
//		//link the user with address use user id
//		address.setUserId(user.getId());
//		//add the address
//		assertEquals("Failed to add address",true, userDAO.addAddress(address));
//		
//		if(user.getRole().equals("USER")) {
//			//create the cart for this user
//			cart =  new Cart();
//			cart.setUser(user);
//			//add the cart
//			assertEquals("Failed to add cart",true, userDAO.addCart(cart));
//			//add a shipping address for this user;
//			address = new Address();
//			address.setAddressLineOne("201/B Jaoo Society, Kressh Nager");
//			address.setAddressLineTwo("Near Kaabil Store");
//			address.setCity("Mumbai");
//			address.setState("Maharahtra");
//			address.setCountry("India");
//			address.setPostalCode("400001");
//			address.setShipping(true);
//			//link it with user;
//			address.setUserId(user.getId());
//			//add shipping address
//			assertEquals("Failed to add shipping address",true, userDAO.addAddress(address));
//			
//		}
//	
//	}
//	@Test
//	public void testAdd() {
//		user = new User();
//		user.setFirstName("Hrithik");
//		user.setLastName("Roshan");
//		user.setEmail("hr@gmail.com");
//		user.setContactNumber("1234512345");
//		user.setRole("USER");
//		user.setPassword("123456");
//		
//		
//		if(user.getRole().equals("USER")) {
//			//create the cart for this user
//			cart =  new Cart();
//			cart.setUser(user);
//			//attach cart with user
//			user.setCart(cart);
//			
//			
//		}
//		assertEquals("Failed to add user",true, userDAO.addUser(user));
//	
//	}
	
//	@Test
//	public void testUpdateCart() {
//		user = userDAO.getByEmail("hr@gmail.com");
//		cart = user.getCart();
//		cart.setGrandTotal(5555);
//		cart.setCartLines(2);
//		assertEquals("Failed to update the cart", true,userDAO.updateCart(cart) );
//	}
	
//	@Test
//	public void testAddAdress() {
//		
//		//we are going to create a new user
//		user = new User();
//		user.setFirstName("Hrithik");
//		user.setLastName("Roshan");
//		user.setEmail("hr@gmail.com");
//		user.setContactNumber("1234512345");
//		user.setRole("USER");
//		user.setPassword("123456");
//		//add the user
//		assertEquals("Failed to add user",true, userDAO.addUser(user));
//		
//		//we are going to create a address
//		address = new Address();
//		address.setAddressLineOne("101/B Jaoo Society, Kressh Nager");
//		address.setAddressLineTwo("Near Kaabil Store");
//		address.setCity("Mumbai");
//		address.setState("Maharahtra");
//		address.setCountry("India");
//		address.setPostalCode("400001");
//		address.setBilling(true);
//		//attached the user to the address
//		address.setUser(user);
//		
//		//add the address
//		assertEquals("Failed to add billing address",true, userDAO.addAddress(address));
//		
//		//we are going to create a shipping address
//		address = new Address();
//		address.setAddressLineOne("201/B Jaoo Society, Kressh Nager");
//		address.setAddressLineTwo("Near Kaabil Store");
//		address.setCity("Mumbai");
//		address.setState("Maharahtra");
//		address.setCountry("India");
//		address.setPostalCode("400001");
//		address.setShipping(true);
//		//attached the user to address
//		address.setUser(user);
//		//add shipping address
//		assertEquals("Failed to add shipping address",true, userDAO.addAddress(address));
//	}
//	@Test
//	public void testAddAdress() {
//		user = userDAO.getByEmail("hr@gmail.com");
//		//we are going to create a shipping address
//		address = new Address();
//		address.setAddressLineOne("301/B Jaoo Society, Kressh Nager");
//		address.setAddressLineTwo("Near Kaabil Store");
//		address.setCity("Bangalore");
//		address.setState("Kanatarka");
//		address.setCountry("India");
//		address.setPostalCode("400001");
//		address.setShipping(true);
//		//attached the user to address
//		address.setUser(user);
//		//add shipping address
//		assertEquals("Failed to add shipping address",true, userDAO.addAddress(address));
//		
//	}
	@Test
	public void testGetAddress() {
		user =  userDAO.getByEmail("hr@gmail.com");
		assertEquals("Failed to fetch the list of address and size doesn't match", 2, userDAO.listShippingAddresses(user).size());
		assertEquals("Failed to fetch the list billing of address and size doesn't match", "Mumbai", userDAO.getBillingAddress(user).getCity());
	}
	
}
