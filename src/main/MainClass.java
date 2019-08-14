package main;
import java.util.Scanner;
import DatabBase.Database;
import model.Electricity;
import model.Rent;
import model.Expenditure;

public class MainClass {

	public static void main(String[] args) throws Exception
	{

		//double bill;
		double total;
		int firstRead;
		int startRead;
		int lastRead;
		int ebill;
		int itemPrice;
		String itemName;
		int rent;
		int ch;
		Scanner sc = new Scanner(System.in);
		Rent r= new Rent();
		Electricity ele = new Electricity();
		Expenditure exp = new Expenditure();
		GrandTotal gt = new  GrandTotal();
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

			case 2: startRead=ele.getFirstRead();
			if(startRead<=0)
			{
				System.out.println("Enter the starting meter reading unit");
				firstRead=sc.nextInt();
				ele.setFirstRead(firstRead);
			}
			System.out.println("Enter the last meter reading unit");
			lastRead=sc.nextInt();
			ele.setLastRead(lastRead);    
			break;	

			case 3: System.out.println("Enter the item name: ");
			itemName=sc.next();
			System.out.println("Enter the item price: ");
			itemPrice = sc.nextInt();
			exp.setItem(itemName,itemPrice);
			//exp.getItemName();
			//exp.getItemPrice();                		          	  
			break;

			case 4: ebill=gt.Total();
			rent = r.getRent();
			total = ebill+rent;
			System.out.println("totol Rent amount= "+total);              
			break;

			case 5: ebill=gt.Total();
			rent = r.getRent();
			total = gt.Total(ebill,rent);
			System.out.println("totol Rent amount= "+total);
			break;

			case 6: //Exist();
				break;

			default:
				System.out.println("invalid input try again");
				break;
			}
		}while(ch!=6);

	}

}
class GrandTotal
{
	int firstRead;
	int startRead;
	int lastRead;
	int unitPrice=15;
	int totalUnit;
	int expenses;
	Expenditure expenditure;
	Electricity ele = new Electricity();
	Expenditure exp = new Expenditure();

	public  int Total()
	{
		firstRead = ele.getFirstRead();
		lastRead = ele.getLastRead();
		//unitPrice = ele.getUnitPrice();
		totalUnit = lastRead-firstRead;
		int ebill= unitPrice*totalUnit;
		return ebill;
	}

	public  int Total(int ebill,int rent)
	{		
		expenditure=exp.getExpenditure();//getting exp obj from expenditure class
		expenses= expenditure.getItemPrice();//extracting expenditure obj
		int total = ebill+rent+expenses;
		return total;
	}
	//	public int Total()
	//	{
	//		
	//	}

}