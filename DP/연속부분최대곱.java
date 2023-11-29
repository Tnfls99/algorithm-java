package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 연속부분최대곱 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		double[] nums = new double[n];
		for(int i = 0; i < n; i++) {
			nums[i] = Double.parseDouble(br.readLine());
		}

		double[] dp = new double[n];
		dp[0] = nums[0];

		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i-1] * nums[i], nums[i]);
		}

		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(dp));
		// System.out.printf("%.3f\n", dp[n-1]);
	}
}
