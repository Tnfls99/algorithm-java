package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 개미전사 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] foods = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int[] dp = new int[101];

		dp[1] = foods[0];
		dp[2] = Math.max(dp[1], foods[1]);

		for(int i = 3; i < n+1; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2] + foods[i-1]);
		}

		System.out.println(dp[n]);
	}
}
