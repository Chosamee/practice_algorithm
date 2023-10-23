import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA7465 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;

    static void initial() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        int p1, p2;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            p1 = Integer.parseInt(st.nextToken()) - 1;
            p2 = Integer.parseInt(st.nextToken()) - 1;
            list.get(p1).add(p2);
            list.get(p2).add(p1);
        }

        visited = new boolean[N];
    }

    static void bfs(int n) {
        ArrayDeque<Integer> que = new ArrayDeque<>();
        que.add(n);
        visited[n] = true;
        int now;
        while (!que.isEmpty()) {
            now = que.poll();
            for (int next : list.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    que.add(next);
                }
            }
        }
    }

    static int process() {
        int ret = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                bfs(i);
                ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            initial();
            sb.append('#').append(i).append(' ').append(process()).append('\n');
        }
        System.out.println(sb);
    }
}
