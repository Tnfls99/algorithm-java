package programmers.level3;

import java.util.Arrays;

public class 정수삼각형 {
	public int solution(int[][] triangle) {

		int[][] answer = new int[triangle.length][triangle[triangle.length - 1].length];

		answer[0][0] = triangle[0][0];

		for (int i = 1; i < triangle.length; i++) {
			for (int j = 0; j < triangle[i - 1].length; j++) {
				int left = answer[i - 1][j] + triangle[i][j];
				int right = answer[i - 1][j] + triangle[i][j + 1];

				answer[i][j] = Math.max(answer[i][j], left);
				answer[i][j + 1] = Math.max(answer[i][j + 1], right);
			}
		}

		return Arrays.stream(answer[answer.length - 1])
			.max()
			.getAsInt();
	}
}
