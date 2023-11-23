package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타일링 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		if(n == 1){
			System.out.println(1);
			return;
		}

		if(n == 2) {
			System.out.println(2);
			return;
		}

		long[] dp = new long[n+1];

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;

		for(int i = 3; i < n+1; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		}

		System.out.println(dp[n]);
	}
}
