
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14500_yet {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[][] maps;
    static int maxVal;

    /** initialize */
    public static void initial() throws Exception {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        maps = new int[N][M];
        maxVal = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    // ====
    static int[][][] d1 = { { { 1, 0 }, { 1, 0 }, { 1, 0 } }, { { 0, 1 }, { 0, 1 }, { 0, 1 } } };

    public static void tet1(int r, int c) {
        int sumVal;
        for (int[][] dd : d1) {
            sumVal = maps[r][c];
            for (int[] d : dd) {
                sumVal += maps[r + d[0]][c + d[1]];
            }
            maxVal = Math.max(maxVal, sumVal);
        }
    }

    // | |
    // === ===
    static int[][][] d2 = { { {} } };

    public static void tet2(int r, int c) {

    }

    // ==
    // ==
    public static void tet3(int r, int c) {

    }

    // |
    // ==
    // .|
    public static void tet4(int r, int c) {

    }

    /**
     * ===
     * .|
     */
    public static void tet5(int r, int c) {

    }

    public static void main(String[] args) throws Exception {
        initial();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tet1(i, j);
                tet2(i, j);
                tet3(i, j);
                tet4(i, j);
                tet5(i, j);
            }
        }
        System.out.println(maxVal);
    }

}
