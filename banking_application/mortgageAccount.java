package banking_application;

public class mortgageAccount extends account {
	
	private final double overDraftLimit;

	public mortgageAccount(double bl, String accNm) {
		this(bl,0,accNm);
	}
	
	public mortgageAccount(double bl, double overDraftLimit, String accNm)
	{
		super(bl,accNm);
		this.overDraftLimit = overDraftLimit;
	}

	@Override
	public boolean withdraw(double amount) {
		if(amount <= bl + overDraftLimit)
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
		return "This is the mortgage account";
	}

}
