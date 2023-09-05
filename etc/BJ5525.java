import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ5525 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static char[] ioi;
    static int cnt;
    static ArrayList<int[]> idxList;

    /** initialize */
    public static void initial() throws Exception {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        ioi = br.readLine().toCharArray();
        cnt = 0;
        idxList = new ArrayList<>();
    }

    public static void findIOI() {
        int now = 0;
        int next = 0;
        while (now < M) {
            next = now;
            while (next < M) {
                if (ioi[next] != 'I') {
                    break;
                }
                next++;
                if (next == M)
                    break;
                if (ioi[next] != 'O') {
                    break;
                }
                next++;
            }
            if (now == next)
                next++;
            if (next - now >= 2 * N + 1)
                cnt += ((next - now) - 2 * N - 1) / 2 + 1;
            now = next;
        }

    }

    public static void main(String[] args) throws Exception {
        initial();
        findIOI();
        System.out.println(cnt);
    }
}
