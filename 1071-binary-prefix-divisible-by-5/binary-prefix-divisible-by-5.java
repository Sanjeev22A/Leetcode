class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        long curNum=0;
        List<Boolean> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            curNum=curNum*2+nums[i];
            curNum=curNum%5;
            if(curNum%5==0){
                ans.add(true);
            }else{
                ans.add(false);
            }
            
        }
        return ans;
    }
}