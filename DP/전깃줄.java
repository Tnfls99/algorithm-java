package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 전깃줄 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] line1 = new int[n];
		int[] line2 = new int[n];

		for(int i = 0; i < n; i++) {
			int[] inputs = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

			line1[i] = inputs[0];
			line2[i] = inputs[1];
		}

		int[] dp = new int[n];
		dp[0] = 1;

		int[] tmp = new int[Arrays.stream(line1).max().getAsInt()];

		for(int i = 0; i < n; i++) {
			tmp[line1[i] - 1] = line2[i];
		}

		int[] tmp2 = new int[n];
		int k = 0;

		for(int i = 0; i < tmp.length; i++) {
			if(tmp[i] == 0) {
				continue;
			}

			tmp2[k] = tmp[i];
			k += 1;
		}

		for(int i = 1; i < tmp2.length; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(tmp2[i] > tmp2[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
		}

		System.out.println(n - Arrays.stream(dp).max().getAsInt());
	}
}
