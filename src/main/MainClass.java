package main;
import java.util.Scanner;
import model.Electricity;
import model.Rent;
import model.Expenditure;

public class MainClass {



    public static void main(String[] args)
    {
        double bill;
        double total;
        int ch;
        Scanner sc = new Scanner(System.in);
        Rent r= new Rent();
        Electricity e = new Electricity();
        //RentAmount ramount = new RentAmount();
      
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
                case 1: r.setRent();
                break;

                case 2: e.setUnit();
                bill= e.ElectricityBill();
                System.out.println("Electricity bill= "+bill);
                break;

                case 3: //Daily();
                break;

                case 4:  
                double el = e.ElectricityBill();
                //System.out.println("ebill="+el);
                double rt = r.rAmount();
                //System.out.println("renamt="+rt);
                double tamount=el+rt;
                System.out.println("renamt="+tamount);
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
