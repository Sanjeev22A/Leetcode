class Solution {
    Map<String,Integer> memo;
    int[] boxes;
    int dp(int left,int right,int count){
        if(left>right){
            return 0;
        }
        String curState=left+":"+right+":"+count;
        if(memo.containsKey(curState)){
            return memo.get(curState);
        }
        while(left<right && boxes[left]==boxes[left+1]){
            left++;
            count++;
        }
        int ans=(count+1)*(count+1)+dp(left+1,right,0);
        for(int m=left+1;m<=right;m++){
            if(boxes[left]==boxes[m]){
                ans=Math.max(ans,dp(m,right,count+1)+dp(left+1,m-1,0));
            }
        }
        memo.put(curState,ans);
        
        return ans;

    }

    public int removeBoxes(int[] boxes) {
        this.boxes=boxes;
        memo=new HashMap<>();
        return dp(0,boxes.length-1,0);
    }
}