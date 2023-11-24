package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 이항계수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] inputs = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int n = inputs[0];
		int k = inputs[1];

		int[][] dp = new int[n+1][k+1];

		for(int i = 0; i < n+1; i++) {
			dp[i][0] = 1;
		}

		for(int i = 0; i < k+1; i++) {
			dp[i][i] = 1;
		}

		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < k+1; j++) {
				if(i == j) {
					dp[i][j] = 1;
				} else {

					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;
				}
			}
		}

		System.out.println(dp[n][k]);
	}
}
