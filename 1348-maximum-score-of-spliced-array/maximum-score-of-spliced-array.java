class Solution{
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(
            sum(nums1) + maxGain(nums2, nums1), // gain if we improve nums1
            sum(nums2) + maxGain(nums1, nums2)  // gain if we improve nums2
        );
    }

    private int sum(int[] a) {
        int s = 0;
        for (int x : a) s += x;
        return s;
    }

    private int maxGain(int[] from, int[] to) {
        int maxSum = 0, curSum = 0;
        for (int i = 0; i < from.length; i++) {
            int diff = from[i] - to[i];
            curSum = Math.max(diff, curSum + diff);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}