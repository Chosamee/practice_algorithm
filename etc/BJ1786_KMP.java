import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1786_KMP {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] pi;
    static String T, P;
    static int TLen, PLen;
    static int cnt;

    /** initialize */
    public static void initial() throws Exception {
        T = br.readLine();
        P = br.readLine();
        TLen = T.length();
        PLen = P.length();
        pi = new int[PLen + 1];
        cnt = 0;
    }

    static void getPi() {
        int i = -1, j = 0;
        pi[j] = i;
        while (j < PLen) {
            if (i == -1 || P.charAt(i) == P.charAt(j))
                pi[++j] = ++i;
            else
                i = pi[i];
        }
    }

    static void kmp() {
        int i = 0, j = 0;
        while (i < TLen) {
            if (j == -1 || T.charAt(i) == P.charAt(j)) {
                i++;
                j++;
            } else
                j = pi[j];
            if (j == PLen) {
                cnt++;
                sb.append(i - PLen + 1).append(' ');
                j = pi[j];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        initial();
        getPi();
        kmp();
        System.out.println(cnt);
        System.out.println(sb);
    }
}
