
public class Employee {
	private String name;
	private int salary;
	
	
	public Employee(String n, int s) {
		name = n;
		salary = s;
	}
	
	public Employee(String n) {
		this(n, 0);
	}
	


	public Employee() {
		this("²»ÖªµÀ", 0);
	}
	
	public void display() {
		System.out.println(name);
		System.out.println(salary);
	}

}

class thisClass {
	public static void main(String[] args) {
		Employee a = new Employee("¸òîþ");
		a.display();
	}
}
