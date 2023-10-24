import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ14891 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static ArrayList<Boolean> que1;
    static ArrayList<Boolean> que2;
    static ArrayList<Boolean> que3;
    static ArrayList<Boolean> que4;

    /** Initializing */
    public static void init() throws Exception {
        que1 = new ArrayList<>();
        que2 = new ArrayList<>();
        que3 = new ArrayList<>();
        que4 = new ArrayList<>();
        String temp;
        temp = br.readLine();
        for (int i = 0; i < 8; i++) {
            que1.add(temp.charAt(i) == '1');
        }
        temp = br.readLine();
        for (int i = 0; i < 8; i++) {
            que2.add(temp.charAt(i) == '1');
        }
        temp = br.readLine();
        for (int i = 0; i < 8; i++) {
            que3.add(temp.charAt(i) == '1');
        }
        temp = br.readLine();
        for (int i = 0; i < 8; i++) {
            que4.add(temp.charAt(i) == '1');
        }
    }

    public static ArrayList<Boolean> rotate(ArrayList<Boolean> que, int dir) {
        boolean temp;
        if (dir == 1) {
            temp = que.get(7);
            que.remove(7);
            que.add(0, temp);
        } else {
            temp = que.get(0);
            que.remove(0);
            que.add(temp);
        }
        return que;
    }

    public static boolean[] isGrav() {
        boolean[] b = new boolean[3];
        if (que1.get(2) ^ que2.get(6))
            b[0] = true;
        if (que2.get(2) ^ que3.get(6))
            b[1] = true;
        if (que3.get(2) ^ que4.get(6))
            b[2] = true;
        return b;
    }

    public static void allCases(int n, int dir, boolean[] isMove) {
        if (n == 1) {
            que1 = rotate(que1, dir);
            if (isMove[0])
                que2 = rotate(que2, -dir);
            if (isMove[0] & isMove[1])
                que3 = rotate(que3, dir);
            if (isMove[0] & isMove[1] & isMove[2])
                que4 = rotate(que4, -dir);
        } else if (n == 2) {
            que2 = rotate(que2, dir);
            if (isMove[0])
                que1 = rotate(que1, -dir);
            if (isMove[1])
                que3 = rotate(que3, -dir);
            if (isMove[1] & isMove[2])
                que4 = rotate(que4, dir);
        } else if (n == 3) {
            que3 = rotate(que3, dir);
            if (isMove[0] & isMove[1])
                que1 = rotate(que1, dir);
            if (isMove[1])
                que2 = rotate(que2, -dir);
            if (isMove[2])
                que4 = rotate(que4, -dir);
        } else if (n == 4) {
            que4 = rotate(que4, dir);
            if (isMove[0] & isMove[1] & isMove[2])
                que1 = rotate(que1, -dir);
            if (isMove[1] & isMove[2])
                que2 = rotate(que2, dir);
            if (isMove[2])
                que3 = rotate(que3, -dir);

        }
    }

    public static void main(String[] args) throws Exception {
        int n, dir;
        int score;
        boolean[] isMove;
        init();

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            dir = Integer.parseInt(st.nextToken());
            isMove = isGrav();
            allCases(n, dir, isMove);
        }
        score = (que1.get(0) ? 1
                : 0) + ((que2.get(0) ? 1 : 0) << 1) + ((que3.get(0) ? 1 : 0) << 2) + ((que4.get(0) ? 1 : 0) << 3);
        System.out.println(score);
    }
}