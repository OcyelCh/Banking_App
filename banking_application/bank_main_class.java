package banking_application;

import java.util.*;

public class bank_main_class {
	
	public static Scanner r=new Scanner(System.in);

	public static void main(String[] args) 
	{
		
		usersInterface();

	}
	
	
	private static void usersInterface()
	{
		bank_class bank=new bank_class();
		customer cust;
		int x=0, id=0;
		do
		{
			System.out.println("Please, select an option:");
			System.out.println("1.- Register");
			System.out.println("2.- Login");
			System.out.println("3.- Exit");
			x=r.nextInt();
			switch(x) 
			{
			case(1):
				System.out.println("What's your name");
				r.nextLine();
				String n = r.nextLine();
				System.out.println("Introduce a mobile number");
				//r.nextLine();
				String m = r.nextLine();
				System.out.println("Please, introduce your e-mail");
				//r.nextLine();
				String e = r.nextLine();
				System.out.println("Please, introduce your password");
				//r.nextLine();
				String p = r.nextLine();
				id = bank.numberOfCus();
				bank.newCustomer(id,n,m,e,p);
				cust = bank.getCustomer(id);
				System.out.println("What kind of account will you have?");
				System.out.println("1.- Saving account");
				System.out.println("2.- Current account");
				System.out.println("3.- Mortgage account");
				int i = r.nextInt();
				System.out.println("How much money will you ingress to the account (you can put 0 and add founds later)?");
				Double ammount = r.nextDouble();
				int accnumber;
				String accNum="";
				switch(i)
				{
				
				case(1): accnumber = (int)((Math.random() * (10000-1000))+1000);
						 accNum ="1"+ String.valueOf(accnumber);
						 cust.addAcc(new savingAccount(ammount,accNum));
						 cust.addTran(new transaction(n, accNum,ammount));
						 break;
						 
				case(2): accnumber = (int)((Math.random() * (10000-1000))+1000);
				 		 accNum ="2"+ String.valueOf(accnumber);
						 cust.addAcc(new currentAccount(ammount,accNum));
						 cust.addTran(new transaction(n, accNum,ammount));
				 		 break;
				 		 
				case(3): accnumber = (int)((Math.random() * (10000-1000))+1000);
				 		 accNum ="3"+ String.valueOf(accnumber);
						 cust.addAcc(new mortgageAccount(ammount,accNum));
						 cust.addTran(new transaction(n, accNum,ammount));
		 		 		 break;
		 		 		 
				}
				System.out.println("New customer added");
				System.out.println();
				break;
				
			case(2):
				System.out.println("Please, introduce your name:");
				r.nextLine();
				String n1=r.nextLine();
				System.out.println("Please, introduce your password");
				String p1=r.nextLine();
				for(int y=0; y<bank.numberOfCus();y++)
					{
						cust = bank.getCustomer(y);
						if((cust.getNames().equals(n1))&&(cust.getPassword().equals(p1)))
						{
							int op;
							do
							{
								System.out.println("Welcome! What do you want to do today?");
								System.out.println("Please, select an option:");
								System.out.println("1.- Check balance from every account");
								System.out.println("2.- Add an account");
								System.out.println("3.- Update balance");
								System.out.println("4.- Make a transaction");
								System.out.println("5.- List transactions");
								System.out.println("6.- Exit");
								op=r.nextInt();
								switch(op)
								{
								case(1):
									for( int l=0; l<cust.numAcc();l++)
									{
										account acc = cust.getAccInfo(l);
										System.out.println(" "+acc);
									}
									System.out.println();
									break;
									
								case(2):
									System.out.println("Select the account you want to create");
									System.out.println("1.- Saving account");
									System.out.println("2.- Current account");
									System.out.println("3.- Mortgage account");
									int ac = r.nextInt();
									Double ammount1;
									String wea;
									String wea2;
									int l=0;
									switch(ac)
									{
									case(1): 
										do
										{
											account acc = cust.getAccInfo(l);
											wea=acc.getAcn();
											if((wea.charAt(0))=='1')
											{
												System.out.println("Already exists a saving account!");
												break;
											}
											else if(l<cust.numAcc()-1)
												l++;
											else
											{	
												 System.out.println("How much money will you ingress to the account (you can put 0 and add founds later)?");
												 ammount1 = r.nextDouble();
												 accnumber = (int)((Math.random() * (10000-1000))+1000);
								 		 		 accNum ="1"+ String.valueOf(accnumber);
								 		 		 cust.addAcc(new savingAccount(ammount1, accNum));
								 		 		 cust.addTran(new transaction(cust.getNames(), accNum,ammount1));
								 		 		 System.out.println("Account added!");
								 		 		 break;
											}
										}while(l<cust.numAcc());
										System.out.println();
										break;
									case(2): 										
										do
										{
											account acc = cust.getAccInfo(l);
											wea=acc.getAcn();
											if((wea.charAt(0))=='2')
											{
												System.out.println("Already exists a current account!");
												break;
											}
											else if(l<cust.numAcc()-1)
												l++;
											else
											{	
												System.out.println("How much money will you ingress to the account (you can put 0 and add founds later)?");
												ammount1 = r.nextDouble();
												accnumber = (int)((Math.random() * (10000-1000))+1000);
												accNum ="2"+ String.valueOf(accnumber);
												cust.addAcc(new currentAccount(ammount1, accNum));
												cust.addTran(new transaction(cust.getNames(), accNum,ammount1));
												System.out.println("Account added!");
												break;
											}
										}while(l<cust.numAcc());
										System.out.println();
										break;
									case(3): 										
										do
										{
											account acc = cust.getAccInfo(l);
											wea=acc.getAcn();
											if((wea.charAt(0))=='3')
											{
												System.out.println("Already exists a mortgage account!");
												break;
											}
											else if(l<cust.numAcc()-1)
												l++;
											else
											{	
												System.out.println("How much money will you ingress to the account (you can put 0 and add founds later)?");
												ammount1 = r.nextDouble();
												accnumber = (int)((Math.random() * (10000-1000))+1000);
												accNum ="3"+ String.valueOf(accnumber);
												cust.addAcc(new mortgageAccount(ammount1, accNum));
												cust.addTran(new transaction(cust.getNames(), accNum,ammount1));
												System.out.println("Account added!");
												break;
											}
										}while(l<cust.numAcc());
										System.out.println();
										break;
									}
									break;
								case(3):
									System.out.println("Do you want to add founds or make a withdrawal?");
									System.out.println("1.- Add founds");
									System.out.println("2.- Make a withdrawal");
									int ac2 = r.nextInt();
									int l1=0;
									switch(ac2)
									{
									case(1): System.out.println("To wich account you want to add founds?");
											 System.out.println("1 .- Saving account");
											 System.out.println("2 .- Current account");
											 System.out.println("3 .- Mortgage account");
											 int op1 = r.nextInt();
											 System.out.println("How much money you want to add?");
											 double money = r.nextDouble();
											 switch(op1)
											 {
											 case(1):
												 do
												{
													account acc = cust.getAccInfo(l1);
													wea=acc.getAcn();
													if((wea.charAt(0))=='1')
													{
														acc.deposit_money(money);
														cust.addTran(new transaction(cust.getNames(), wea, money));
														System.out.println("Founds added!");
														break;
													}
													else if(l1<cust.numAcc()-1)
														l1++;
													else
													{	System.out.println("We cannot find this type of account for this user");
										 		 		 break;
													}
												}while(l1<cust.numAcc());
											 	System.out.println();
											 	break;
											 case(2):
												 do
												{
													account acc = cust.getAccInfo(l1);
													wea=acc.getAcn();
													if((wea.charAt(0))=='2')
													{
														acc.deposit_money(money);
														cust.addTran(new transaction(cust.getNames(), wea, money));
														System.out.println("Founds added!");
														break;
													}
													else if(l1<cust.numAcc()-1)
														l1++;
													else
													{	System.out.println("We cannot find this type of account for this user");
										 		 		 break;
													}
												}while(l1<cust.numAcc());
											 	break;
											 case(3):
												 do
												{
													account acc = cust.getAccInfo(l1);
													wea=acc.getAcn();
													if((wea.charAt(0))=='3')
													{
														acc.deposit_money(money);
														cust.addTran(new transaction(cust.getNames(), wea, money));
														System.out.println("Founds added!");
														break;
													}
													else if(l1<cust.numAcc()-1)
														l1++;
													else
													{	System.out.println("We cannot find this type of account for this user");
										 		 		 break;
													}
												}while(l1<cust.numAcc());
											 	System.out.println();
											 	break;
											 }
											 break;
										case(2):
										 	System.out.println("How much money you want to withdraw?");
											double withdraw1 = r.nextDouble();
											System.out.println("From wich account?");
											System.out.println("1 .- Saving account");
											System.out.println("2 .- Current account");
											System.out.println("3 .- Mortgage account");
											int op2 = r.nextInt();
											l1=0;
											switch(op2)
											 {
											 case(1):
												 do
												{
													account acc = cust.getAccInfo(l1);
													wea=acc.getAcn();
													if((wea.charAt(0))=='1')
													{
														if(acc.withdraw(withdraw1))
															System.out.println("Founds withdrawed!");
														else
															System.out.println();
														break;
													}
													else if(l1<cust.numAcc()-1)
														l1++;
													else
													{	System.out.println("We cannot find this type of account for this user");
										 		 		 break;
													}
												}while(l1<cust.numAcc());
											 	System.out.println();
											 	break;
											 case(2):
												 do
												{
													account acc = cust.getAccInfo(l1);
													wea=acc.getAcn();
													if((wea.charAt(0))=='2')
													{
														if(acc.withdraw(withdraw1))
															System.out.println("Founds withdrawed!");
														else
															System.out.println();
														break;
													}
													else if(l1<cust.numAcc()-1)
														l1++;
													else
													{	System.out.println("We cannot find this type of account for this user");
										 		 		 break;
													}
												}while(l1<cust.numAcc());
											 	break;
											 case(3):
												 do
												{
													account acc = cust.getAccInfo(l1);
													wea=acc.getAcn();
													if((wea.charAt(0))=='3')
													{
														if(acc.withdraw(withdraw1))
															System.out.println("Founds withdrawed!");
														else
															System.out.println();
														break;
													}
													else if(l1<cust.numAcc()-1)
														l1++;
													else
													{	System.out.println("We cannot find this type of account for this user");
										 		 		 break;
													}
												}while(l1<cust.numAcc());
											 	System.out.println();
											 	break;
											 }
											 System.out.println();
											 break;	
										}
									case(4):
										System.out.println("The only transaction that can be made at the moment is a transfer between clients");
										//System.out.println("And only between the same type of accounts");
										System.out.println("Who will receive the money?");
										r.nextLine();
										String receiver = r.nextLine();
										customer cust2;
										for(int k=0; k<bank.numberOfCus();k++)
										{
											cust2 = bank.getCustomer(k);
											if((cust2.getNames().equals(receiver)))
											{
												System.out.println("To which account will you send the money? (Receiver account)");
												System.out.println("1.- Saving account");
												System.out.println("2.- Current account");
												int o = r.nextInt();
												int l3 =0;
												account acc2;
												boolean ban = true;
												switch(o)
												{
												case(1):
												do {
													acc2 = cust2.getAccInfo(l3);
													wea2= acc2.getAcn();
													if((wea2.charAt(0))=='1')
														break;
													else if(l3<cust2.numAcc()-1)
														l3++;
													else
													{
														System.out.println("The user " + cust2.getNames()+ " does not have a Saving account type");
														ban=false;
														break;
													}
												}while(l3<cust2.numAcc());
												System.out.println();
												break;
												case(2):
													do {
														acc2 = cust2.getAccInfo(l3);
														wea2= acc2.getAcn();
														if((wea2.charAt(0))=='2')
															break;
														else if(l3<cust2.numAcc()-1)
															l3++;
														else
														{
															System.out.println("The user " + cust2.getNames()+ " does not have a Current account type");
															break;
														}
													}while(l3<cust2.numAcc());
												System.out.println();
												break;
												}//switch verify receiver account
												if(ban==true)
												{
												System.out.println("From which account do you want to withdraw the money?");
												System.out.println("1 .- Saving account");
												System.out.println("2 .- Current account");
												//System.out.println("3 .- Mortgage account");
												//r.next();
												int bo = r.nextInt();
												
												double mon;
												int l2=0;
												switch(bo)
												{
												case(1):
													do
													{
														account acc = cust.getAccInfo(l2);
														wea=acc.getAcn();
														
														if((wea.charAt(0))=='1')
														{
															System.out.println("How much money will you transfer?");
															mon = r.nextDouble();
															if(acc.withdraw(mon))
															{
																System.out.println("Founds withdrawed from your account!");
																acc2 = cust2.getAccInfo(l3);
																acc2.deposit_money(mon);
																System.out.println("Founds added to the account of "+ cust2.getNames());
																cust.addTran(new transaction(cust.getNames(),cust2.getNames(),acc.getAcn(),acc2.getAcn(),mon));
																cust2.addTran(new transaction(cust.getNames(),cust2.getNames(),acc.getAcn(),acc2.getAcn(),mon));
																System.out.println();
																break;
															}
															else
																System.out.println();
															break;
														}
														else if(l2<cust.numAcc()-1)
															l2++;
														else
														{	System.out.println("We cannot find this type of account for this user");
										 		 		 	break;
														}
													}while(l2<cust.numAcc());
												System.out.println();
												break;
												case(2):
													do
													{
														account acc = cust.getAccInfo(l2);
														wea=acc.getAcn();
														if((wea.charAt(0))=='2')
														{
															System.out.println("How much money will you transfer?");
															mon = r.nextDouble();
															if(acc.withdraw(mon))
															{
																System.out.println("Founds withdrawed from your account!");
																acc2 = cust2.getAccInfo(l3);
																acc2.deposit_money(mon);
																System.out.println("Founds added to the account of "+ cust2.getNames());
																cust.addTran(new transaction(cust.getNames(),cust2.getNames(),acc.getAcn(),acc2.getAcn(),mon));
																cust2.addTran(new transaction(cust.getNames(),cust2.getNames(),acc.getAcn(),acc2.getAcn(),mon));
																System.out.println();
																break;
															}
															else
																System.out.println();
															break;
														}
														else if(l2<cust.numAcc()-1)
															l2++;
														else
														{	System.out.println("We cannot find this type of account for this user");
										 		 		 	break;
														}
													}while(l2<cust.numAcc());
													System.out.println();
													break;
												}//switch verify own type of account
												}//if verify
											}//if
												else if(k==bank.numberOfCus()-1)
													System.out.println("We cannot find this customer, transaction canceled");
										}//for
										System.out.println();
										break;
									case(5):
										for( int l11=0; l11<cust.numAcc();l11++)
										{
											transaction tran = cust.getTranInfo(l11);
											System.out.println(" "+tran.getTransferDescription());
										}
										System.out.println();
										break;
									case(6):
										System.out.println("Session closed");
										System.out.println();
										break;
									default:
										System.out.println("Not a valid option");
									}
							}while(op!=6);
						}
						else if(y==bank.numberOfCus()-1)
							System.out.println("We cannot found a customer with these credentials");
						
					}
				System.out.println();
				break;
			case(3):
				System.out.println("Good bye!");
				System.out.println();
				break;
			default:
				System.out.println("Please, select a correct option");
				System.out.println();
			}
				
			
		}while (x!=3);
	}
	

}
