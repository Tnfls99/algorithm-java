package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 바이러스 {

	public static void main(String[] args) throws IOException {
		int answer = 0;

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine());

		List<Integer>[] computers = new ArrayList[n+1];

		int edge = Integer.parseInt(bufferedReader.readLine());

		for (int i = 0; i < n+1; i++) {
			computers[i] = new ArrayList<>();
		}

		for (int i = 0; i < edge; i++) {
			String[] input = bufferedReader.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			computers[a].add(b);
			computers[b].add(a);
		}

		boolean[] visited = new boolean[n+1];

		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = true;

		while (!queue.isEmpty()) {
			int node = queue.poll();

			for (int next : computers[node]) {
				if (!visited[next]) {
					visited[next] = true;
					answer++;
					queue.add(next);
				}
			}
	}

		System.out.println(answer);
	}

}
