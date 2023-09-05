import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	static StringTokenizer st;
	static int N;
	static int M;
	static List<List<Integer>> map = null;

	static int getSum(int row, int col) {
		int ret = 0;
		for (int i = row; i < row + M; i++) {
			for (int j = col; j < col + M; j++) {
				ret += map.get(i).get(j);
			}
		}
		return ret;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new ArrayList<>(new ArrayList<>());
			List<Integer> l = null;
			for (int i = 0; i < N; i++) {
				l = new ArrayList<>();
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					l.add(Integer.parseInt(st.nextToken()));
				}
				map.add(l);
			}
			int res = 0;
			int val = 0;
			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					val = getSum(i, j);
					if (res < val) {
						res = val;
					}
				}
			}
			System.out.printf("#%d %d\n", test_case, res);

		}
	}
}