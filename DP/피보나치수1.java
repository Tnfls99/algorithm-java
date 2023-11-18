package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수1 {
	private static int[] fibo;
	private static int n;
	private static int code1 = 0;
	private static int code2 = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		fibo = new int[n+1];

		fibo1(n);
		fibo2();

		System.out.printf("%d %d\n", code1, code2);
	}

	private static int fibo1(int num) {
		if(num == 1 || num == 2) {
			code1++;
			return 1;
		}

		return fibo1(num - 1) + fibo1(num - 2);
	}

	private static int fibo2() {
		fibo[1] = 1;
		fibo[2] = 1;

		for(int i = 3; i <= n; i++) {
			code2++;
			fibo[n] = fibo[n-1] + fibo[n-2];
		}

		return fibo[n];
	}
}
