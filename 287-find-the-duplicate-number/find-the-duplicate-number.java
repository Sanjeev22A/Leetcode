class Solution {
    public int findDuplicate(int[] nums) {
        int[] count=new int[nums.length+1];
        for(int a:nums){
            count[a]++;
            if(count[a]>1){
                return a;
            }
        }
        return 0;
    }
}