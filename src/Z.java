/**
 * Created by Shaw on 2015/11/12.
 */

interface X {
	int zz();
}

interface Y {
	float zz();
}

public class Z implements X {

	@Override
	public int zz() {
		return 1;
	}

	private class ZImpY implements Y {
		@Override
		public float zz() {
			return 1.1f;
		}
	}

	public static void main(String[] args) {
		X x = new Z();
		System.out.println(new Z().zz());
		System.out.println(new Z().new ZImpY().zz());
	}

}
