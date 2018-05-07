package School.hello.controller;
import java.util.List;

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

import com.squareup.okhttp.Connection;

import School.hello.Dao.GenericDao;
import School.hello.Dao.GeneriDaoImpl;
import School.hello.Entity.Student;
import School.hello.Utility.HibernateUtility;


@Path("students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentController {

	private GenericDao<Student> student;
//	private Session session = HibernateUtility.getSesstionFactory().openSession();
	public StudentController() {
		 this.student = new GeneriDaoImpl<Student>(Student.class);
	}
	
	@GET
	public Response getAllStudents() {
		try 
		{
		return Response.ok(student.getAll()).build();
		}
		catch(Exception e)
		{
			System.out.println(">>>>>>>>>>>>>Exception in StudentController getAll Method<<<<<<<<<<<<<" +e);
			return null;
		}
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
	public Response updateStudent(@PathParam("id") int id,Student newDetails) throws InterruptedException {
		this.student.updateObject(newDetails, id);	
		System.out.println("hellooooooooo");
		return Response.ok(200).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteStudent(@PathParam("id") int id) {
		this.student.deleteObject(id);
		return Response.ok(200).build();
	}
}
