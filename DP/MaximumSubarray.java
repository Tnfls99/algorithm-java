package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximumSubarray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());

			int[] nums = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

			int[] dp = new int[n];

			dp[0] = nums[0];

			for(int i = 1; i < n; i++) {
				dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
			}

			System.out.println(Arrays.stream(dp)
				.max()
				.getAsInt());
		}
	}
}
