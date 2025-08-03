class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int startPosition=startPos;
        Map<Integer,Integer> map=new HashMap<>();
        int maxPosition=0;
        for(int[] a:fruits){
            maxPosition=Math.max(a[0],maxPosition);
            map.put(a[0],a[1]);
        }
        int[] prefixSum=new int[maxPosition+1];
   
        for(int i=0;i<=maxPosition;i++){
            if(i>0){
                prefixSum[i]+=prefixSum[i-1];
            }
            if(map.containsKey(i)){
                prefixSum[i]+=map.get(i);
            }
        }
        
        int ansMax=0;
        if(startPos<maxPosition){
            int ans=prefixSum[Math.min(maxPosition,startPos+k)];
            ans-=(startPos>0)?prefixSum[startPos-1]:0;
            ansMax=Math.max(ansMax,ans);

        }

        if(startPos-k<maxPosition){
            int ans=prefixSum[Math.min(startPosition,maxPosition)];
            if(startPos-k>0){
                ans-=prefixSum[startPos-k-1];
            }
            ansMax=Math.max(ans,ansMax);
        }

        for(int i=0;i<=k/2;i++){
            int right=startPosition+i;
            int left=startPosition-k+2*i;
            int ans=0;
            if(right>maxPosition){
                ans+=prefixSum[maxPosition];
            }else{
                ans+=prefixSum[right];
            }
            if(left>0 && left<=maxPosition){
                ans-=prefixSum[left-1];
            }
            if(left>maxPosition || right<0){
                ans=0;
            }
            ansMax=Math.max(ans,ansMax);
            ans=0;
            left=startPosition-i;
            right=startPosition+k-2*i;
            //System.out.println(left+":"+right);
            if(right>maxPosition){
                ans+=prefixSum[maxPosition];
            }else{
                ans+=prefixSum[right];
            }
            if(left>0 && left<=maxPosition){
                ans-=prefixSum[left-1];
            }
            if(left>maxPosition || right<0){
                ans=0;
            }
            ansMax=Math.max(ans,ansMax);
            ans=0;
        }

        return ansMax;
    }
}