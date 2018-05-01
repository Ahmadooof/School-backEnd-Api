package School.hello.controller;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;

import School.hello.Entity.Student;
import School.hello.Service.Access;
import School.hello.Utility.HibernateUtility;

@Path("students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentController {

	private Access<Student> student = new Access<Student>(Student.class);
	private Session session = HibernateUtility.getSesstionFactory().openSession();

	@GET
	public Response getAllStudents() {
		return Response.ok(student.getAll()).build();
	}
	
	@GET
	@Path("{id}")
	public Response getStudentById(@PathParam ("id") int id) {
		return Response.ok(student.getById(id)).build();
	}
	
	@POST
	public Response createStuden(Student FrontEndObject) {
		this.student.createObject(FrontEndObject);
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
		
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteStudent(@PathParam("id") int id) {
		this.student.deleteObject(id);
		return Response.ok(200).build();
	}
}
