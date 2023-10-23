import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ2606 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int v; // 컴 수
    static int e; // 엣지 수
    static ArrayList<ArrayList<Integer>> link;
    static boolean[] visited;

    public static void initial() throws Exception {
        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());
        link = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            link.add(new ArrayList<>());
        }
        int s, d;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            link.get(s).add(d);
            link.get(d).add(s);
        }
        visited = new boolean[v + 1];
    }

    public static void bfs() {
        ArrayDeque<Integer> que = new ArrayDeque<>();

        for (int i : link.get(1)) {
            que.add(i);
            visited[i] = true;
        }
        int next;
        while (!que.isEmpty()) {
            next = que.poll();
            for (int i : link.get(next)) {
                if (!visited[i]) {
                    que.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int res = 0;
        initial();
        bfs();
        visited[1] = false;
        for (boolean b : visited) {
            if (b)
                res++;
        }
        System.out.println(res);
    }
}
