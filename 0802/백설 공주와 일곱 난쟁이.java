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

		int sumVal = 0;
		int temp = 0;
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			temp = Integer.parseInt(br.readLine());
			sumVal += temp;
			l.add(temp);
		}
		int des = sumVal - 100;
		for (int i = 0; i < 9; i++) {
			for (int j = i+1; j < 9; j++) {
				if (l.get(i) + l.get(j) == des) {
					l.remove(j);
					l.remove(i);
					break;
				}
			}
			if (l.size() == 7) {
				break;
			}
		}
		for (int i : l) {
			System.out.println(i);
		}
	}
}