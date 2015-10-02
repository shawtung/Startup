/**
 * Created by Shaw on 2015/9/29.
 */
public class ThreadTest {
	public static void main(String[] args) {
		Thread newthread = new Thread(() -> {
			for (int i = 0; i < 20; i++) {
				System.out.println("TTTTT: " + i);
			}
		});
		newthread.run();
		newthread.start();
		for (int i = 0; i < 20; i++) {
			System.out.println("MT: " + i);
		}

	}
}

/*

class MyThread implements Runnable {
	public static Thread currentThread() {
		return Thread.currentThread();
	}
//class MyThread extends Thread {
	public void run() {

		while (true) {
			System.out.println(new Date());
			try {
				Thread.sleep(1000);

			} catch (InterruptedException ie) {
				return;
			}
		}



		for (int i = 0; i < 100; i++) {
			System.out.println("TTTTT: " + i);
		}
	}
}
*/
