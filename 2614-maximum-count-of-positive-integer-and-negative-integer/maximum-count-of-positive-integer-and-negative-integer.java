class Solution {
    public int maximumCount(int[] nums) {
        int positive=0,negative=0;
        for(int a:nums){
            if(a>0){positive++;}
            else if(a<0){
                negative++;

            }
        }
        return Math.max(positive,negative);
    }
}