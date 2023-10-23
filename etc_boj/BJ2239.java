import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2239 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static char[][] maps;

    /** initialize */
    public static void initial() throws Exception {
        maps = new char[9][9];
        for (int i = 0; i < 9; i++) {
            maps[i] = br.readLine().toCharArray();
        }
    }

    /** main process (dfs) */
    public static void process(int idx) {
        if (idx == 81) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(maps[i][j]);
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }

        int r = idx / 9, c = idx % 9;
        if (maps[r][c] == '0') {
            for (int i = 1; i < 10; i++) {
                char ch = Character.forDigit(i, 10);
                if (check(r, c, ch)) {
                    maps[r][c] = ch;
                    process(idx + 1);
                    maps[r][c] = '0';
                }
            }
        } else {
            process(idx + 1);
        }
        return;
    }

    /** check Is can put now into maps[r][c] */
    public static boolean check(int r, int c, char now) {
        // row
        for (int i = 0; i < 9; i++) {
            if (maps[r][i] == now)
                return false;
        }

        // col
        for (int i = 0; i < 9; i++) {
            if (maps[i][c] == now)
                return false;
        }

        // 3 by 3
        int nr = r / 3 * 3;
        int nc = c / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (maps[nr + i][nc + j] == now)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        initial();
        process(0);
    }
}