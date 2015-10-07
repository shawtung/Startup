/**
 * Created by Shaw on 2015/10/6.
 */
public class TestThreadLock implements Runnable {
	private int No;

	public TestThreadLock(int No) {
		this.No = No;
	}

	@Override
	public void run() {
		synchronized (this.getClass()) {
			for (int j = 1; j <= 9; j++) {
				System.out.println(getNo() + j);
			}
		}

	}

	String getNo() {
		StringBuffer tmp = new StringBuffer("");
		for (int j = 1; j < No; j++) {
			tmp = tmp.append("  ");
		}
		return tmp.toString();
	}


	public static void main(String[] args) throws InterruptedException{

		Thread tt1 = new Thread(new TestThreadLock(1));
		Thread tt2 = new Thread(new TestThreadLock(2));
		Thread tt3 = new Thread(new TestThreadLock(3));

		tt1.start();
		Thread.sleep(10);
		tt2.start();
		Thread.sleep(10);
		tt3.start();
	}
}
