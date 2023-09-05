import java.util.Scanner;

class Main {
	static int N = 0;
	static int M = 0;
	static StringBuilder sb = new StringBuilder();
	static int[] ret;
	static void combination(int n, int now) {
		if (now == M) {
			for (int i : ret) {
				sb.append(i).append(' ');
			}
			sb.append("\n");
			return;
		}
		for (int i=n; i<=N; i++) {
			ret[now] = i;
			combination(i+1, now+1);
		}
	}
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		ret = new int[M];
		combination(1, 0);
		System.out.println(sb);
		
	}
}