//------------------------------------------------------------------------------
//	Commission.java
//	by Caleb Phillips
//	CSCI 1302
//	Chapter 10 Lab #1
//	9/25/18 - 9/26/18
//------------------------------------------------------------------------------
public class Commission extends Hourly {

	private double totalSales;
	private double commissionRate;

	public Commission(String eName, String eAddress, String ePhone, String socSecNumber, double rate,
			double commissionRate) {

		super(eName, eAddress, ePhone, socSecNumber, rate);

		this.commissionRate = commissionRate;

	}

	public void addSales(double totalSales) {

		this.totalSales += totalSales;
	}

	
	public double getCommission() {

		double calcCommission = totalSales * commissionRate;

		return calcCommission;
	}
	
	//-----------------------------------------------------------------
	//	Overrides the pay method in Hourly class
	//-----------------------------------------------------------------
	public double pay() {

		double payment = super.pay() + getCommission();

		totalSales = 0;

		return payment;
	}

	//-----------------------------------------------------------------
	//	Overrides the toString method in Hourly class
	//-----------------------------------------------------------------
	public String toString() {

		String result = super.toString();

		result += "\nTotal Sales: $" + totalSales;

		result += "\nCommission Rate: " + (100 * commissionRate) + "%";

		return result;

	}

}