import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Shaw on 2015/11/6.
 */
public class CovariantTest {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Object[] arr = new String[10];
		arr[0] = Integer.toString(1111, 2);
//		System.out.println(arr[0]);
//		List<Object> list = new ArrayList<String>();
//		list.add(10);
//		display1(123, 123f);

		class Generic {

			public <T> T getObject(Class<T> c) throws InstantiationException, IllegalAccessException {
				return c.newInstance();
			}

		}

		Object obj = new Generic().getObject(Class.forName("Daemons"));
		System.out.println(obj.getClass());
	}

	public static <T> T[] fun1(T[] arg){  // 接收可变参数
		return arg ;            // 返回泛型数组
	}

	public static <D extends Number, E extends String> void display1(D t1, E t2) {
		System.out.println(t1.getClass());
		System.out.println(t2.getClass());
	}

	public static double totalArea(Collection<Shape> arr) {
		double total = 0;
		for (Shape s : arr)
			if (s != null)
				total += s.area();
		return total;
	}

}

