public class ThreadTest {

	public static void main(String[] args) {
		Thread newthread1 = new Thread(new MyThread1());
		newthread1.start();

		for (int i = 0; i < 20; i++) {
			System.out.println("MT: " + i);
		}
	}

}


class MyThread1 implements Runnable {

	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println("TTTTT: " + i);
		}
	}

}
