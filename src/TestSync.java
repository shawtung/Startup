/**
 * Created by Shaw on 2015/10/3.
 */
public class TestSync implements Runnable {
	Timer timer = new Timer();

	public static void main(String[] args) {
		TestSync test = new TestSync();
		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test);
		Thread t3 = new Thread(test);
		t1.setName("t1");
		t2.setName("t2");
		t3.setName("t3");
		t1.start();
		t2.start();
		t3.start();

	}

	public void run() {
		timer.add(Thread.currentThread().getName());
	}
}

class Timer {
	private static int ord = 0;

	public void add(String name) {
		ord++;
/*
		try {
			Thread.sleep(1);
		} catch (InterruptedException ie) {

		}
*/
		System.out.println(name + ' ' + ord);
	}
}
