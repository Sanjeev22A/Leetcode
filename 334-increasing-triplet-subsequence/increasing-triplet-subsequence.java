class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        for(int a:nums){
            if(a<=min1){
                min1=a;
            }
            else if(a<=min2){
                min2=a;
            }
            else{
                return true;
            }
        }
        return false;
    }
}