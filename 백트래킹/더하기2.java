package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 더하기2 {

	private static int n, k;
	private static List<String>[] results;
	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] inputs = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		n = inputs[0];
		k = inputs[1];

		results = new ArrayList[11];

		for(int i = 0; i < 11; i++) {
			results[i] = new ArrayList<>();
		}

		results[1].add("1");
		results[2].add("1+1");
		results[2].add("2");
		results[3].add("1+1+1");
		results[3].add("1+2");
		results[3].add("2+1");
		results[3].add("3");

		for(int i = 4; i < 11; i++) {

			for(int j = 1; j < 4; j++) {
				for(int l = 0; l < results[i-j].size(); l++) {
					String s = results[i-j].get(l);
					results[i].add(s + "+" + j);
				}
			}
		}

		if(results[n].size() < k) {
			System.out.println(-1);
		} else {
			Collections.sort(results[n]);
			System.out.println(results[n].get(k-1));
		}
	}
}
