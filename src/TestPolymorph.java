
public class TestPolymorph {
	public static void main(String[] args) {
		Lady l3 = new Lady("l3", new Bird("birdname", "green"));
		l3.myPetEnjoy();
	}
}

abstract class Animal {
	private String name;
	
	Animal(String name) {
		this.name = name;
	}
	
	abstract public void enjoy();
}

class Bird extends Animal {
	private String featherColor;
	
	Bird(String n, String f) {
		super(n);
		featherColor = f;
	}
	
	public void enjoy() {
		System.out.println("Bird singing...");
	}
}


class Lady {
	private String name;
	private Animal pet;
	
	Lady(String name, Animal pet) {
		this.name = name;
		this.pet = pet;
	}
	
	public void myPetEnjoy() {
		pet.enjoy();
	}
}














