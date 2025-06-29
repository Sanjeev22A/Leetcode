class Solution {
    int mod=(int)(Math.pow(10,9)+7);
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int left=0,right=n-1;
        int[] pow=new int[n+1];
        pow[0]=1;
        for(int i=1;i<n+1;i++){
            pow[i]=(int)(((long)pow[i-1]*2)%mod);
        }
        int ans=0;
        while(left<=right){
            if(nums[left]+nums[right]<=target){
                ans=(int)(((long)ans+pow[right-left])%mod);
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }
}