import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2630 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] maps;
    static int[] wb = new int[2];

    /** initialize */
    public static void initial() throws Exception {

        N = Integer.parseInt(br.readLine());
        maps = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    /** recursion search */
    public static void search(int r, int c, int len) {
        int color = maps[r][c];
        int newLen = len / 2;
        for (int i = r; i < r + len; i++) {
            for (int j = c; j < c + len; j++) {
                if (maps[i][j] != color) {
                    search(r, c, newLen);
                    search(r + newLen, c, newLen);
                    search(r, c + newLen, newLen);
                    search(r + newLen, c + newLen, newLen);
                    return;
                }
            }
        }
        wb[color]++;
    }

    public static void main(String[] args) throws Exception {
        initial();
        search(0, 0, N);
        System.out.println(wb[0]);
        System.out.println(wb[1]);
    }
}