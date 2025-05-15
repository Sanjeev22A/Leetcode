class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff=Integer.MAX_VALUE;
        int sumClosest=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<nums.length-2;i++){
            
            int j=i+1,k=nums.length-1;
            while(j<k){
                sum=nums[i]+nums[j]+nums[k];
                
                if(Math.abs(sum-target)<diff){
                    sumClosest=sum;
                    diff=Math.abs(sum-target);
                    if(diff==0){
                        return sumClosest;
                    }
                }
                if(sum>target){
                    k--;
                }else{
                   j++;
                }
            }
        }
        return sumClosest;
    }
}