class Solution {
    int[] nums;
    Map<String,int[]> map;
    int[] dp(int startIndex,int endIndex,int playerTurn){
        if(startIndex>endIndex){
            return new int[]{0,0};
        }
        String key=startIndex+":"+endIndex+":"+playerTurn;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int[] val1=dp(startIndex+1,endIndex,(playerTurn+1)%2);
        int[] val2=dp(startIndex,endIndex-1,(playerTurn+1)%2);
        int[] ans=new int[2];
        if(val1[playerTurn]+nums[startIndex]>val2[playerTurn]+nums[endIndex]){
            
            ans[playerTurn]=val1[playerTurn]+nums[startIndex];
            ans[1-playerTurn]=val1[1-playerTurn];
            
        }else if(val1[playerTurn]+nums[startIndex]<val2[playerTurn]+nums[endIndex]){
           
            ans[playerTurn]=val2[playerTurn]+nums[endIndex];
            ans[1-playerTurn]=val2[1-playerTurn];
            
        }else if(val1[1-playerTurn]<val2[1-playerTurn]){
            
            ans[playerTurn]=val1[playerTurn]+nums[startIndex];
            ans[1-playerTurn]=val1[1-playerTurn];
          
        }else{
            
            ans[playerTurn]=val2[playerTurn]+nums[endIndex];
            ans[1-playerTurn]=val2[1-playerTurn];
            
        }
        map.put(key,ans);
        return ans;
    }
    public boolean predictTheWinner(int[] nums) {
        map=new HashMap<>();
        
        this.nums=nums;
        int[] ans=dp(0,nums.length-1,0);
        return ans[0]>=ans[1];
    }
}