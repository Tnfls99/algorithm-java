package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 돌게임2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] dp = new String[1001];

		dp[1] = "CY";
		dp[2] = "SK";

		for(int i = 3; i < n+1; i++) {
			if(dp[i-1].equals("SK")) {
				dp[i] = "CY";
			} else {
				dp[i] = "SK";
			}
		}

		System.out.println(dp[n]);
	}
}
