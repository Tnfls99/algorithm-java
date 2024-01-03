package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 카드구매하기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] cards = Arrays.stream(br.readLine()
			.split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int[] dp = new int[1001];

		dp[1] = cards[0];
		dp[2] = Math.min(cards[1] , cards[0]+cards[0]);

		for(int i = 3; i < n+1; i++) {
			dp[i] = cards[i-1];
			for(int j = 1; j <= i/2; j++) {
				dp[i] = Math.min(dp[i], dp[i-j] + dp[j]);
			}
		}

		System.out.println(dp[n]);
	}
}
