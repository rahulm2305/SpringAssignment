import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_one_to_one")

public class Employee{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	
	private int id;

	private String firstName;
	private String lastName;
	private int salary;

	@OneToOne (targetEntity = Address.class, cascade=CascadeType.ALL)
	private Address address;

	public Employee () {}

	public Employee (int id, String fname, String lname, int salary) {

	this.id = id;
	this.firstName = fname;
	this.lastName = lname;
	this. salary = salary;
	
}
	public Employee (int id, String fname, String lname, int salary, Address address ) {

	this.id = id;
	this.firstName = fname;
	this.lastName = lname;
	this.salary = salary; 
	this.address = address;
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first_Name) {
		this.firstName = first_Name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last_Name) {
		this.lastName = last_Name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}