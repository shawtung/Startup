package EightQueens;

public class EightQueens {
	public static void main(String[] args) {
		Board b;
		Queen[] x;
		boolean overlap;
		
		
/* DEMO
		do {
			x = new Queen[9];
			
			//生成不重复的八个棋子的坐标
			for (int i = 1; i <= 8; i++) {
				Queen temp = new Queen((int) (Math.random() * 8 + 1), (int) (Math.random() * 8 + 1));
				overlap = false;
				if (i == 1)
					x[i] = temp;
				else {
					for (int j = 1; j < i; j++) {
						if (x[j].x == temp.x && x[j].y == temp.y) {
							overlap = true;
							break;
						}
					}
				}
				if (overlap)
					i--;
				else
					x[i] = temp;
			}
			
			//根据棋子位置生成棋盘
			b = new Board(x);
			
			//判断如果是合法阵型才打印出来
			if (b.boardIsNotConflicted()) {
				b.printBoard();
				System.out.println(b.boardIsNotConflicted());
			}

		} while (!b.boardIsNotConflicted());
*/
		
		
		
	}
}
