package aaa;

import java.util.Scanner;

class Main {
	static int num = 0;
	static int len = 0;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	static int[] ret;
	static void permutation(int now) {
		if (now == len) {
			for (int i : ret) {
				sb.append(i).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = 0; i < num; i++) {
			if (!visited[i]) {
				ret[now] = i + 1;
				visited[i] = true;
				permutation(now + 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		len = sc.nextInt();
		ret = new int[len];
		visited = new boolean[num];
		permutation( 0);
		System.out.println(sb);
	}
}