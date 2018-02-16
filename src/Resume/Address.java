package Resume;

class Addr {
	private int ID;
	private String City;
	private String State;
	private String Country;
	private int Pin;
	private String Line1;
	private String Line2;

	public Addr() {

	}

	public Addr(int iD, String city, String state, String country, int pin, String line1, String line2) {
		
		this.ID = iD;
		this.City = city;
		this.State = state;
		this.Country = country;
		this.Pin = pin;
		this.Line1 = line1;
		this.Line2 = line2;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public int getPin() {
		return Pin;
	}

	public void setPin(int pin) {
		Pin = pin;
	}

	public String getLine1() {
		return Line1;
	}

	public void setLine1(String line1) {
		Line1 = line1;
	}

	public String getLine2() {
		return Line2;
	}

	public void setLine2(String line2) {
		Line2 = line2;
	}

	@Override
	public String toString() {
		return "Addr [ID=" + ID + ", City=" + City + ", State=" + State + ", Country=" + Country + ", Pin=" + Pin
				+ ", Line1=" + Line1 + ", Line2=" + Line2 + "]";
	}
	
	
	
}

public class Address {

}
