class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0 && k>0){
                if(k%2==0){
                    sum+=nums[i];
                }else{
                    sum-=nums[i];
                }
                k=0;
            }else if(nums[i]<0 && k>0){
                if(i<nums.length-1 && k%2==0 && -nums[i]<nums[i+1]){
                    sum+=nums[i];
                }else if(i==nums.length-1 && k%2==0){
                    sum+=nums[i];
                }
                else{
                    sum-=nums[i];
                    k--;
                }
            }else{
                sum+=nums[i];
            }
            //System.out.println(nums[i]+":"+sum+":"+k);
        }
        return sum;
    }
}