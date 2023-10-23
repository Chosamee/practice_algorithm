import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16401 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[] cookies;
    static int right;
    static int left;
    static int ans;

    /** initialize */
    public static void initial() throws Exception {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        cookies = new int[N];
        st = new StringTokenizer(br.readLine());

        right = 1;
        left = 1;
        int cookie;
        for (int i = 0; i < N; i++) {
            cookie = Integer.parseInt(st.nextToken());
            cookies[i] = cookie;
            right = Math.max(right, cookie);
        }
    }

    public static void binSearch() {
        int cookieNum;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            cookieNum = getCookieNum(mid);
            if (cookieNum >= M) {
                ans = mid;
                left = mid + 1;
            } else if (cookieNum < M) {
                right = mid - 1;
            }
        }
    }

    public static int getCookieNum(int cookieSize) {
        int ret = 0;
        for (int cookie : cookies) {
            ret += cookie / cookieSize;
        }
        return ret;
    }

    public static void main(String[] args) throws Exception {
        initial();
        binSearch();
        System.out.println(ans);
    }
}
