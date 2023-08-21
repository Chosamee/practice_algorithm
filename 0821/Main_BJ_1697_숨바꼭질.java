import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int N, K;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Deque<int[]> que = new ArrayDeque<>();
		int[] temp;
		int n, depth = 0;
		boolean visited[] = new boolean[150001];
		que.offer(new int[] { N, depth });
		while (!que.isEmpty()) {
			temp = que.poll();
			n = temp[0];
			depth = temp[1];
			if (n == K)
				break;
			visited[n] = true;
			if (n < K) {
				if (n < 75000 && !visited[2 * n])
					que.offer(new int[] { n * 2, depth + 1 });
				if (!visited[n + 1])
					que.offer(new int[] { n + 1, depth + 1 });
			}
			if (n > 0 && !visited[n - 1])
				que.offer(new int[] { n - 1, depth + 1 });
		}
		System.out.println(depth);
	}
}
