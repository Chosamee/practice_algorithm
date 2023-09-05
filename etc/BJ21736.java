import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BJ21736 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static char[][] maps;
    static boolean[][] visited;
    static int cnt;

    /** initialize */
    public static void initial() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maps = new char[N][M];
        for (int i = 0; i < N; i++) {
            maps[i] = br.readLine().toCharArray();
        }
        visited = new boolean[N][M];
        cnt = 0;
    }

    // 상하좌우
    static int[][] d = { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } };

    /** bfs */
    public static void bfs() {
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.add(findMe());
        int[] now;
        int R, C, newR, newC;
        while (!que.isEmpty()) {
            now = que.poll();
            R = now[0];
            C = now[1];
            if (maps[R][C] == 'P')
                cnt++;
            for (int[] drc : d) {
                newR = R + drc[0];
                newC = C + drc[1];
                if (newR >= 0 && newC >= 0 && newR < N && newC < M
                        && maps[newR][newC] != 'X' && !visited[newR][newC]) {
                    que.add(new int[] { newR, newC });
                    visited[newR][newC] = true;
                }
            }
        }
    }

    /** find 도연 */
    public static int[] findMe() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i][j] == 'I')
                    return new int[] { i, j };
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        initial();
        bfs();
        System.out.println(cnt == 0 ? "TT" : cnt);
    }
}
