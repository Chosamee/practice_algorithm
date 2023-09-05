import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String args[]) throws Exception {
		int n = Integer.parseInt(br.readLine());
		int res = (int) (Math.log10(2*n - 1)/Math.log10(2));
		System.out.println(2*n - (1<<res));
	}
}