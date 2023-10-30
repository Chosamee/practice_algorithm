import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S, P;
        S = br.readLine();
        P = br.readLine();
        System.out.println(S.contains(P) ? 1 : 0);
    }
}