import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA14510 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, maxTree;
    static int[] trees;

    static void init() throws Exception {
        int tree;
        maxTree = 0;
        N = Integer.parseInt(br.readLine());
        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree = Integer.parseInt(st.nextToken());
            trees[i] = tree;
            maxTree = Math.max(maxTree, tree);
        }
    }

    static int process() {
        int need, days = 0;
        int r1 = 0, r2 = 0;
        for (int i = 0; i < N; i++) {
            need = maxTree - trees[i];
            r1 += need % 2;
            r2 += need / 2;
        }
        int cha = Math.max(r2 - r1, 0);
        int convert = cha / 3 + Math.max(0, cha % 3 - 1);
        r1 += convert * 2;
        r2 -= convert;
        if (r1 > r2)
            days += r1 * 2 - 1;
        else if (r1 <= r2)
            days += r2 * 2;
        return days;
    }

    public static void main(String[] args) throws Exception {
        int T;
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            init();
            sb.append('#').append(t).append(' ').append(process()).append('\n');
        }
        System.out.println(sb);
    }
}
