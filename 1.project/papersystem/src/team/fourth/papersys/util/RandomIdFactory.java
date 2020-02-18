package team.fourth.papersys.util;

import java.util.Random;

public class RandomIdFactory {
	
	// 生成10位数字的随机数
	public static String getRandomId() {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			sb.append(random.nextInt(10));
		}
		return sb.toString();
	}
	
}
