public class Test {
	public static void main (String[] args) throws ClassNotFoundException {
		final int i = 1;
		Bread bread1 = new Bread();
		Bread bread2 = new Bread();
	}
}

class Bread {
	static {
		System.out.println("Bread is Loaded");
	}
	
	Bread(){
		System.out.println("Bread");
	}
}