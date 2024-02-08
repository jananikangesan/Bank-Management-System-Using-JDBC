package com.cbc.bank.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cbc.bank.dao.CustomerDao;
import com.cbc.bank.model.Customer;
import com.cbc.bank.util.DBFactory;

public class CustomerDaoImpl implements CustomerDao{
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public Customer findByUsername(String username) {
		// TODO Auto-generated method stub
		
		Customer customer=null;
		try {
			con=DBFactory.getDBConnection();
			ps=con.prepareStatement(CustomerDao.FIND_USERNAME_QUERY);
			ps.setString(1, username);
			rs=ps.executeQuery();
			if(rs.next()) {
				customer=new Customer(rs.getInt(1), rs.getString(2), rs.getLong(3),rs.getString(4), rs.getString(5), rs.getFloat(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
		
	}

	@Override
	public boolean updatePassword(Customer customer) {
		boolean result=false;
		try {
			con=DBFactory.getDBConnection();
			ps=con.prepareStatement(CustomerDao.UPDATE_PASSWORD_QUERY);
			ps.setString(1,customer.getCustomerPassword()); 
			ps.setString(2, customer.getCustomerUsername());
			
			int r=ps.executeUpdate();
			
			if(r>0) {
				result=true;
				con.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			try {
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
		
		return result;
		
	}
	@Override
	public Customer findByAccount(int accountNo) {
		// TODO Auto-generated method stub
		Customer customer=null;
		try {
			con=DBFactory.getDBConnection();
			ps=con.prepareStatement(CustomerDao.FIND_ACCOUNT_QUERY);
			ps.setInt(1, accountNo);
			rs=ps.executeQuery();
			if(rs.next()) {
				customer=new Customer(rs.getInt(1), rs.getString(2), rs.getLong(3),rs.getString(4), rs.getString(5), rs.getFloat(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}
	
	@Override
	public boolean updateBalance(Customer customer) {
		// TODO Auto-generated method stub
		
		boolean result=false;
		try {
			con=DBFactory.getDBConnection();
			ps=con.prepareStatement(CustomerDao.UPDATE_BALANCE_QUERY);
			ps.setFloat(1,customer.getCustomerBalance()); 
			ps.setInt(2, customer.getCustomerId());
			
			int r=ps.executeUpdate();
			
			if(r>0) {
				result=true;
				con.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			try {
	            if (ps != null) {
	                ps.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
		
		return result;
	}


	@Override
	public boolean fundTransfer(Customer sender, Customer receiver, float amount) {
		// TODO Auto-generated method stub
		boolean result=false;
		float senderBalance=sender.getCustomerBalance()-amount;
		boolean updateSenderResult=false;
		boolean updateReceiverResult=false;
		if(senderBalance>0) {
			sender.setCustomerBalance(senderBalance);
			updateSenderResult=updateBalance(sender);
			float receiverBalance=receiver.getCustomerBalance()+amount;
			receiver.setCustomerBalance(receiverBalance);
			updateReceiverResult=updateBalance(receiver);
		}
		if(updateReceiverResult && updateSenderResult) {
			result=true;
		}
		
		return result;
	}


}
