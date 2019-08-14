package model;
public class Expenditure {


	    // instance variables - replace the example below with your own
	    
	    private int expenditure;	
	    private String itemName;
	    private int itemPrice;
	    private String item;
	    	  
	    /**
	     * Constructor for objects of class Daily
	     */
	    public Expenditure()
	    {
	        this.expenditure=0;
	    }
	
		public String getItemName() {
			return this.itemName;
		}
		public int getItemPrice() {
			return this.itemPrice;
		}
		public Expenditure getExpenditure() {
			Expenditure exp=new Expenditure();
			exp.itemName=this.itemName;
			exp.itemPrice=this.itemPrice;
			return exp;
		}
		
		public void setItem(String itemName, int itemPrice) {
			this.itemName = itemName;
			this.itemPrice=itemPrice;
		}

	

		
		
	}


