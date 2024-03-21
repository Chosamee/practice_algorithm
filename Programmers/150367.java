import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (long number : numbers) {
            if (number == 0)
                ans.add(0);
            else
                ans.add(getSol(number));
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    public int getSol(long n) {
        long power = findPowerBin(n);
        long popower = findPowerBin(power);
        long totLen = binPow(popower) - 1;
        StringBuilder sb = new StringBuilder();
        for (long i = power; i < totLen; i++) {
            sb.append("0");
        }
        String str = Long.toBinaryString(n);
        sb.append(str);

        String input = sb.toString();

        if (dc(input))
            return 1;
        else
            return 0;

    }

    public boolean dc(String str) {
        int size = str.length();

        if (size == 1)
            return true;

        if (str.charAt(size / 2) == '0') {
            if (str.charAt((size / 2) / 2) == '1')
                return false;
            if (str.charAt((size / 2 + size) / 2) == '1')
                return false;
        }
        if (!dc(str.substring(0, size / 2)))
            return false;
        if (!dc(str.substring(size / 2 + 1, size)))
            return false;
        return true;
    }

    public long binPow(long n) {
        long ret = 1;
        for (long i = 0; i < n; i++) {
            ret *= 2;
        }
        return ret;
    }

    public long findPowerBin(long n) {
        long comp = 1;
        long cnt = 0;
        while (comp < n + 1) {
            comp *= 2;
            cnt++;
        }
        return cnt;
    }
}