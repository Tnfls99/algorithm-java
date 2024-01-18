package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 평범한배낭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] inputs = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int n = inputs[0];
		int k = inputs[1];

		int[] values = new int[n+1];
		int[] weights = new int[n+1];

		int[][] dp = new int[n+1][k+1];

		for(int i = 1; i <= n ;i++) {
			int[] input = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

			weights[i] = input[0];
			values[i] = input[1];
		}

		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < k+1; j++) {
				if(weights[i] > j) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = Math.max(dp[i-1][j-weights[i]] + values[i], dp[i-1][j]);
				}
			}
		}

		System.out.println(dp[n][k]);
	}
}
