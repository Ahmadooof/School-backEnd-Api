package School.hello.Utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	
private static SessionFactory sessionFactory;
	
	public static SessionFactory getSesstionFactory() {
		if(sessionFactory== null) {
			try {
				Configuration cfg= new Configuration().configure(); // it will look to hibernate.cfg.xml file and load it
				sessionFactory= cfg.buildSessionFactory();
			}catch(Exception ex) {
				ex.printStackTrace();
				System.out.println("couldn't create session factory");
			}
			
		}
		return sessionFactory;
	}
	

}