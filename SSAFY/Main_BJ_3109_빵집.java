import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static char[][] maps;
	static boolean[][] visited;
	static int cnt = 0;
	static int R, C;
	static boolean flag = false;
	static int[] di = new int[] { -1, 0, 1 };

	static void check(int row, int col) {
		int ni = row;
		int nj = col;
		visited[ni][nj] = true;
		if (nj == C) {
			cnt += 1;
			flag = true;
			return;
		}

		nj++;
		for (int k = 0; k < 3; k++) {
			if (!visited[ni + di[k]][nj] && maps[ni + di[k]][nj] == '.') {
				check(ni + di[k], nj);
				if (flag)
					return;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		String str;
		maps = new char[R + 3][C + 3];
		visited = new boolean[R + 2][C + 2];
		for (int l = 0; l < C + 2; l++) {
			visited[0][l] = true;
			visited[R + 1][l] = true;
		}
		for (int l = 0; l < R + 2; l++) {
			visited[l][0] = true;
			visited[l][C + 1] = true;
		}
		for (int k = 1; k < R + 1; k++) {
			str = br.readLine();
			for (int l = 1; l < C + 1; l++) {
				maps[k][l] = str.charAt(l - 1);
			}
		}
		for (int i = 1; i < R + 1; i++) {
			flag = false;
			check(i, 1);
		}

		System.out.println(cnt);
	}
}
