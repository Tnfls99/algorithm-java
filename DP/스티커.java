package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 스티커 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for(int k = 0; k < t; k++) {
			int n = Integer.parseInt(br.readLine());

			int[][] stickers = new int[2][n];
			for(int i = 0; i < 2; i++) {
				stickers[i] = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			}

			int[][] dp = new int[2][n];

			dp[0][0] = stickers[0][0];
			dp[1][0] = stickers[1][0];
			int max = Math.max(dp[0][0], dp[1][0]);

			for(int i = 1; i < n; i++) {
				if(i == 1) {
					dp[0][i] = dp[1][0] + stickers[0][i];
					dp[1][i] = dp[0][0] + stickers[1][i];
					max = Math.max(dp[0][i], dp[1][i]);
					continue;
				}

				dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + stickers[0][i];
				dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + stickers[1][i];
				max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
			}

			System.out.println(max);
		}
	}
}
