public class ThreadTest3 extends Thread {

	private int threadNo;

	public ThreadTest3(int threadNo) {
		this.threadNo = threadNo;
	}

	public static void main(String[] args) throws Exception {

		for (int i = 1; i < 20; i++) {
			new ThreadTest3(i).start();
			Thread.sleep(1);
		}
	}

	public static synchronized void abc(int threadNo) {
		for (int i = 1; i < 10000; i++) {
			System.out.println("No." + threadNo + ":" + i);
		}
	}

	public void run() {
		abc(threadNo);
	}
}