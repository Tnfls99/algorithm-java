package programmers.level1;

import java.util.*;
import java.util.stream.Collectors;

public class FruitSeller {
	public int solution(int k, int m, int[] score) {
		List<Integer> scores = Arrays.stream(score)
			.boxed()
			.sorted(Comparator.reverseOrder())
			.collect(Collectors.toList());

		int answer = 0;

		if (score.length < m) {
			return 0;
		}

		for (int i = 0; i < scores.size() - m; i += m) {
			List<Integer> box = scores.subList(i, i + m);

			int minScore = Collections.min(box);
			answer += minScore * m;
		}

		return answer;
	}
}
