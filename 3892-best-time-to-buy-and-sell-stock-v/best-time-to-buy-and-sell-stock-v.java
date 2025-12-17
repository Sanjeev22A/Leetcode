class Key {

    int curIndex;
    int k;
    int type;

    Key(int curIndex, int k, int type) {
        
        this.curIndex = curIndex;
        this.k = k;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;          
        if (o == null || getClass() != o.getClass()) return false;

        Key key = (Key) o;
        return 
               curIndex == key.curIndex &&
               k == key.k &&
               (type == key.type );
    }

    @Override
    public int hashCode() {
        return Objects.hash(curIndex, k, type);
    }
}

class Solution {
    long[][][] cache;
    long totalProfit(int curIndex,int[] prices,int k,int type){
        if(curIndex>=prices.length){
            return 0L;
        }
        if(cache[curIndex][k][type]!=-1){
            return cache[curIndex][k][type];
        }
        if(k<=0 || curIndex>=prices.length){
            cache[curIndex][k][type]=0L;
            return 0L;
        }
        if(type!=0){
            if(type==1){ //type 1 is a normal transaction
                //Two cases: we can either sell it on this day or carry forward
                long p1=totalProfit(curIndex+1,prices,k,type);
                long p2=(long)prices[curIndex]+totalProfit(curIndex+1,prices,k-1,0);
                long ans=Math.max(p1,p2);
                cache[curIndex][k][type]=ans;
                return ans;
            }else if(type==2){  //Type 2 is short selling transaction
                if(curIndex==prices.length-1){
                    long val=-(long)prices[curIndex];
                    cache[curIndex][k][type]=val;
                    return val;

                }
                long p1=totalProfit(curIndex+1,prices,k,type);
                long p2=-(long)prices[curIndex]+totalProfit(curIndex+1,prices,k-1,0);
                long ans=Math.max(p1,p2);
                cache[curIndex][k][type]=ans;
                return ans;
            }
        }else{
            //No transaction
            long p1=totalProfit(curIndex+1,prices,k,0);
            //Doing a normal transaction
            long p2=-(long)prices[curIndex]+totalProfit(curIndex+1,prices,k,1);
            //Doing a short selling
            long p3=(long)prices[curIndex]+totalProfit(curIndex+1,prices,k,2);
            if(curIndex==prices.length-1){
                p3=0L;
            }
            long ans=Math.max(p1,Math.max(p2,p3));
            cache[curIndex][k][type]=ans;
            return ans;
        }
        return 0L;
    }
    public long maximumProfit(int[] prices, int k) {
        cache=new long[prices.length][k+1][3];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<=k;j++){
                Arrays.fill(cache[i][j],-1L);
            }
        }
        long p1=totalProfit(0,prices,k,0);
        return p1;
    }
}