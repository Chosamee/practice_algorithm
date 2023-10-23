import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BJ9205 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[][] nodes;
    static boolean[] visited;

    static int[] start;
    static int[] dest;

    /** initialize */
    public static void initial() throws Exception {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        start = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

        visited = new boolean[n];
        nodes = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
        }

        st = new StringTokenizer(br.readLine());
        dest = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
    }

    public static boolean process() {
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.add(start);
        int[] now;
        int[] next;
        while (!que.isEmpty()) {
            now = que.poll();
            if (getDist(now, dest) <= 1000) {
                return true;
            }
            for (int i = 0; i < nodes.length; i++) {
                next = nodes[i];
                if (getDist(now, next) <= 1000 && !visited[i]) {
                    visited[i] = true;
                    que.add(next);
                }
            }
        }
        return false;
    }

    public static int getDist(int[] n1, int[] n2) {
        return Math.abs(n1[0] - n2[0]) + Math.abs(n1[1] - n2[1]);
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            initial();
            sb.append(process() ? "happy" : "sad").append('\n');
        }
        System.out.println(sb);
    }
}
