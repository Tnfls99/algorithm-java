package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class 도키도키간식드리미 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] line = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		Stack<Integer> stack = new Stack<>();

		int target = 1;

		for (int i : line) {
			stack.push(i);

			while (!stack.isEmpty() && stack.peek() == target) {
				stack.pop();
				target += 1;
			}

		}

		if (stack.isEmpty()) {
			System.out.println("Nice");
		} else {
			System.out.println("Sad");
		}
	}
}
