package model;
import java.util.Scanner;
public class Rent {
	
	/**
	 * Write a description of class Rent here.
	 *
	 * @author (your name)
	 * @version (a version number or a date)
	 */
	
	    
	    private int x;
	    private  double rent;
	    Scanner sc= new Scanner(System.in);
	         
	    public Rent()
	    {
	      
	        x = 0;
	    }

	 
	    public int Rent(int y)
	    {
	        // put your code here
	        return x + y;
	    }

	    public void setRent()
	    {
	        System.out.println("Enter the rent amount");
	        this.rent=sc.nextDouble();
	    }
	    public double getRent()
	    {
	        double r= this.rent;
	        return r;
	    }
	     public  double rAmount()
	    {
	        double ramount= getRent();
	        return ramount;
	    }
	}



