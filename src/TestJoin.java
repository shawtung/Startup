public class TestJoin {
	public static void main(String[] args) {
		MyThread2 t1 = new MyThread2("awerty");
		t1.start();

		try {
			t1.join();
		} catch (InterruptedException ie) {

		}

		for (int i = 1; i < 11; i++) {
			System.out.println("I'm the main thread " + i);
		}
	}
}


class MyThread2 extends Thread {
	MyThread2(String s) {
		super(s);
	}

	public void run() {
		for (int i = 1; i < 11; i++) {
			System.out.println("I'm " + getName() + ' ' + i);
		}
		try {
			sleep(1000);
		} catch (InterruptedException ie) {
			return;
		}
	}

}