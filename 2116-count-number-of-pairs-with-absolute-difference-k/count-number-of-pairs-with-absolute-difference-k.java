class Solution {
    public int countKDifference(int[] nums, int k) {
        int ans=0;
        int[] digitCount=new int[101];
        for(int a:nums){
            if(a+k<=100){
                ans+=digitCount[a+k];
            }
            if(a-k>=0){
                ans+=digitCount[a-k];
            }
            digitCount[a]++;
        }
        return ans;
    }
}