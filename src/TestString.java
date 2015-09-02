public class TestString {
	public static void main(String[] args) {
//		Date d = new Date(0L);
//		Date e = new Date(0,0,0);
//		time h = new time();
//		System.out.println(e);
//		String str = String.valueOf(d);
//		System.out.println(str);
//		
//		String s = d.toString();
//		System.out.println(s);
//		System.out.println();
//			
//		
/*		
		String a = "ooboo:a"+""+"nd:foo";
		String[] b = a.split("o");
				
		
		
*/
/*		
		String s1 = "hello ";
		String s3 = s1;
		String s2 = "world!";
		System.out.println(s1+=s2);
		System.out.println(s1);
		System.out.println(s3);

		
		
		
		StringBuffer sb1 = new StringBuffer("hello ");
		StringBuffer sb3 = sb1;
		StringBuffer sb2 = new StringBuffer("world!");
		
		System.out.println(sb1.append(sb2));
		System.out.println(sb1);
		System.out.println(sb3);
		System.out.println(sb3.delete(3, 4));
		System.out.println(sb3);
		System.out.println(sb3.insert(3, 4));
		System.out.println(sb3);
		return;
		
*/

		String[] b = "1,2;3,4,5;0,5,6,8,9".split(";");
		double[][] a = new double[b.length][];

		for (int i = 0; i < b.length; i++) {
			a[i] = new double[b[i].split(",").length];
			for (int j = 0; j < b[i].split(",").length; j++)
				a[i][j] = Double.parseDouble(b[i].split(",")[j]);
		}

		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + "  ");
			}
			System.out.println();
		}

	}

}
