package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 달나라토끼를위한구매대금지불도우미 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[100001];

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;
		dp[4] = 2;
		dp[5] = 1;
		dp[6] = 2;
		dp[7] = 1;

		for(int i = 8; i < n+1; i++) {
				dp[i] = Math.min(dp[i-1], Math.min(dp[i-2], Math.min(dp[i-5], dp[i-7]))) + 1;
		}
		// 행렬곱이랑 비슷한 것 같다.
		// 이전에 올 수 있는 경우의 수가 1원, 2원, 5월, 7원 중 1개가 더해져 오는 것이기 때문에 이전의 가장 작은 값 중 하나를 선택하여 코인을 1개 더해주면 된다.
		// 즉, 1원, 2원, 5원, 7원 중 어떤 코인을 하나만 더 사용하여 원하는 금액을 만들 수 있는지를 알아보는 것이다. 그 중에 가장 최소의 갯수를 가져와 1을 더해줘야 최소값이 된다.
		// 중요한 것은 어떤 코인을 사용했냐가 아닌 코인의 갯수이기 때문에 이런 규칙이 성립하는 것 같다.

		System.out.println(dp[n]);
	}
}
