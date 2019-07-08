package model;
import java.util.Scanner;
public class Electricity {
	
	
	    // instance variables - replace the example below with your own
	    private  double uf;
	    private  double ul;
	    private double uprice;
	    Scanner sc= new Scanner(System.in);

	    public Electricity()
	    {
	        
	        this.uf = 0.0;
	        this.ul=0.0;
	        this.uprice=15;
	    }

	    //  public Electricity(double u)
	    // {
	    // initialise instance variables
	    //this.unit = u;
	    // }

	    public void setUnit()
	    {
	        if(this.uf<=0)
	        {
	            System.out.println("Enter the starting meter reading unit");
	            this.uf=sc.nextDouble();
	            System.out.println("Enter the last meter reading unit");
	            this.ul=sc.nextDouble();
	        }
	        else
	        {
	            System.out.println("Enter the last meter reading unit");
	            this.ul=sc.nextDouble();

	        }
	    }

	    public double getUnit()
	    {
	        //double uf = this.uf;
	        //System.out.println("uf = "+uf);
	       // double ul = this.ul;
	        //System.out.println("ul = "+ul);
	        double unit= ul-uf;
	        return unit;

	    }

	    public double ElectricityBill()
	    {
	        double u= getUnit();
	        //System.out.println("unit= "+u);
	        double p=this.uprice;
	        //System.out.println("unprice= "+p);
	        double eBill=u*p;
	       // System.out.println("Electricity bill= "+eBill);
	        return eBill;
	    }

	}



