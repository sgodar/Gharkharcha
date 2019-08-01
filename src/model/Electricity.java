package model;
public class Electricity {
	
	
	    // instance variables - replace the example below with your own
	    private double firstRead;
	    private double lastRead;
	    private double unitPrice;
	    private double unit;
	    
	    public Electricity()
	    {
	        
	        this.firstRead = 0.0;
	        this.lastRead=0.0;
	        this.unitPrice=15;
	    }
	   	    
	    public double getFirstRead() {
			return firstRead;
		}

		public void setFirstRead(double firstRead) {
			this.firstRead = firstRead;
		}

		public double getLastRead() {
			return lastRead;
		}

		public void setLastRead(double lastRead) {
			this.lastRead = lastRead;
		}

		public double getUnitPrice() {
			return unitPrice;
		}

		public void setUnitPrice(double unitPrice) {
			this.unitPrice = unitPrice;
		}
	
		
		

	  //  public double getUnit()
	  //  {
	        //double uf = this.uf;
	        //System.out.println("uf = "+uf);
	       // double ul = this.ul;
	        //System.out.println("ul = "+ul);
	        //double unit= ul-uf;
	      //  return unit;

	//    }

	  //  public double ElectricityBill()
	  //  {
	       // double u= getUnit();
	        //System.out.println("unit= "+u);
	      //  double p=this.uprice;
	        //System.out.println("unprice= "+p);
	       // double eBill=u*p;
	       // System.out.println("Electricity bill= "+eBill);
	       // return eBill;
	  //  }

	}



