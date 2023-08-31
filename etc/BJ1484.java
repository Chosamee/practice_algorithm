import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1484 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int G = Integer.parseInt(br.readLine());
        for (int i = (int) Math.sqrt(G); i >= 1; i--) {
            if (G % i == 0 && (i + G / i) % 2 == 0 && (i - G / i) != 0) {
                sb.append((i + G / i) / 2).append('\n');
            }
        }
        System.out.println(sb.length() != 0 ? sb : -1);
    }
}
