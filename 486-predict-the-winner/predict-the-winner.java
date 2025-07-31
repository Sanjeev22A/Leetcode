class Solution {
    int[] nums;
    
    int[] dp(int startIndex,int endIndex,int playerTurn){
        if(startIndex>endIndex){
            return new int[]{0,0};
        }
        int[] val1=dp(startIndex+1,endIndex,(playerTurn+1)%2);
        int[] val2=dp(startIndex,endIndex-1,(playerTurn+1)%2);
        if(val1[playerTurn]+nums[startIndex]>val2[playerTurn]+nums[endIndex]){
            int[] ans=new int[2];
            ans[playerTurn]=val1[playerTurn]+nums[startIndex];
            ans[1-playerTurn]=val1[1-playerTurn];
            return ans;
        }else if(val1[playerTurn]+nums[startIndex]<val2[playerTurn]+nums[endIndex]){
            int[] ans=new int[2];
            ans[playerTurn]=val2[playerTurn]+nums[endIndex];
            ans[1-playerTurn]=val2[1-playerTurn];
            return ans;
        }else if(val1[1-playerTurn]<val2[1-playerTurn]){
            int[] ans=new int[2];
            ans[playerTurn]=val1[playerTurn]+nums[startIndex];
            ans[1-playerTurn]=val1[1-playerTurn];
            return ans;
        }else{
            int[] ans=new int[2];
            ans[playerTurn]=val2[playerTurn]+nums[endIndex];
            ans[1-playerTurn]=val2[1-playerTurn];
            return ans;
        }
    }
    public boolean predictTheWinner(int[] nums) {
        this.nums=nums;
        int[] ans=dp(0,nums.length-1,0);
        return ans[0]>=ans[1];
    }
}