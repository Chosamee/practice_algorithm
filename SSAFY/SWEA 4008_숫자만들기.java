import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int maxv, minv;
	static List<Integer> numList = new ArrayList<>();
	static int N;

	// a b c d => count + - * /
	static void cal(int now, int val, int a, int b, int c, int d) {
		if (now == N) {
			if (val > maxv)
				maxv = val;
			if (val < minv)
				minv = val;
		}
		if (a > 0)
			cal(now + 1, val + numList.get(now), a - 1, b, c, d);
		if (b > 0)
			cal(now + 1, val - numList.get(now), a, b - 1, c, d);
		if (c > 0)
			cal(now + 1, val * numList.get(now), a, b, c - 1, d);
		if (d > 0)
			cal(now + 1, val / numList.get(now), a, b, c, d - 1);
	}

	public static void main(String args[]) throws Exception {
		int T = Integer.parseInt(br.readLine());
		int plus, minus, mult, div;
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			plus = Integer.parseInt(st.nextToken());
			minus= Integer.parseInt(st.nextToken());
			mult = Integer.parseInt(st.nextToken());
			div = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			numList.clear();
			for (int i = 0; i < N; i++) {
				numList.add(Integer.parseInt(st.nextToken()));
			}
			
			maxv = -100000000;
			minv = 100000000;
			cal(1, numList.get(0), plus, minus, mult, div);
			sb.append("#").append(test_case).append(" ").append(maxv - minv).append("\n");
		}
		System.out.println(sb);
	}
}
