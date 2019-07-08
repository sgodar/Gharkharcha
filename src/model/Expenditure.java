package model;
import java.util.Scanner;
public class Expenditure {


	    // instance variables - replace the example below with your own
	    private int x;
	    private double exp;	
	    Scanner sc= new Scanner(System.in);
	    /**
	     * Constructor for objects of class Daily
	     */
	    public Expenditure()
	    {
	        this.exp=0;
	    }
	
	    public void setDaily()
	    {
	        System.out.println("Enter the daily expenditure");
	        this.exp=sc.nextDouble() + this.exp;
	    }
	    public double getDaily()
	    {
	        double ed= this.exp;
	        return ed;
	    }
	}


