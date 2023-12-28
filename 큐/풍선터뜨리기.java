package 큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 풍선터뜨리기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] ballons = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		StringBuilder sb = new StringBuilder();

		Deque<int[]> b = new ArrayDeque<>();

		for(int i = 0; i < n; i++) {
			b.addLast(new int[]{i+1, ballons[i]});
		}

		int[] ballon = b.removeFirst();
		sb.append("1 ");

		while(!b.isEmpty()) {
			if(ballon[1] > 0) {
				for(int i = 0; i < ballon[1]; i++) {
					b.addLast(b.removeFirst()); // 오른쪽으로 회전
				}
				ballon = b.removeLast();
			} else {
				for(int i = ballon[1]; i < 0; i++) {
					b.addFirst(b.removeLast()); // 왼쪽으로 회전
				}
				ballon = b.removeFirst();
			}
			sb.append(ballon[0] + " ");
		}

		System.out.println(sb);
	}
}
