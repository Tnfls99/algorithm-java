package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 가장긴바이토닉부분수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] nums = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int[] increase = new int[n];
		int[] decrease = new int[n];

		increase[0] = 1;
		for(int i = 1; i < n; i++) {
			increase[i] = 1;
			// 아예 증가하는 부분이 없었다면 길이가 0이 아니라 1이어야 하기 때문에 0이 아닌 1로 채워주기 위해 1로 초기화를 해야함
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					increase[i] = Math.max(increase[j] + 1, increase[i]);
				}
			}
		}

		decrease[decrease.length-1] = 1;

		for(int i = n-2; i >= 0; i--) {
			decrease[i] = 1;
			for(int j = n-1; j > i; j--) {
				if(nums[i] > nums[j]) {
					decrease[i] = Math.max(decrease[j] + 1, decrease[i]);
				}
			}
		}

		int answer = 0;

		for(int i = 0; i < n; i++) {
			answer = Math.max(answer, increase[i] + decrease[i] - 1);
		}

		System.out.println(answer);
	}
}
