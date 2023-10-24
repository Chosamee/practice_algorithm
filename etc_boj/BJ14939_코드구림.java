import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14939_코드구림 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int R, C;
    static char[][] mapOrigin;

    /** 초기화 */
    static void init() throws Exception {
        R = 10;
        C = 10;
        mapOrigin = getMap();
    }

    /** map 입력받기 */
    static char[][] getMap() throws Exception {
        char[][] ret = new char[R][C];
        for (int i = 0; i < R; i++) {
            ret[i] = br.readLine().toCharArray();
        }
        return ret;
    }

    /** 범위 확인 */
    static boolean checkRange(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

    /** 맨 아래줄에 다 꺼져있다면 가능 */
    static boolean checkPossible(char[] lastLine) {
        for (char c : lastLine) {
            if (c == 'O')
                return false;
        }
        return true;
    }

    // 상하좌우, 본인까지 (십자가)
    static int[][] drc = { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 }, { 0, 0 } };

    /** 버튼 눌렀을 때 process, 십자가 상태 바꿈 */
    static void pressProcess(char[][] map, int r, int c) {
        int nr, nc;
        for (int[] d : drc) {
            nr = r + d[0];
            nc = c + d[1];
            if (checkRange(nr, nc))
                map[nr][nc] = (map[nr][nc] == 'O') ? '#' : 'O';
        }
    }

    /** main process, 윗칸에 켜져있는 부분만 끄기 */
    static int mainProcess(char[][] map) {
        int cnt = 0;
        for (int i = 1; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i - 1][j] == 'O') {
                    pressProcess(map, i, j);
                    cnt++;
                }
            }
        }
        return checkPossible(map[R - 1]) ? cnt : -1;
    }

    /** 맨 윗줄 우선 작업 */
    static int firstLine(char[][] map, int cases) {
        int cnt = 0;
        int c = C - 1;
        while (c >= 0) {
            if ((cases >> c & 1) == 1) {
                pressProcess(map, 0, C - (c + 1));
                cnt++;
            }
            c--;
        }
        return cnt;
    }

    /** map 복사 함수 */
    static char[][] copyMap(char[][] map) {
        char[][] ret = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ret[i][j] = map[i][j];
            }
        }
        return ret;
    }

    public static void main(String[] args) throws Exception {
        init();
        char[][] map;
        int min = Integer.MAX_VALUE, ans, cnt;
        for (int i = 0; i < 1 << C; i++) {
            ans = 0;
            map = copyMap(mapOrigin);
            ans += firstLine(map, i);
            if ((cnt = mainProcess(map)) != -1) {
                min = Math.min(min, ans + cnt);
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
