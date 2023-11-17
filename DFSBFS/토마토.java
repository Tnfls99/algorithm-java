package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 토마토 {
	private static int[][] d = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	private static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] inputs = br.readLine().split(" ");
		int m = Integer.parseInt(inputs[0]);
		int n = Integer.parseInt(inputs[1]);

		int[][] map = new int[n][m];

		for (int i = 0; i < n; i++) {
			map[i] = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		}

		boolean[][] visited = new boolean[n][m];

		Queue<int[]> queue = new LinkedList<>();

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				if (map[y][x] == 1) {
					queue.add(new int[] {x, y});
					visited[y][x] = true;
				}
			}
		}

		while (!queue.isEmpty()) {
			queue = bfs(m, n, map, visited, queue);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}

		System.out.println(count-1);
	}

	private static Queue bfs(int m, int n, int[][] map, boolean[][] visited, Queue<int[]> queue) {
		Queue<int[]> nqueue = new LinkedList<>();

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int[] next : d) {
				int nx = cur[0] + next[0];
				int ny = cur[1] + next[1];

				if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
					if (map[ny][nx] == 0 && !visited[ny][nx]) {
						map[ny][nx] = 1;
						visited[ny][nx] = true;
						nqueue.add(new int[] {nx, ny});
					}
				}
			}
		}

		count++;
		return nqueue;
	}
}
