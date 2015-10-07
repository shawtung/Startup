/**
 * Created by Shaw on 2015/10/2.
 */
public class TestYield {
	public static void main(String[] args) {
		MyThread3 t1 = new MyThread3("t1");
		MyThread3 t2 = new MyThread3("\tt2");
		t1.setPriority(1);
		t2.setPriority(10);
		t1.start();
		t2.start();
	}

}

class MyThread3 extends Thread {
	MyThread3(String s) {
		super(s);
	}

	public void run() {
		System.out.println(Thread.currentThread().isAlive());
		for (int i = 1; i <= 50; i++) {
			System.out.println(getName() + ": " + i);
			if (i % 12 == 0) {
				yield();
			}
		}

	}

}