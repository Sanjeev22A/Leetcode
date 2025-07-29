class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int[] pos=new int[32];
        int[] ans=new int[nums.length];
        Arrays.fill(pos,-1);
        for(int i=nums.length-1;i>=0;i--){
            int curNum=nums[i];
            int end=i;
            for(int j=31;j>=0;j--){
                if((curNum&(1<<j))==0){
                    if(pos[j]!=-1){
                        end=Math.max(pos[j],end);
                    }
                }else{
                    pos[j]=i;
                }
            }
            ans[i]=end-i+1;
        }
        return ans;
    }
}