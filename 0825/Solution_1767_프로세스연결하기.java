import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N;
	static int[][] maps;
	static ArrayList<int[]> cores;
	static int coreN;
	static int maxDepth;
	static int minVal;

	/** initialize 벽 너머 -1, 전선 2 */
	public static void initial() throws Exception {
		N = Integer.parseInt(br.readLine());
		maps = new int[N + 2][N + 2];
		cores = new ArrayList<>();
		for (int i = 0; i < N + 2; i++) {
			maps[i][0] = -1;
			maps[i][N + 1] = -1;
			maps[0][i] = -1;
			maps[N + 1][i] = -1;

		}
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 2; i < N; i++) {
			for (int j = 2; j < N; j++) {
				if (maps[i][j] == 1)
					cores.add(new int[] { i, j });
			}
		}
		coreN = cores.size();
		maxDepth = -1;
		minVal = Integer.MAX_VALUE;
	}

	static int[] dR = { -1, 1, 0, 0 };
	static int[] dC = { 0, 0, -1, 1 };

	/** 벽 끝까지 갈 수있다면 선 깔기 */
	public static int setLine(int r, int c, int dir) {
		int dr = dR[dir], dc = dC[dir];
		int newR = r + dr;
		int newC = c + dc;
		int length = 0;
		while (maps[newR][newC] != -1) {
			if (maps[newR][newC] != 0)
				return -1;
			newR += dr;
			newC += dc;
		}
		newR = r + dr;
		newC = c + dc;
		while (maps[newR][newC] != -1) {
			maps[newR][newC] = 2;
			newR += dr;
			newC += dc;
			length++;

		}
		return length;
	}

	/** 어짜피 선 겹칠 일 없으니까 그냥 쭉 가서 제거 */
	public static void delLine(int r, int c, int dir) {
		int dr = dR[dir], dc = dC[dir];
		int newR = r + dr;
		int newC = c + dc;
		while (maps[newR][newC] != -1) {
			maps[newR][newC] = 0;
			newR += dr;
			newC += dc;
		}
	}

	/** DFS */
	public static void allCases(int depth, int length, int coreCnt) {
		if (depth == coreN) {
			if (coreCnt > maxDepth) {
				maxDepth = coreCnt;
				minVal = length;
			} else if (coreCnt == maxDepth) {
				minVal = Math.min(minVal, length);
			}
			return;
		}
		int[] core = cores.get(depth);
		int r = core[0], c = core[1];
		int nextCnt = 0;
		for (int i = 0; i < 4; i++) {
			if ((nextCnt = setLine(r, c, i)) != -1) {
				allCases(depth + 1, length + nextCnt, coreCnt + 1);
				delLine(r, c, i);
			}

		}
		allCases(depth + 1, length, coreCnt);
	}

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			initial();
			allCases(0, 0, 0);
			sb.append("#").append(t).append(" ").append(minVal).append("\n");
		}
		System.out.println(sb);
	}
}
