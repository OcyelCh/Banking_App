package banking_application;

public abstract class account {
	
	protected double bl;
	protected String accNm;
	
	public account(double bl, String accNm)
	{
		this.bl = bl;
		this.accNm = accNm;
	}
	
	public double getBl()
	{
		return bl;
	}
	
	public String getAcn()
	
	{
		return accNm;
	}
	
	public void deposit_money(double amount)
	{
		bl = bl + amount;
	}
	
	@Override
	public String toString()
	{
		return "Account number: " + accNm + " " + getDescription() + ": Actually, the balance is: $"+ bl;
	}
	
	public abstract boolean withdraw(double amount);

	public abstract String getDescription();

}
