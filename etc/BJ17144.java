import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ17144 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int R, C, T;
    static ArrayList<int[]> ac;
    static int[][] maps;
    // 변화
    static int[][] spreadMaps;
    // 상하좌우
    static int[][] d = { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } };

    static void initial() throws Exception {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        maps = new int[R][C];
        spreadMaps = new int[R][C];
        ac = new ArrayList<>();
        int temp;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                temp = Integer.parseInt(st.nextToken());
                if (temp == -1)
                    ac.add(new int[] { i, j });
                maps[i][j] = temp;
            }
        }
    }

    /** 범위 확인 */
    static boolean checkRange(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

    /** 확산 */
    static void getSpreadMaps(int r, int c) {
        int cnt = 0;
        int nr, nc;
        int spreadVal = maps[r][c] / 5;
        for (int[] drc : d) {
            nr = r + drc[0];
            nc = c + drc[1];
            if (checkRange(nr, nc) && maps[nr][nc] != -1) {
                cnt++;
                spreadMaps[nr][nc] += spreadVal;
            }
        }
        spreadMaps[r][c] -= spreadVal * cnt;
    }

    /** 전체 확산 */
    static void spreadProcess() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                getSpreadMaps(i, j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                maps[i][j] += spreadMaps[i][j];
            }
        }
        spreadMaps = new int[R][C];
    }

    /** 청정기 작동 */
    static void aircon() {
        int[] up = ac.get(0);
        int[] down = ac.get(1);
        int ur = up[0];
        int c = up[1];
        int dr = down[0];
        for (int i = c - 1; i > 0; i--) {
            maps[ur][i] = maps[ur][i - 1];
            maps[dr][i] = maps[dr][i - 1];
        }

        for (int i = ur; i > 0; i--) {
            maps[i][0] = maps[i - 1][0];
        }
        for (int i = dr; i < R - 1; i++) {
            maps[i][0] = maps[i + 1][0];
        }

        for (int i = 0; i < C - 1; i++) {
            maps[0][i] = maps[0][i + 1];
            maps[R - 1][i] = maps[R - 1][i + 1];
        }

        for (int i = 0; i < ur; i++) {
            maps[i][C - 1] = maps[i + 1][C - 1];
        }
        for (int i = R - 1; i > dr; i--) {
            maps[i][C - 1] = maps[i - 1][C - 1];
        }

        for (int i = C - 1; i > c + 1; i--) {
            maps[ur][i] = maps[ur][i - 1];
            maps[dr][i] = maps[dr][i - 1];
        }
        maps[ur][c + 1] = 0;
        maps[dr][c + 1] = 0;
        maps[ur][c] = -1;
        maps[dr][c] = -1;
    }

    static int totalDust() {
        int ret = 0;
        for (int i = 0; i < R; i++) {
            for (int dust : maps[i]) {
                if (dust != -1)
                    ret += dust;
            }
        }
        return ret;
    }

    static void printMaps(int[][] m) {
        for (int i = 0; i < R; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
    }

    public static void main(String[] args) throws Exception {
        initial();
        for (int t = 0; t < T; t++) {
            spreadProcess();
            aircon();
        }
        System.out.println(totalDust());
    }
}
