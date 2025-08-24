class Solution {
    public int longestSubarray(int[] nums) {
        int left=0,right=0,nonOnePosition=-1;
        boolean otherSeen=false;
        int max=0;
        while(right<nums.length){
            if(nums[right]==1){
                right++;
            }else if(nums[right]==0 && !otherSeen){
                nonOnePosition=right;
                otherSeen=true;
                right++;
            }else{
                left=nonOnePosition+1;
                otherSeen=false;
                nonOnePosition=-1;
            }
            //System.out.println(left+":"+right+":"+nonOnePosition);
         
            max=Math.max(right-left-1,max);
            
        }
        return max;
    }
}