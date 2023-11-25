package programmers.level3;

import java.util.*;

public class 아이템줍기 {

	private int[][] d = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		int[][] map = new int[101][101];

		for(int[] rec : rectangle) {
			int lx = rec[0]*2;
			int ly = rec[1]*2;
			int rx = rec[2]*2;
			int ry = rec[3]*2;

			for(int i = ly; i <= ry; i++) {
				for(int j = lx; j <= rx; j++) {
					if(i == ry || i == ly || j == lx || j == rx) {
						if(map[i][j] == -1) {
							continue;
						}
						map[i][j] = 1;
						continue;
					}

					map[i][j] = -1;
				}
			}
		}

		boolean[][] visited = new boolean[101][101];
		int[][] route = new int[101][101];

		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[]{characterX*2, characterY*2});
		visited[characterY*2][characterX*2] = true;

		int count = 0;

		int[] end = new int[]{itemX*2, itemY*2};

		while(!queue.isEmpty()) {
			int[] cur = queue.poll();

			int x = cur[0];
			int y = cur[1];

			if(x == end[0] && y == end[1]) {
				break;
			}

			for(int[] next : d) {
				int nx = next[0] + x;
				int ny = next[1] + y;

				if(nx >= 0 && nx < 101 && ny >= 0 && ny < 101) {
					if(map[ny][nx] == 1 && !visited[ny][nx]) {
						route[ny][nx] = Math.max(route[ny][nx], route[y][x] + 1);
						queue.add(new int[]{nx, ny});
						visited[ny][nx] = true;
					}
				}
			}
		}

		return route[itemY*2][itemX*2]/2;
	}
}
