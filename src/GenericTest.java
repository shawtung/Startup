import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Shaw on 2015/11/11.
 */
public class GenericTest {
	public static void main(String[] args) throws Exception {
		List a = new ArrayList();
		a.add(new Integer(1));
		a.add("string");
		System.out.println(a.toString());
		Collection<?> c = a;
//		c.add()
		System.out.println(c);
//		c.add(new String()); // Compile time error

		List<Integer> list = new ArrayList<>();
		list.add(100);
//		System.out.println(list.getClass().getName());

		Method method = list.getClass().getDeclaredMethod("add",Object.class);
		method.invoke(list, "hello");
		System.out.println(list);

	}

	void printCollection(Collection<?> c) {
		for (Object e : c) {
			System.out.println(e);
		}
	}

	void func(List<Integer> list) {

	}
}
