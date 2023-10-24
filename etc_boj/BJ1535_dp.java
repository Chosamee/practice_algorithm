import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1535_dp {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] energy, happy;
    static int health, N;

    /** initial */
    public static void init() throws Exception {
        health = 100;
        N = Integer.parseInt(br.readLine());
        energy = new int[N];
        happy = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            energy[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            happy[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static int dp() {
        int[] dp = new int[health];
        for (int i = 0; i < N; i++) {
            for (int j = health - 1; j >= energy[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - energy[i]] + happy[i]);
            }
        }
        return dp[99];
    }

    public static void main(String[] args) throws Exception {
        init();
        System.out.println(dp());
    }
}
