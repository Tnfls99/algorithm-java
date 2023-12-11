package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 거스름돈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[100001];

		dp[1] = -1;
		dp[2] = 1;
		dp[3] = -1;
		dp[4] = 2;
		dp[5] = 1;

		for(int i = 6; i < n+1; i++) {
			int case1 = dp[i-2] + 1;
			int case2 = dp[i-5] + 1;

			if(case1 == 0 && case2 > 0) {
				dp[i] = case2;
			} else if(case2 == 0 && case1 > 0) {
				dp[i] = case1;
			} else if(case1 == 0 && case2 == 0){
				dp[i] = -1;
			} else {
				dp[i] = Math.min(case1, case2);
			}
		}

		System.out.println(dp[n]);
	}
}
