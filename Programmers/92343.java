import java.util.*;

class Solution {
    static int max = 0;
    static ArrayList<ArrayList<Integer>> relation = new ArrayList<ArrayList<Integer>>();
    static int[] infos;

    public int solution(int[] info, int[][] edges) {
        for (int i = 0; i < info.length; i++) {
            relation.add(new ArrayList<Integer>());
        }
        int answer = 0;
        infos = info;
        for (int[] rel : edges) {
            relation.get(rel[0]).add(rel[1]);
        }
        dfs(0, 0, 0);
        return max;
    }

    public Boolean dfs(int n, int sheep, int wolf) {
        int nS = infos[n] == 0 ? sheep + 1 : sheep;
        int nW = infos[n] == 1 ? wolf + 1 : wolf;
        max = Math.max(max, nS);
        if (nS <= nW) {
            return false;
        }
        for (int child : relation.get(n)) {
            if (dfs(child, nS, nW)) {
                for (int cc : relation.get(child)) {
                    dfs(child, infos[n] == 0 ? nS + 1 : nS, infos[n] == 1 ? nW + 1 : nW);
                }
            }
        }
        return true;
    }

}