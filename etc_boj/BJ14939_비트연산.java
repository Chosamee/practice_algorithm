import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ14939_비트연산 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int R, C, max;
    static int[] map;

    /** 초기화 */
    static void init() throws Exception {
        R = 10;
        C = 10;
        max = R * C + 1;
        map = new int[R + 1];
        String s;
        int temp;
        for (int i = 0; i < R; i++) {
            temp = 0;
            s = br.readLine();
            for (int j = 0; j < C; j++) {
                if (s.charAt(j) == 'O') {
                    temp |= 1 << (C - j - 1);
                }
            }
            map[i] = temp;
        }
    }

    static int mainProcess(int first) {
        int pre, now = 0, next, cnt = 0;
        now = first;
        next = map[0];
        for (int i = 1; i <= R; i++) {
            pre = now;
            now = next;
            next = map[i];
            for (int j = C - 1; j >= 0; j--) {
                if (((1 << j) & pre) != 0) {
                    now ^= j == 0 ? 3 : 7 << (j - 1);
                    next ^= 1 << j;
                    cnt++;
                }
            }
        }
        return (now & ((1 << C) - 1)) == 0 ? cnt : max;
    }

    public static void main(String[] args) throws Exception {
        init();
        int ans, min = max;

        for (int first = 0; first < 1 << C; first++) {
            ans = mainProcess(first);
            if (ans != -1)
                min = Math.min(ans, min);
        }

        System.out.println(min == max ? -1 : min);
    }
}
