package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 상자넣기 {
	// 가장 긴 증가하는 부분 수열을 구하는 문제
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] boxes = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int[] dp = new int[1000];

		dp[0] = 1;

		for(int i = 1; i < n; i++) {
			dp[i] = 1;

			for(int j = 0; j < i; j++) {
				if(boxes[i] > boxes[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
		}

		System.out.println(Arrays.stream(dp).max().getAsInt());
	}
}
