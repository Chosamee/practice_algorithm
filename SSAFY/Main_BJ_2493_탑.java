import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static Stack<Integer> tower = new Stack<>();
	static Stack<Integer> idx = new Stack<>();
	static int[] receives;

	public static void main(String args[]) throws Exception {
		final int tNum = Integer.parseInt(br.readLine());
		receives = new int[tNum];
		int temp;
		st = new StringTokenizer(br.readLine());
		tower.add(0);
		idx.add(-1);
		for (int i = 0; i < tNum; i++) {

			temp = Integer.parseInt(st.nextToken());
			while (!tower.isEmpty() && temp > tower.peek()) {
				tower.pop();
				idx.pop();
			}
			if (tower.isEmpty()) {
				sb.append("0").append(" ");
			}
			else {
				sb.append(idx.peek() + 1).append(" ");
			}
			tower.push(temp);
			idx.push(i);
		}
		System.out.println(sb);

	}
}