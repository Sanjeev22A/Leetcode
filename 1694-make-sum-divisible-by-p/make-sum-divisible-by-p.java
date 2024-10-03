class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for (int a : nums) {
            sum = (sum + a) % p; // Apply modulo early to avoid overflow
        }
        if (sum % p == 0) {
            return 0;  // Already divisible by p
        }
        int remainder = (int) sum;
        return smallestSubarray(nums, p, remainder);
    }

    private int smallestSubarray(int[] nums, int p, int remainder) {
        long prefixSum = 0;
        int minLength = nums.length;
        HashMap<Long, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0L, -1);  // Prefix sum of 0 at index -1
        
        for (int i = 0; i < nums.length; i++) {
            // Update the prefix sum, using modulo to avoid large sums
            prefixSum = (prefixSum + nums[i]) % p;
            
            // Calculate the target remainder
            int targetRemainder = (int) (prefixSum - remainder + p) % p;
            
            // Check if the target remainder exists in the prefix map
            if (prefixMap.containsKey((long) targetRemainder)) {
                minLength = Math.min(minLength, i - prefixMap.get((long) targetRemainder));
            }
            
            // Store the current prefix sum (mod p) in the map
            prefixMap.put(prefixSum, i);
        }
        return minLength < nums.length ? minLength : -1;  // Return -1 if no valid subarray
    }
}
