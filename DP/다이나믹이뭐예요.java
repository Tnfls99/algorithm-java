package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 다이나믹이뭐예요 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] inputs = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int n = inputs[0];
		int m = inputs[1];

		long[][] dp = new long[1001][1001];


		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < m+1; j++) {
				if(j == 1 || i == 1) {
					dp[i][j] = 1;
					continue;
				}
				dp[i][j] = (dp[i-1][j] + dp[i-1][j-1] + dp[i][j-1])%1000000007;
			}
		}

		System.out.println(dp[n][m]);
	}
}
