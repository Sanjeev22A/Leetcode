class Solution {
    int time = 0;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        int[] xor = new int[n];
        int[] in = new int[n];
        int[] out = new int[n];
        dfs(0, -1, graph, nums, xor, in, out);

        int totalXor = xor[0];
        int minScore = Integer.MAX_VALUE;

        for (int i = 0; i < edges.length; ++i) {
            int a = edges[i][0], b = edges[i][1];
            if (in[a] < in[b]) {
                // a is parent of b
            } else {
                int temp = a;
                a = b;
                b = temp;
            }
            for (int j = i + 1; j < edges.length; ++j) {
                int c = edges[j][0], d = edges[j][1];
                if (in[c] < in[d]) {
                    // c is parent of d
                } else {
                    int temp = c;
                    c = d;
                    d = temp;
                }

                if (isDescendant(d, b, in, out)) {
                    // d in b-subtree
                    int x1 = xor[d];
                    int x2 = xor[b] ^ xor[d];
                    int x3 = totalXor ^ xor[b];
                    minScore = Math.min(minScore, getDiff(x1, x2, x3));
                } else if (isDescendant(b, d, in, out)) {
                    // b in d-subtree
                    int x1 = xor[b];
                    int x2 = xor[d] ^ xor[b];
                    int x3 = totalXor ^ xor[d];
                    minScore = Math.min(minScore, getDiff(x1, x2, x3));
                } else {
                    // Separate subtrees
                    int x1 = xor[b];
                    int x2 = xor[d];
                    int x3 = totalXor ^ xor[b] ^ xor[d];
                    minScore = Math.min(minScore, getDiff(x1, x2, x3));
                }
            }
        }
        return minScore;
    }

    void dfs(int node, int parent, List<List<Integer>> graph, int[] nums, int[] xor, int[] in, int[] out) {
        in[node] = time++;
        xor[node] = nums[node];
        for (int nei : graph.get(node)) {
            if (nei != parent) {
                dfs(nei, node, graph, nums, xor, in, out);
                xor[node] ^= xor[nei];
            }
        }
        out[node] = time++;
    }

    boolean isDescendant(int u, int v, int[] in, int[] out) {
        return in[v] <= in[u] && out[u] <= out[v];
    }

    int getDiff(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        return max - min;
    }
}
