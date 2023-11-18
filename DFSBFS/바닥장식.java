package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 바닥장식 {

	private static boolean[][] visited;
	private static String[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);

		map = new String[n][m];

		for (int y = 0; y < n; y++) {
			map[y] = br.readLine().split("");
		}

		visited = new boolean[n][m];

		int count = 0;

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				if (visited[y][x]) {
					continue;
				}
				dfs(m, n, x, y, map[y][x]);
				count++;
			}
		}

		System.out.println(count);
	}

	private static void dfs(int m, int n, int x, int y, String type) {
		visited[y][x] = true;

		if (type.equals("-")) {
			int nx = x + 1;

			if (nx < m && map[y][nx].equals(type)) {
				dfs(m, n, nx, y, type);
			}
		} else {
			int ny = y + 1;

			if (ny < n && map[ny][x].equals(type)) {
				dfs(m, n, x, ny, type);
			}
		}
	}
}
