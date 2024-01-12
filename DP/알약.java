package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알약 {

	private static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		dp = new long[31][31];

		for(int i = 0; i < 31; i++) {
			dp[0][i] = 1;
		}

		// i 는 큰 알약 갯수, j는 작은 알약 갯수, 큰 알약 1개가 없어져야 작은 알약 1개가 생기므로 j는 i보다 1이 작다.
		for(int i = 1; i < 31; i++) {
			for(int j = 0; j < 30; j++) {
				if(j == 0) { // 작은 알약이 없는 경우
					dp[i][j] = dp[i-1][j+1];
					// 큰 알약을 하나 꺼내고 작은 알약 1개가 늘어난다.
				} else { // 작은 알약이 있는 경우
					dp[i][j] = dp[i][j-1] + dp[i-1][j+1];
					// 작은 알약을 하나 꺼내는 경우와 큰 얄약을 하나 꺼내는 경우의 합
				}
			}
		}

		while(true) {
			int t = Integer.parseInt(br.readLine());

			if(t == 0) {
				break;
			}

			long result = dp[t][0];

			sb.append(result);
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
