package 큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 덱 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Deque<Integer> deque = new ArrayDeque<>();

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < n; i++) {
			int[] commands = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

			int command = commands[0];
			switch (command) {
				case 1:
					deque.addFirst(commands[1]);
					break;
				case 2:
					deque.addLast(commands[1]);
					break;
				case 3:
					if(deque.isEmpty()) {
						sb.append("-1\n");
					} else {
						sb.append(deque.removeFirst() + "\n");
					}
					break;
				case 4:
					if(deque.isEmpty()) {
						sb.append("-1\n");
					} else {
						sb.append(deque.removeLast() + "\n");
					}
					break;
				case 5:
					sb.append(deque.size() + "\n");
					break;
				case 6:
					if(deque.isEmpty()) {
						sb.append("1\n");
					} else {
						sb.append("0\n");
					}
					break;
				case 7:
					if(deque.isEmpty()) {
						sb.append("-1\n");
					} else {
						sb.append(deque.peekFirst() + "\n");
					}
					break;
				case 8:
					if(deque.isEmpty()) {
						sb.append("-1\n");
					} else {
						sb.append(deque.peekLast() + "\n");
					}
					break;
			}
		}

		System.out.println(sb);
	}
}
