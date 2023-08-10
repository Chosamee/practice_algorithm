import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] maps;
	static int N, M, K;
	static int[] permute;
	static int[][] cal;
	static int r, c, s;
	static int[][] copyM;

	static boolean np() {
		int i = K - 1;
		while (i > 0 && permute[i - 1] >= permute[i])
			i--;
		if (i == 0)
			return false;
		int j = K - 1;
		while (permute[i - 1] >= permute[j])
			j--;
		swap(i - 1, j);
		int k = K - 1;
		while (i < k) {
			swap(i++, k--);
		}
		return true;
	}

	static void swap(int i, int j) {
		int temp = permute[i];
		permute[i] = permute[j];
		permute[j] = temp;
	}

	static int[][] copyArray() {
		int[][] c = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				c[i][j] = maps[i][j];
			}
		}
		return c;
	}

	static void rotate() {
		int ni, nj;

		for (int l = 1; l < s + 1; l++) {
			ni = r - l;
			nj = c - l;
			int i00 = copyM[ni][nj];
			for (int j = 0; j < 2 * l; j++) {
				copyM[ni][nj] = copyM[++ni][nj];
			}
			for (int j = 0; j < 2 * l; j++) {
				copyM[ni][nj] = copyM[ni][++nj];
			}
			for (int j = 0; j < 2 * l; j++) {
				copyM[ni][nj] = copyM[--ni][nj];
			}
			for (int j = 0; j < 2 * l; j++) {
				copyM[ni][nj] = copyM[ni][--nj];
			}
			copyM[ni][nj + 1] = i00;
		}
	}

	static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.printf("%d ", copyM[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String args[]) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		maps = new int[N][M];
		int sumVal = 0;
		int minVal = 10001;
		int val = 10001;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cal = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			cal[i][0] = Integer.parseInt(st.nextToken());
			cal[i][1] = Integer.parseInt(st.nextToken());
			cal[i][2] = Integer.parseInt(st.nextToken());
		}
		permute = new int[K];
		for (int i = 0; i < K; i++) {
			permute[i] = i;
		}

		do {
			copyM = copyArray();
			for (int p : permute) {
				r = cal[p][0] - 1;
				c = cal[p][1] - 1;
				s = cal[p][2];
				rotate();
			}
			val = 10001;
			for (int i = 0; i < N; i++) {
				sumVal = 0;
				for (int j = 0; j < M; j++) {
					sumVal += copyM[i][j];
				}
				if (val > sumVal) {
					val = sumVal;
				}
			}
			if (minVal > val) {
				minVal = val;
			}

		} while (np());
		System.out.println(minVal);
	}
}