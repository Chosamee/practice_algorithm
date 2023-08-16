package test3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	// win draw lose
	static int[] win = new int[6];
	static int[] draw = new int[6];
	static int[] lose = new int[6];
	static boolean isCan = false;
	
	static boolean fcheck() {
		// 각 팀 전적 5판
		for (int i = 0; i < 6; i++) {
			if (win[i] + draw[i] + lose[i] != 5) {
				return false;
			}
		}
		// 무승부 총 합 짝수, 팀 수 확인
		int drawCnt = 0;
		int drawTeam = 0;
		for (int i = 0; i < 6; i++) {
			if (draw[i] != 0) {
				drawCnt += draw[i];
				drawTeam++;
			}
		}
		if (drawCnt % 2 == 1)
			return false;
		if (drawCnt != 0 && drawTeam <= 1)
			return false;

		// 승, 패 수 같아야됨
		int winCnt = 0;
		int loseCnt = 0;
		for (int i = 0; i < 6; i++) {
			winCnt += win[i];
			loseCnt += lose[i];
		}
		if (winCnt != loseCnt)
			return false;

		// 5승, 4승 2팀 || 5패, 4패 2팀 공존 불가능
		int win5 = 0;
		int win4 = 0;
		int lose5 = 0;
		int lose4 = 0;
		for (int i = 0; i < 6; i++) {
			if (win[i] == 5) {
				win5++;
			} else if (win[i] == 4) {
				win4++;
			} else if (lose[i] == 5) {
				lose5++;
			} else if (lose[i] == 4) {
				lose4++;
			}
		}
		if (win5 >= 2)
			return false;
		if (win5 == 1 && win4 >= 2)
			return false;
		if (lose5 >= 2)
			return false;
		if (lose5 == 1 && lose4 >= 2)
			return false;

		return true;
	}
	
	static void check(int now, int enemy) {

		if (now == 5) {
			isCan = true;
			return;
		} else if (enemy == 6) {
			check(now + 1, now + 2);
			return;
		}

		if (win[now] >= 1 && lose[enemy] >= 1) {
			win[now]--;
			lose[enemy]--;
			check(now, enemy + 1);
			win[now]++;
			lose[enemy]++;
		}
		if (draw[now] >= 1 && draw[enemy] >= 1) {
			draw[now]--;
			draw[enemy]--;
			check(now, enemy + 1);
			draw[now]++;
			draw[enemy]++;
		}
		if (lose[now] >= 1 && win[enemy] >= 1) {
			lose[now]--;
			win[enemy]--;
			check(now, enemy + 1);
			lose[now]++;
			win[enemy]++;
		}
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 4; i++) {
			isCan = false;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				win[j] = Integer.parseInt(st.nextToken());
				draw[j] = Integer.parseInt(st.nextToken());
				lose[j] = Integer.parseInt(st.nextToken());
			}
			
			if (fcheck())
				check(0, 1);

			if (isCan)
				sb.append(1).append(" ");
			else
				sb.append(0).append(" ");

		}
		System.out.println(sb);
	}
}
