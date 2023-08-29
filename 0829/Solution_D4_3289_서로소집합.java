package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N;
	static int n, m;
	static int[] parent;

	public static void initial() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			parent[i] = i;
		}

	}

	public static void setSet() {
		int a1 = Integer.parseInt(st.nextToken());
		int a2 = Integer.parseInt(st.nextToken());
		parent[find(a2)] = find(a1);
	}

	public static int check() {
		int a1 = Integer.parseInt(st.nextToken());
		int a2 = Integer.parseInt(st.nextToken());
		return find(a1)==find(a2)?1:0;
	}

	public static int find(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}
	
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append('#').append(t).append(' ');
			initial();
			int type;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				type = Integer.parseInt(st.nextToken());
				if(type == 0)
					setSet();
				else if (type == 1)
					sb.append(check());
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
