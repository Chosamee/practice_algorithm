package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int to;
	int w;

	public Node(int to, int w) {
		super();
		this.to = to;
		this.w = w;
	}

	@Override
	public int compareTo(Node o) {
		return this.w - o.w;
	}
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int E, V, start;
	static ArrayList<ArrayList<Node>> edges = new ArrayList<>();
	static int[] res;

	/** initialize */
	public static void initial() throws Exception {
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		start = Integer.parseInt(br.readLine());
		res = new int[V + 1];
		for (int i = 0; i < V + 1; i++) {
			res[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < V + 1; i++) {
			edges.add(new ArrayList<>());
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			edges.get(Integer.parseInt(st.nextToken()))
					.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
	}

	/** BFS */
	public static void bfs() {
		PriorityQueue<Node> heap = new PriorityQueue<>();
		heap.add(new Node(start, 0));
		res[start] = 0;
		int val;
		while (!heap.isEmpty()) {
			Node now = heap.poll();
			val = now.w;
			if (val > res[now.to])
				continue;
			for (Node next : edges.get(now.to)) {
				if (val + next.w < res[next.to]) {
					res[next.to] = val + next.w;
					heap.add(new Node(next.to, res[next.to]));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		initial();
		bfs();
		for (int i = 1; i < V + 1; i++) {
			sb.append(res[i] == Integer.MAX_VALUE ? "INF" : res[i]).append('\n');
		}
		System.out.println(sb);
	}
}
