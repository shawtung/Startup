import java.util.*;


/**
 * Created by Shaw on 2015/9/17.
 */

public class ComparatorTest {

	public static void main(String[] args) {
		List<Monk> monkList = Monk.createShortList();

/*
		Collections.sort(monkList, new Comparator<Monk>() {
			@Override
			public int compare(Monk m1, Monk m2){
				return m1.getName().compareTo(m2.getName());
			}
		});
*/
/*

		for(Monk m : monkList) {
			m.printName();
		}
		System.out.println();
*/

		Collections.sort(monkList, (m1, m2) -> m2.getName().compareTo(m1.getName()));
		for (Monk m : monkList) {
			m.printName();
		}




















	}

}



class Monk {

	private String Name;

	Monk(String name){
		this.Name = name;
	}

	public void printName(){
		System.out.println(Name);
	}

	public String getName(){
		return Name;
	}

	public static List<Monk> createShortList() {
		List list = new ArrayList<Monk>();

		for (int i = 70; i >= 65; i--) {
			list.add(new Monk(String.valueOf((char)i)));
		}

		return list;
	}

}
