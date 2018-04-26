package School.hello.controller;
import java.util.List;

import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;

import School.hello.Domain.Student;
import School.hello.Utility.HibernateUtility;

@Path("students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@SuppressWarnings("unchecked")
public class StudentController {

	private Session session= HibernateUtility.getSesstionFactory().openSession();
	

	@GET
	public Response getAllStudents() {
		String HQL_BY_TITLE = "FROM Student ";
		
		List<Student> result = session.createQuery(HQL_BY_TITLE)
			.getResultList();		

		return Response.ok(result).build();
	}
	
	@GET
	@Path("{id}")
	public Response getStudentById(@PathParam ("id") int id) {
		try {
		String HQL = "from Student as stu where stu.id = :id";
		Query q = session.createQuery(HQL);
		q.setParameter("id", id);
		Student oneObject =(Student) q.getSingleResult();
		return Response.ok(oneObject).build();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@POST
	public Response createStuden(Student student) {
		session.beginTransaction();
		
		session.persist(student);
		
		session.getTransaction().commit();
		
		return Response.ok(200).build();
	}
	
	@PUT
	@Path("{id}")
	public Response updateStudent(@PathParam("id") int id,Student newDetails) {
		try {
			session.beginTransaction();
			
			String HQL = "from Student as stu where stu.id = :id";
			Query q = session.createQuery(HQL);
			q.setParameter("id", id);
			Student oldDetails =(Student) q.getSingleResult();
			oldDetails.setName(newDetails.getName());
			oldDetails.setEmail(newDetails.getEmail());
			oldDetails.setLand(newDetails.getLand());
			oldDetails.setCity(newDetails.getCity());
			oldDetails.setPostNumber(newDetails.getPostNumber());
			
			session.getTransaction().commit();
		
		return Response.ok(newDetails).build();
		}catch(Exception e ) {
			System.out.println("there is fuckin exception here: " + e);
		}
		return null;
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteStudent(@PathParam("id") int id) {
		try {
			session.beginTransaction();
			
			String HQL = "from Student as stu where stu.id = :id";
			Query q = session.createQuery(HQL);
			q.setParameter("id", id);
			Student deleteStudent =(Student) q.getSingleResult();
			session.remove(deleteStudent);
			
			session.getTransaction().commit();
			return Response.ok(200).build();
		}catch(Exception e)
		{
			System.out.println("exception here dude"+ e);
		}
		return null;
	}
}
