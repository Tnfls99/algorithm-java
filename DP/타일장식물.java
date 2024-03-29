package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타일장식물 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		long[] dp = new long[81];

		dp[1] = 2;
		dp[2] = 3;

		for(int i = 3; i < n+1; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}

		System.out.println(dp[n] * 2);
	}
}
