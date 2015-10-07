/**
 * Created by Shaw on 2015/10/3.
 */
public class TestSyncLock implements Runnable {

	int b = 100;

	public synchronized void m1() {
		b = 1000;
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("m1 " + b);
	}

	public void m2() {
		b = 300;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("m2 " + b);
	}

	@Override
	public void run() {
		m1();
	}

	public static void main(String[] args) {
		TestSyncLock tsl = new TestSyncLock();
		Thread t = new Thread(tsl);
		t.start();
		synchronized (TestSyncLock.class) {

		}

		tsl.m2();
	}

}
