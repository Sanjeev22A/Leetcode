class Solution {
    public int minMoves2(int[] nums) {
        int reference=0;
        Arrays.sort(nums);
        if(nums.length%2==1){
            reference=nums[nums.length/2];
        }else{
            reference=nums[nums.length/2];
        }
        int ans=0;
        for(int a:nums){
            ans+=Math.abs(reference-a);
        }
        return ans;
    }
}