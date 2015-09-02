package AnotherPackage;

class MyException extends Exception {
	private int id;

	public MyException(String message, int id) {
		super(message);
		this.id = id;
	}

	public int getId() {
		return id;
	}
}

public class AnoTest {
	public void register(int num) throws MyException{
		if (num < 0) {
			MyException i = new MyException("Negative person amount " + num, 3);
			System.out.println("haha");
			throw i;
		}
		System.out.println("Registration amount " + num + '.');
	}

	public void manager(int num) {
		try {
			register(num);
			System.out.println("Register succeeded.");
		} catch (MyException e) {
			System.out.println("Register failed, ERROR code = " + e.getId());
			e.printStackTrace();
		}
		System.out.println("Operation end.");
	}

	public static void main(String[] args) {
		AnoTest t = new AnoTest();
		t.manager(-33);
	}
}
