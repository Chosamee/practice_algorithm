import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int R, C;
	static boolean[] visited = new boolean[27];
	static char[][] maps;
	static char asci = (char) ('A' + 26);

	static int maxDist;

	/** initialize */
	static void initial() throws Exception {
		visited[26] = true;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		maps = new char[R + 2][C + 2];
		String str;

		for (int i = 0; i < R + 2; i++) {
			maps[i][0] = asci;
			maps[i][C + 1] = asci;
		}
		for (int i = 0; i < C + 2; i++) {
			maps[0][i] = asci;
			maps[R + 1][i] = asci;
		}
		for (int i = 1; i < R + 1; i++) {
			str = br.readLine();
			for (int j = 1; j < C + 1; j++) {
				maps[i][j] = str.charAt(j - 1);
			}
		}
		maxDist = -1;
	}

	// for search
	static int[] dr = new int[] { 0, 0, 1, -1 };
	static int[] dc = new int[] { 1, -1, 0, 0 };
	static int temp;
	/** dfs */
	static void dfs(int nr, int nc, int dist, int visit) {
		int now = maps[nr][nc] - 'A';
		if (now == 26) return;
		maxDist = Math.max(maxDist, dist);
		for (int i = 0; i < 4; i++) {
			temp = maps[nr + dr[i]][nc + dc[i]] - 'A';
			if (now != asci && (visit & 1 << temp) == 0) {
				dfs(nr + dr[i], nc + dc[i], dist + 1, visit | 1 << temp);
			}
		}
			
	}

	/** main */
	public static void main(String[] args) throws Exception {
		initial();
		dfs(1, 1, 1, 1<<(maps[1][1] - 'A'));

		System.out.println(maxDist);
	}
}
