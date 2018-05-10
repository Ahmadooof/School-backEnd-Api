package School.hello.Dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import School.hello.Utility.HibernateUtility;


@SuppressWarnings("unchecked")
public class GeneriDaoImpl<T> implements GenericDao<T> {

	Session session = HibernateUtility.getSesstionFactory().openSession();
	private Class<T> runTimeClass ;
	private String className;
	
	public GeneriDaoImpl(Class<T> test) {
		runTimeClass = test;
		className = this.runTimeClass.getSimpleName();
	}
	
	@Override
	public List<T> getAll() {
		try
		{
		String hql = "from "+ this.className;
		List<T> Objects	= session.createQuery(hql).getResultList();
		return Objects;
		}
		catch(Exception e)
		{
			System.out.println(">>>>>>>Exception in getAll Method GENERICDAO" + e);
			return null;
		}
	}
	
	@Override
	public T getById(int id) {
		try 
		{
		session.beginTransaction();
		String hql = "from "+ this.className + " as generic where generic.id = :id";
		Query q    = session.createQuery(hql);
		q.setParameter("id", id);
		T oneObject = (T) q.getSingleResult();
		return oneObject;
		}
		catch(Exception e)
		{
			System.out.println(">>>>>>>Exception in getById GENERICDAO" + e);
			return null;
		}


	}
	
	@Override
	public void createObject(T Object){
		try 
		{
		session.beginTransaction();
		session.persist(Object);
		session.getTransaction().commit();
		return;
		}
		catch(Exception e)
		{
			System.out.println(">>>>>>>Exception in createObject Method GENERICDAO" + e);
		}


	}

	@Override
	public void deleteObject(int id) {
		try 
		{
		T ObjectInDb = getById(id);
		session.remove(ObjectInDb);
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			System.out.println(">>>>>>>Exception in deleteObject Method GENERICDAO" + e);
		}


	}

	@Override
	public void updateObject(T ObjectFrontEnd,int id) {
		try 
		{
		T searchForObject = getById(id);
		searchForObject = (T) session.merge(ObjectFrontEnd);
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			System.out.println(">>>>>>>Exception in updateObject GENERICDAO" + e);
		}


	}
	
	
	


	
}
