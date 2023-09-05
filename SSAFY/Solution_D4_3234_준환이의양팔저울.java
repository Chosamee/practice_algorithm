import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N;
	static int[] choo;
	static int totWeight;
	static int cnt;

	/** next permutation */
	static boolean np() {
		int i = N - 1;
		while (i > 0 && choo[i - 1] >= choo[i])
			i--;
		if (i == 0)
			return false;
		int j = N - 1;
		while (choo[i - 1] >= choo[j])
			j--;
		swap(i - 1, j);
		int k = N - 1;
		while (i < k) {
			swap(i++, k--);
		}
		return true;
	}

	static void swap(int i, int j) {
		int temp = choo[i];
		choo[i] = choo[j];
		choo[j] = temp;
	}

	/** initialize */
	static void initial() throws Exception {
		cnt = 0;
		N = Integer.parseInt(br.readLine());
		choo = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			choo[i] = Integer.parseInt(st.nextToken());
			totWeight += choo[i];
		}
		Arrays.sort(choo);
	}

	/** dfs */
	static void dfs(int depth, int left, int right) {
		if (left > totWeight / 2 || left > right) {
			return;
		}
		if (depth == N) {
			cnt++;
			return;
		}
		dfs(depth + 1, left + choo[depth], right);
		dfs(depth + 1, left, right + choo[depth]);
	}

	/** main */
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			initial();
			do {
				dfs(0, 0, 0);
			} while (np());
			sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
