public class Loop2 {
	public static void main(String[] args) {
		int N = 1000;									//总人数
		int cursor = 1;									//报数指针
		int del_count = 0;								//删除人数
		int index = 1;									//数组下表
		boolean[] loop = new boolean[N + 1];			//布尔数组，true：已出圈，默认false

		while (del_count < N - 1) {						//圈里还剩一个以上
			if (index > N)								//下标如果越界
				index = 1;								//则重置为1，代表一圈报数完毕，循环开始
			if (!loop[index]) {							//该下标对应人还没出圈
				if (cursor == 3) {						//数到3
					loop[index] = true;					//出圈
					del_count++;						//删除人数+1
					cursor = 0;							//重新开始报数
				}
				cursor++;								//如果是已经出圈的则跳过报数
			}
			index++;									//下一个人继续判断
		}

		for (int j = 1; j <= N; j++) {					//查找最后那个为false的元素下标
			if (loop[j] == false)
				System.out.print(j);
		}
	}
}
