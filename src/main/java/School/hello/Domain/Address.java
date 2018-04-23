package School.hello.Domain;

import javax.persistence.Embeddable;

//Embeddable annotation used to embeeding this class with any class we want by using "@Embedded" in the other class,
//saving two classes with one table in DB

@Embeddable
public class Address {

	private String Land;
	private String city;
	private int postNumber;
	
	
	// Required by hibernate
	public Address()
	{
		
	}
	
	public Address(String land, String city, int postNumber) {
		super();
		Land = land;
		this.city = city;
		this.postNumber = postNumber;
	}
	
	
	public String getLand() {
		return Land;
	}
	public void setLand(String land) {
		Land = land;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPostNumber() {
		return postNumber;
	}
	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}

	@Override
	public String toString() {
		return "Address [Land=" + Land + ", city=" + city + ", postNumber=" + postNumber + "]";
	}
	
	
}
