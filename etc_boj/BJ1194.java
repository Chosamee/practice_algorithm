import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1194 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int R, C;
    static char[][] maps;
    static int[][][] visited;
    static int minVal = Integer.MAX_VALUE;

    /** initialize */
    public static int[] initial() throws Exception {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        maps = new char[R][C];
        visited = new int[R][C][64];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {

                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }
        // start index
        int sR = 0, sC = 0;
        boolean isFindStart = false;
        for (int i = 0; i < R; i++) {
            maps[i] = br.readLine().toCharArray();
            if (isFindStart)
                continue;
            for (int j = 0; j < C; j++) {
                if (maps[i][j] == '0') {
                    isFindStart = true;
                    sR = i;
                    sC = j;
                }
            }
        }
        return new int[] { sR, sC };
    }

    static int[][] drc = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static String keys = "abcdef";
    static String Doors = "ABCDEF";

    // fedcba 111111
    public static void bfs(int sR, int sC) {
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.add(new int[] { sR, sC, 0, 0 });
        visited[sR][sC][0] = 0;
        int r, c;
        // new
        int nr, nc;
        int[] now;
        int key, cnt;
        int newV;
        int newKey;
        int newKeyIdx;
        while (!que.isEmpty()) {
            now = que.poll();
            r = now[0];
            c = now[1];
            cnt = now[2];
            key = now[3];
            for (int[] d : drc) {
                nr = r + d[0];
                nc = c + d[1];
                // 키를 갖고 있으면서 visit 값이 더 작아야됨...
                if (checkRange(nr, nc) && (newV = maps[nr][nc]) != '#' && cnt + 1 < visited[nr][nc][key]) {
                    // System.out.printf("%d %d\n", nr, nc);
                    if (newV != '.' && newV != '0' && newV != '1') {
                        if ((newKeyIdx = keys.indexOf(newV)) != -1) {
                            newKey = key | (1 << newKeyIdx);
                            if (cnt + 1 < visited[nr][nc][newKey]) {
                                visited[nr][nc][newKey] = cnt + 1;
                                que.add(new int[] { nr, nc, cnt + 1, newKey });
                            }
                        } else if ((key & (1 << (newV - 65))) != 0) {
                            visited[nr][nc][key] = cnt + 1;
                            que.add(new int[] { nr, nc, cnt + 1, key });
                        }
                    } else if (newV == '1') {
                        minVal = Math.min(minVal, cnt + 1);
                        return;
                    } else {
                        visited[nr][nc][key] = cnt + 1;
                        que.add(new int[] { nr, nc, cnt + 1, key });
                    }
                }
            }
        }
        minVal = -1;
    }

    public static boolean checkRange(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

    public static void main(String[] args) throws Exception {
        int[] start = initial();
        int sR = start[0], sC = start[1];
        bfs(sR, sC);
        System.out.println(minVal);
    }
}
