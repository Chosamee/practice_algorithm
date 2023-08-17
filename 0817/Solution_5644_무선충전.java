import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BC {
	int x;
	int y;
	int range;
	int power;

	public BC(int x, int y, int range, int power) {
		this.x = x;
		this.y = y;
		this.range = range;
		this.power = power;
	}
}

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int M, A;
	static BC[] BCs;

	static int[] Amove;
	static int[] Bmove;

	static int Ax, Ay;
	static int Bx, By;

	/** initialize */
	static void initial() throws Exception {
		Ax = 1;
		Ay = 1;
		Bx = 10;
		By = 10;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());

		Amove = new int[M];
		Bmove = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			Amove[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			Bmove[i] = Integer.parseInt(st.nextToken());
		}

		BCs = new BC[A];
		for (int i = 0; i < A; i++) {
			st = new StringTokenizer(br.readLine());
			BCs[i] = new BC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
	}

	/** calculate distance */
	static int calDist(int nowR, int nowC, int nextR, int nextC) {
		return Math.abs(nowR - nextR) + Math.abs(nowC - nextC);
	}

	/** moving! */
	static void move(char c, int dir) {
		int dx = 0, dy = 0;
		switch (dir) {
		case 1:
			dy = -1;
			break;
		case 2:
			dx = 1;
			break;
		case 3:
			dy = 1;
			break;
		case 4:
			dx = -1;
			break;
		default:
			break;
		}
		switch (c) {
		case 'A':
			Ax += dx;
			Ay += dy;
			break;
		case 'B':
			Bx += dx;
			By += dy;
			break;
		default:
			break;
		}
	}

	/** get max bc */
	static int getMax() {
		int maxVal = 0;
		int val = 0;
		for (int i = 0; i < A; i++) { // user A
			for (int j = 0; j < A; j++) { // user B
				val = isCan(BCs[i], Ax, Ay) + isCan(BCs[j], Bx, By);
				if (i == j && val > BCs[i].power)
					val = BCs[i].power;
				maxVal = Math.max(maxVal, val);
			}
		}
		return maxVal;
	}

	/** check is can ? */
	static int isCan(BC bc, int nX, int nY) {
		if (calDist(bc.x, bc.y, nX, nY) <= bc.range) {
			return bc.power;
		}
		return 0;
	}

	/** main */
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		int res;
		for (int test_case = 1; test_case <= T; test_case++) {
			res = 0;
			initial();
			res += getMax();
			for (int i = 0; i < M; i++) {
				move('A', Amove[i]);
				move('B', Bmove[i]);
				res += getMax();
			}
			sb.append("#").append(test_case).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
}
