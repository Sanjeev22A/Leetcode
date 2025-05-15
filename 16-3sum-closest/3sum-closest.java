class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int sumClosest = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int delta = Math.abs(sum - target);

                if (delta < diff) {
                    diff = delta;
                    sumClosest = sum;
                }

                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    // Found exact match
                    return sum;
                }
            }
        }

        return sumClosest;
    }
}

