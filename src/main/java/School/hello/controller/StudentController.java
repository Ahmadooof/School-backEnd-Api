package School.hello.controller;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;

import School.hello.Domain.Student;
import School.hello.Utility.HibernateUtility;

@Path("students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentController {

	private Session session= HibernateUtility.getSesstionFactory().openSession();

	@GET
	public Response getStudents() {
		String HQL_BY_TITLE = "FROM Student ";
		
		@SuppressWarnings("unchecked")
		List<Student> result = session.createQuery(HQL_BY_TITLE)
			.getResultList();		
		for(Student t : result){
			System.out.println(t);
		}
		return Response.ok(result).build();
	}
	
	@POST
	public Response createStudent() {
		
		
		return Response.ok(result).build();
	}
}
