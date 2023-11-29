package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 점화식 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		if(n == 0) {
			System.out.println(1);
			return;
		}

		long[] dp = new long[n+1];
		dp[0] = 1;
		dp[1] = 1;

		for(int i = 2; i < n+1; i++) {
			long sum = 0;

			for(int j = 0; j < i; j++) {
				sum = sum + dp[j] * dp[i-(j+1)];
			}

			dp[i] = sum;
		}

		System.out.println(dp[n]);
	}
}
