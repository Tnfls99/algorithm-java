package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 가장큰증가하는부분수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] nums = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int[] dp = new int[n];

		dp[0] = nums[0];

		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + nums[i]);
				} else {
					dp[i] = Math.max(dp[i], nums[i]);
				}
			}
		}

		System.out.println(Arrays.stream(dp).max().getAsInt());
	}
}
