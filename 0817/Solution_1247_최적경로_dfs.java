import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int R, C;
	static int N;
	static int[] r, c;

	// company, home
	static int cr, cc, hr, hc;

	static int minDist;
	static boolean[] visited;

	/** initialize */
	static void initial() throws Exception {
		N = Integer.parseInt(br.readLine());
		r = new int[N];
		c = new int[N];
		st = new StringTokenizer(br.readLine());
		cr = Integer.parseInt(st.nextToken());
		cc = Integer.parseInt(st.nextToken());
		hr = Integer.parseInt(st.nextToken());
		hc = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			r[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
		}
		minDist = Integer.MAX_VALUE;
		visited = new boolean[N];
	}

	/** calculate distance */
	static int calDist(int nowR, int nowC, int nextR, int nextC) {
		return Math.abs(nowR - nextR) + Math.abs(nowC - nextC);
	}

	/** research */
	static void research(int depth, int nR, int nC, int dist) {
		if (depth == N) {
			dist += calDist(nR, nC, hr, hc);
			minDist = Math.min(minDist, dist);
			return;
		}

		if (dist >= minDist)
			return;
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				research(depth + 1, r[i], c[i], dist + calDist(nR, nC, r[i], c[i]));
				visited[i] = false;
			}
		}

	}

	/** main */
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			initial();
			research(0, cr, cc, 0);
			sb.append("#").append(test_case).append(" ").append(minDist).append("\n");
		}
		System.out.println(sb);
	}
}
