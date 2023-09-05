import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int K = 9;
	static int[] cards = new int[9];
	static int[] yours = new int[9];

	static boolean np() {
		int i = K - 1;
		while (i > 0 && cards[i - 1] >= cards[i])
			i--;
		if (i == 0)
			return false;
		int j = K - 1;
		while (cards[i - 1] >= cards[j])
			j--;
		swap(i - 1, j);
		int k = K - 1;
		while (i < k) {
			swap(i++, k--);
		}
		return true;
	}

	static void swap(int i, int j) {
		int temp = cards[i];
		cards[i] = cards[j];
		cards[j] = temp;
	}

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			boolean[] allCard = new boolean[18];
			int idx = 0;
			int temp;
			int score = 0;
			int yscore = 0;
			int wincnt = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				temp = Integer.parseInt(st.nextToken());
				allCard[temp - 1] = true;
				yours[idx++] = temp;
			}
			idx = 0;
			for (int i = 0; i < 18; i++) {
				if (!allCard[i])
					cards[idx++] = i + 1;
			}
			do {
				score = 0;
				yscore = 0;
				for (int i = 0; i < 9; i++) {

					if (yours[i] < cards[i])
						score += yours[i] + cards[i];
					else
						yscore += yours[i] + cards[i];

					if (score > 85) {
						wincnt++;
						break;
					}
					if (yscore > 85)
						break;
				}
			} while (np());
			sb.append("#").append(test_case).append(" ").append(362880 - wincnt).append(" ").append(wincnt)
					.append("\n");
		}
		System.out.println(sb);
	}
}
