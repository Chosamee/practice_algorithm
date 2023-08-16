import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();
	static StringTokenizer st;
	static int set = 0;
	static void cal(String str, int num) {
		int n = 1 << (num-1);
		if (str.equals("add")) set = set|n;
		else if (str.equals("check")) sb.append((set & n) >>> (num-1)).append("\n");
		else if( str.equals("remove")) set = set&(~n);
		else if(str.equals("toggle")) set = set^n;
		else if (str.equals("all")) set = 0b11111111111111111111;
		else if(str.equals("empty")) set = 0;
	}
	
	public static void main(String args[]) throws Exception {

		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			try{
				int num = Integer.parseInt(st.nextToken());
				cal(str, num);
			}
			catch(Exception e) {
				cal(str, 0);
			}
		}

		System.out.println(sb);
	}
}