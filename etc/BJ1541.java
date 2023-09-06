import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1541 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static String[] nums;
    static String[] cals;

    /** initial */
    public static void initial() throws Exception {
        String s = br.readLine();
        nums = s.split("\\+|-");
        cals = s.split("([0-9])+");

    }

    /** 첫 - 이후로 나오는 숫자는 모조리 빼는 함수 */
    public static int check() {
        int flag = 1;
        int sum = 0;
        for (int i = 0; i < cals.length; i++) {
            if (flag == 1 && cals[i].equals("-")) {
                flag = -1;
            }
            sum += flag * Integer.parseInt(nums[i]);
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        initial();
        System.out.println(nums.length == 1 ? nums[0] : check());
    }
}
