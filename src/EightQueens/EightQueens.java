package EightQueens;

public class EightQueens {
	public static void main(String[] args) {
		Board b;
		Queen[] x;
		boolean overlap;
		
		
/* DEMO
		do {
			x = new Queen[9];
			
			//���ɲ��ظ��İ˸����ӵ�����
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
			
			//��������λ����������
			b = new Board(x);
			
			//�ж�����ǺϷ����ͲŴ�ӡ����
			if (b.boardIsNotConflicted()) {
				b.printBoard();
				System.out.println(b.boardIsNotConflicted());
			}

		} while (!b.boardIsNotConflicted());
*/
		
		
		
	}
}
