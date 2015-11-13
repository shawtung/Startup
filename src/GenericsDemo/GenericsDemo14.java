package GenericsDemo;

/**
 * Created by Shaw on 2015/11/12.
 */
public class GenericsDemo14 {

	public static void main(String[] args) {
		Info1<Float> i = new Info1<>();
		i.setKey(1.111f);
		fun(i);
	}

	public static void fun(Info1<?> temp) {
		System.out.println("content " + temp);
		System.out.println(temp.getKey().getClass().getName());
		System.out.println(temp.getClass().getName());
//		temp.setKey();
		try {
			System.out.println(Class.forName("C").newInstance().getClass());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}


	}

}

class Info1<K> {

	private K key;

	public void setKey(K key) {
		this.key = key;
	}

	public K getKey() {
		return key;
	}

	public String toString() {
		return key.toString();
	}

}
