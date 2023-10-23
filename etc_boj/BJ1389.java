import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1389 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();

    static int N, min = Integer.MAX_VALUE, minWho;

    public static void init() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            nodes.add(new ArrayList<>());
        }

        int p1, p2;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            p1 = Integer.parseInt(st.nextToken()) - 1;
            p2 = Integer.parseInt(st.nextToken()) - 1;
            nodes.get(p1).add(p2);
            nodes.get(p2).add(p1);
        }
    }

    public static int bfs(int who) {
        int ret = 0;
        // 사람, 거리
        ArrayDeque<int[]> que = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        que.add(new int[] { who, 0 });
        visited[who] = true;
        int[] temp;
        int now, dist;
        while (!que.isEmpty()) {
            temp = que.poll();
            now = temp[0];
            dist = temp[1];
            ret += dist;
            for (int next : nodes.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    que.add(new int[] { next, dist + 1 });
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) throws Exception {
        int ret;
        init();
        for (int i = 0; i < N; i++) {
            if ((ret = bfs(i)) < min) {
                minWho = i;
                min = ret;
            }
        }
        System.out.println(minWho + 1);
    }
}
