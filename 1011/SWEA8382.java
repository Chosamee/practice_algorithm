import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA8382 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int process() throws Exception {
        int x1, y1, x2, y2;
        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());
        int dx, dy;
        dx = Math.abs(x1 - x2);
        dy = Math.abs(y1 - y2);
        int minus = Math.abs(dx - dy);
        if (dx > dy) {
            return dy * 2 + minus / 2 * 4 + minus % 2;
        } else if (dx < dy) {
            return dx * 2 + minus / 2 * 4 + minus % 2;
        } else
            return dx * 2;
    }

    public static void main(String[] args) throws Exception {
        int T;
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ').append(process()).append('\n');
        }
        System.out.println(sb);
    }
}
