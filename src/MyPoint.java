public class MyPoint {
	// Variable
	private double scale_x;
	private double scale_y;
	private double scale_z;

	// Construct
	MyPoint(double _x, double _y, double _z) {
		scale_x = _x;
		scale_y = _y;
		scale_z = _z;
	}

	// Method
	public void setScale(double _x, double _y, double _z) {
		scale_x = _x;
		scale_y = _y;
		scale_z = _z;
	}

		
//	public String getName(Point b){
//		return toString(b);
//	}
//	
	public void displayScale() {
//		System.out.println(super);
		System.out.println("x=" + scale_x);
		System.out.println("y=" + scale_y);
		System.out.println("z=" + scale_z);
	}

	public double distance() {
		return Math.sqrt(scale_x * scale_x + scale_y * scale_y + scale_z
				* scale_z);
	}

	// Main
	public static void main(String args[]) {
		MyPoint haha = new MyPoint(3, 4, 0);
		haha.displayScale();
		System.out.println("distance="+haha.distance());
		
		haha.setScale(4, 5, 6);
		haha.displayScale();
		System.out.println("distance="+haha.distance());
		
	}
}
