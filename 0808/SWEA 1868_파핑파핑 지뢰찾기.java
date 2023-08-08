import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static List<String> maps = new ArrayList<>();
	static List<List<Integer>> nums = new ArrayList<>(new ArrayList<>());
	static boolean[][] visited;
	static int N;

	static int count_mine(int i, int j) {
		int cnt = 0;
		int[] diL = { 0, 1, -1 };
		int[] djL = { 0, 1, -1 };
		int ni, nj;
		for (int di : diL) {
			for (int dj : djL) {
				ni = i + di;
				nj = j + dj;
				if (0 <= ni && ni < N && 0 <= nj && nj < N && maps.get(ni).charAt(nj) == '*') {
					cnt++;
				}
			}
		}
		return cnt;
	}

	static void visit(int i, int j) {
		if (i == -1 || j == -1 || i == N || j == N)
			return;
		if (visited[i][j])
			return;
		visited[i][j] = true;
		if (nums.get(i).get(j) != 0) {
			return;
		}
		else {
			visit(i - 1, j - 1);
			visit(i - 1, j);
			visit(i - 1, j + 1);
			visit(i, j - 1);
			visit(i, j + 1);
			visit(i + 1, j - 1);
			visit(i + 1, j);
			visit(i + 1, j + 1);
		}

	}

	public static void main(String args[]) throws Exception {
		int res;
		int T = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		for (int test_case = 1; test_case <= T; test_case++) {
			res = 0;
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N][N];
			maps.clear();
			nums.clear();
			for (int i = 0; i < N; i++) {
				maps.add(br.readLine());
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (maps.get(i).charAt(j) == '.') {
						list.add(count_mine(i, j));
					} else {
						list.add(-1);
					}
				}
				nums.add(new ArrayList<>(list));
				list.clear();
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (nums.get(i).get(j) == 0 && !visited[i][j]) {
						visit(i, j);
						res++;
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (nums.get(i).get(j) != -1 && !visited[i][j]) {
						visit(i, j);
						res++;
					}
				}
			}
			sb.append("#").append(test_case).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
}