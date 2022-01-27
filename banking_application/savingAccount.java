package banking_application;

public class savingAccount extends account {
	
	
	public savingAccount(double bl, String accNm)
	{
		super(bl, accNm);
	}

	@Override
	public boolean withdraw(double amount) {
		if(amount <= bl)
		{
			bl = bl - amount;
			return true;
		} 
		else 
		{
			System.out.println("Not enough founds!");
			return false;
		}
	}

	@Override
	public String getDescription() {
		return "This is the saving account";
	}

}
