class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        
        // Handle edge case for arrays smaller than 3 elements
        if (n < 3) return 0;
        
        int[] LISforward = new int[n];
        Arrays.fill(LISforward, 1);
        
        int[] LISbackward = new int[n];
        Arrays.fill(LISbackward, 1);
        
        // Calculate LISforward (Longest Increasing Subsequence from the start)
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    LISforward[i] = Math.max(LISforward[i], 1 + LISforward[j]);
                }
            }
        }
        
        // Calculate LISbackward (Longest Decreasing Subsequence from the end)
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    LISbackward[i] = Math.max(LISbackward[i], 1 + LISbackward[j]);
                }
            }
        }
        
        // Find the maximum length of a valid mountain
        int maxLen = 0;
        for (int i = 1; i < n - 1; i++) {
            // Both LISforward[i] and LISbackward[i] must be > 1 for a valid peak
            if (LISforward[i] > 1 && LISbackward[i] > 1) {
                maxLen = Math.max(maxLen, LISforward[i] + LISbackward[i] - 1);
            }
        }
        
        // The minimum removals are the total elements minus the longest valid mountain
        return n - maxLen;
    }
}
