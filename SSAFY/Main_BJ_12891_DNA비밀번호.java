import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] required = new int[4];
	static int[] cnt = new int[4];
	static int possible = 0;

	static void isCanPassword() {
		for (int i = 0; i < 4; i++) {
			if (cnt[i] < required[i])
				return;
		}
		possible += 1;
	}

	static void checkAlpha(char alpha, int dir) {
		switch (alpha) {
		case 'A':
			cnt[0] += dir;
			break;
		case 'C':
			cnt[1] += dir;
			break;
		case 'G':
			cnt[2] += dir;
			break;
		case 'T':
			cnt[3] += dir;
			break;
		default:
			break;
		}
	}

	public static void main(String args[]) throws Exception {

		st = new StringTokenizer(br.readLine());
		int totLen = Integer.parseInt(st.nextToken());
		int len = Integer.parseInt(st.nextToken());
		String totPass = br.readLine();
		// A C G T
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 4; i++) {
			required[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < len; i++) {
			char alpha = totPass.charAt(i);
			checkAlpha(alpha, 1);
		}

		isCanPassword();
		int startIndex = 0;
		int endIndex = len - 1;
		for (int i = 0; i < totLen - len; i++) {
			checkAlpha(totPass.charAt(startIndex++), -1);
			checkAlpha(totPass.charAt(++endIndex), 1);
			isCanPassword();
		}
		System.out.println(possible);
	}
}