package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BABBA {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(br.readLine());

		int[][] dp = new int[45+1][45+1];

		dp[0] = new int[]{1, 0};
		dp[1] = new int[]{0, 1};

		for(int i = 2; i <= k; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-2][0];
			dp[i][1] = dp[i-1][1] + dp[i-2][1];
		}

		System.out.printf("%d %d\n", dp[k][0], dp[k][1]);
	}
}
