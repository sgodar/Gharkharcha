package main;
import java.sql.SQLException;
import java.util.Scanner;

import DatabBase.Database;
import model.Electricity;
import model.Rent;
import model.Expenditure;

public class MainClass {



    public static void main(String[] args) throws Exception
    {
        double bill;
        double total;
        double firstRead;
        double startRead;
        double lastRead;
        int rent;
        int ch;
        Scanner sc = new Scanner(System.in);
        Rent r= new Rent();
        Electricity e = new Electricity();
     
        do{
            System.out.println("---Menu---");
            System.out.println("1.Rent");
            System.out.println("2.Electricity Meter");
            System.out.println("3.Daily Kharcha");
            System.out.println("4.Calcuate Rent amount");
            System.out.println("5.Calculation Total Expenditure");
            System.out.println("6.Exist");

            System.out.println("Enter your choice");
            ch= sc.nextInt();
            switch(ch)
            {
                case 1: System.out.println("Enter the rent amount");
	        	        rent=sc.nextInt();
	        	        r.setRent( rent);
	        	        Database db= new Database();
	        	        db.addRent(rent, null, null, false);
	        	        break;

                case 2: startRead=e.getFirstRead();
		                if(startRead<=0)
		        	        {
		        	            System.out.println("Enter the starting meter reading unit");
		        	            firstRead=sc.nextDouble();
		        	            e.setFirstRead(firstRead);
		        	        }
		        	    System.out.println("Enter the last meter reading unit");
		        	    lastRead=sc.nextDouble();
		        	    e.setLastRead(lastRead);    
		        	    break;	
		                
		              //  bill= e.ElectricityBill();
		              //  System.out.println("Electricity bill= "+bill);
		                

                case 3: //Daily();
//                	  public void setExpenditure()
//              	    {
//              	        System.out.println("Enter the daily expenditure");
//              	        this.expenditure=sc.nextDouble() + this.expenditure;
//              	    }
                break;

                case 4:  
             //   double el = e.ElectricityBill();
                //System.out.println("ebill="+el);
                double rt = r.rAmount();
                //System.out.println("renamt="+rt);
              //  double tamount=el+rt;
              //  System.out.println("renamt="+tamount);
                // total=ramount.TotalRent();
                // System.out.println("Rent amount= "+total);
                break;

                case 5: //TotalExpenditure();
                //double rent=r.rAmount();
               // double ebill= e.ElectricityBill();
                //double daily = d.getDaily();
                //double expenditure= rent+ebill+daily;
               // System.out.println("total expenditure per month= "+expenditure);;
                break;

                case 6: //Exist();
                break;

                default:
                System.out.println("invalid input try again");
                break;

            }}while(ch!=6);

    }
}
