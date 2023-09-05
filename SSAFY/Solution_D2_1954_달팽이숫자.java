import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;

	public static void main(String args[]) throws Exception {
		int T;
		T = Integer.parseInt(br.readLine());
		int[][] move = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		for (int test_case = 1; test_case <= T; test_case++) {
			sb = new StringBuilder();
			int n = Integer.parseInt(br.readLine());
			int row = 0;
			int col = -1;
			int dir = 0;
			int inputN = 1;
			int[][] map = new int[n][n];
			boolean pas = true;
			while (pas) {
				int mRow = move[dir][0];
				int mCol = move[dir][1];
				pas = false;
				while (true) {
					try {
						if (map[row+mRow][col+mCol] != 0) break;
						map[row += mRow][col += mCol] = inputN++;
					}
					catch(Exception e) {
						break;
					}
					pas = true;
				}
				dir++;
				dir %= 4;
			}

			for (int i =0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.printf("#%d\n", test_case);
			System.out.print(sb);
		}
	}
}