import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();

	public static boolean isPrime(int num) {
		if (num < 2)
			return false;
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String args[]) throws Exception {

		int n = Integer.parseInt(br.readLine());
		Integer[] odd = { 1, 3, 5, 7, 9 };
		List<Integer> primeList = new ArrayList<>(Arrays.asList(2, 3, 5, 7));
		List<Integer> newPrimeList = new ArrayList<>();
		int newPrime = 0;
		for (int i = 1; i < n; i++) {
			for (int s : primeList) {
				for (int o : odd) {
					newPrime = s*10 + o;
					if (isPrime(newPrime))
						newPrimeList.add(newPrime);
				}
			}
			primeList.clear();
			primeList.addAll(newPrimeList);
			newPrimeList.clear();
		}
		for (int s : primeList) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}
}