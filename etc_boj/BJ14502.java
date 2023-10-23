import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ14502 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int R, C;
    static int[][] maps;
    static int[] maps2d;
    static ArrayList<int[]> virus;
    static boolean[][] visited;
    static int totalSize;
    static int wallCnt;
    static int maxVal;
    static ArrayDeque<int[]> que;
    static int compareVal;

    /** initialize */
    public static void initial() throws Exception {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        totalSize = R * C;
        maps = new int[R][C];
        maps2d = new int[totalSize];
        virus = new ArrayList<>();
        int type;
        int idx = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                type = Integer.parseInt(st.nextToken());
                maps[i][j] = type;
                maps2d[idx++] = type;
                if (type == 2)
                    virus.add(new int[] { i, j });
                else if (type == 1)
                    wallCnt++;
            }
        }
        que = new ArrayDeque<>();
        maxVal = 0;
        compareVal = totalSize - wallCnt - 3;
    }

    /** set combination 3 points */
    public static void comb() {
        for (int i = 0; i < totalSize; i++) {
            if (maps2d[i] != 0)
                continue;
            for (int j = i + 1; j < totalSize; j++) {
                if (maps2d[j] != 0)
                    continue;
                for (int l = j + 1; l < totalSize; l++) {
                    if (maps2d[l] != 0)
                        continue;
                    maps[i / C][i % C] = 1;
                    maps[j / C][j % C] = 1;
                    maps[l / C][l % C] = 1;
                    bfs();
                    maps[i / C][i % C] = 0;
                    maps[j / C][j % C] = 0;
                    maps[l / C][l % C] = 0;
                }
            }
        }
    }

    static int[][] drc = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void bfs() {
        int virusCnt = 0;
        que.clear();
        visited = new boolean[R][C];
        for (int[] v : virus) {
            que.add(v);
            visited[v[0]][v[1]] = true;
            virusCnt++;
        }
        int r, c;
        int dr, dc;
        // new
        int nr, nc;
        int[] v;
        while (!que.isEmpty()) {
            v = que.poll();
            r = v[0];
            c = v[1];
            for (int[] d : drc) {
                dr = d[0];
                dc = d[1];
                nr = r + dr;
                nc = c + dc;
                if (checkRange(nr, nc) && maps[nr][nc] == 0 && !visited[nr][nc]) {
                    que.add(new int[] { nr, nc });
                    visited[nr][nc] = true;
                    virusCnt++;
                }
            }
        }
        maxVal = Math.max(maxVal, compareVal - virusCnt);
    }

    public static boolean checkRange(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

    public static void main(String[] args) throws Exception {
        initial();
        comb();
        System.out.println(maxVal);
    }
}
