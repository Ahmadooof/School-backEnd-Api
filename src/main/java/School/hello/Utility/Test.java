package School.hello.Utility;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;


@SuppressWarnings("unchecked")
public class Test<T> {
	
	public Class<T> type;
	public String className;
	Session session = HibernateUtility.getSesstionFactory().openSession();
	

//
//	
//	
//	public List<T> getAllEntity(){
//		System.out.println("hiiiiiiiii");
//		String hql = "from :class";
//		Query q = session.createQuery(hql);
//		q.setParameter("class", this.getClass());
//		System.out.println(this.className);
//		System.out.println("deeeeeeeeeeeeeeeeeeeeeeeee");
//		List<T> getAllObject = (List<T>) session.createQuery(hql).getResultList(); 
//		
//		return getAllObject;
////	}
//	
//	public void hi() {
//		String hql = "from :class";
//		Query q = session.createQuery(hql);
//		q.setParameter("class", );
//	}
	
}
