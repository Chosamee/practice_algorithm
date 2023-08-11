import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static int[][] synergy;
	static int[] cook;
	static int[] cook2;
	static int totMin;

	static void combination(int depth, int idx) {
		if (depth == N / 2) {
			cookPoint();
			return;
		}
		for (int i = idx; i < N; i++) {
			cook[depth] = i;
			combination(depth + 1, i + 1);
		}
	}

	static void cookPoint() {
		int val = 0;
		int val2 = 0;
		int s = N / 2;
		int idx = 0;
		int idx2 = 0;
		for (int i = 0; i < N; i++) {
			if (idx < s && cook[idx] == i)
				idx++;
			else
				cook2[idx2++] = i;
		}

		for (int i = 0; i < s; i++) {
			for (int j = i; j < s; j++) {
				val += synergy[cook[i]][cook[j]] + synergy[cook[j]][cook[i]];
			}
		}
		for (int i = 0; i < s; i++) {
			for (int j = i; j < s; j++) {
				val2 += synergy[cook2[i]][cook2[j]] + synergy[cook2[j]][cook2[i]];
			}
		}
		totMin = Math.min(totMin, Math.abs(val - val2));
	}

	public static void main(String args[]) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			synergy = new int[N][N];
			totMin = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			cook = new int[N / 2];
			cook2 = new int[N / 2];
			combination(0, 0);
			sb.append("#").append(test_case).append(" ").append(totMin).append("\n");
		}

		System.out.println(sb);
	}
}