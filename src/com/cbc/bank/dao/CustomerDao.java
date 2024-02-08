package com.cbc.bank.dao;

import com.cbc.bank.model.Customer;

public interface CustomerDao {

	public static String FIND_USERNAME_QUERY = "SELECT * FROM cbc_customer_table WHERE username=?";

	public static String UPDATE_PASSWORD_QUERY="UPDATE cbc_customer_table SET password=? WHERE username=?";
	
	public static String FIND_ACCOUNT_QUERY="SELECT * FROM cbc_customer_table WHERE account_number=?";
	
	public static String UPDATE_BALANCE_QUERY="UPDATE cbc_customer_table SET balance=? WHERE account_number=?";
	
	public boolean updatePassword(Customer customer);
	
	public Customer findByUsername(String username);
	
	public boolean fundTransfer(Customer sender, Customer receiver,float amount);
	
	public  Customer findByAccount(int accountNo);
	
	public boolean updateBalance(Customer customer);

}
