import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Solution {
	static int nx = 0;
	static int ny = 0;
	static List<Integer>[] lad;

	static void checkLR() {
		if (nx > 0 && lad[ny].get(nx - 1) == 1) {
			checkU(-1);
		} else if (nx <99 && lad[ny].get(nx + 1) == 1) {
			checkU(1);
		}
	}

	static void checkU(int dir) {
		while (true) {
			nx += dir;
			if (lad[ny - 1].get(nx) == 1) {
				break;
			}
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			sc.nextInt();
			lad = new ArrayList[100];
			for (int i = 0; i < 100; i++) {

				List<Integer> l = new ArrayList<>();
				for (int j = 0; j < 100; j++) {
					l.add(sc.nextInt());
				}
				lad[i] = l;
			}
			nx = lad[99].indexOf(2);
			ny = 99;
			while (ny > 0) {
				ny -= 1;
				checkLR();
			}
			System.out.printf("#%d %d\n", test_case, nx);
		}
	}
}