/**
 * Created by Shaw on 2015/9/20.
 */

import java.io.*;


public class TestPrintStream1 {

	public static void main(String[] args) throws IOException {
		PrintStream OriginalOut = System.out;

		FileOutputStream fos = new FileOutputStream("d:/1.txt");
		PrintStream ps = new PrintStream(fos);


		if (ps != null) {
			System.setOut(ps);
		}

		int ln = 0;
		for (char c = 0; c < 1000; c++) {
			System.out.print(c);
			if (ln++ >= 100 && (ln = 0) == 0) {
				System.out.println();
			}
		}

		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		System.out.println("Finished");


	}


}
