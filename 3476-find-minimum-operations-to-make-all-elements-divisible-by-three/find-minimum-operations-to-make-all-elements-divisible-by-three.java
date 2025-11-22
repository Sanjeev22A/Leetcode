class Solution {
    public int minimumOperations(int[] nums) {
        int ans=0;
        for(int a:nums){
            ans+=Math.min((a%3),3-(a%3));
        }
        return ans;
    }
}