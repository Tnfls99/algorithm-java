package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 다리놓기 {
	private static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		dp = new int[30][30];

		for(int k = 0; k < 30; k++){
			dp[k][0] = 1;
			dp[k][k] = 1;
		}

		for(int i = 2; i < 30; i++){
			for(int j = 1; j < 30; j++){
				dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
			}
		}

		for (int i = 0; i < t; i++) {
			String[] inputs = br.readLine().split(" ");
			int n = Integer.parseInt(inputs[0]);
			int m = Integer.parseInt(inputs[1]);

			System.out.println(dp[m][n]);
		}
	}
}
