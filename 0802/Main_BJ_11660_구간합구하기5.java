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
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int test_case = Integer.parseInt(st.nextToken());

		List<List<Integer>> dp = new ArrayList<>(new ArrayList<>());
		int sumVal = 0;
		int x1, y1, x2, y2;
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < N+1; i++) {
			l.add(0);
		}
		dp.add(l);
		for (int i = 1; i < N+1; i++) {
			sumVal = 0;
			st = new StringTokenizer(br.readLine(), " ");
			l = new ArrayList<>();
			l.add(0);
			for (int j = 1; j < N+1; j++) {
				sumVal += Integer.parseInt(st.nextToken());
				l.add(sumVal + dp.get(i-1).get(j));
			}
			dp.add(l);
		}

		for (int i = 0; i < test_case; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			sb.append(dp.get(x2).get(y2)- dp.get(x1-1).get(y2) - dp.get(x2).get(y1-1) + dp.get(x1-1).get(y1-1)).append("\n");
		}
		System.out.println(sb);
	}
}