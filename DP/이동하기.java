package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 이동하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] size = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int n = size[0];
		int m = size[1];

		int[][] map = new int[n][m];
		int[][] dp = new int[n][m];

		for(int i = 0; i < n; i++) {
			map[i] = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		}

		int[][] next = new int[][]{{1, 0}, {0, 1}, {1, 1}};

		dp[0][0] = map[0][0];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				for(int[] nt : next) {
					int nx = j + nt[0];
					int ny = i + nt[1];

					if(nx < m && nx >= 0 && ny < n && ny >= 0) {
						dp[ny][nx] = Math.max(map[ny][nx] + dp[i][j], dp[ny][nx]);
					}
				}
			}
		}

		System.out.println(dp[n-1][m-1]);
	}
}
