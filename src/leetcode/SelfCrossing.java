package leetcode;

import java.util.ArrayList;

/**
 * Created by Shawtung on 3/31/16.
 */
public class SelfCrossing {
	public boolean isSelfCrossing(int[] x) {

		int leftmost = 0, rightmost = 0, upmost = 0, downmost = 0;
		int lf = 0, ud = 0, i = 0;
		while (i < x.length) {
			if (i%2 == 0) {
				ud += ((i+1)/2%2 == 0 ? x[i++] : -x[i++]);
				if (ud < downmost) {
					downmost = ud;
				} else if (upmost < ud) {
					upmost = ud;
				}
			} else {
				lf += ((i+1)/2%2 == 0 ? x[i++] : -x[i++]);
				if (lf < leftmost) {
					leftmost = lf;
				} else if (rightmost < lf) {
					rightmost = lf;
				}
			}
		}

		int width = rightmost-leftmost;
		int height = upmost-downmost;
		int px = -leftmost;
		int py = -downmost;
		boolean[][] path = new boolean[width+1][height+1];
		path[px][py] = true;

		for (int j = 0; j < x.length; j++) {
			switch (j%4) {
				case 0 :
					for (int k = 0; k < x[j]; k++) {
						if (path[px][++py]) {
							return true;
						}
						path[px][py] = true;
					}
					break;
				case 1 :
					for (int k = 0; k < x[j]; k++) {
						if (path[--px][py]) {
							return true;
						}
						path[px][py] = true;
					}
					break;
				case 2 :
					for (int k = 0; k < x[j]; k++) {
						if (path[px][--py]) {
							return true;
						}
						path[px][py] = true;
					}
					break;
				case 3 :
					for (int k = 0; k < x[j]; k++) {
						if (path[++px][py]) {
							return true;
						}
						path[px][py] = true;
					}
					break;
			}
		}

		return false;
	}

	class Point {
		double x;
		double y;
		Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	public boolean judgeCrossing(Point A, Point B, Point C, Point D) {
		if (A.x == B.x) {
			if (A.y <= B.y) {
				if (C.x <= D.x) {
					return (A.y <= C.y && C.y <= B.y) && (C.x <= A.x && A.x <= D.x);
				} else {
					return (A.y <= C.y && C.y <= B.y) && (D.x <= A.x && A.x <= C.x);
				}
			} else {
				if (C.x <= D.x) {
					return (B.y <= C.y && C.y <= A.y) && (C.x <= A.x && A.x <= D.x);
				} else {
					return (B.y <= C.y && C.y <= A.y) && (D.x <= A.x && A.x <= C.x);
				}
			}
		} else { //A.y == B.y
			if (A.x <= B.x) {
				if (C.y <= D.y) {
					return (A.x <= C.x && C.x <= B.x) && (C.y <= A.y && A.y <= D.y);
				} else {
					return (A.x <= C.x && C.x <= B.x) && (D.y <= A.y && A.y <= C.y);
				}
			} else {
				if (C.y <= D.y) {
					return (B.x <= C.x && C.x <= A.x) && (C.y <= A.y && A.y <= D.y);
				} else {
					return (B.x <= C.x && C.x <= A.x) && (D.y <= A.y && A.y <= C.y);
				}
			}
		}
	}

	public boolean isSelfCrossing2(int[] x) {
		Point p = new Point(0, 0);
		ArrayList<Point> path = new ArrayList<>();
		path.add(p);

		for (int i = 0; i < x.length; i++) {
			switch (i%4) {
				case 0 :
					path.add(new Point(path.get(i).x, path.get(i).y+x[i]));
					break;
				case 1 :
					path.add(new Point(path.get(i).x-x[i], path.get(i).y));
					break;
				case 2 :
					path.add(new Point(path.get(i).x, path.get(i).y-x[i]));
					break;
				case 3 :
					path.add(new Point(path.get(i).x+x[i], path.get(i).y));
					break;
			}
		}

		if ((path.size() > 5) && (path.get(5).x == 0 && path.get(5).y == 0)) {
			return true;
		}

		for (int i = 3; i < path.size()-1; i++) {
			if (judgeCrossing(path.get(i-3), path.get(i-2),
					path.get(i), path.get(i+1))) {
				return true;
			}
		}

		for (int i = 5; i < path.size()-1; i++) {
			if (judgeCrossing(path.get(i-5), path.get(i-4),
					path.get(i), path.get(i+1))) {
				return true;
			}
		}
		return false;
	}



	public static void main(String[] args) {
		int[] yy = {2,1,1,2,};
//		System.out.println(new SelfCrossing().isSelfCrossing(yy));
		System.out.println(new SelfCrossing().isSelfCrossing2(yy));
	}
}


