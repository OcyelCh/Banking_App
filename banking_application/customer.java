package banking_application;

import java.util.ArrayList;

public class customer {

	private String names;
	private int customerId;
	private String mobileNo;
	private String emailId;
	private String password;
	private ArrayList<account> accounts_from_customer;
	private ArrayList<transaction> transactions;
	
	public customer(int customerId, String names, String mobile, String email, String password)
	{
		this.customerId=customerId;
		this.names=names;
		this.mobileNo=mobile;
		this.emailId=email;
		this.password=password;
		accounts_from_customer = new ArrayList<account>();
		transactions = new ArrayList<transaction>();
	}
	
	public String getNames()
	{
		return names;
	}
	
	public String getMobile()
	{
		return mobileNo;
	}
	
	public String getEmail()
	{
		return emailId;
	}
	
	public int getCustomerId()
	{
		return customerId;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void addAcc(account acc)
	{
		accounts_from_customer.add(acc);
	}
	
	public void addTran(transaction tran)
	{
		transactions.add(tran);
	}
	
	public int numAcc()
	{
		return accounts_from_customer.size();
	}
	
	public account getAccInfo(int ind)
	{
		return accounts_from_customer.get(ind);
	}
	
	public transaction getTranInfo(int ind)
	{
		return transactions.get(ind);
	}
}
