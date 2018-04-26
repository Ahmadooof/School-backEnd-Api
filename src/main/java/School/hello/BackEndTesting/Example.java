package School.hello.BackEndTesting;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import School.hello.Domain.Student;
import School.hello.Domain.Tutor;
import School.hello.Utility.HibernateUtility;

public class Example {
	
	public static void main(String args[]) {
		



		
//		************ To Save Object into Database As Table ************ 
		
		Session session= HibernateUtility.getSesstionFactory().openSession();
		session.beginTransaction();
		
		Student test = new Student("Ali", "ali@2e21e.com", "test", "test", 2323);
		session.persist(test);
		
		session.getTransaction().commit();
		
//		session.beginTransaction();
//		Student student = new Student("Martin","Martin@hotmail.com","Sweden","Vaxjo",23123);
//		Tutor tutor = new Tutor("ABC", "Erik", 30000000, "Sweden", "vaxjo", 112233);
//		student.setSupervisor(tutor);
//		session.persist(student);
//		
//		String lookingForStudent = "Martin";
//		// this  %  means all students started thier names with "Mar" for example we will get all "Martin" from DB.
//		// this  :  means we are setting variable called name and we used it in setParameter method, (good way to prevent injections).
//		Query q = session.createQuery("from Student as student where student.name = :name ");
//		q.setParameter("name", lookingForStudent);
//		List<Student> studentFromDb = q.getResultList();
//		System.out.println(studentFromDb);
//		
////		List<Student> students = q.getResultList();
////		
////		for(Student test : students)
////		{
////			System.out.println(test);
////		}
//				
//		session.getTransaction().commit();	
//		System.out.println("finished");
//		
//
//// 		************ To get Object from DB By ID  ! ************ 
//		
////		Session session= HibernateUtility.getSesstionFactory().openSession();
////		session.beginTransaction();
////		
////		Student test = session.get(Student.class, 1);
////		
////		session.getTransaction().commit();
////		session.close();
//		
//// 		************ To Delete Object from DB By ID (first we get it then delete it ! ************ 
//		
////		Session session= HibernateUtility.getSesstionFactory().openSession();
////		session.beginTransaction();
////		
////		Student test = session.get(Student.class, 1);
////		session.delete(test);
////		
////		session.getTransaction().commit();
////		session.close();
//		
//// 		************ To Update Object from DB By ID (first we get it then we change something in the object,   ************ 
////		************ 	hibernate will figure out that (dirtyCheck) so "DON'T USE" Update Method in hibernate !************  
//
////		Session session= HibernateUtility.getSesstionFactory().openSession();
////		session.beginTransaction();
////		
////		Student test = session.get(Student.class, 2);
////		test.setName("Omar");
////		
////		session.getTransaction().commit();
////		session.close();
	}

}
