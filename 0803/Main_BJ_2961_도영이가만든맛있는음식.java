import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static List<Integer> bitter = new ArrayList<>();
	static List<Integer> sour = new ArrayList<>();
	static int[] bRet;
	static int[] sRet;
	static int diff = 1000000000;
	static int N;

	static void getTaste(int n, int now, int len) {
		if (now == len) {
			int b = 0;
			int s = 1;
			for (int i = 0; i < bRet.length; i++) {
				s *= sRet[i];
				b += bRet[i];
			}
			if (diff > Math.abs(s - b))
				diff = Math.abs(s - b);
			return;
		}
		for (int i = n; i < N; i++) {
			bRet[now] = bitter.get(i);
			sRet[now] = sour.get(i);
			getTaste(i + 1, now + 1, len);
		}
	}

	public static void main(String args[]) throws Exception {

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			sour.add(Integer.parseInt(st.nextToken()));
			bitter.add(Integer.parseInt(st.nextToken()));
		}
		for (int i = 1; i < N+1; i++) {
			bRet = new int[i];
			sRet = new int[i];
			getTaste(0, 0, i);
		}
		System.out.println(diff);
	}
}