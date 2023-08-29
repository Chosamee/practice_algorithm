package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		int[] dp = new int[1000001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		int cnt = 0;
		dp[1] = 0;
		for (int i = 1; i < 1000001; i++) {
			if (i == N) {
				cnt = dp[i];
				break;
			}
			if (3 * i <= N && dp[i] + 1 < dp[3 * i])
				dp[3 * i] = dp[i] + 1;
			if (2 * i <= N && dp[i] + 1 < dp[2 * i])
				dp[2 * i] = dp[i] + 1;
			if (i + 1 <= N && dp[i] + 1 < dp[i + 1])
				dp[i + 1] = dp[i] + 1;
		}
		System.out.println(cnt);
	}
}
