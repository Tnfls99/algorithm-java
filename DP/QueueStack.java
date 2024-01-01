package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class QueueStack {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] structures = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		long[] nums = Arrays.stream(br.readLine().split(" "))
			.mapToLong(Long::parseLong)
			.toArray();
		int m = Integer.parseInt(br.readLine());
		long[] inserts = Arrays.stream(br.readLine().split(" "))
			.mapToLong(Long::parseLong)
			.toArray();

		Deque<Long> deque = new ArrayDeque();

		for(int i = 0; i < n; i++) {
			if(structures[i] == 0) {
				deque.addLast(nums[i]);
			}
		}

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < m; i++) {
			deque.addFirst(inserts[i]);
			sb.append(deque.pollLast() + " ");
		}
		System.out.println(sb);
	}
}
