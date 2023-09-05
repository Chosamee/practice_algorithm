import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static boolean[][] maps = new boolean[100][100];
	static int N, M;

	public static void main(String args[]) throws Exception {
		N = Integer.parseInt(br.readLine());
		int i, j;
		int res = 0;
		for (int _ = 0; _ < N; _++) {
			st = new StringTokenizer(br.readLine());
			j = Integer.parseInt(st.nextToken());
			i = Integer.parseInt(st.nextToken());
			for (int ii = i; ii < i + 10; ii++) {
				for (int jj = j; jj < j + 10; jj++) {
					maps[ii][jj] = true;
				}
			}
		}
		for (int ii = 0; ii < 100; ii++) {
			for (int jj = 0; jj < 100; jj++) {
				if (maps[ii][jj]) {
					res++;
				}
			}
		}
		System.out.println(res);
	}
}