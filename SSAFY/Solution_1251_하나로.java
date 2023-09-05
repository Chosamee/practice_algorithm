package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int to;
	double dist;

	public Node(int to, double dist) {
		super();
		this.to = to;
		this.dist = dist;
	}

	@Override
	public int compareTo(Node o) {
		return Double.compare(this.dist, o.dist);
	}
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N;
	static double E;
	static PriorityQueue<Node> que;
	static ArrayList<ArrayList<Node>> nodes;
	static boolean[] visited;
	static int[] x, y;
	static double ret;

	public static void initial() throws Exception {
		N = Integer.parseInt(br.readLine());
		x = new int[N];
		y = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			x[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			y[i] = Integer.parseInt(st.nextToken());
		}
		ret = 0;
		que = new PriorityQueue<>();
		nodes = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			nodes.add(new ArrayList<>());
		}
		visited = new boolean[N];
		double dist;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				dist = Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2);
				nodes.get(i).add(new Node(j, dist));
				nodes.get(j).add(new Node(i, dist));

			}
		}
		E = Double.parseDouble(br.readLine());
	}

	public static void prim() {

		visited[0] = true;
		for (Node n : nodes.get(0)) {
			que.add(n);
		}

		Node n;
		int to;
		double w;
		int cnt = 0;
		while (cnt != N - 1) {
			n = que.poll();
			to = n.to;
			w = n.dist;
			if (visited[to])
				continue;
			for (Node nn : nodes.get(to)) {
				if (!visited[nn.to])
					que.add(nn);
			}
			visited[to] = true;
			ret += w * E;
			cnt++;
		}
	}

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			initial();
			prim();
			sb.append('#').append(t).append(' ').append(Math.round(ret)).append('\n');
		}
		System.out.print(sb);
	}
}
