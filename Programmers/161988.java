import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int size = sequence.length;
        long[] seq1 = new long[size + 1];
        long[] seq2 = new long[size + 1];
        seq1[0] = 0;
        seq2[0] = 0;

        for (int i = 1; i < size + 1; i++) {
            seq1[i] = seq1[i - 1] + sequence[i - 1] * pow(-1, i);
            seq2[i] = seq2[i - 1] + sequence[i - 1] * pow(-1, i + 1);
        }

        long diffMax = Integer.MIN_VALUE;
        long min = seq1[0];
        long minIdx = 0;
        long max = seq1[0];
        long maxIdx = 0;
        for (int i = 1; i < size + 1; i++) {

            if (seq1[i] < min) {
                min = seq1[i];
                minIdx = i;
            }
            if (seq1[i] > max) {
                max = seq1[i];
                maxIdx = i;
            }
            if (minIdx > maxIdx)
                maxIdx = minIdx + 1;
            if (max - min > diffMax)
                diffMax = max - min;
        }

        min = seq2[0];
        minIdx = 0;
        max = seq2[0];
        maxIdx = 0;
        for (int i = 1; i < size; i++) {
            if (seq1[i] < min) {
                min = seq2[i];
                minIdx = i;
            }
            if (seq1[i] > max) {
                max = seq2[i];
                maxIdx = i;
            }
            if (minIdx > maxIdx)
                maxIdx = minIdx + 1;
            if (max - min > diffMax)
                diffMax = max - min;
        }
        answer = diffMax;
        return answer;
    }

    public int pow(int under, int power) {
        int ret = 1;
        return power % 2 == 0 ? 1 : -1;
    }

}