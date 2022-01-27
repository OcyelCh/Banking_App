package banking_application;

import java.util.ArrayList;

public class bank_class {
	
	private ArrayList<customer> customers;

	public bank_class() {
		customers = new ArrayList<customer>();
	}
	
	public void newCustomer(int id, String n, String m, String e, String p)
	{
		customers.add(new customer(id,n,m,e,p));
	}
	
	public int numberOfCus()
	{
		return customers.size();
	}
	
	
	public customer getCustomer(int customer_id)
	{
		return customers.get(customer_id);
	}

}
