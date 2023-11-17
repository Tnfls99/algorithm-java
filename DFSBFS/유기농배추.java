package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 유기농배추 {
	private static int[][] d = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			System.out.println(answer(br));
		}
	}

	private static int answer(BufferedReader br) throws IOException {
		int answer = 0;

		String[] inputs = br.readLine().split(" ");
		int m = Integer.parseInt(inputs[0]);
		int n = Integer.parseInt(inputs[1]);
		int k = Integer.parseInt(inputs[2]);

		int[][] map = new int[m][n];

		for (int i = 0; i < k; i++) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);

			map[x][y] = 1;
		}

		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					int count = bfs(i, j, m, n, visited, map);

					if(count > 0){
						answer += 1;
					}
				}
			}
		}

		return answer;
	}

	private static int bfs(int x, int y, int m, int n, boolean[][] visited, int[][] map) {
		int count = 0;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			count += 1;

			for(int[] next : d) {
				int nx = cur[0] + next[0];
				int ny = cur[1] + next[1];

				if(nx >= 0 && nx < m && ny >= 0 && ny < n) {
					if(map[nx][ny] == 1 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						queue.add(new int[]{nx, ny});
					}
				}
			}
		}

		return count;
	}
}
