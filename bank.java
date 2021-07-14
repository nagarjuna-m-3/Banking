import java.util.*;
import java.lang.Math;

class Account
 {
	String name,accno;
	int acctype;
	Scanner in=new Scanner(System.in);
    void read()
	 {
		System.out.print("Enter customer name: ");
		name=in.nextLine();
		System.out.print("Enter Accno: ");
		accno=in.next();
	 }
    void type()
	{
		System.out.println("Choose type of ACCOUNT:");
		System.out.println("\t1.Current Account\n\t2.Savings Account");		
		System.out.println("---------------------------------------------------------------");
		acctype=in.nextInt();
		
	}
}
 
class Current extends Account
 {
   int ch,balance=0;
   void cur()
    {
	  super.read();
	  Scanner in=new Scanner(System.in);
	  while(true)
	   {
	     System.out.println("Enter your choice");
	     System.out.println("\t1.DEPOSIT\n\t2.WITHDRAWAL\n\t3.CURRENT BALANCE\n\t4.EXIT\t");
	     System.out.println("---------------------------------------------------------------");
	     ch=in.nextInt();
	  
	switch(ch)
	{
	case 1:  System.out.print("Enter amount to be deposited:");
	         int bal=in.nextInt();
	         balance=balance+bal;
	         System.out.println("Balance = "+balance);
	          break;
	case 2: System.out.println("Enter the check number:");
	         String checkno=in.next();
		     System.out.print("Enter amount to be withdrawn:");
	         int withdraw=in.nextInt();
	         if(withdraw>balance)
	         {
	        	 System.out.println("---------------------------------------------------------------");
	        	 System.out.println("____Insufficient balance....please check balance___");
	         } 
	        	 else
	         {
	        	 balance=balance-withdraw;
	        	 System.out.println("checkno:"+checkno+"\tBalance = "+balance);
	         }
	         if(balance<100)
	         {
	        	 System.out.print("NOTICE:  Minimum balance not maintained----->SERVICE CHARGES = Rs 100");
	        	 System.out.println("\n---------------------------------------------------------------");
	        	 balance=balance-100;
	        	 System.out.println("\nBalance = "+balance);
	        }
	         break;
	case 3:System.out.println("Displaying your current balance:");
	       System.out.println("--------------------------------");
	       System.out.println("CURRENT BALANCE = "+balance);
	       break;
	case 4:java.lang.System.exit(0);
	break;
	default :System.out.println("invalid");
	}
	
	}
  }
}
class Savings extends Account
{
	double t,CI,balance=0;
	Scanner in=new Scanner(System.in);
	void sav()
	{
		super.read();
		while(true)
		{
		System.out.println("Enter your choice");
		System.out.println("\t1.DEPOSIT\n\t2.WITHDRAWAL\n\t3.COMOUND INTREST\n\t4.CURRENT BALANCE\n\t5.EXIT\t");
		System.out.println("---------------------------------------------------------------");
		int ch=in.nextInt();
		switch(ch)
		{
		case 1:  System.out.print("Enter amount to be deposited:");
		         double bal=in.nextDouble();
		         balance=balance+bal;
		         /*System.out.println("Enter the number of years");
		         t=in.nextdouble();
		         System.out.println("Enter the number of months");
		         int n=in.nextInt();*/
		         System.out.printf("Balance = %.2f\n",balance);
		         break;
	
		case 2:  System.out.print("Enter amount to be withdrawn:");
                 int withdraw=in.nextInt();
                 if(withdraw>balance)
                 {
                	 System.out.println("----------------------------------------------------"); 
       	             System.out.println("Insufficient balance....please check your balance");
       	             System.out.println("-----------------------------------------------------");
                 }
                  else
                  {
                     balance=balance-withdraw;
                     System.out.printf("Balance = %.2f\n",balance);
                  }
                  break;       
		         
		case 3:   balance=compound(balance);
		          System.out.printf("Balance = %.2f\n",balance);
		          System.out.println("---------------------------");
                   break;
        
		case 4:  System.out.println("Displaying your current balance");
		         System.out.println("-------------------------------");   
	             System.out.printf("CURRENT BALANCE = %.2f\n",balance);
	             break;
	             
		case 5:java.lang.System.exit(0);    
		}
	}
}
   double compound(double bal)
	{
		double n=365,r=0.05;
		double t=1;
	
			       double amount = bal * (Math.pow(1 + (r / n), n * t));
			        double interest = amount - bal;
			         System.out.printf("Compond Interest:- %.2f\n", interest);
			       //System.out.printf("Amount is %.2f\n",amount);
			        return (amount);
    }
}
public class Bank {

	public static void main(String[] args) {
		Account ob=new Account();
		ob.type();
	    if(ob.acctype==1)
		 {
		   Current obj1=new Current();
		   obj1.cur();
		 }
		else if(ob.acctype==2)
		 {
		   Savings obj2=new Savings();
		   obj2.sav();
		 }
	    else
	    {
	    	System.out.println("Please Enter a valid option");
	    	ob.type(); 
	    }
	}
	}


