
public class Fib {

	static long f(int i) {
		if (i==1 || i==2){
			return 1;
		}
		else return f(i-1)+f(i-2);
	}

	public static void main(String[] args) {
		long beg = System.currentTimeMillis();
		long med = f(60);
		long end = System.currentTimeMillis();
		System.out.println(med);
		System.out.println(end-beg);
		System.out.println();
	}

}
