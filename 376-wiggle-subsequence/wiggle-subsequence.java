class Solution {
    public int wiggleMaxLength(int[] nums) {
        
        int up=1,down=1;

        int i=0;
        while(i<nums.length-1){
            if(nums[i]<nums[i+1]){
                up=down+1;

            }else if(nums[i]>nums[i+1]){
                down=up+1;
            }
            i++;
        }
        return Math.max(up,down);
    }
}