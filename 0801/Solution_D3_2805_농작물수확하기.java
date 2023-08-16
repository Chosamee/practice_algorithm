import java.util.Scanner;
import java.util.stream.Stream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int size = sc.nextInt();
			int[][] bot = new int[size][size];
			int res = 0;
			for (int i = 0; i < size; i++) {
				bot[i] = Stream.of(sc.next().split("")).mapToInt(Integer::parseInt).toArray();
			}
			for (int i = 0; i < size; i++) {
				int lm = Math.abs(size/2 - i);
				for (int j = lm; j < size-lm; j++) {
					res += bot[i][j];
				}
			}
			System.out.printf("#%d %d\n", test_case, res);
		}
	}
}