import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ4889 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Stack<Character> stack = new Stack<>();
    static char first;

    public static String read() throws Exception {
        String s = br.readLine();
        return s.charAt(0) == '-' ? null : s;
    }

    public static void initial(String s) {
        if (s.charAt(0) == '-')
            System.exit(0);

        stack.empty();
        char[] cs = s.toCharArray();
        stack.add(cs[0]);
        first = cs[0];

        char c;
        for (int i = 1; i < cs.length; i++) {
            c = s.charAt(i);
            if (c == '}' && stack.peek() == '{') {
                stack.pop();
            } else
                stack.add(c);
        }
    }

    public static void main(String[] args) throws Exception {

        String s;
        int num = 1;
        while ((s = read()) != null) {
            initial(s);
            System.out.println(stack.toString());
            sb.append(num++).append('.').append(stack.size() + first == '}' ? 1 : 0).append('\n');
        }
        System.out.println(sb);
    }
}
