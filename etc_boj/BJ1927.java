import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1927 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int input;
        int out;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            input = Integer.parseInt(br.readLine());
            if (input == 0) {
                try {
                    out = que.poll();
                    sb.append(out).append('\n');
                } catch (Exception e) {
                    sb.append(0).append('\n');
                }
            } else
                que.add(input);
        }
        System.out.println(sb);
    }
}
