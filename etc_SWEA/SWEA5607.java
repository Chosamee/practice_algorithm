import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5607 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int mod = 1234567891;

    static long pow(long n, long indices) {
        if (indices == 0)
            return 1;
        long ret = pow(n, indices / 2);
        if (indices % 2 == 0)
            return (ret * ret) % mod;
        else
            return (ret * ret) % mod * n % mod;
    }

    public static void main(String[] args) throws Exception {
        long[] fact = new long[1000001];
        fact[0] = 1;
        for (int i = 1; i < 1000001; i++) {
            fact[i] = (fact[i - 1] * i) % mod;
        }

        long ans;
        int T, N, R;
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            ans = fact[N] * pow((fact[R] * fact[N - R]) % mod, 1234567889) % mod;
            sb.append('#').append(t).append(' ').append(ans).append('\n');
        }
        System.out.println(sb);
    }
}
