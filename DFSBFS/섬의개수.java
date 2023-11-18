package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 섬의개수 {
	private static final int[][] d = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}, {-1, 1}, {1, -1}, {-1, -1}, {1, 1}};
	private static boolean[][] visited;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			String[] inputs = br.readLine().split(" ");
			int w = Integer.parseInt(inputs[0]);
			int h = Integer.parseInt(inputs[1]);

			if(w == 0 && h == 0) {
				break;
			}

			map = new int[h][w];

			visited = new boolean[h][w];

			for (int y = 0; y < h; y++) {
				map[y] = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			}

			int count = 0;

			for(int y = 0; y < h; y++) {
				for(int x = 0; x < w; x++) {
					if(visited[y][x]){
						continue;
					}

					if(map[y][x] == 1) {
						dfs(w, h, x, y);
						count++;
					}
				}
			}

			System.out.println(count);
		}

	}

	private static void dfs(int w, int h, int x, int y) {
		visited[y][x] = true;

		for(int[] next : d) {
			int nx = x + next[0];
			int ny = y + next[1];

			if(nx >= 0 && nx < w && ny >= 0 && ny < h){
				if(map[ny][nx] == 1 && !visited[ny][nx]){
					dfs(w, h, nx, ny);
				}
			}
		}
	}
}
