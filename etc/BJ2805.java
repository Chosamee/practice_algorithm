import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2805 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] trees;
    static int totSum;
    static int right;
    static int left;
    static int ans;

    /** initialize */
    public static void initial() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new int[N];
        st = new StringTokenizer(br.readLine());

        totSum = 0;
        right = 0;
        left = 0;
        int tree;
        for (int i = 0; i < N; i++) {
            tree = Integer.parseInt(st.nextToken());
            trees[i] = tree;
            totSum += tree;
            right = Math.max(right, tree);
        }
    }

    public static void binSearch() {
        long sums;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            sums = getSum(mid);
            if (sums == M) {
                ans = mid;
                return;
            }
            if (sums > M) {
                ans = mid;
                left = mid + 1;
            } else if (sums < M) {
                right = mid - 1;
            }
        }
    }

    /** bfs */
    public static long getSum(int guess) {
        long ret = 0;
        for (int tree : trees) {
            ret += Math.max(tree - guess, 0);
        }
        return ret;
    }

    public static void main(String[] args) throws Exception {
        initial();
        binSearch();
        System.out.println(ans);
    }
}
