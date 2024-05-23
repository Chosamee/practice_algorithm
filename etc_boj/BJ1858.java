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
        this.w = Math.abs((y - x) * y / x);
    }

    @Override
    public int compareTo(Xy o) {
        if (this.w == o.w)
            return this.n - o.n;
        return this.w - o.w;
    }
}

public class BJ1858 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static Xy[] nodes;
    static int N;

    static void init() throws Exception {
        N = Integer.parseInt(br.readLine());
        nodes = new Xy[N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            nodes[i] = new Xy(i + 1, a, b);
        }
    }

    public static void main(String[] args) throws Exception {
        init();
        Arrays.sort(nodes);
        System.out.printf("%d %d", nodes[0].n, nodes[N - 1].n);
    }

}
