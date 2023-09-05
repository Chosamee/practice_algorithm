import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ15652 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] per;
    static int[] nums;

    /** initialize */
    public static void initial() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        per = new int[M];
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums, Comparator((i1, i2) -> {
            return Integer.compare(i1, i2);
        }));
    }

    /** permutation */
    public static void permute(int depth, int now) {
        if (depth == M) {
            for (int p : per) {
                sb.append(p).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = now + 1; i <= N; i++) {
            per[depth] = i;
            permute(depth + 1, i);
        }
    }

    public static void main(String[] args) throws Exception {
        initial();
        permute(0, 1);
        System.out.println(sb);
    }
}
