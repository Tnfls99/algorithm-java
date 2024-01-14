package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피자 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[11];

		dp[2] = 1;

		for(int i = 3; i < n+1; i++) {
			for(int j = 1; j <= i/2; j++) {
				int tmp = j * (i-j);

				dp[i] = Math.max(dp[i], tmp + dp[j] + dp[i-j]);
			}
		}

		System.out.println(dp[n]);
	}
}
