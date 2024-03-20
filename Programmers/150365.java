// https://school.programmers.co.kr/learn/courses/30/lessons/150365

class Solution {
    static StringBuilder sb = new StringBuilder();

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        if (!checkPossible(x, y, r, c, k))
            return "impossible";
        getAnswer(n, m, x, y, r, c, k);
        answer = sb.toString();
        return answer;
    }

    public Boolean checkPossible(int x, int y, int r, int c, int k) {
        int distance = Math.abs(x - r) + Math.abs(c - y);
        if (distance > k)
            return false;
        if ((distance - k) % 2 != 0)
            return false;
        return true;
    }

    public void getAnswer(int n, int m, int x, int y, int r, int c, int k) {
        int nx = x;
        int ny = y;
        int nk = k;
        int distance = Math.abs(nx - r) + Math.abs(ny - c);
        while ((nk > distance && nx < n) | (nx < r)) {
            nk--;
            nx++;
            distance = Math.abs(nx - r) + Math.abs(ny - c);
            sb.append("d");
        }
        while ((nk > distance && ny > 1) | (ny > c)) {
            nk--;
            ny--;
            distance = Math.abs(nx - r) + Math.abs(ny - c);
            sb.append("l");
        }
        while (nk > distance) {
            nk -= 2;
            sb.append("rl");
        }
        for (int i = 0; i < Math.abs(ny - c); i++) {
            sb.append("r");
        }
        for (int i = 0; i < Math.abs(nx - r); i++) {
            sb.append("u");
        }
    }
}