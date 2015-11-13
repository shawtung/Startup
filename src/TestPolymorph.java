
public class TestPolymorph {
	public static void main(String[] args) {
		Lady l3 = new Lady("l3", new Bird("birdname", "green"));
		l3.myPetEnjoy();
	}
}

class Animal {
	private String name;
	
	Animal(String name) {
		this.name = name;
	}
	
	static Number enjoy() {
		return new Integer(1);
	}
}

class Bird extends Animal {
	private String featherColor;
	
	Bird(String n, String f) {
		super(n);
		featherColor = f;
	}

//	@Override
	static protected Long enjoy() {
		double a = 0.1f;
		System.out.println("Bird singing...");
		return null;
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














