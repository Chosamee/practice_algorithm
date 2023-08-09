import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] maps;
	static int N;
	static int maxCnt = 0;
	static int minVal;
	static int start = 0;

	static void bfs(int z, int x) {
		Deque<int[]> d = new ArrayDeque<>();
		int ni, nj, i, j, cnt;
		int[][] dij = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		d.add(new int[] { z, x, 1 });
		while (!d.isEmpty()) {
			int[] temp = d.poll();
			i = temp[0];
			j = temp[1];
			cnt = temp[2];
			for (int k = 0; k < 4; k++) {
				ni = i + dij[k][0];
				nj = j + dij[k][1];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && maps[ni][nj] == maps[i][j] + 1) {
					d.add(new int[] { ni, nj, cnt + 1 });
				}
			}
			if (maxCnt < cnt) {
				maxCnt = cnt;
				minVal = start;
			} else if (maxCnt == cnt) {
				if (minVal > start)
					minVal = start;
			}
		}
		return;
	}

	public static void main(String args[]) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			maps = new int[N][N];
			minVal = N * N;
			maxCnt = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					maps[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					start = maps[i][j];
					bfs(i, j);
				}
			}

			sb.append("#").append(test_case).append(" ").append(minVal).append(" ").append(maxCnt).append("\n");
		}

		System.out.println(sb);
	}
}