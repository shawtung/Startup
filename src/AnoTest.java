public class AnoTest {
	public static void main(String[] args) {
		Shape shape = new Circle();
		System.out.println(shape.name);
		shape.printType();
		shape.printName();
	}
}

class Shape {
	public String name = "shape";
	
	public Shape(){
		System.out.println("shape constructor");
	}
	
//	public void printName() {
//		System.out.println();
//	}

	public void printType() {
		System.out.println("this is shape");
	}
	
	public static void printName() {
		System.out.println("shape");
	}

	public int area() {
		return 0;
	}
}

class Circle extends Shape {
	public String name = "circle";
	
	public Circle() {
		System.out.println("circle constructor");
	}
	
	@Override
	public void printType() {
		System.out.println("this is circle");
	}
	
//	@Override
	public static void printName() {
		System.out.println("circle");
	}
	
//	@Override
//	public void printName() {
//		System.out.println("circle");
//	}
}