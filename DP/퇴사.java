package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 퇴사 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] info = new int[n][2];

		for(int i = 0; i < n; i++) {
			info[i] = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		}

		int[] dp = new int[n+1];

		for(int i = 0; i < n; i++) {
			int days = info[i][0];
			int paid = info[i][1];

			if(i + days <= n) { // 일하는 날짜가 벗어나지 않는다면
				dp[i + days] = Math.max(dp[i + days], dp[i] + paid);
			}

			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}

		System.out.println(dp[n]);
	}
}
