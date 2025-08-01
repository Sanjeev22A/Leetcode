class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int[] nonIncreasing=new int[nums.length];
        int[] nonDecreasing=new int[nums.length];
        int n=nums.length;
        nonDecreasing[n-1]=1;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                nonIncreasing[i]=1;
            }else{
                if(nums[i-1]>=nums[i]){
                    nonIncreasing[i]=nonIncreasing[i-1]+1;
                }
                else{
                    nonIncreasing[i]=1;
                }
            }
        }
        for(int i=n-2;i>=0;i--){
            if(nums[i]<=nums[i+1]){
                nonDecreasing[i]=nonDecreasing[i+1]+1;
            }else{
                nonDecreasing[i]=1;
            }
        }
        
        List<Integer> ans=new ArrayList<>();
        for(int i=k;i<n-k;i++){
            //System.out.println(nonIncreasing[i-1]+":"+nonDecreasing[i+1]+":"+i);
            if(nonIncreasing[i-1]>=k && nonDecreasing[i+1]>=k){
                ans.add(i);
            }
        }
        return ans;

    }
}