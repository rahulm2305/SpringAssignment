import java.util.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.SQLQuery;
import java.util.List;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.Session;

public class Client {
	private static SessionFactory factory;
	
	public static void getSessionFactory()
	{
		try {
			
			Configuration conf = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
			factory = conf.buildSessionFactory(builder.build());
		}
		catch(Throwable ex) {
			System.err.println("Failed to create session");
			throw new ExceptionInInitializerError(ex);
		}
	}

public static void main(String[] args) throws InterruptedException {
	getSessionFactory();
	
	Client client_1 = new Client();
	
	Address add1 = new Address("Flemingo Road", "Washington DC","USA","532");
	Employee emp1 = new Employee (3, "Charan", "Kumar", 4000, add1);
	//emp1.setAddress (add1);
	client_1.insertData(emp1, add1);

	Address add2 = new Address("RR Nagar", "Bangalore", "India", "560098");
	Employee emp2= new Employee (4, "Rajesh", "Charan", 4000, add2); 
	//emp2.setAddress(add2); 
	client_1.insertData(emp2, add2);
	
	client_1.displayRecords();
	
}

public void insertData(Employee empObj,Address addObj) {
	
	Session session = factory.openSession();

	Transaction tx = session.beginTransaction();
	
	session.save(empObj);
	session.save(addObj);
	tx.commit();

	System.out.println("Employee and Address are inserted");
	session.close();
}

public void displayRecords() throws InterruptedException{
	
	Session session = factory.openSession();
	
	List employees = session.createQuery("FROM Employee").list();
	for (Iterator iterator = employees.iterator();iterator.hasNext();){
		
		Employee employee = (Employee) iterator.next();
		System.out.print("First Name:" + employee.getFirstName());
		System.out.print("Last Name:" + employee.getLastName());
		System.out.print("Salary:" + employee.getSalary());
		Address add = employee.getAddress();
		System.out.println("Address");
		System.out.print("\t Street" + add.getStreet());
		System.out.print("\t City:" + add.getCity());
		System.out.print("\t State:" + add.getState());
		System.out.print("\t Zipcode:" + add.getZipcode());
		
	}
	session.close();
}
}

