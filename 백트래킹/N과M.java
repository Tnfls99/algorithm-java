package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N과M {

	private static int n, m;
	private static boolean[] nums;
	private static int[] array;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] inputs = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		n = inputs[0];
		m = inputs[1];

		nums = new boolean[n+1];
		array = new int[m+1];

		dfs(0);

		System.out.println(sb);
	}

	private static void dfs(int idx) {
		if(idx == m) {
			for(int i = 0; i < m; i++) {
				sb.append(array[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for(int i = 1; i < n+1; i++) {
			if(nums[i]) continue;

			nums[i] = true;
			array[idx] = i;
			dfs(idx+1);
			nums[i] = false;
		}
	}
}
