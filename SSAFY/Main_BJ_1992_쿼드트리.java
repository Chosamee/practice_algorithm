import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static char[][] maps;

	static void zzip(int si, int sj, int ei, int ej) {
		char first = maps[si][sj];
		for (int k = si; k < ei; k++) {
			for (int l = sj; l < ej; l++) {
				if (maps[k][l] != first) {
					first = 2;
					break;
				}
			}
			if (first == 2)
				break;
		}

		if (first != 2) {
			sb.append(first);
			return;
		}
		else {
			int halfi = (si + ei)/2;
			int halfj = (sj + ej)/2;
			sb.append("(");
			zzip(si, sj, halfi, halfj);
			zzip(si, halfj, halfi, ej);
			zzip(halfi, sj, ei, halfj);
			zzip(halfi, halfj, ei, ej);
			sb.append(")");
		}
	}

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		String str;
		maps = new char[N][N];
		for (int k = 0; k < N; k++) {
			str = br.readLine();
			for (int l = 0; l < N; l++) {
				maps[k][l] = str.charAt(l);
			}
		}

		zzip(0, 0, N, N);
		System.out.println(sb);
	}
}
