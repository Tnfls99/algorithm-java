package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 연구소 {

	private static int[][] d = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	private static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);

		int[][] map = new int[n][m];

		for(int i = 0; i < n; i++) {
			map[i] = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		}

		dfs(m, n, map, 0);

		System.out.println(answer);

	}

	private static void dfs(int m, int n, int[][] map, int wall){
		if(wall == 3){
			bfs(m, n, map);
			return;
		}

		for(int y = 0; y < n; y++){
			for(int x = 0; x < m; x++){
				if(map[y][x] == 0) {
					map[y][x] = 1;
					dfs(m, n, map, wall+1);
					map[y][x] = 0;
				}
			}
		}
	}

	private static void bfs(int m, int n, int[][] map) {
		boolean[][] visited = new boolean[n][m];

		int[][] nmap = new int[n][m];

		Queue<int[]> queue = new LinkedList<>();

		for(int y =0 ; y < n; y++){
			for(int x = 0; x < m; x++){
				nmap[y][x] = map[y][x];
				if (map[y][x] == 2) {
					queue.add(new int[]{x, y});
					visited[y][x] = true;
				}
			}
		}

		while(!queue.isEmpty()) {
			int[] cur = queue.poll();

			for(int[] next : d){
				int nx = cur[0] + next[0];
				int ny = cur[1] + next[1];

				if(nx >= 0 && nx < m && ny >= 0 && ny < n) {
					if(nmap[ny][nx] == 0 && !visited[ny][nx]){
						visited[ny][nx] = true;
						nmap[ny][nx] = 2;
						queue.add(new int[]{nx, ny});
					}
				}
			}
		}

		findMax(m, n, nmap);
	}

	private static void findMax(int m, int n, int[][] map){
		int count = 0;
		for(int y = 0; y < n; y++){
			for(int x = 0; x < m; x++){
				if(map[y][x] == 0){
					count++;
				}
			}
		}

		answer = Math.max(answer, count);
	}
}
