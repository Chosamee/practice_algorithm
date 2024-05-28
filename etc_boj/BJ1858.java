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

    public static int[] solution(Xy[] nodes) {
        // System.out.println(Arrays.toString(nodes));

        int max = -1;
        int A = 0;
        int B = 0;
        for (int i = 0; i < nodes.length - 1; i++) {
            int incline = Math.abs((nodes[i + 1].y - nodes[i].y) / (nodes[i + 1].x - nodes[i].x));
            if (incline == max) {
                if ((nodes[i].n < nodes[A].n || nodes[i + 1].n < nodes[A].n))
                    if (nodes[i].n < nodes[i + 1].n)
                        A = i;
                    else
                        A = i + 1;
                if ((nodes[i].n < nodes[B].n || nodes[i + 1].n < nodes[B].n))
                    if (nodes[i].n < nodes[i + 1].n && A != i)
                        B = i;
                    else if (A != i + 1)
                        B = i + 1;
            } else if (incline > max) {
                max = incline;
                if (nodes[i].n < nodes[i + 1].n) {
                    A = i;
                    B = i + 1;
                } else {
                    A = i + 1;
                    B = i;
                }
            }
        }
        return new int[] { A, B };
    }

    public static void main(String[] args) throws Exception {
        init();
        Arrays.sort(nodes);
        int[] idx = solution(nodes);
        // System.out.println(Arrays.toString(idx));
        if (nodes[idx[0]].n < nodes[idx[1]].n)
            System.out.printf("%d %d", nodes[idx[0]].n, nodes[idx[1]].n);
        else
            System.out.printf("%d %d", nodes[idx[1]].n, nodes[idx[0]].n);
    }

}
