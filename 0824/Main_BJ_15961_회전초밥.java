package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, d, k, c;
	static int[] sushi;
	static int maxVal = 0;
	static int val = 0;
	static int first;
	static int[] fList;
	static Deque<Integer> que = new ArrayDeque<>();

	/** initialize */
	public static void initial() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		sushi = new int[d + 1];

		sushi[c]++;
		val++;
		int kind;
		fList = new int[k];
		for (int i = 0; i < k; i++) {
			kind = Integer.parseInt(br.readLine());
			fList[i] = kind;
			que.add(kind);
			if (sushi[kind] == 0)
				val++;
			sushi[kind]++;
		}
	}

	public static void slide() throws Exception {
		int next;
		for (int i = 0; i < N - k; i++) {
			first = que.poll();
			next = Integer.parseInt(br.readLine());
			que.add(next);
			if (sushi[next]++ == 0)
				val++;
			if (--sushi[first] == 0)
				val--;
			maxVal = Math.max(maxVal, val);
		}
		for (int i = 0; i < k; i++) {
			first = que.poll();
			next = fList[i];
			que.add(next);
			if (sushi[next]++ == 0)
				val++;
			if (--sushi[first] == 0)
				val--;
			maxVal = Math.max(maxVal, val);
		}
	}

	public static void main(String[] args) throws Exception {
		initial();
		slide();
		System.out.println(maxVal);
	}
}
