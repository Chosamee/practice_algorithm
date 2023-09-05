import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int cnt = Integer.parseInt(sc.next());
			sc.nextLine();
			List<Integer> apt = new ArrayList<>();
			for (int i =0; i<100; i++) {
				apt.add(sc.nextInt());
			}
			for (int i = 0; i < cnt; i++) {
				apt.sort(Comparator.reverseOrder());
				apt.set(0, apt.get(0)-1) ;
				apt.set(99, apt.get(99)+1);
				
			}
			apt.sort(Comparator.reverseOrder());
			System.out.printf("#%d %d\n", test_case, apt.get(0)-apt.get(99));
		}
	}
}