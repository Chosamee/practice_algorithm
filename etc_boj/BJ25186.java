import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ25186 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int[] clothes = new int[N];
        long total = 0;
        st = new StringTokenizer(br.readLine());
        int n;
        for (int i = 0; i < N; i++) {
            n = Integer.parseInt(st.nextToken());
            clothes[i] = n;
            total += n;
        }
        if (total == 1) {
            System.out.println("Happy");
            return;
        }
        total /= 2;
        for (int c : clothes) {
            if (c > total) {
                System.out.println("Unhappy");
                return;
            }
        }
        System.out.println("Happy");
    }
}
