class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans=new ArrayList<>();
        int prev=nums[0]-1;
        for(int a:nums){
            if(a!=prev+1){
                for(int b=prev+1;b<a;b++){
                    ans.add(b);
                }
            }
            prev=a;
        }
        return ans;
    }
}