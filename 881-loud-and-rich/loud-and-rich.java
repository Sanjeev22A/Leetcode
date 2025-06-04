class Solution {
    int[] dp;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        dp = new int[n];
        Arrays.fill(dp, -1);

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] r : richer) graph.get(r[1]).add(r[0]);

        for (int i = 0; i < n; i++) {
            dfs(i, graph, quiet);
        }
        return dp;
    }

    int dfs(int node, List<List<Integer>> graph, int[] quiet) {
        if (dp[node] != -1) return dp[node];

        int minPerson = node;
        for (int richerPerson : graph.get(node)) {
            int candidate = dfs(richerPerson, graph, quiet);
            if (quiet[candidate] < quiet[minPerson]) {
                minPerson = candidate;
            }
        }
        return dp[node] = minPerson;
    }
}
