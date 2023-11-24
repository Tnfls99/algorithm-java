package programmers.level3;

public class 등굣길 {

	public int solution(int m, int n, int[][] puddles) {
		int[][] map = new int[n][m];

		for(int[] p : puddles) {
			map[p[1]-1][p[0]-1] = 1;
		}

		int[][] dp = new int[n][m];

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(i == 0 && j == 0) {
					dp[i][j] = 1;
					continue;
				}

				if(map[i][j] == 1) {
					continue;
				}

				else {
					if(i == 0) {
						dp[i][j] = dp[i][j-1] % 1000000007;
					} else if(j == 0) {
						dp[i][j] = dp[i-1][j] % 1000000007;
					} else {
						dp[i][j] = (dp[i-1][j] + dp[i][j-1])%1000000007;
					}
				}
			}
		}

		return dp[n-1][m-1];
	}
}
