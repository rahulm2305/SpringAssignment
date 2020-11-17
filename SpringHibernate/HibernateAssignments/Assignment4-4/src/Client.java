import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class Client {
	
	private static SessionFactory factory;
//	Configuration currentconf;
	public static void getSessionFactory() {
		
		try {
			Configuration conf = new Configuration().configure();
//			currentconf = conf;
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
			factory = conf.buildSessionFactory(builder.build());
		}
		
		catch(Throwable ex) {
			System.err.println("Failed to create Session Factory Object "+ex);	
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static void main(String args[]) {
		try
		{
			getSessionFactory();
			Client c = new Client();
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();

			Student RM = new Student(18, "Rahul Manne");
			Student PG = new Student(24, "Pranay Gunda");
			Student SR = new Student(32, "Snehal Reddy");
			
			Set<Student> shift1 = new HashSet<Student>();
			shift1.add(PG);
			shift1.add(SR);
			
			Set<Student> shift2 = new HashSet<Student>();
			shift2.add(RM);
									
			Teacher charan = new Teacher(1, "Spring", "Charan", shift2);
			Teacher sami = new Teacher(2, "Java", "Sami", shift1);
			Teacher pradeep = new Teacher(3, "Angular", "Pradeep", shift2);
			

			session.save(charan);
			session.save(sami);
			session.save(pradeep);
		
			
			tx.commit();
			c.displayRecords();
			c.closeSession(factory);
			
			
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void displayRecords() throws HibernateException{
		try {
		Session session = factory.openSession();
		List teacherList = session.createQuery("From Teacher").list();
		display(teacherList);
		session.close();
		}
		catch(HibernateException ex) {
			System.out.println("Exception Occurred in display records" + ex.getMessage());
		}
	}
	public void display(List obj) {
		for(Iterator iterator = obj.iterator(); iterator.hasNext();) {
			Teacher clg = (Teacher) iterator.next();
			System.out.println("Students studying under "+clg.getName()+":\n");
			Set<Student> std = clg.getStd();
			Iterator it = std.iterator();
			while(it.hasNext()) {
				System.out.println(it.next().toString());
			}
		}
	}
	public void closeSession(SessionFactory f) {
		f.close();
		if(!f.isClosed()) {
			System.out.println("Hey I am closing the session");
			f.close();	
		}
	}
	
	
}
