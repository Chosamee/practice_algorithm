import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
 
    static ArrayList<Boolean> que1 = new ArrayList<>();
    static ArrayList<Boolean> que2 = new ArrayList<>();
    static ArrayList<Boolean> que3 = new ArrayList<>();
    static ArrayList<Boolean> que4 = new ArrayList<>();
    static int K;
 
    /** Initializing */
    public static void initial() throws Exception {
        K = Integer.parseInt(br.readLine());
        que1.clear();
        que2.clear();
        que3.clear();
        que4.clear();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 8; i++) {
            que1.add(Integer.parseInt(st.nextToken()) == 1);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 8; i++) {
            que2.add(Integer.parseInt(st.nextToken()) == 1);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 8; i++) {
            que3.add(Integer.parseInt(st.nextToken()) == 1);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 8; i++) {
            que4.add(Integer.parseInt(st.nextToken()) == 1);
        }
    }
 
    /** check god */
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
        int T = Integer.parseInt(br.readLine());
        int n, dir;
        int score;
        boolean[] isMove;
        for (int t = 1; t <= T; t++) {
            initial();
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());
                dir = Integer.parseInt(st.nextToken());
                isMove = isGrav();
                allCases(n, dir, isMove);
            }
            score = (que1.get(0) ? 1
                    : 0) + ((que2.get(0) ? 1 : 0) << 1) + ((que3.get(0) ? 1 : 0) << 2) + ((que4.get(0) ? 1 : 0) << 3);
            sb.append("#").append(t).append(" ").append(score).append("\n");
        }
        System.out.println(sb);
    }
}