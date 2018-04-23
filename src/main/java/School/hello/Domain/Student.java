package School.hello.Domain;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//hibernate annotation
@Entity
public class Student {
	
	// hibernate annotaions
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String email;
	
	
	// cascade used to save multible objects related with each other in one line PS:"session.persist(student);"
	@ManyToOne(cascade= CascadeType.PERSIST)
	private Tutor supervisor;
	
	//Embedded annotations used to embeeding two class with one table in the DB
	@Embedded
	private Address StudentAddress;
	
	// Required for Hibernate
	public Student() 
	{
		
	}
	
	public Student(String name,String email, 
			String land,String city,int postNumber) 
	{
		this.name = name;
		this.email = email;
		this.StudentAddress = new Address(land,city,postNumber);
	}
	
	
//	public void AddStudentDb()
//	{
//		Session session= HibernateUtility.getSesstionFactory().openSession();
//		session.beginTransaction();
//		session.save();
//		session.getTransaction().commit();
//		session.close();
//	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", supervisor=" + getSupervisor()
				+ ", StudentAddress=" + getStudentAddress() + "]";
	}

	public Address getStudentAddress() {
		return StudentAddress;
	}

	public void setStudentAddress(Address studentAddress) {
		StudentAddress = studentAddress;
	}

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
