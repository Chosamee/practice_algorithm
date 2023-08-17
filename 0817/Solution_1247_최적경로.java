package test3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int R, C;
	static int N;
	static int[] r, c;

	// company, home
	static int cr, cc, hr, hc;

	// for next permutation array
	static int[] npArray;
	static int minDist;

	/** initialize */
	static void initial() throws Exception {
		N = Integer.parseInt(br.readLine());
		r = new int[N];
		c = new int[N];
		npArray = new int[N];
		for (int i = 0; i < N; i++) {
			npArray[i] = i;
		}
		st = new StringTokenizer(br.readLine());
		cr = Integer.parseInt(st.nextToken());
		cc = Integer.parseInt(st.nextToken());
		hr = Integer.parseInt(st.nextToken());
		hc = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			r[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
		}
		minDist = Integer.MAX_VALUE;
	}

	/** next permutation */
	static boolean np() {
		int i = N - 1;
		while (i > 0 && npArray[i - 1] >= npArray[i])
			i--;
		if (i == 0)
			return false;
		int j = N - 1;
		while (npArray[i - 1] >= npArray[j])
			j--;
		swap(i - 1, j);
		int k = N - 1;
		while (i < k) {
			swap(i++, k--);
		}
		return true;
	}

	static void swap(int i, int j) {
		int temp = npArray[i];
		npArray[i] = npArray[j];
		npArray[j] = temp;
	}

	/** calculate distance */
	static int calDist(int nowR, int nowC, int nextR, int nextC) {
		return Math.abs(nowR - nextR) + Math.abs(nowC - nextC);
	}

	/** research */
	static void research() {
		int dist;
		int nowR, nowC, nextR, nextC;
		do {
			dist = 0;
			nowR = cr;
			nowC = cc;
			for (int idx : npArray) {
				nextR = r[idx];
				nextC = c[idx];
				dist += calDist(nowR, nowC, nextR, nextC);
				nowR = nextR;
				nowC = nextC;
				if (dist > minDist)
					break;
			}
			dist += calDist(nowR, nowC, hr, hc);
			minDist = Math.min(minDist, dist);
		} while (np());
	}

	/** main */
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			initial();
			research();
			sb.append("#").append(test_case).append(" ").append(minDist).append("\n");
		}
		System.out.println(sb);
	}
}
