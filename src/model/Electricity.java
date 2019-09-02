package model;
public class Electricity {
	

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
	@Override
	public String toString() {
		return "Electricity [firstRead=" + firstRead + ", lastRead=" + lastRead + "]";
	}

	//		public int getUnitPrice() {
	//			return unitPrice;
	//		}
	//
	//		public void setUnitPrice(int unitPrice) {
	//			this.unitPrice = unitPrice;
	//		}
}



