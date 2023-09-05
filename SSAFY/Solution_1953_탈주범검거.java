import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

class Where {
	int r;
	int c;
	int depth;
	int tunnel;

	public Where(int r, int c, int depth, int tunnel) {
		super();
		this.r = r;
		this.c = c;
		this.depth = depth;
		this.tunnel = tunnel;
	}
}

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] in;
	static int N, M, R, C, L;
	static int[][] maps;
	static boolean[][] visited;
	static Deque<Where> que = new ArrayDeque<>();

	/** initialize */
	public static void initial() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		maps = new int[N + 2][M + 2];
		visited = new boolean[N + 2][M + 2];
		for (int i = 0; i < N + 2; i++) {
			maps[i][0] = 0;
			maps[i][M + 1] = 0;
		}
		for (int i = 0; i < M + 2; i++) {
			maps[0][i] = 0;
			maps[N + 1][i] = 0;
		}
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < M + 1; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static int[][][] d = { {}, { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } }, { { -1, 0 }, { 1, 0 } },
			{ { 0, -1 }, { 0, 1 } }, { { -1, 0 }, { 0, 1 } }, { { 1, 0 }, { 0, 1 } }, { { 1, 0 }, { 0, -1 } },
			{ { -1, 0 }, { 0, -1 } } };

	/** 연결되어 있니 */
	public static boolean isConnect(Where w1, Where w2) {
		int t = w2.tunnel;
		int r = w2.r;
		int c = w2.c;
		int rr = w1.r;
		int cc = w1.c;
		int dr, dc;
		for (int[] tt : d[t]) {
			dr = tt[0];
			dc = tt[1];
			if (r + dr == rr && c + dc == cc)
				return true;
		}
		return false;
	}

	static int cnt;

	/** BFS */
	public static void bfs() {
		Where w, next;
		int newR, newC;
		while (!que.isEmpty()) {
			w = que.poll();
			cnt++;
			if (w.depth == L)
				continue;
			for (int[] dd : d[w.tunnel]) {
				newR = w.r + dd[0];
				newC = w.c + dd[1];
				next = new Where(newR, newC, w.depth + 1, maps[newR][newC]);

				if (!visited[newR][newC] && isConnect(w, next)) {
					visited[newR][newC] = true;
					que.add(next);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			cnt = 0;
			initial();
			visited[R + 1][C + 1] = true;
			que.add(new Where(R + 1, C + 1, 1, maps[R + 1][C + 1]));
			bfs();
			sb.append('#').append(t).append(' ').append(cnt).append('\n');
		}
		System.out.println(sb);
	}
}
