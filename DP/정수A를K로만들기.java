package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 정수A를K로만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] inputs = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int A = inputs[0];
		int K = inputs[1];

		int[] dp = new int[1000001];
		boolean[] visited = new boolean[1000001];

		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(K);

		Arrays.fill(dp, Integer.MAX_VALUE);

		dp[K] = 0;

		while(!queue.isEmpty()) {
			int t = queue.poll();

			if(visited[t]) {
				continue;
			}

			if(t-1 > 0) {
				dp[t-1] = Math.min(dp[t] + 1, dp[t-1]);
				queue.add(t-1);
			}

			if(t % 2 == 0) {
				dp[t/2] = Math.min(dp[t] + 1, dp[t/2]);
				queue.add(t/2);
			}

			visited[t] = true;
		}

		System.out.println(dp[A]);
	}
}
