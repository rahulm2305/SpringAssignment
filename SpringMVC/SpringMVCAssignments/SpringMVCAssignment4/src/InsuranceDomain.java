

public class InsuranceDomain {
	public int id;
	public String name;
	public String type;
	public String dept;
	public int amount;
	public InsuranceDomain() {
		
	}
	public InsuranceDomain(int id, String name, String type, String dept, int amount) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.dept = dept;
		this.amount = amount;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	

}
