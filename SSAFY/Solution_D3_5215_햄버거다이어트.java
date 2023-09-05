import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] mat;
	static int[] calories;
	static int res = 0;
	static int N, C;

	static void ham(int idx, int matTot, int calTot) {
		if (calTot > C) return;
		if(idx == N) {
			if (matTot > res) {
				res = matTot;
			}
			return;
		}
		ham(idx+1, matTot + mat[idx], calTot + calories[idx]);
		ham(idx+1, matTot, calTot);
	}

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			mat = new int[N];
			calories = new int[C];
			res = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				mat[i] = Integer.parseInt(st.nextToken());
				calories[i] = Integer.parseInt(st.nextToken());
			}
			ham(0, 0, 0);
			sb.append("#").append(test_case).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
}
