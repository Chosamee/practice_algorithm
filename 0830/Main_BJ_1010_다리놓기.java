import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	
	public static void main(String[] args) throws Exception{
		int T = Integer.parseInt(br.readLine());
		int[][] dp = new int[31][31];
		int n, r;
		for (int i = 0; i < 31; i++) {
			dp[i][0] = 1;
			dp[i][i] = 1;
		}
		for (int i = 2; i < 31; i++) {
			for (int j = 1; j < i; j++) {
				dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
			}
		}
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			sb.append(dp[n][r]).append('\n');
		}
		System.out.println(sb);
	}
}
