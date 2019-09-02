package model;
public class Expenditure {

private int expenditure;
 private String itemName;
 private int itemPrice;
 private String item;

 public Expenditure() {
  this.expenditure = 0;
 }

 public String getItemName() {
  return this.itemName;
 }

 public int getItemPrice() {
  return this.itemPrice;
 }

 public Expenditure getExpenditure() {
  Expenditure exp = new Expenditure();
  exp.itemName = this.itemName;
  exp.itemPrice = this.itemPrice;
  return exp;
 }

 public void setItem(String itemName, int itemPrice) {
  this.itemName = itemName;
  this.itemPrice = itemPrice;
 }
 @Override
	public String toString() {
		return "Expenditure [expenditure=" + expenditure + ", itemName=" + itemName + ", itemPrice=" + itemPrice
				+ ", item=" + item + "]";
	}

}