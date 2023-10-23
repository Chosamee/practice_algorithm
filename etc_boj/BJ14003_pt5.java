import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ14003_pt5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[] nums;
    static int[] dp, dpIdx;

    static void init() throws Exception {
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        dp = new int[N];
        dpIdx = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
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
        dp[0] = nums[0];
        for (int i = 1; i < N; i++) {
            now = nums[i];
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
        sb.append(len + 1).append('\n');
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = N - 1; i >= 0; i--) {
            if (len == dpIdx[i]) {
                len--;
                ans.add(nums[i]);
            }
        }
        for (int i = ans.size() - 1; i >= 0; i--) {
            sb.append(ans.get(i)).append(' ');
        }
        System.out.println(sb);
    }
}
