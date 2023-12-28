package 큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class 풍선터뜨리기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] ballons = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int[] answer = new int[n];

		LinkedList<Integer> b = new LinkedList<>();

		for(int i : ballons) {
			b.add(i);
		}

		int idx = 0;

		while(!b.isEmpty()) {
			if(b.size() < Math.abs(b.get(idx))) {

			}
		}
	}
}
