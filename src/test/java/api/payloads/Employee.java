package api.payloads;

public class Employee {
	
	String id;
	
	String name;
    boolean ft;
    String sex;
    double salary;
    String[] shifttype;
   
	
	
	
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isFt() {
		return ft;
	}
	public void setFt(boolean ft) {
		this.ft = ft;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String[] getShifttype() {
		return shifttype;
	}
	public void setShifttype(String[] shifttype) {
		this.shifttype = shifttype;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
       

}
