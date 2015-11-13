
/**
 * Created by Shaw on 2015/11/10.
 */
public class GenericMemoryCell<AnyType> {

	private AnyType storedValue;

	public AnyType read() {
		return storedValue;
	}

/*
	public Class getType() {
		return ;
	}
*/

	public void write(AnyType anyType) {
		storedValue = anyType;
	}

	public boolean contains(AnyType[] arr, AnyType x) {
		for (AnyType val : arr)
			if (x.equals(val))
				return true;
		return false;
	}

	public static void main(String[] args) {

/*
		GenericMemoryCell<String> gmc = new GenericMemoryCell<>();
		String[] a = {"- =","= -","- -","= ="};
		System.out.println(gmc.contains(a, "- -"));
*/

		GenericMemoryCell<Integer> cell1 = new GenericMemoryCell<>();
		cell1.write(4);
		Object cell = cell1;
		GenericMemoryCell<String> cell2 = (GenericMemoryCell) cell;
		System.out.println(cell2 instanceof GenericMemoryCell);
//		String s = cell2.read();
	}


	public static <AnyType extends Comparable<? super AnyType>> AnyType findMax(AnyType[] arr) {

		int maxIndex = 0;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i].compareTo(arr[maxIndex]) > 0) {
				maxIndex = i;
			}
		}

		return arr[maxIndex];

	}

}

