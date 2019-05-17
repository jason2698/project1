package Firstproject.eshop.Dao;

import Firstproject.eshop.Model.Customer;

public interface CustomerDAO {

	
	void registerCustomer(Customer customer);
	boolean isEmailUnique(String email);
}
