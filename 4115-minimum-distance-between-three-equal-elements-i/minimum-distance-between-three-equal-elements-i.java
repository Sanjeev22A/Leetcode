class Solution {
    public int minimumDistance(int[] nums) {
        int minDist=Integer.MAX_VALUE;
        for(int i=1;i<nums.length-1;i++){
            for(int j=0;j<i;j++){
                for(int k=i+1;k<nums.length;k++){
                    if(nums[i]==nums[j] && nums[j]==nums[k]){
                        int calc=(i-j)+(k-i)+(k-j);
                        minDist=Math.min(minDist,calc);
                    }
                }
            }
        }
        if(minDist==Integer.MAX_VALUE){
            return -1;
        }
        return minDist;
    }
}