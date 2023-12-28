package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 쉬운계단수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		System.out.println(func1(n));
	}

	private static long func1(int n){
		long[][] dp = new long[101][10];

		for(int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}

		for(int i = 2; i < n+1; i++) {
			dp[i][0] = dp[i-1][1]%1000000000; // 0으로 시작하는 수는 이전 길이에서 뒤의 자리가 1로 끝나는 것들의 갯수와 동일하다.

			for(int j = 1; j < 9; j++) {
				dp[i][j] = (dp[i-1][j+1] + dp[i-1][j-1])%1000000000;
			}

			dp[i][9] = dp[i-1][8]%1000000000; // 9로 시작하는 수는 이전 길이에서 뒤의 자리가 8로 끝나는 것들의 갯수와 동일하다.
		}

		return Arrays.stream(dp[n]).sum()%1000000000;
	}
}
