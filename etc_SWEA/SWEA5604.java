import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA5604 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static String A, B;

    public static long getSum(String n) {
        int N = n.length();
        long front = 0, now, end = 0, jarisu;
        long ret = 0;
        for (int i = N - 1; i >= 0; i--) {
            front = 0;
            end = 0;
            if (i > 0)
                front = Long.parseLong(n.substring(0, i));
            now = n.charAt(i) - '0';
            if (i < N - 1)
                end = Long.parseLong(n.substring(i + 1, N));
            jarisu = N - 1 - i;

            ret += front * 45 * (long) (Math.pow(10, jarisu));

            for (int j = 0; j < now; j++) {
                ret += j * (long) (Math.pow(10, jarisu));
            }
            ret += now * (end + 1);
        }
        return ret;
    }

    public static void main(String[] args) throws Exception {
        long res;
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            A = st.nextToken();
            B = st.nextToken();
            res = getSum(B) - getSum(A);
            for (char c : A.toCharArray()) {
                res += c - '0';
            }
            sb.append('#').append(i).append(' ').append(res).append('\n');
        }
        System.out.println(sb);
    }
}