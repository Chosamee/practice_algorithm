import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static List<Integer> month = new ArrayList<>();
	static List<Integer> mCost = new ArrayList<>();
	static List<Integer> costs = new ArrayList<>();
	static int res = 3001;

	static void check(int mcnt, int cost) {
		if (mcnt >= 12) {
			if (cost < res)
				res = cost;
			return;
		}
		check(mcnt + 1, cost + mCost.get(mcnt));
		check(mcnt + 3, cost + costs.get(2));
	}

	public static void main(String args[]) throws Exception {

		int days;
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			res = 3001;
			costs.clear();
			mCost.clear();
			month.clear();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++)
				costs.add(Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				days = Integer.parseInt(st.nextToken());
				if (costs.get(0) * days < costs.get(1))
					mCost.add(costs.get(0) * days);
				else
					mCost.add(costs.get(1));
				month.add(days);
			}
			check(0, 0);
			if (costs.get(3) < res)
				res = costs.get(3);
			sb.append("#").append(test_case).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
}