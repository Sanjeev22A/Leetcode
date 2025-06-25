class UnionFind {
    int[] parent, start, end;
    long[] sum;
    boolean[] active;

    UnionFind(int n) {
        parent = new int[n];
        start = new int[n];
        end = new int[n];
        sum = new long[n];
        active = new boolean[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);  // path compression
        }
        return parent[x];
    }

    void add(int x, int val) {
        start[x] = end[x] = x;
        sum[x] = val;
        active[x] = true;
    }

    long union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return sum[px];

        parent[py] = px;
        start[px] = Math.min(start[px], start[py]);
        end[px] = Math.max(end[px], end[py]);
        sum[px] += sum[py];
        return sum[px];
    }

    long getSum(int x) {
        return sum[find(x)];
    }
}

class Solution {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int n = nums.length;
        UnionFind uf = new UnionFind(n);
        long[] result = new long[n];
        long maxSum = 0;

     
        for (int i = n - 1; i >= 0; i--) {
            result[i] = maxSum;

            int idx = removeQueries[i];
            uf.add(idx, nums[idx]);

            if (idx > 0 && uf.active[idx - 1]) {
                uf.union(idx, idx - 1);
            }
            if (idx < n - 1 && uf.active[idx + 1]) {
                uf.union(idx, idx + 1);
            }

            maxSum = Math.max(maxSum, uf.getSum(idx));
        }

        return result;
    }
}