class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> seen=new HashSet<>();
        int curSum=0;
        int left=0,right=0;
        int max=0;
        while(right<nums.length){
            if(!seen.contains(nums[right])){
                curSum+=nums[right];
                seen.add(nums[right]);
                right++;
            }else{

                while(left<right && seen.contains(nums[right])){
                    seen.remove(nums[left]);
                    curSum-=nums[left];
                    left++;
                }
            }
            max=Math.max(max,curSum);
        }
        return max;

    }
}