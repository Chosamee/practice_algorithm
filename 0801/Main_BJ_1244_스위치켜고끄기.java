import java.util.Scanner;

public class Main {
	static String[] sch;

	static void change(int i) {
		switch (sch[i]) {
		case "0":
			sch[i] = "1";
			break;
		case "1":
			sch[i] = "0";
			break;
		default:
			break;
		}
	}

	static void man(int num) {
		for (int i = num - 1; i < sch.length; i += num) {
			change(i);
		}
	}

	static void woman(int num) {
		try {
			change(num);
			int left = num;
			int right = num;
			while (true) {
				left--;
				right++;
				int l = Integer.parseInt(sch[left]);
				int r = Integer.parseInt(sch[right]);
				if (l == r) {
					change(left);
					change(right);
				} else {
					return;
				}
			}
		} catch (Exception e) {
			return;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sex;
		int len = sc.nextInt();
		sc.nextLine();
		sch = sc.nextLine().split(" ");
		int num = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < num; i++) {
			String[] s = sc.nextLine().split(" ");
			sex = s[0];
			if (sex.equals("1"))
				man(Integer.parseInt(s[1]));
			else
				woman(Integer.parseInt(s[1]) - 1);
		}
		int cnt = 0;
		for (String ss : sch) {
			System.out.print(ss + " ");
			cnt++;
			if (cnt == 20) {
				System.out.println();
				cnt = 0;
			}

		}
	}
}
