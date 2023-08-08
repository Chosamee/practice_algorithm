import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static boolean checkInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	static int check() throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		if (N % 2 == 0) {
			for (int i = 0; i < N; i++)
				br.readLine();
			return 0;
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.countTokens() % 2 != 0) {
				for (int j = i + 1; j < N; j++)
					br.readLine();
				return 0;
			} else if (st.countTokens() == 4) {
				st.nextToken();
				if (checkInt(st.nextToken())) {
					for (int j = i + 1; j < N; j++)
						br.readLine();
					return 0;
				}
			} else if (st.countTokens() == 2) {
				st.nextToken();
				if (!checkInt(st.nextToken())) {
					for (int j = i + 1; j < N; j++)
						br.readLine();
					return 0;
				}
			}

		}
		return 1;

	}

	public static void main(String args[]) throws Exception {
		int res;
		for (int test_case = 1; test_case <= 10; test_case++) {
			res = check();
			sb.append("#").append(test_case).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
}