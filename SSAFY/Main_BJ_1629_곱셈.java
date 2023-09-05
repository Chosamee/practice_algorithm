package test3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static long A;
	static long C;

	static long cal(long a, long b) {
		long val = a % C;
		
		if (b == 1)
			return val;
		
		long res = cal(val * val % C, b / 2);
		if (b % 2 == 0) {
			return res % C;
		} else
			return res * val % C;
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		System.out.println(cal(A % C, B));
	}
}
