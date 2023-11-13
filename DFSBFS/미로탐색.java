package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 미로탐색 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] strs = br.readLine().split(" ");

		int N = Integer.parseInt(strs[0]);
		int M = Integer.parseInt(strs[1]);

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split("");
			int[] line = Arrays.stream(input)
				.mapToInt(Integer::parseInt)
				.toArray();

			map[i] = line;
		}

		int[][] distance = new int[N][M];

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0));
		distance[0][0] = 1;

		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			int x = cur.x;
			int y = cur.y;
			int dis = distance[y][x];

			if(x+1 < M && map[y][x+1] == 1){
				map[y][x+1] = 0;
				distance[y][x+1] = dis + 1;
				queue.add(new Node(x+1, y));
			}

			if(y+1 < N && map[y+1][x] == 1){
				map[y+1][x] = 0;
				distance[y+1][x] = dis + 1;
				queue.add(new Node(x, y+1));
			}

			if(x-1 >= 0 && map[y][x-1] == 1){
				map[y][x-1] = 0;
				distance[y][x-1] = dis + 1;
				queue.add(new Node(x-1, y));
			}

			if(y-1 >= 0 && map[y-1][x] == 1){
				map[y-1][x] = 0;
				distance[y-1][x] = dis + 1;
				queue.add(new Node(x, y-1));
			}
		}

		System.out.println(distance[N - 1][M - 1]);

		br.close();
	}

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
