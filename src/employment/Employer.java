package employment;

import java.util.ArrayList;

public class Employer {
	
	String name;
	ArrayList<Employee> employees;
	
	public Employer(String name){
		this.name = name;
		employees = new ArrayList<Employee>();
	}
	
	public String getName(){
		return name;
	}
	
	public Employee getEmployee(int index){
		return employees.get(index);
	}
	
	public void addEmployee(Employee employee){
		if(! employees.contains(employee)){
			employees.add(employee);
			employee.setEmployer(this);
		}
	}
	
	public void removeEmployee(Employee employee){
		if(employees.contains(employee)){
			employees.remove(employee);
			employee.setEmployer(null);
		}
	}
	
	public String toString(){
		return name + ": " + employees.toString();
	}

}
