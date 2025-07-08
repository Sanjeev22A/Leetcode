class Solution {
    int[][] events;
    int[][] dp;
    int getNextIndex(int curIndex){
        int endTime=events[curIndex][1];
        int left=curIndex,right=events.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(events[mid][0]<=endTime){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
    int dp(int curIndex,int k){
        if(k==0 || curIndex>=events.length){
            return 0;
        }
        if(dp[k][curIndex]!=-1){
            return dp[k][curIndex];
        }
        int nextIndex=getNextIndex(curIndex);
        //Here if we use the curIndex then in recursion we have to use nextIndex or if we dont we can use curIndex+1
        int usedVal=events[curIndex][2]+dp(nextIndex,k-1);
        int notUsedVal=dp(curIndex+1,k);
        int val=Math.max(usedVal,notUsedVal);
        dp[k][curIndex]=val;
        return val;

    }
    public int maxValue(int[][] events, int k) {
        dp=new int[k+1][events.length];
        for(int i=0;i<k+1;i++){
            Arrays.fill(dp[i],-1);
        }
        this.events=events;
        Arrays.sort(events,(a,b)->(a[0]-b[0]));
        return dp(0,k);
    }
}