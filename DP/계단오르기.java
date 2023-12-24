package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] stairs = new int[301];

		for (int i = 0; i < n; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[301];

		dp[1] = stairs[0];
		dp[2] = Math.max(stairs[1], stairs[0] + stairs[1]);
		dp[3] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);

		for (int i = 4; i < n + 1; i++) {
			dp[i] = Math.max(dp[i - 3] + stairs[i - 1] + stairs[i - 2], dp[i - 2] + stairs[i - 1]);
		}

		System.out.println(dp[n]);
	}
}
