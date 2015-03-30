package employment;

public class Employee {
	
	private String name;
	Employer employer;
	
	public Employee(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public Employer getEmployer(){
		return employer;
	}
	
	public void setEmployer(Employer employer){
		if(this.employer == employer){
			return;
		}
		else if(employer == null){
			this.employer.removeEmployee(this);
			this.employer = null;
		} else if(this.employer == null){
			this.employer = employer;
		} else{
			this.employer.removeEmployee(this);
			this.employer = employer;
			this.employer.addEmployee(this);
		}
		
	}
	
	public String toString(){
		if(employer!= null){
			return name + "@" + employer.getName();			
		} else {
			return name + "@null";
		}
	}
	
	public static void main(String[] args) {
		Employer accenture = new Employer("Accenture");
		Employee kristian = new Employee("Kristian");
		Employee nicolaj = new Employee("Nicolaj");
		Employee moritz = new Employee("Morritz");
		Employer burgerking = new Employer("BurgerKing");
		accenture.addEmployee(kristian);
		accenture.addEmployee(nicolaj);
		accenture.addEmployee(moritz);
		System.out.println(accenture);
		System.out.println(burgerking);
		nicolaj.setEmployer(burgerking);
		burgerking.addEmployee(moritz);
		System.out.println(accenture);
		System.out.println(burgerking);
		
		
	}

}
