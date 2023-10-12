import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA5643 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int small, tall;
    static ArrayList<ArrayList<Integer>> smallM, tallM;
    static boolean[] visited;

    /** initialize */
    public static void initial() throws Exception {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        smallM = new ArrayList<>();
        tallM = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            smallM.add(new ArrayList<>());
            tallM.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            small = Integer.parseInt(st.nextToken()) - 1;
            tall = Integer.parseInt(st.nextToken()) - 1;
            tallM.get(small).add(tall);
            smallM.get(tall).add(small);
        }
    }

    /** Is this idx can know where? */
    public static boolean isCan(int idx) {
        return getCnt(idx, tallM) + getCnt(idx, smallM) == N - 1 ? true : false;
    }

    /** matrix type -> taller, smaller, get people number */
    public static int getCnt(int idx, ArrayList<ArrayList<Integer>> matrix) {
        int cnt = 0;
        // for bfs
        ArrayDeque<Integer> que = new ArrayDeque<>();
        visited = new boolean[N];
        que.add(idx);
        int now;
        while (!que.isEmpty()) {
            now = que.poll();
            for (int next : matrix.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    cnt++;
                    que.add(next);
                }
            }
        }
        return cnt;
    }

    /** main process */
    public static int process() {
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (isCan(i))
                ans++;
        }
        return ans;
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
