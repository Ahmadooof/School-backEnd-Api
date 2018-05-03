package School.hello.Service;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import School.hello.Utility.HibernateUtility;


@SuppressWarnings("unchecked")
public class GenericServiceImpl<T> implements GenericService<T> {

	private Session session;
	private Class<T> runTimeClass ;
	private String className;
	
	public GenericServiceImpl(Class<T> test) {
		runTimeClass = test;
		className = this.runTimeClass.getSimpleName();
		session = HibernateUtility.getSesstionFactory().openSession();
	}
	
	@Override
	public List<T> getAll() {
		String hql = "from "+ this.className;
		List<T> Objects	= session.createQuery(hql).getResultList();
		return Objects;
	}
	
	@Override
	public T getById(int id) {
		String hql = "from "+ this.className + " as generic where generic.id = :id";
		Query q    = session.createQuery(hql);
		q.setParameter("id", id);
		T oneObject = (T) q.getSingleResult();
		return oneObject;
	}
	
	@Override
	public void createObject(T Object){
		
		session.beginTransaction();
		session.persist(Object);
		return;
	}

	@Override
	public void deleteObject(int id) {
		session.beginTransaction();
		T ObjectInDb = getById(id);
		session.remove(ObjectInDb);
		session.getTransaction().commit();
	}

	@Override
	public void updateObject(T ObjectFrontEnd,int id) {
		session.beginTransaction();
		T searchForObject = getById(id);
		searchForObject = (T) session.merge(ObjectFrontEnd);
		session.getTransaction().commit();
	}
	
	


	
}
