class Solution {
    static int div = 10007;

    public int solution(int n, int[] tops) {
        int[][] DP = new int[n + 1][2];
        DP[0][0] = 0;
        DP[0][1] = 1;
        for (int i = 0; i < n; i++) {
            DP[i + 1][0] = (DP[i][0] + DP[i][1]) % div;
            if (tops[i] == 0) {
                DP[i + 1][1] = (DP[i][0] + 2 * DP[i][1]) % div;
            } else {
                DP[i + 1][1] = (2 * DP[i][0] + 3 * DP[i][1]) % div;
            }
        }
        return (DP[n][0] + DP[n][1]) % div;
    }
}