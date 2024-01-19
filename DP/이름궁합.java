package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 이름궁합 {
	private static final int[] ALPHABETS =
		{3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String name1 = br.readLine();
		String name2 = br.readLine();

		int n = name1.length() + name2.length();

		int[][] dp = new int[n-1][];

		dp[0] = new int[n];

		for(int i = 0; i < name1.length(); i++) {
			char c = name1.charAt(i);
			dp[0][i*2] = ALPHABETS[c-65];
		}

		for(int i = 0; i < name2.length(); i++) {
			char c = name2.charAt(i);
			dp[0][i*2+1] = ALPHABETS[c-65];
		}

		for(int i = 1; i < dp.length; i++) {
			dp[i] = new int[dp[i-1].length-1];
			for(int j = 0; j < dp[i].length; j++) {
				dp[i][j] = getUnits(dp[i-1][j] + dp[i-1][j+1]);
			}
		}

		StringBuilder sb = new StringBuilder();
		Arrays.stream(dp[n - 2]).forEach(sb::append);

		System.out.println(sb);
	}

	private static int getUnits(int num){
		return num % 10;
	}
}
