package DP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NCalculate {

	private Map<Integer, Set<Integer>> dp = new HashMap();

	public int solution(int N, int number) {
		for (int i = 1; i < 9; i++) {
			dp.put(i, new HashSet<>());
		}



		System.out.println(dp);

		dp.get(1).add(N);

		if (dp.get(1).contains(number)) {
			return 1;
		}

		for (int i = 2; i < 9; i++) {
			Set<Integer> newSet = dp.get(i);

			for (int j = 1; j < i; j++) {
				Set<Integer> nums = dp.get(j);
				System.out.println(i-j);
				Set<Integer> nums2 = dp.get(i - j);
				for (int num : nums) {
					for (int num2 : nums2) {
						newSet.addAll(calculate(num, num2));
					}
				}
			}

			if (newSet.contains(number)) {
				return i;
			}

			newSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
		}

		return -1;
	}

	private Set<Integer> calculate(int x, int y) {
		Set<Integer> calculateList = new HashSet<>();

		calculateList.add(x + y);
		calculateList.add(x - y);
		calculateList.add(x * y);
		if (y != 0 && x != 0) {
			calculateList.add(x / y);
		}

		return calculateList;
	}
}