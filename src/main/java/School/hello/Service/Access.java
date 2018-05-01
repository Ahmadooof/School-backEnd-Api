package School.hello.Service;

import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import School.hello.Entity.Student;
import School.hello.Utility.HibernateUtility;


@SuppressWarnings("unchecked")
public class Access<T> {

	private Session session = HibernateUtility.getSesstionFactory().openSession();
	private Class<T> runTimeClass ;
	private String className;
	
	public Access(Class<T> test) {
		runTimeClass = test;
		className = this.runTimeClass.getSimpleName();
	}
	
	public List<T> getAll() {
		String hql = "from "+ this.className;
		List<T> Objects	= session.createQuery(hql).getResultList();
		System.out.println(Objects);
		return Objects;
	}
	
	public T getById(int id) {
		String hql = "from "+ this.className + " as generic where generic.id = :id";
		Query q    = session.createQuery(hql);
		q.setParameter("id", id);
		T oneObject = (T) q.getSingleResult();
		return oneObject;
	}
	
	public void createObject(T Object){
		session.beginTransaction();
		session.persist(Object);
		return;
	}

	public void deleteObject(int id) {
		session.beginTransaction();
		T ObjectInDb = getById(id);
		session.remove(ObjectInDb);
		session.getTransaction().commit();
	}

	
}
