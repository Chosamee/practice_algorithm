import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int M;
	static int[] com;
	static List<int[]> homes = new ArrayList<>();
	static List<int[]> chicks = new ArrayList<>();
	static int totMin = Integer.MAX_VALUE;

	static void combination(int depth, int idx) {
		if (depth == M) {
			chicksRoad();
			return;
		}
		for (int i = idx; i < chicks.size(); i++) {
			com[depth] = i;
			combination(depth + 1, i + 1);
		}
	}

	static void chicksRoad() {
		List<int[]> selectedChicks = new ArrayList<>();
		int val = 0;
		int min;
		int s;
		for (int i=0;i<com.length;i++) {
			selectedChicks.add(chicks.get(com[i]));
		}
		
		for (int[] home:homes) {
			min = Integer.MAX_VALUE;
			for (int[] chick:selectedChicks) {
				s = Math.abs(home[0] - chick[0]) + Math.abs(home[1] - chick[1]);
				min = Math.min(min, s);
			}
			val += min;
		}
		totMin = Math.min(totMin, val);
	}
	
	public static void main(String args[]) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		com = new int[M];
		int next;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				next = Integer.parseInt(st.nextToken());
				if (next == 1) {
					homes.add(new int[] { i, j });
				} else if (next == 2) {
					chicks.add(new int[] { i, j });
				}
			}
		}

		combination(0, 0);
		System.out.println(totMin);
	}
}