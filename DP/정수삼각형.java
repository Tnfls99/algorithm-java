package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 정수삼각형 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] nums = new int[n][];

		for(int i = 0; i < n; i++) {
			nums[i] = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		}

		int[][] dp = new int[n][];
		dp[0] = new int[1];
		dp[0][0] = nums[0][0];

		for(int i = 1; i < n; i++) {
			int[] arr = nums[i];
			dp[i] = new int[arr.length];

			for(int j = 0; j < arr.length; j++) {
				if(j == 0) {
					dp[i][j] = dp[i-1][j] + nums[i][j];
				} else if(j == arr.length-1) {
					dp[i][j] = dp[i-1][j-1] + nums[i][j];
				} else {
					dp[i][j] = Math.max(dp[i-1][j-1] + nums[i][j] , dp[i-1][j]+nums[i][j]);
				}
			}
		}

		System.out.println(Arrays.stream(dp[n-1]).max().getAsInt());
	}
}
