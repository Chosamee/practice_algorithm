import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M, V;
	static boolean[][] matrix;
	static boolean[] visited;

	/** initialize */
	static void initial() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken()) - 1;
		matrix = new boolean[N][N];
		int r, c;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken()) - 1;
			matrix[r][c] = true;
			matrix[c][r] = true;
		}
	}

	/** dfs */
	static void dfs(int next) {
		visited[next] = true;
		sb.append(next + 1).append(" ");
		for (int i = 0; i < N; i++) {
			if (matrix[next][i] && !visited[i]) {
				dfs(i);
			}
		}
	}

	/** bfs */
	static Deque<Integer> que = new ArrayDeque<>();

	static void bfs() {
		que.add(V);
		int now;
		while (!que.isEmpty()) {
			now = que.poll();
			sb.append(now + 1).append(" ");
			for (int i = 0; i < N; i++) {
				if (matrix[now][i] && !visited[i]) {
					visited[i] = true;
					que.add(i);
				}
			}
		}
	}

	/** main */
	public static void main(String[] args) throws Exception {
		initial();
		visited = new boolean[N];
		dfs(V);
		sb.append("\n");

		visited = new boolean[N];
		visited[V] = true;
		bfs();
		System.out.println(sb);

	}
}
