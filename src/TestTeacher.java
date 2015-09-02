class TestPerson {
	private String name;
	private String location;

	TestPerson(String name) {
		this(name, "Beijing");
	}

	TestPerson(String name, String location) {
		this.name = name;
		this.location = location;
	}

	public String info() {
		return "name: " + name + " location: " + location;
	}
}

class TestStudent extends TestPerson {
	private String school;

	TestStudent(String name) {
		this(name, "Beijing", "PKU");
	}

	TestStudent(String name, String school) {
		this(name, "Beijing", school);
	}

	TestStudent(String name, String location, String school) {
		super(name, location);
		this.school = school;
	}

	public String info() {
		return super.info() + " school: " + school;
	}
}

public class TestTeacher extends TestPerson {
	private String title;

	TestTeacher(String name) {
		this(name, "lecturer");
	}

	TestTeacher(String name, String title) {
		this(name, "Beijing", title);
	}

	TestTeacher(String name, String location, String title) {
		super(name, location);
		this.title = title;
	}

	public String info() {
		return super.info() + " title: " + title;
	}
	
	public int info(int i) {
		return 1+1;
	}
			
	
	public static void main(String[]  args) {
		TestPerson p1 = new TestPerson("A");
		TestPerson p2 = new TestPerson("B", "Shanghai");
		TestStudent s1 = new TestStudent("C", "FDU");
		TestStudent s2 = new TestStudent("C", "Shanghai","SJTU");
		TestTeacher t1 = new TestTeacher("T", "Seoul", "Cambridge");
		
		
		System.out.println(p1.info());
		System.out.println(p2.info());
		System.out.println(s1.info());
		System.out.println(s2.info());
		System.out.println(t1.info());
	}
}
