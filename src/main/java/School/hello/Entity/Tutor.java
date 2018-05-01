package School.hello.Entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tutor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String tutorID;
	private String name;
	private int salary;
	
	
//	//Embedded annotations used to embeed two class with one table in the DB
//	@Embedded
//	private Address teacherAddress;
	
//	Required for hibernate
	public Tutor()
	{
		
	}
	
	public Tutor(String tutorId,String name, int salary)
	{
		this.tutorID = tutorId;
		this.name = name;
		this.salary = salary;
	}
	
	// this constructer to create a teacher object with Embeeded Address
//	public Tutor(String tutorId,String name, int salary,String land,String city,int postnumber)
//	{
//		this.tutorID = tutorId;
//		this.name = name;
//		this.salary = salary;
//		this.teacherAddress = new Address(land,city,postnumber);
//	}
	
	
	public String getTutorID() {
		return tutorID;
	}

	public void setTutorID(String tutorID) {
		this.tutorID = tutorID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}


	

}
