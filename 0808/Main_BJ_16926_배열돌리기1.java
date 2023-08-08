import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] maps;
	static int N, M;

	static void rotate() {
		int i00, ni, nj;
		for (int k = 0; k < Math.min(M, N) / 2; k++) {
			ni = k;
			nj = k;
			i00 = maps[ni][nj];
			for (int j = k; j < M - k - 1; j++) {
				maps[ni][nj] =  maps[ni][++nj];
			}
			for (int j = k; j < N - k - 1; j++) {
				maps[ni][nj] =  maps[++ni][nj];
			}
			for (int j = k; j < M - k - 1; j++) {
				maps[ni][nj] =  maps[ni][--nj];
			}
			for (int j = k; j < N - k - 1; j++) {
				maps[ni][nj] =  maps[--ni][nj];
			}
			maps[ni + 1][nj] =  i00;

		}
	}

	public static void main(String args[]) throws Exception {
		int R;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		maps = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				maps[i][j] =Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < R; i++) {
			rotate();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(maps[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}