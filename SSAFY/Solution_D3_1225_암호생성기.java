import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb;
	static StringTokenizer st;
	static Deque<Integer> deque = new ArrayDeque<>();

	static void amho() {

		int temp;
		while (true) {
			for (int i = 1; i <= 5; i++) {
				temp = deque.poll() - i;
				if (temp <= 0) {
					temp = 0;
					deque.offer(temp);
					return;
				}
				deque.offer(temp);
			}
		}
	}

	public static void main(String args[]) throws Exception {
		int T = 1;
		while (br.readLine() != null) {
			sb = new StringBuffer();
			st = new StringTokenizer(br.readLine());
			deque.clear();
			for (int i = 0; i < 8; i++) {
				deque.offer(Integer.parseInt(st.nextToken()));
			}
			amho();
			for (int i = 0; i < 8; i++) {
				sb.append(deque.poll()).append(" ");
			}

			System.out.printf("#%d %s\n", T++, sb);
		}
	}
}
