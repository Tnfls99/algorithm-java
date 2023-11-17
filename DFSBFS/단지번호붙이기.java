package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 단지번호붙이기 {
	private static int[][] d = new int[][] {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] map = new int[n][n];

		for (int i = 0; i < n; i++) {
			map[i] = Arrays.stream(br.readLine().split(""))
				.mapToInt(Integer::parseInt)
				.toArray();
		}

		boolean[][] visited = new boolean[n][n];

		List<Integer> apartments = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (map[i][j] == 1 && !visited[i][j]) {
					int count = bfs(n, map, visited, i, j);
					apartments.add(count);
				}
			}
		}

		apartments.sort(Comparator.naturalOrder());

		System.out.println(apartments.size());
		apartments.forEach(System.out::println);
	}

	private static int bfs(int n, int[][] map, boolean[][] visited, int x, int y) {
		int count = 0;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			count += 1;

			for (int[] next : d) {
				int nx = cur[0] + next[0];
				int ny = cur[1] + next[1];

				if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					if (map[nx][ny] == 1 && !visited[nx][ny]) {
						queue.add(new int[] {nx, ny});
						visited[nx][ny] = true;
					}
				}
			}
		}

		return count;
	}
}
