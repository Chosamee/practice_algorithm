import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> people = new ArrayList<>();

	public static void main(String args[]) throws Exception {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int term = Integer.parseInt(st.nextToken());
		int temp = 0;
		for (int i = 1; i <= n; i++) {
			people.add(i);
		}
		sb.append("<");
		temp = (temp + term - 1) % n;
		sb.append(people.get(temp));
		people.remove(temp);
		n -= 1;
		while (!people.isEmpty()) {
			temp = (temp + term - 1) % n;
			sb.append(", ");
			sb.append(people.get(temp));
			people.remove(temp);
			n -= 1;
		}
		sb.append(">");
		System.out.println(sb);
	}
}