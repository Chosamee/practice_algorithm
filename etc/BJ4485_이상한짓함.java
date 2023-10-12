import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ4485_이상한짓함 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] maps;
    static int[][] dp;
    static int minVal;

    /** initialize */
    public static void initial() throws Exception {
        maps = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][N];
        dp[0][0] = maps[0][0];
        for (int i = 1; i < N; i++) {
            dp[0][i] = dp[0][i - 1] + maps[0][i];
        }
        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i - 1][0] + maps[i][0];
        }
    }

    public static void process() {
        int r, c;
        for (int i = 1; i < N - 1; i++) {
            r = 1;
            c = i;
            while (c != 0) {
                dp[r][c] = Math.min(dp[r][c - 1], dp[r - 1][c]) + maps[r][c];
                r++;
                c--;
            }
        }
        for (int i = 1; i < N; i++) {
            c = N - 1;
            r = i;
            while (r != N) {
                dp[r][c] = Math.min(dp[r][c - 1], dp[r - 1][c]) + maps[r][c];
                r++;
                c--;
            }
        }
        System.out.println(dp[N - 1][N - 1]);
        printMap(dp);
    }

    public static void printMap(int[][] m) {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0)
                break;
            initial();
            process();
        }
    }
}
