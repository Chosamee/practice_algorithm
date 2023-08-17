package test3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int R, C;
	static char[][] maps;
	static int N;

	static String str;
	static char nowLook;
	static int nowR, nowC;

	/** initialize */
	static void initial() throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		maps = new char[R + 2][C + 2];
		for (int i = 0; i < R + 2; i++) {
			maps[i][0] = '-';
			maps[i][C + 1] = '-';
		}
		for (int i = 0; i < C + 2; i++) {
			maps[0][i] = '-';
			maps[R + 1][i] = '-';
		}
		char m;
		for (int i = 1; i < R + 1; i++) {
			str = br.readLine();
			for (int j = 1; j < C + 1; j++) {
				m = str.charAt(j - 1);
				maps[i][j] = m;
				if (m == '<' || m == '>' || m == '^' || m == 'v') {
					nowLook = m;
					nowR = i;
					nowC = j;
				}
			}
		}
		N = Integer.parseInt(br.readLine());
	}

	/** check move */
	static void checkMove(int dr, int dc) {
		if (maps[nowR + dr][nowC + dc] == '.') {
			maps[nowR][nowC] = '.';
			nowR += dr;
			nowC += dc;
		}
		maps[nowR][nowC] = nowLook;
	}

	/** shooting! */
	static void shoot() {
		int dR = 0;
		int dC = 0;
		switch (nowLook) {
		case '^':
			dR = -1;
			break;
		case 'v':
			dR = 1;
			break;
		case '<':
			dC = -1;
			break;
		case '>':
			dC = 1;
			break;
		default:
			break;
		}

		// bomb RC
		int bR = nowR;
		int bC = nowC;
		int bombNow;
		while (bR >= 0 && bC >= 0 && bR < R + 2 && bC < C + 2) {
			bombNow = maps[bR][bC];
			if (bombNow == '*') {
				maps[bR][bC] = '.';
				break;
			} else if (bombNow == '#') {
				break;
			}
			bR += dR;
			bC += dC;
		}
	}

	/** action follow character */
	static void action(char c) {
		if (c == 'U') {
			nowLook = '^';
			checkMove(-1, 0);
		} else if (c == 'D') {
			nowLook = 'v';
			checkMove(1, 0);
		} else if (c == 'L') {
			nowLook = '<';
			checkMove(0, -1);
		} else if (c == 'R') {
			nowLook = '>';
			checkMove(0, 1);
		} else if (c == 'S') {
			shoot();
		}
	}

	/** print map */
	static void printMap() {
		for (int i = 1; i < R + 1; i++) {
			for (int j = 1; j < C + 1; j++) {
				sb.append(maps[i][j]);
			}
			sb.append("\n");
		}
	}

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			initial();
			str = br.readLine();
			for (int i = 0; i < str.length(); i++) {
				action(str.charAt(i));
			}
			sb.append("#").append(test_case).append(" ");
			printMap();
		}
		System.out.println(sb);
	}
}
