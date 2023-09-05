import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] in;
	static int L, start;
	static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
	static boolean[] visited;
	static Deque<Integer> que = new ArrayDeque<>();

	/** initialize */
	public static void initial() throws Exception {
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		int from, to;
		que.clear();
		edges.clear();
		for (int i = 0; i < 101; i++) {
			edges.add(new ArrayList<>());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < L / 2; i++) {
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			if (!edges.get(from).contains(to))
				edges.get(from).add(to);
		}
		visited = new boolean[101];
	}

	static int maxVal;

	/** BFS */
	public static boolean bfs() {
		int now;
		if(que.isEmpty()) return true;
		maxVal = 0;
		int n = que.size();
		for (int i = 0; i < n; i++) {
			now = que.poll();
			maxVal = Math.max(now, maxVal);
			for (int next : edges.get(now)) {
				if (!visited[next]) {
					visited[next] = true;
					que.add(next);
				}
			}
		}
		return bfs();
	}

	public static void main(String[] args) throws Exception {
		for (int t = 1; t <= 10; t++) {
			maxVal = 0;
			initial();
			que.add(start);
			visited[start] = true;
			bfs();
			sb.append('#').append(t).append(' ').append(maxVal).append('\n');
		}
		System.out.println(sb);
	}
}
