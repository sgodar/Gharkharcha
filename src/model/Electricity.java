package model;
public class Electricity {


	// instance variables - replace the example below with your own
	private int firstRead;
	private int lastRead;
	// private int unitPrice=15;
	
	public Electricity()
	{
		this.firstRead = 0;
		this.lastRead=0;
		// this.unitPrice=15;
	}

	public int getFirstRead() {
		return firstRead;
	}

	public void setFirstRead(int firstRead) {
		this.firstRead = firstRead;
	}

	public int getLastRead() {
		return lastRead;
	}

	public void setLastRead(int lastRead) {
		this.lastRead = lastRead;
	}

	//		public int getUnitPrice() {
	//			return unitPrice;
	//		}
	//
	//		public void setUnitPrice(int unitPrice) {
	//			this.unitPrice = unitPrice;
	//		}
	//	



	//  public int getUnit()
	//  {
	//int uf = this.uf;
	//System.out.println("uf = "+uf);
	// int ul = this.ul;
	//System.out.println("ul = "+ul);
	//int unit= ul-uf;
	//  return unit;

	//    }

	//  public int ElectricityBill()
	//  {
	// int u= getUnit();
	//System.out.println("unit= "+u);
	//  int p=this.uprice;
	//System.out.println("unprice= "+p);
	// int eBill=u*p;
	// System.out.println("Electricity bill= "+eBill);
	// return eBill;
	//  }

}



