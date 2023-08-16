import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();

	public static void main(String args[]) throws Exception {
		int addcnt, addidx, addlen;
		LinkedList<String> origin = new LinkedList<>();
		LinkedList<String> plus = new LinkedList<>();
		for (int test_case = 1; test_case <= 10; test_case++) {
			origin.clear();
			plus.clear();
			int origin_len = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < origin_len; i++) {
				origin.add(st.nextToken());
			}
			addcnt = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<addcnt;i++) {
				st.nextToken();
				addidx = Integer.parseInt(st.nextToken());
				addlen = Integer.parseInt(st.nextToken());
				for (int j=0;j<addlen;j++) {
					plus.add(st.nextToken());
				}
				origin.addAll(addidx, plus);
				plus.clear();
				
			}
			sb.append("#").append(test_case).append(" ");
			for(int i=0;i<10;i++) {
				sb.append(origin.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}