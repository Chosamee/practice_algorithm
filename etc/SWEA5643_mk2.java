import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA5643_mk2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int small, tall;
    static ArrayList<ArrayList<Integer>> matrix;
    static int[] compareCnt;
    static boolean[] visited;

    /** initialize */
    public static void initial() throws Exception {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        matrix = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            matrix.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            small = Integer.parseInt(st.nextToken()) - 1;
            tall = Integer.parseInt(st.nextToken()) - 1;
            matrix.get(small).add(tall);
        }
        compareCnt = new int[N];
    }

    /** matrix type -> taller, smaller, get people number */
    public static void getCnt(int idx) {
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
                    compareCnt[next]++;
                    cnt++;
                    que.add(next);
                }
            }
        }
        compareCnt[idx] += cnt;
    }

    /** main process */
    public static int process() {
        for (int i = 0; i < N; i++) {
            getCnt(i);
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (compareCnt[i] == N - 1)
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
        System.out.println(Arrays.toString(compareCnt));
        System.out.println(sb);
    }
}
