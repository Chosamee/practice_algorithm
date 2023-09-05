import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();
	static StringTokenizer st;
	static Stack<Character> stack = new Stack<>();
	static int cnt;
	static String str;

	static int check() {
		char c;
		for (int i = 0; i < cnt; i++) {
			switch (c = str.charAt(i)) {
			case ')':
				if (stack.pop() != '(')
					return 0;
				break;
			case '}':
				if (stack.pop() != '{')
					return 0;
				break;
			case '>':
				if (stack.pop() != '<')
					return 0;
				break;
			case ']':
				if (stack.pop() != '[')
					return 0;
				break;
			default:
				stack.push(c);
			}
		}
		if (!stack.isEmpty())
			return 0;
		return 1;
	}

	public static void main(String args[]) throws Exception {
		int T;
		T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			stack.clear();
			cnt = Integer.parseInt(br.readLine());
			str = br.readLine();
			System.out.printf("#%d %d\n", test_case, check());
		}
	}
}
