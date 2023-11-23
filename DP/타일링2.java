package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타일링2 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		if(n == 1) {
			System.out.println(1);
			return;
		}

		if(n == 2){
			System.out.println(3);
			return;
		}

		int[] dp = new int[n+1];

		dp[1] = 1;
		dp[2] = 3;
		dp[3] = 5;

		for(int i = 4; i < n+1; i++) {
			if(i % 2 == 0) {
				dp[i] = (dp[i-1] * 2 + 1)%10007;
			} else {
				dp[i] = (dp[i-1] * 2 - 1)%10007;
			}
		}

		System.out.println(dp[n]);
	}
}
