package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class 안전영역 {
	private static int answer = 0;
	private static int[][] map;
	private static int n;
	private static boolean[][] visited;
	private static int[][] d = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		map = new int[n][n];

		int max = 0;

		for(int y = 0; y < n; y++) {
			map[y] = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

			int lineMax = Arrays.stream(map[y])
				.max()
				.getAsInt();

			max = Math.max(max, lineMax);
		}

		for(int rain = 0; rain <= max; rain++) {
			bfs(rain);
		}

		System.out.println(answer);
	}

	private static void dfs(int x, int y, int[][] nmap) {
		visited[y][x] = true;

		for(int[] next : d) {
			int nx = x + next[0];
			int ny = y + next[1];

			if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if(nmap[ny][nx] > 0 && !visited[ny][nx]) {
					dfs(nx, ny, nmap);
				}
			}
		}
	}

	private static void bfs(int rain) {
		int[][] nmap = new int[n][n];

		visited = new boolean[n][n];

		int count = 0;

		for(int y = 0; y < n; y++){
			for(int x = 0; x < n; x++) {
				nmap[y][x] = map[y][x];
				if(nmap[y][x] <= rain) {
					nmap[y][x] = -1;
				}
			}
		}

		for(int y = 0; y < n; y++) {
			for(int x= 0; x < n; x++) {
				if(visited[y][x]){
					continue;
				}

				if(nmap[y][x] > rain) {
					dfs(x, y, nmap);
					count++;
				}
			}
		}

		answer = Math.max(answer, count);

	}
}
