import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Block {
    int r;
    int c;
    int v;

    public Block(int r, int c, int v) {
        this.r = r;
        this.c = c;
        this.v = v;
    }
}

public class SWEA5656 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, W, H;
    static int[][] initMaps;
    static boolean[][] visited;
    static int minVal;

    /** initialize */
    public static void initial() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        initMaps = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                initMaps[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        minVal = Integer.MAX_VALUE;
    }

    /** dfs, 지우고 보내고 rollback */
    public static void dfs(int depth, int[][] maps) {
        if (depth == N) {
            minVal = Math.min(minVal, checkBlockN(maps));
            return;
        }
        ArrayList<Block> brokenBlock;
        for (int i = 0; i < W; i++) {
            brokenBlock = new ArrayList<>();
            breakBlock(findBlock(i, maps), i, maps, brokenBlock);
            dfs(depth + 1, downBlock(maps));
            rollback(maps, brokenBlock);

        }
    }

    public static void rollback(int[][] maps, ArrayList<Block> brokenBlock) {
        for (Block block : brokenBlock) {
            maps[block.r][block.c] = block.v;
        }
    }

    /**
     * 부딫히는 첫 블럭, 없으면 -1
     * return: row idx
     */
    public static int findBlock(int col, int[][] maps) {
        for (int i = 0; i < H; i++) {
            if (maps[i][col] != 0)
                return i;
        }
        return -1;
    }

    // 상하좌우
    static int[][] drc = { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } };

    /** break block */
    public static void breakBlock(int r, int c, int[][] maps, ArrayList<Block> brokenBlock) {
        if (r == -1)
            return;
        visited = new boolean[H][W];
        ArrayDeque<Block> que = new ArrayDeque<>();
        Block now, nBlock;

        nBlock = new Block(r, c, maps[r][c]);
        que.add(nBlock);
        maps[r][c] = 0;
        brokenBlock.add(nBlock);

        int nr, nc, nv;
        while (!que.isEmpty()) {
            now = que.poll();
            for (int i = 1; i < now.v; i++) {
                for (int[] d : drc) {
                    nr = now.r + d[0] * i;
                    nc = now.c + d[1] * i;
                    if (checkRange(nr, nc) && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        if ((nv = maps[nr][nc]) == 0) {
                            continue;
                        }
                        nBlock = new Block(nr, nc, nv);
                        que.add(nBlock);
                        brokenBlock.add(nBlock);
                        maps[nr][nc] = 0;

                    }
                }
            }
        }
    }

    /** 상자 중력 적용 */
    public static int[][] downBlock(int[][] maps) {
        int[][] retMaps = new int[H][W];
        int row;
        for (int i = 0; i < W; i++) {
            row = H - 1;
            for (int j = H - 1; j >= 0; j--) {
                if (maps[j][i] != 0)
                    retMaps[row--][i] = maps[j][i];
            }
        }
        return retMaps;
    }

    /** 남은 블럭 갯수 */
    public static int checkBlockN(int[][] maps) {
        int ans = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (maps[i][j] != 0)
                    ans++;
            }
        }
        return ans;
    }

    /** 범위 확인 */
    public static boolean checkRange(int r, int c) {
        return 0 <= r && r < H && 0 <= c && c < W;
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            initial();
            dfs(0, downBlock(initMaps));
            sb.append('#').append(i).append(' ').append(minVal).append('\n');
        }
        System.out.println(sb);
    }
}