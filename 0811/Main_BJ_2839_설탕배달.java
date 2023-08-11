import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String args[]) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int q = N / 5;
		int r = N - 5 * q;
		int n3 = 0;
		switch (r) {
		case 1:
			q--;
			n3 = 2;
			break;
		case 2:
			q -= 2;
			n3 = 4;
			break;
		case 3:
			n3 = 1;
			break;
		case 4:
			q--;
			n3 = 3;
			break;
		default:
			break;
		}
		if (q < 0) {
			System.out.println(-1);
			return;
		}
		System.out.println(q + n3);
	}
}