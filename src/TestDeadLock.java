/**
 * Created by Shaw on 2015/10/3.
 */
public class TestDeadLock implements Runnable {

	static final int SIZE = 4;
	static Object[] o = new Object[SIZE + 1];

	public int flag;

	public static void main(String[] args) {
		for (int i = 1; i <= SIZE; i++) {
			add(i);
		}
	}

	public static void add(int i) {
		o[i] = new Object();
		TestDeadLock tdl = new TestDeadLock();
		tdl.flag = i;
		Thread t = new Thread(tdl);
		t.start();
	}

	public void run() {
		for (int i = 1; i <= SIZE; i++) {
			if (flag == i) {
				synchronized (o[i]) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (o[i == SIZE ? 1 : i + 1]) {
						System.out.println("ALL released!");
					}
				}
			}
		}
	}

}

















