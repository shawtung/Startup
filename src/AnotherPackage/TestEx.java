package AnotherPackage;

import java.io.*;

public class TestEx {
	public static void main(String[] args) {
/*		FileInputStream in = null;

		try {
			in = new FileInputStream("myfile.txt");
			int b;
			b = in.read();
			while (b != -1) {
				System.out.println((char) b);
				b = in.read();
			}
		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (NullPointerException e) {

			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}*/

/*		int[] arr = { 1, 2, 3 };

		try {
			System.out.println(arr[1]);
			System.out.println(arr[4]);
			System.out.println(arr[4]);
			System.out.println(arr[1]);
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("Mending\n");
		}

		for (int i = 0; i <= 7; i++) {
			try {
				System.out.println(arr[i]);
				System.out.println("Correct");
			} catch (Exception e) {
//				e.printStackTrace();
				System.out.println("This is the end");
//				break;
			}
		}

		System.out.println("\nThis isn't the end");
	}
*/
		FileInputStream in = null;

		try {
			in = new FileInputStream("Myfile.txt");
			int b;
			b = in.read();
			while (b != -1) {
				System.out.println((char) b);
				b = in.read();
			}
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("ÕÒ²»×Å");
		} catch (IOException e) {
//			System.out.println(e.getMessage());
			System.out.println("IO´í1");
		} finally {
			try {
				in.close();
			} catch (NullPointerException e) {
//				e.printStackTrace();
				System.out.println("IO´í2");
			} catch (IOException e) {
//				e.printStackTrace();
				System.out.println("¿ÕÖ¸Õë");
			}
		}

	}

	void m(int i) throws ArithmeticException {
		if (i == 0)
			throw new ArithmeticException("asdfasdf");
	}
}
