import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

class SWEA5658 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static String str;
    static int N, K;
    static int patLen;
    static TreeSet<String> set;

    /** initialize */
    public static void initial() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        str = br.readLine();
        patLen = N / 4;
        str = str + str;
        set = new TreeSet<>(Collections.reverseOrder());
    }

    public static void process() {
        String substr;
        for (int i = 0; i < N; i++) {
            substr = str.substring(i, i + patLen);
            if (!set.contains(substr))
                set.add(substr);
        }
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        Iterator<String> iter;
        String ans;
        for (int i = 1; i <= T; i++) {
            initial();
            process();
            iter = set.iterator();
            for (int j = 1; j < K; j++) {
                iter.next();
            }
            ans = iter.next().toString();
            sb.append('#').append(i).append(' ').append(Integer.parseInt(ans, 16)).append('\n');

        }
        System.out.println(sb);
    }
}