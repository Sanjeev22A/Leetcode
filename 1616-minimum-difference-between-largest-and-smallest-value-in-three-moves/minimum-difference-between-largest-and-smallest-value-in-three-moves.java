class Solution {
    int backTrack(int[] nums,int start,int end,int numMoves){
        if(numMoves==3){
            return nums[end]-nums[start];
        }
        if(start==end){
            return nums[end]-nums[start];
        }
        
        int m1=backTrack(nums,start+1,end,numMoves+1);
        int m2=backTrack(nums,start,end-1,numMoves+1);
        return Math.min(m1,m2);
        
    }
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        return backTrack(nums,0,nums.length-1,0);
    }
}