public class Loop2 {
	public static void main(String[] args) {
		int N = 1000;									//������
		int cursor = 1;									//����ָ��
		int del_count = 0;								//ɾ������
		int index = 1;									//�����±�
		boolean[] loop = new boolean[N + 1];			//�������飬true���ѳ�Ȧ��Ĭ��false

		while (del_count < N - 1) {						//Ȧ�ﻹʣһ������
			if (index > N)								//�±����Խ��
				index = 1;								//������Ϊ1������һȦ������ϣ�ѭ����ʼ
			if (!loop[index]) {							//���±��Ӧ�˻�û��Ȧ
				if (cursor == 3) {						//����3
					loop[index] = true;					//��Ȧ
					del_count++;						//ɾ������+1
					cursor = 0;							//���¿�ʼ����
				}
				cursor++;								//������Ѿ���Ȧ������������
			}
			index++;									//��һ���˼����ж�
		}

		for (int j = 1; j <= N; j++) {					//��������Ǹ�Ϊfalse��Ԫ���±�
			if (loop[j] == false)
				System.out.print(j);
		}
	}
}
