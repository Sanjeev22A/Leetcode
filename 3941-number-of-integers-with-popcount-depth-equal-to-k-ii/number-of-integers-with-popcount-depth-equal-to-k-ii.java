class Solution {
    private static final int MAX_DEPTH = 6;
    private final Map<Long, Integer> depthCache = new HashMap<>();
    
    // Precompute popcount depth for numbers 0-64 (covers all possible bit counts)
    private void precomputeDepths() {
        depthCache.put(0L, Integer.MAX_VALUE); // Special case for 0
        depthCache.put(1L, 0);
        
        for (int i = 2; i <= 64; i++) {
            depthCache.put((long)i, 1 + depthCache.get((long)Long.bitCount(i)));
        }
    }
    
    private int findPopDepth(long val) {
        if (val == 0L) return Integer.MAX_VALUE; // Or handle as needed
        if (val == 1L) return 0;
        
        if (depthCache.containsKey(val)) {
            return depthCache.get(val);
        }
        
        int setBits = Long.bitCount(val);
        int depth = 1 + findPopDepth(setBits);
        depthCache.put(val, depth);
        return depth;
    }
    
    public int[] popcountDepth(long[] nums, long[][] queries) {
        precomputeDepths();
        
        int n = nums.length;
        int[] depths = new int[n];
        
        // Initialize depths array
        for (int i = 0; i < n; i++) {
            depths[i] = findPopDepth(nums[i]);
        }
        
        // Use Fenwick Trees for efficient range sum queries and updates
        FenwickTree[] trees = new FenwickTree[MAX_DEPTH + 1];
        for (int i = 0; i <= MAX_DEPTH; i++) {
            trees[i] = new FenwickTree(n);
        }
        
        // Initialize Fenwick Trees
        for (int i = 0; i < n; i++) {
            int depth = depths[i];
            if (depth <= MAX_DEPTH) {
                trees[depth].update(i, 1);
            }
        }
        
        List<Integer> results = new ArrayList<>();
        
        for (long[] query : queries) {
            if (query[0] == 1) { // Range query
                int l = (int) query[1];
                int r = (int) query[2];
                int k = (int) query[3];
                
                if (k <= MAX_DEPTH) {
                    int count = trees[k].query(r) - (l > 0 ? trees[k].query(l - 1) : 0);
                    results.add(count);
                } else {
                    results.add(0);
                }
            } else { // Update query
                int idx = (int) query[1];
                long newVal = query[2];
                
                int oldDepth = depths[idx];
                int newDepth = findPopDepth(newVal);
                
                // Update the arrays
                nums[idx] = newVal;
                depths[idx] = newDepth;
                
                // Update Fenwick Trees
                if (oldDepth <= MAX_DEPTH) {
                    trees[oldDepth].update(idx, -1);
                }
                if (newDepth <= MAX_DEPTH) {
                    trees[newDepth].update(idx, 1);
                }
            }
        }
        
        return results.stream().mapToInt(Integer::intValue).toArray();
    }
}

// Fenwick Tree (Binary Indexed Tree) for efficient range sum queries
class FenwickTree {
    private final int[] tree;
    private final int n;
    
    public FenwickTree(int size) {
        this.n = size;
        this.tree = new int[n + 1];
    }
    
    public void update(int idx, int delta) {
        idx++; // Convert to 1-indexed
        while (idx <= n) {
            tree[idx] += delta;
            idx += idx & (-idx);
        }
    }
    
    public int query(int idx) {
        idx++; // Convert to 1-indexed
        int sum = 0;
        while (idx > 0) {
            sum += tree[idx];
            idx -= idx & (-idx);
        }
        return sum;
    }
}