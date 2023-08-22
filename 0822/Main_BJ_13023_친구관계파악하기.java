import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M;
	static ArrayList<ArrayList<Integer>> friend;
	static boolean isExisted = false;
	static boolean[] visited;

	public static void dfs(int length, int lastIdx) {
		if (length == 4) {
			isExisted = true;
			return;
		}
		for (int f : friend.get(lastIdx)) {
			if (isExisted)
				return;
			if (!visited[f]) {
				visited[f] = true;
				dfs(length + 1, f);
				visited[f] = false;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		friend = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			friend.add(new ArrayList<>());
		}
		visited = new boolean[N];
		int r, c;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			friend.get(r).add(c);
			friend.get(c).add(r);
		}
		for (int i = 0; i < N; i++) {
			visited[i] = true;
			dfs(0, i);
			visited[i] = false;
			if (isExisted)
				break;
		}
		System.out.println(isExisted ? 1 : 0);
	}
}
