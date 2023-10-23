import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Line implements Comparable<Line> {
    int left;
    int right;

    public Line(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Line l) {
        return this.left - l.left;
    }
}

public class BJ2568_pt5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static Line[] lines;
    static int[] dp, dpIdx;

    static void init() throws Exception {
        N = Integer.parseInt(br.readLine());
        lines = new Line[N];
        dp = new int[N];
        dpIdx = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i] = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(lines);
    }

    static int binarySearch(int left, int right, int key) {
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (dp[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    static int lis() {
        int idx, now, len = 0;
        dp[0] = lines[0].right;
        for (int i = 1; i < N; i++) {
            now = lines[i].right;
            if (now > dp[len]) {
                idx = ++len;
                dp[idx] = now;
            } else {
                idx = binarySearch(0, len, now);
                dp[idx] = now;
            }
            dpIdx[i] = idx;
        }
        return len;
    }

    public static void main(String[] args) throws Exception {
        init();
        int len = lis();
        sb.append(N - len - 1).append('\n');
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = N - 1; i >= 0; i--) {
            if (len != dpIdx[i]) {
                ans.add(lines[i].left);
            } else
                len--;
        }
        for (int i = ans.size() - 1; i >= 0; i--) {
            sb.append(ans.get(i)).append('\n');
        }
        System.out.println(sb);
    }
}
