package School.hello.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;

//hibernate annotation
@Entity
public class Student {
	
	// hibernate annotaions
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String email;
	private String city;
	private String land;
	private int postNumber;
	
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public int getPostNumber() {
		return postNumber;
	}

	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}

	// cascade used to save multible objects related with each other in one line example:"session.persist(student);"
	@ManyToOne(cascade= CascadeType.PERSIST)
	private Tutor supervisor;
	
//	//Embedded annotations used to embeeding two class with one table in the DB
//	@Embedded
//	private Address StudentAddress;
	
	// Required for Hibernate
	public Student() 
	{
		
	}
	
	public Student(String name,String email, String land,String city,int postNumber) 
	{
		this.name = name;
		this.email = email;
//		this.StudentAddress = new Address(land,city,postNumber);
	}
	
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", supervisor=";
//				+ ", StudentAddress=" + StudentAddress + "]";
	}

//	public Address getStudentAddress() {
//		return StudentAddress;
//	}
//
//	public void setStudentAddress(Address studentAddress) {
//		StudentAddress = studentAddress;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Tutor getSupervisor() {
		return this.supervisor;
	}
	
	public void setSupervisor(Tutor supervisor) {
		this.supervisor = supervisor;
	}



}
