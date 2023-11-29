package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 가장긴감소하는부분수열 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] numbers = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int[] length = new int[n+1];

		for(int i = 0; i < n; i++) {
			length[i] = 1;
			for(int k = 0; k < i; k++) {
				if(numbers[i] < numbers[k]) {
					length[i] = Math.max(length[i], length[k] + 1);
				}
			}
		}

		System.out.println(Arrays.stream(length)
			.max()
			.getAsInt());
	}
}
