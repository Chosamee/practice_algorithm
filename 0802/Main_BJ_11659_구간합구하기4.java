import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		String[] f;
		f = br.readLine().split(" ");
		int N = Integer.parseInt(f[0]);
		int test_case = Integer.parseInt(f[1]);
		List<Integer> dp = new ArrayList<>();
		int sumVal = 0;
		int start, end;
		dp.add(0);
		int[] lists = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		for (int i=0;i<N;i++) {
			dp.add(sumVal+=lists[i]);
		}

		for (int i=0;i<test_case; i++) {
			f = br.readLine().split(" ");
			start = Integer.parseInt(f[0]);
			end = Integer.parseInt(f[1]);
			sb.append(dp.get(end) - dp.get(start-1)).append("\n");
		}
		System.out.println(sb);
	}
}