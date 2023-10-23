import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** BFS랑 DP랑 섞어야될듯 */
public class BJ12761_yet {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int A, B, N, M;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int maxi = 100001;
        int[] dp = new int[100001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int cnt = 0;
        dp[1] = 0;
        for (int i = N; i < 100001; i++) {
            if (i == M) {
                cnt = dp[i];
                break;
            }
            if (A * i < maxi && dp[i] + 1 < dp[A * i])
                dp[A * i] = dp[i] + 1;
            if (B * i < maxi && dp[i] + 1 < dp[B * i])
                dp[B * i] = dp[i] + 1;
            if (i + 1 < maxi && dp[i] + 1 < dp[i + 1])
                dp[i + 1] = dp[i] + 1;
            if (1 <= i - 1 && dp[i] + 1 < dp[i - 1])
                dp[i - 1] = dp[i] + 1;

        }
        System.out.println(cnt);
    }
}
