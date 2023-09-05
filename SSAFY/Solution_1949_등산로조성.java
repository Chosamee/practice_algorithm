import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Idx {
	int r;
	int c;

	public Idx(int r, int c) {
		this.r = r;
		this.c = c;
	}

	@Override
	public String toString() {
		return r + " " + c;
	}
}

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, K;
	static int[][] maps;
	static boolean[][] visited;
	static int maxDist;
	static int maxHeight;
	static ArrayList<Idx> talls;

	/** Initializing */
	public static void initial() throws Exception {
		talls = new ArrayList<>();
		maxDist = 0;
		maxHeight = 0;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		maps = new int[N][N];
		visited = new boolean[N][N];
		int height;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				height = Integer.parseInt(st.nextToken());
				maps[i][j] = height;
				maxHeight = Math.max(maxHeight, height);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (maps[i][j] == maxHeight) {
					talls.add(new Idx(i, j));
				}
			}
		}
	}

	static int[] dR = { -1, 1, 0, 0 };
	static int[] dC = { 0, 0, -1, 1 };

	/** dfs */
	public static void dfs(int r, int c, boolean useK, int dist, int val) {
		int newR, newC;
		int k;
		int newVal;
		visited[r][c] = true;
		maxDist = Math.max(maxDist, dist);
		for (int i = 0; i < 4; i++) {
			newR = r + dR[i];
			newC = c + dC[i];
			
			try {
				k = K;
				newVal = maps[newR][newC];
				if (newVal < val)
					dfs(newR, newC, useK, dist + 1, newVal);
				if (!useK && newVal >= val) {

					while (k != 0 && newVal >= val) {
						k--;
						newVal--;
					}
					if (!visited[newR][newC] && newVal < val)
						dfs(newR, newC, true, dist + 1, newVal);
				}
			} catch (Exception e) {
				// 아무것도 안함
			}
		}
		visited[r][c] = false;
	}

	/** print map */
	public static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				System.out.print(maps[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			initial();
			for (Idx ii : talls) {
				dfs(ii.r, ii.c, false, 1, maxHeight);
			}

			sb.append("#").append(t).append(" ").append(maxDist).append("\n");
		}
		System.out.println(sb);
	}
}
