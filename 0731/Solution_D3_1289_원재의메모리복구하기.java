import java.util.Scanner;
import java.util.Arrays;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			
			String mem = sc.next();
			int len = mem.length();
			char[] chars = mem.toCharArray();
			int cnt = 0;
			char flag = '0';
			for (int i=0; i<len; i++) {
				char val = chars[i];
				if (val != flag) {
					flag = val;
					cnt ++;
				}
			}
			System.out.printf("#%d %d\n", test_case, cnt);
		
		}
	}
}