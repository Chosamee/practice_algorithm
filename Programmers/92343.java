import java.util.*;

class Solution {
    static int maxSheep = 0;
    static List<List<Integer>> relation;
    static int[] info;

    public int solution(int[] info, int[][] edges) {
        Solution.info = info;
        relation = new ArrayList<>();

        for (int i = 0; i < info.length; i++) {
            relation.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            relation.get(edge[0]).add(edge[1]);
        }
        boolean[] visited = new boolean[info.length];
        dfs(0, 0, 0, visited.clone(), new HashSet<>());

        return maxSheep;
    }

    public void dfs(int now, int sheep, int wolf, boolean[] visited, Set<Integer> available) {
        if (info[now] == 0)
            sheep++;
        else
            wolf++;

        if (wolf >= sheep)
            return;
        if (sheep > maxSheep)
            maxSheep = sheep;

        visited[now] = true;
        available.remove(now);
        available.addAll(relation.get(now));

        for (int next : available) {
            if (!visited[next]) {
                dfs(next, sheep, wolf, visited.clone(), new HashSet<>(available));
            }
        }
    }
}
