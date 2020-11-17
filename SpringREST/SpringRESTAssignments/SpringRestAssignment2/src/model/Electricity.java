package model;

public class Electricity {
	
	private double initialReading;
	private double thisMonthReading;
	public static final double COST_PER_UNIT = 2.4;
	private double totalBill;
	
	public Electricity(){
		
	}
	
	public Electricity(double initialReading, double thisMonthReading){
		this.initialReading = initialReading;
		this.thisMonthReading = thisMonthReading;
	}

	public void setInitialReading(double initialReading) {
		this.initialReading = initialReading;
	}

	public void setThisMonthReading(double thisMonthReading) {
		this.thisMonthReading = thisMonthReading;
	}
	
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	
	public double getInitialReading() {
		return this.initialReading;
	}
	
	public double getThisMonthReading() {
		return this.thisMonthReading;
	}
	
	public double getTotalBill() {
		return this.totalBill;
	}
	
	@Override
	public String toString() {
		return "Total Bill : "+this.getTotalBill();
	}
}
