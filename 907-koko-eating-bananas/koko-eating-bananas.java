class Solution {
    int ceil(int x,int y){
        int ans=0;
        if(x%y>0){
            ans++;
        }
        return ans+x/y;
    }
    int max(int[] arr){
        int ans=Integer.MIN_VALUE;
        for(int a:arr){
            ans=Math.max(a,ans);
        }
        return ans;
    }
    long calc(int[] piles,int rate){
        long ans=0;
        for(int a:piles){
            ans+=(long)ceil(a,rate);
        }
        return ans;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int start=1,end=max(piles);
        int ans=Integer.MAX_VALUE;
        while(start<=end){
            int mid=start+(end-start)/2;
            long val=calc(piles,mid);
            if(val<=h){
                ans=Math.min(ans,mid);
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
}