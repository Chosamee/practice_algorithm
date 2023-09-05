import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int first = 0;
		int i = 0;
		int j = 0;
		int k = N - 1;
		int val = 0;
		int idx = 0;
		while (i != r || j != c) {
			idx = 1 << k;
			val = (int) 1 << (2 * k);
			if (i + idx > r) {
				if (j + idx <= c) {
					first += val;
					j += idx;
				}
			} else {
				if (j + idx > c) {
					first += 2 * val;
					i += idx;
				} else {
					first += 3 * val;
					i += idx;
					j += idx;
				}
			}
			k--;

		}

		System.out.println(first);
	}
}
