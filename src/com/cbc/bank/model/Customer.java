package com.cbc.bank.model;

public class Customer {
		
		private int customerId;
		
		private String customerName;
		
		private long customerNumber;
		
		private String customerUsername;
		
		private String customerPassword;
		
		private float customerBalance;
		
		public Customer() {
		}

		public Customer(int customerId, String customerName, long customerNumber, String customerUsername,
				String customerPassword, float customerBalance) {
			this.customerId = customerId;
			this.customerName = customerName;
			this.customerNumber = customerNumber;
			this.customerUsername = customerUsername;
			this.customerPassword = customerPassword;
			this.customerBalance = customerBalance;
		}

		public int getCustomerId() {
			return customerId;
		}

		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public long getCustomerNumber() {
			return customerNumber;
		}

		public void setCustomerNumber(long customerNumber) {
			this.customerNumber = customerNumber;
		}

		public String getCustomerUsername() {
			return customerUsername;
		}

		public void setCustomerUsername(String customerUsername) {
			this.customerUsername = customerUsername;
		}

		public String getCustomerPassword() {
			return customerPassword;
		}

		public void setCustomerPassword(String customerPassword) {
			this.customerPassword = customerPassword;
		}

		public float getCustomerBalance() {
			return customerBalance;
		}

		public void setCustomerBalance(float customerBalance) {
			this.customerBalance = customerBalance;
		}

		@Override
		public String toString() {
			return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerNumber="
					+ customerNumber + ", customerUsername=" + customerUsername + ", customerPassword=" + customerPassword
					+ ", customerBalance=" + customerBalance + "]";
		}
				


}
