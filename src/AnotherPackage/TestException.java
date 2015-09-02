package AnotherPackage;

public class TestException {
	public static void main(String[] args) {
		TestException test = new TestException();
		try {
			test.method1();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void method1() {
		try {
			method2();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERR M1");
		}
	}

	public void method2() {
		try {
			method3();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERR M2");
		}
	}

	public void method3() {
		try {
			throw new Exception("Some Exception occured in method3");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("ERR M3");
		}
	}
}
