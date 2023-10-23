import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA8458 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int maxLen;

    static int init() throws Exception {
        int N, x, y, len;
        boolean isOdd, isCan = true;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        maxLen = Math.abs(x) + Math.abs(y);
        isOdd = checkOdd(maxLen);
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            len = Math.abs(x) + Math.abs(y);
            if (checkOdd(len) != isOdd)
                isCan = false;
            maxLen = Math.max(maxLen, len);
        }
        return isCan ? 0 : -1;
    }

    static boolean checkOdd(int n) {
        return n % 2 == 1 ? true : false;
    }

    static int process() {
        int ans = 0;
        int sum = 0;
        if (maxLen == 0)
            return 0;
        while (sum <= maxLen) {
            if (sum == maxLen)
                return ans;
            sum += ++ans;
        }
        while ((sum - maxLen) % 2 != 0) {
            sum += ++ans;
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        int T;
        T = Integer.parseInt(br.readLine());
        int check;
        for (int t = 1; t <= T; t++) {
            check = init();
            if (check == -1) {
                sb.append('#').append(t).append(' ').append(-1).append('\n');
                continue;
            }
            sb.append('#').append(t).append(' ').append(process()).append('\n');
        }
        System.out.println(sb);
    }
}
