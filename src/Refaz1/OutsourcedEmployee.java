package Refaz1;

public class OutsourcedEmployee extends Employee {
	private double aditionalCharge;

	public OutsourcedEmployee() {

	}

	public OutsourcedEmployee(String name, int hours, double valuePerHour, double aditionalCharge) {
		super(name, hours, valuePerHour);
		this.aditionalCharge = aditionalCharge;
	}

	public double getAditionalCharge() {
		return aditionalCharge;
	}

	public void setAditionalCharge(double aditionalCharge) {
		this.aditionalCharge = aditionalCharge;
	}
	@Override
	public double payment() {
		return super.payment() + (aditionalCharge * 1.1);
	}
}
