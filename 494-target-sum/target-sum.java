class Solution {
    Map<String,Integer> memo;
    int ways(int[] nums,int currentIndex,int curVal,int target){
        String cur=curVal+":"+currentIndex;
        if(memo.containsKey(cur)){
            return memo.get(cur);
        }
        if(currentIndex==nums.length){
            if(curVal==target){
                memo.put(cur,1);
                return 1;
            }
            memo.put(cur,0);
            return 0;
        }
        int val=ways(nums,currentIndex+1,curVal+nums[currentIndex],target)
            + ways(nums,currentIndex+1,curVal-nums[currentIndex],target);
        memo.put(cur,val);
        return val;
    }
    public int findTargetSumWays(int[] nums, int target) {
        memo=new HashMap<>();
        return ways(nums,0,0,target);
    }
}