package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] numbers = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int max = 1;
		int count = 1;

		// 커지는 경우 카운트
		for(int i = 1; i < n; i++){
			if(numbers[i - 1] <= numbers[i]) {
				count++; // 만약 기준값 보다 이전의 배열값이 작은 값이라면 카운트 업
				max = Math.max(max, count); // 현재 최댓값과 비교해서 더 큰 값이라면 교체
			} else {
				count = 1; // 만약 기준값보다 큰 값이 나오면 연속되지 않게 되므로 다시 1로 초기화
			}
		}

		count = 1;
		for(int i = 1; i < n; i++) {
			if(numbers[i-1] >= numbers[i]) {
				count++;
				max = Math.max(max, count);
			} else {
				count = 1;
			}
		}

		System.out.println(max);
		br.close();
	}
}
