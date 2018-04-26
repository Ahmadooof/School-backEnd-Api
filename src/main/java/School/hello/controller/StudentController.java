package School.hello.controller;
import java.util.List;

import javax.persistence.Query;
import javax.ws.rs.Consumes;
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
	public Response getStudents() {
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
		System.out.println("Post Method");
		session.persist(student);
		session.getTransaction().commit();
		return Response.ok(200).build();
	}
	
	@PUT
	public Response update(@DefaultValue("0")Student test) {
		System.out.println(test);
		System.out.println(test.getName());
		return Response.ok(test).build();
	}
	
	@PUT
	@Path("{id}")
	public Response updateStudent(@DefaultValue("0") @PathParam("id") int id, Student NewStudentDetails) {
		try {
			String HQL = "from Student as stu where stu.id = :id";
			Query q = session.createQuery(HQL)
					.setParameter("id", id);      					// this line to prevent sql injections
			Student OldStudentDetails =(Student) q.getSingleResult();
			System.out.println("111");
			System.out.println(id);
			System.out.println(NewStudentDetails.getName());
			System.out.println("222");
			OldStudentDetails.setName(NewStudentDetails.getName());
			OldStudentDetails.setEmail(NewStudentDetails.getEmail());
			System.out.println("3333");
			session.getTransaction().commit();
			return Response.ok(NewStudentDetails).build();
		}
		catch(Exception e )
		{
			System.out.println(e);
			System.out.println("catchhhhhhhhhh");
		}
		return null;
	}
}
