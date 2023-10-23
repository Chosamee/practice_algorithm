import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Island {
    int r;
    int c;

    public Island(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Edge implements Comparable<Edge> {
    int to;
    int cost;

    Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class BJ17472 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int R, C;
    static int[][] maps;
    static int[][] islands;
    static boolean[][] visited;
    static int[][] adjMat;
    static int islandN;
    static boolean[] primVisited;

    /** initialize */
    public static void initial() throws Exception {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        maps = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        islands = new int[R][C];
        visited = new boolean[R][C];
        markIsland();
    }

    /** island marking */
    public static void markIsland() {
        int num = 1;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (maps[i][j] == 1 && !visited[i][j])
                    bfs(i, j, num++);
            }
        }
        islandN = num;
        adjMat = new int[islandN + 1][islandN + 1];
        for (int i = 0; i < islandN + 1; i++) {
            Arrays.fill(adjMat[i], 11);
        }
    }

    static int[][] drc = { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } };

    /** 연결되어 있는 섬 확인하기 */
    public static void bfs(int r, int c, int num) {
        ArrayDeque<Island> que = new ArrayDeque<>();
        que.add(new Island(r, c));
        visited[r][c] = true;
        islands[r][c] = num;
        Island now;
        int nr, nc;
        while (!que.isEmpty()) {
            now = que.poll();
            for (int[] d : drc) {
                nr = now.r + d[0];
                nc = now.c + d[1];
                if (checkRange(nr, nc) && !visited[nr][nc] && maps[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    islands[nr][nc] = num;
                    que.add(new Island(nr, nc));
                }
            }
        }
    }

    /** (r,c)에서 다리 놓을 수 있는 방향대로 다 놔보기 */
    public static void setBridge(int r, int c) {
        int dr, dc;
        int nr, nc;
        int len;
        for (int[] d : drc) {
            len = 0;
            dr = d[0];
            dc = d[1];
            nr = r + dr;
            nc = c + dc;
            while (checkRange(nr, nc) && islands[nr][nc] == 0) {
                nr += dr;
                nc += dc;
                len++;
            }
            if (checkRange(nr, nc) && len >= 2) {
                adjMat[islands[r][c]][islands[nr][nc]] = Math.min(adjMat[islands[r][c]][islands[nr][nc]], len);
            }
        }
    }

    public static void process() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (maps[i][j] == 1)
                    setBridge(i, j);
            }
        }
    }

    public static int prim() {
        primVisited = new boolean[islandN + 1];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));

        int total = 0;
        Edge n;
        int to, cost;
        while (!pq.isEmpty()) {
            n = pq.poll();
            to = n.to;
            cost = n.cost;
            if (primVisited[to])
                continue;
            primVisited[to] = true;
            total += cost;

            for (int i = 1; i < islandN + 1; i++) {
                if (adjMat[to][i] != 11 && !primVisited[i]) {
                    pq.add(new Edge(i, adjMat[to][i]));
                }
            }
        }

        return total;
    }

    /** 범위 확인 */
    public static boolean checkRange(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

    public static void main(String[] args) throws Exception {
        initial();
        process();
        int ans = prim();
        for (int i = 1; i < islandN; i++) {
            if (!primVisited[i]) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(ans);
    }
}
