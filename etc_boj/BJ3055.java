import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ3055 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int R, C;
    // 도치, 목적지
    static int endR, endC;
    static Deque<int[]> waterQ;
    static Deque<int[]> dochiQ;
    static char[][] maps;
    static boolean[][] visited;
    static int dist;
    static boolean end;

    /** Initializing */
    public static void initial() throws Exception {
        dist = 0;
        end = false;
        waterQ = new ArrayDeque<>();
        dochiQ = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        maps = new char[R][C];
        visited = new boolean[R][C];
        char c;
        for (int i = 0; i < R; i++) {
            maps[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                c = maps[i][j];
                if (c == '*') {
                    waterQ.add(new int[] { i, j });
                } else if (c == 'S') {
                    dochiQ.add(new int[] { i, j });
                    visited[i][j] = true;
                } else if (c == 'D') {
                    endR = i;
                    endC = j;
                }
            }
        }
    }

    static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    /** 한번만 퍼지는 함수 */
    public static Deque<int[]> oneStep(Deque<int[]> deque, boolean isWater) {
        int r, c;
        // new
        int nr, nc;
        int[] now;
        Deque<int[]> ret = new ArrayDeque<>();
        while (!deque.isEmpty()) {
            now = deque.poll();
            r = now[0];
            c = now[1];
            for (int[] d : drc) {
                nr = r + d[0];
                nc = c + d[1];
                if (checkRange(nr, nc)) {
                    if (!visited[nr][nc] && maps[nr][nc] == '.') {
                        visited[nr][nc] = true;
                        ret.add(new int[] { nr, nc });

                        if (isWater)
                            maps[nr][nc] = '*';
                    } else if (!isWater && maps[nr][nc] == 'D') {
                        end = true;
                        break;
                    }
                }
            }
        }
        return ret;
    }

    /** check 비버 주변에 길 있슴? */
    public static boolean check() {
        int nr, nc;

        for (int[] d : drc) {
            nr = endR + d[0];
            nc = endC + d[1];
            if (checkRange(nr, nc) && (maps[nr][nc] == '.' || maps[nr][nc] == 'S')) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkRange(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

    public static void main(String[] args) throws Exception {
        initial();

        while (!end && !dochiQ.isEmpty() && check()) {
            waterQ = oneStep(waterQ, true);
            dochiQ = oneStep(dochiQ, false);
            dist++;
        }
        System.out.println(end ? dist : "KAKTUS");
    }
}
