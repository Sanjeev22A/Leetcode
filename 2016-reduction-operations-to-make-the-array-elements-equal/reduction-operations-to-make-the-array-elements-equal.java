class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        int levels=-1;
        int cost=0;
        int prev=-1;
        for(int a:nums){
            if(a!=prev){
                levels++;
                prev=a;
            }
            cost+=levels;
        }
        return cost;
    }
}