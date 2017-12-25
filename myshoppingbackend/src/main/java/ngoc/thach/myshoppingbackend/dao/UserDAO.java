package ngoc.thach.myshoppingbackend.dao;

import java.util.List;

import ngoc.thach.myshoppingbackend.dto.Address;
import ngoc.thach.myshoppingbackend.dto.Cart;
import ngoc.thach.myshoppingbackend.dto.User;

public interface UserDAO {
	//add an user
	boolean addUser(User user);
	
	User getByEmail(String email);
	
	//add an address
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);
	
	//add a cart
	boolean updateCart(Cart cart);
}
