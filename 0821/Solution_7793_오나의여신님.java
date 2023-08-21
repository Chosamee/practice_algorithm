import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M;
	// 수연, 목적지
	static int endR, endC;
	static Deque<int[]> devils;
	static Deque<int[]> sQue;
	static char[][] maps;
	static boolean[][] visited;
	static int dist;
	static boolean end;

	/** Initializing */
	public static void initial() throws Exception {
		dist = 0;
		end = false;
		devils = new ArrayDeque<>();
		sQue = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maps = new char[N][M];
		visited = new boolean[N][M];
		String temp;
		char c;
		for (int i = 0; i < N; i++) {
			temp = br.readLine();
			for (int j = 0; j < M; j++) {
				c = temp.charAt(j);
				maps[i][j] = c;
				if (c == '*') {
					devils.offer(new int[] { i, j });
				} else if (c == 'S') {
					sQue.offer(new int[] { i, j });
					visited[i][j] = true;
				} else if (c == 'D') {
					endR = i;
					endC = j;
				}
			}
		}
	}

	static int[] dR = { -1, 1, 0, 0 };
	static int[] dC = { 0, 0, -1, 1 };

	/** 한번만 퍼지는 함수 */
	public static Deque<int[]> oneStep(Deque<int[]> deque, boolean flag) {
		int newR, newC;
		int nowR, nowC;
		int[] nowRC;
		Deque<int[]> ret = new ArrayDeque<>();
		while (!deque.isEmpty()) {
			nowRC = deque.poll();
			nowR = nowRC[0];
			nowC = nowRC[1];
			for (int i = 0; i < 4; i++) {
				newR = nowR + dR[i];
				newC = nowC + dC[i];
				try {
					if (!visited[newR][newC] && maps[newR][newC] == '.') {
						visited[newR][newC] = true;
						ret.offer(new int[] { newR, newC });
						
						if (flag)
							maps[newR][newC] = '*';
					} else if (!flag && maps[newR][newC] == 'D') {
						end = true;
						break;
					}
				} catch (Exception e) {
					// 아무것도 안함
				}
			}
		}
		return ret;
	}

	/** print map */
	public static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				System.out.print(maps[i][j] + " ");
			}
			System.out.println();
		}
	}

	/** check god */
	public static boolean check() {
		int newR, newC;

		for (int i = 0; i < 4; i++) {
			newR = endR + dR[i];
			newC = endC + dC[i];
			try {
				if (maps[newR][newC] == '.' || maps[newR][newC] == 'S') {
					return true;
				}
			} catch (Exception e) {

			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			initial();

			while (!end && !sQue.isEmpty() && check()) {
				devils = oneStep(devils, true);
				sQue = oneStep(sQue, false);
				dist++;
			}
			sb.append("#").append(t).append(" ").append(end ? dist : "GAME OVER").append("\n");
		}
		System.out.println(sb);
	}
}
