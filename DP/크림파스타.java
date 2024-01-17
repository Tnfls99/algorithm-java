package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 크림파스타 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n];
		int[] nums = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int min = nums[0];

		for (int i = 1; i < n; i++) {
			if(min > nums[i]) {
				min = nums[i];
			}

			dp[i] = Math.max(dp[i-1], nums[i] - min);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(dp[i] + " ");
		}

		sb.append("\n");
		System.out.println(sb);
	}
}
