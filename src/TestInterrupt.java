import java.util.Date;

/**
 * Created by Shaw on 2015/9/30.
 */
public class TestInterrupt {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException ie) {

		}
//		myThread.interrupt();
//		myThread.flag = false;
	}

}


class MyThread extends Thread {
	boolean flag = true;
	public void run() {
		while (flag) {
			System.out.println(new Date());
			try {
				sleep(1000);

			} catch (InterruptedException ie) {
			}
		}
	}

}
