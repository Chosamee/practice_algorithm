import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int to;
    int weight;

    public Node(int to, int weight) {
        super();
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class BJ1197 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int V, E;
    static PriorityQueue<Node> que;
    static ArrayList<ArrayList<Node>> nodes;
    static boolean[] visited;
    static long ret;

    public static void initial() throws Exception {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        ret = 0;
        que = new PriorityQueue<>();
        nodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            nodes.add(new ArrayList<>());
        }
        visited = new boolean[V];
        int from, to, w;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken()) - 1;
            to = Integer.parseInt(st.nextToken()) - 1;
            w = Integer.parseInt(st.nextToken());
            nodes.get(from).add(new Node(to, w));
            nodes.get(to).add(new Node(from, w));
        }
    }

    public static void prim() {

        visited[0] = true;
        for (Node n : nodes.get(0)) {
            que.add(n);
        }

        Node n;
        int to, w;
        int cnt = 0;
        while (cnt != V - 1) {
            n = que.poll();
            to = n.to;
            w = n.weight;
            if (visited[to])
                continue;
            for (Node nn : nodes.get(to)) {
                if (!visited[nn.to])
                    que.add(nn);
            }
            visited[to] = true;
            ret += w;
            cnt++;
        }
    }

    public static void main(String[] args) throws Exception {

        initial();
        prim();
        System.out.println(ret);

    }
}
