import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Integer> p = new PriorityQueue<>((i1, i2) ->{
		int abs1 = Math.abs(i1);
		int abs2 = Math.abs(i2);
		if(abs1 == abs2) return i1 - i2;
		return abs1 - abs2;
	});

	public static void main(String args[]) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int num;
		for (int _ = 0; _ < N; _++) {
			num = Integer.parseInt(br.readLine());
			if (num != 0) {
				p.add(num);
			}
			else if(p.peek() == null) {
				sb.append(0).append("\n");
			}
			else {
				sb.append(p.poll()).append("\n");
			}
		}
		System.out.println(sb);
	}
}
