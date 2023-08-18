import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M, D;
	static boolean[][] maps;
	static int maxKill = -1;

	/** initialize */
	static void initial() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		maps = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if (st.nextToken().equals("1"))
					maps[i][j] = true;
			}
		}
	}

	/** combination */
	public static void comb() {
		for (int i = 0; i < M; i++) {
			for (int j = i + 1; j < M; j++) {
				for (int l = j + 1; l < M; l++) {
					archer(i, j, l);
				}
			}
		}
	}

	/** input archer's column */
	public static void archer(int i1, int i2, int i3) {
		int nN = N;
		boolean[][] nMaps = Arrays.stream(maps).map(boolean[]::clone).toArray(boolean[][]::new);
		int kill = 0;
		while (nN > 0) {
			int rc1 = shoot(i1, nN, nMaps);
			int rc2 = shoot(i2, nN, nMaps);
			int rc3 = shoot(i3, nN, nMaps);
			if (rc1 != -1) {
				nMaps[rc1 / 100][rc1 % 100] = false;
				kill++;
			}
			if (rc2 != -1) {
				nMaps[rc2 / 100][rc2 % 100] = false;
				kill++;
			}
			if (rc3 != -1) {
				nMaps[rc3 / 100][rc3 % 100] = false;
				kill++;
			}
			if (rc1 == rc2 && rc1 != -1)
				kill--;
			if (rc1 == rc3 && rc1 != -1)
				kill--;
			if (rc2 == rc3 && rc2 != -1)
				kill--;
			if (rc1 == rc2 && rc2 == rc3 && rc1 != -1)
				kill++;
			nN--;
		}
		maxKill = Math.max(maxKill, kill);
	}

	/** shoot target */
	public static int shoot(int idx, int n, boolean[][] nMaps) {
		int dc;
		for (int i = 1; i <= D; i++) {
			for (int dr = 1; dr <= i; dr++) {
				dc = i - dr;
				if (idx - dc >= 0 && n - dr >= 0 && nMaps[n - dr][idx - dc]) {
					return (n - dr) * 100 + idx - dc;
				}
			}
			for (int dr = i; dr >= 1; dr--) {
				dc = i - dr;
				if (idx + dc < M && n - dr >= 0 && nMaps[n - dr][idx + dc]) {
					return (n - dr) * 100 + idx + dc;
				}
			}
		}
		return -1;
	}

	/** main */
	public static void main(String[] args) throws Exception {
		initial();
		comb();
		System.out.println(maxKill);

	}
}
