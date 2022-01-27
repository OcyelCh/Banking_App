package banking_application;

import java.time.LocalDate;

public class transaction {
	
	private String sendName;
	private String recName;
	private String sendAccn;
	private String recAccn;
	private double ammount;
	private LocalDate date;

	public transaction(String sendName, String recName, String sendAccn, String recAccn, double ammount)
	{
		this.sendName = sendName;
		this.recName = recName;
		this.sendAccn = sendAccn;
		this.recAccn = recAccn;
		this.ammount = ammount;
		date = LocalDate.now();
	}
	
	public transaction(String sendName, String sendAccn, double ammount)
	{
		this.sendName = sendName;
		this.ammount = ammount;
		this.recName = "yourself";
		this.sendAccn = "deposit";
		this.recAccn = sendAccn;
		date = LocalDate.now();
	}
	
	public String getNames()
	{
		return "Transaction from " + sendName + " to " + recName;
	}
	
	public String getAccounts()
	{
		return " With the next account numbers: from "+ sendAccn + " to " +recAccn; 
	}
	
	public String getTransferDescription()
	{
		return getNames() + getAccounts() + " $" + ammount + " at " + date;
	}
	
	
}
