import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Xy implements Comparable<Xy> {
    int n;
    int x, y;
    int w;

    public Xy(int n, int x, int y) {
        this.n = n;
        this.x = x;
        this.y = y;
        // x==0일때??
        // this.w = Math.abs((y - x) * y / x);
    }

    @Override
    public int compareTo(Xy o) {
        return this.x - o.x;
    }

    @Override
    public String toString() {
        return String.format("%d %d %d", n, x, y);
    }
}

public class BJ1858 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static Xy[] nodes;

    static void init() throws Exception {
        int N = Integer.parseInt(br.readLine());
        nodes = new Xy[N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            nodes[i] = new Xy(i + 1, a, b);
        }
    }

    public static int solution(Xy[] nodes) {
        // System.out.println(Arrays.toString(nodes));

        int max = -1;
        int maxIdx = 0;
        for (int i = 0; i < nodes.length - 1; i++) {
            int incline = Math.abs((nodes[i + 1].y - nodes[i].y) / (nodes[i + 1].x - nodes[i].x));
            if (incline == max && (nodes[i].n < nodes[maxIdx].n || nodes[i + 1].n < nodes[maxIdx].n)) {
                maxIdx = i;
            } else if (incline > max) {
                max = incline;
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    public static void main(String[] args) throws Exception {
        init();
        Arrays.sort(nodes);
        int idx = solution(nodes);
        if (nodes[idx].n < nodes[idx + 1].n)
            System.out.printf("%d %d", nodes[idx].n, nodes[idx + 1].n);
        else
            System.out.printf("%d %d", nodes[idx + 1].n, nodes[idx].n);
    }

}
