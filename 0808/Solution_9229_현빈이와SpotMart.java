import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws Exception {
		int T = Integer.parseInt(br.readLine());
		int N, M, res, hap;
		List<Integer> gwaja = new ArrayList<>();
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			gwaja.clear();
			for (int i = 0; i < N; i++) {
				gwaja.add(Integer.parseInt(st.nextToken()));
			}
			res = -1;
			hap = -1;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					hap = gwaja.get(i) + gwaja.get(j);
					if (hap <= M && hap > res) {
						res = hap;
					}
				}
			}
			sb.append("#").append(test_case).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
}