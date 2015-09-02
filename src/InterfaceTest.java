interface Singer {
	public void sing();

	public String getName();

	public void sleep();
}

interface Painter {
	public void paint();

	public String getName();

	public void eat();
}

class Teacher implements Singer, Painter {
	private String name;

	public String getName() {
		return name;
	}

	Teacher(String name) {
		this.name = name;
	}

	public void teach() {
		System.out.println(name + " teacher is teaching");
	}

	public void sing() {
		System.out.println(name + " teacher is singing");
	}

	public void sleep() {
		System.out.println(name + " teacher is sleep");
	}

	public void paint() {
		System.out.println(name + " teacher is painting");
	}

	public void eat() {
		System.out.println(name + " teacher is eating");
	}
}

class Student implements Singer {
	private String name;

	Student(String name) {
		this.name = name;
	}

	public void study() {
		System.out.println(name + " Studying");
	}

	public String getName() {
		return name;
	}

	public void sing() {
		System.out.println(name + " student sings");
	}

	public void sleep() {
		System.out.println(name + " Student sleeps");
	}
}

public class InterfaceTest {
	public static void main(String[] args) {
		// Singer s1 = new Student("le");
		// s1.sing();
		// s1.sleep();
		// System.out.println(s1.getClass());

		Singer s2 = new Teacher("Steven");
		s2.sing();
		// s2.teach();
		// s2.paint();
		System.out.println(s2.getClass() + "\n");

		Painter p1 = new Teacher("Jobs");
		// p1.sing();
		// p1.teach();
		p1.paint();
		System.out.println(p1.getClass() + "\n");

		Teacher t1 = (Teacher) p1;
		((Teacher) s2).sing();
		((Teacher) p1).teach();
		t1.paint();
		System.out.println(t1.getClass() + "\n");
		
		
	}
}
