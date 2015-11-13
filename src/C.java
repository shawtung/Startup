import java.util.*;

public class C {

	public static void main(String[] args) {
		Map<String, List<Object>> map = new HashMap<String, List<Object>>();
		List<Object> aList = new ArrayList<Object>();
		aList.add(new A());
		aList.add(new A());

		map.put("1", aList);

		List<Object> bList = new ArrayList<Object>();
		bList.add(new B());
		bList.add(new B());

		map.put("2", bList);

		for (String s : map.keySet()) {
			List<Object> list = map.get(s);

			for (Object object : list) {
				if(object instanceof A) {
					System.out.println("AAA");
				} else {
					System.err.println("BBB");
				}
			}
		}
	}

}

class B {

}

class A {

}