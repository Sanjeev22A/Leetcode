class Solution {
    Map<Integer,Boolean> memo;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        memo=new HashMap<>();
        if(desiredTotal==0){
            return true;
        }
        int a=maxChoosableInteger*(maxChoosableInteger+1)/2;
        if(a<desiredTotal){
            return false;
        }
        return dfs(0,0,desiredTotal,maxChoosableInteger);
    }

    boolean dfs(int curTotal,int mask,int desiredTotal,int maxChoosableInteger){
        if(memo.containsKey(mask)){
            return memo.get(mask);
        }
        if(curTotal>=desiredTotal){
            return false;
        }
        boolean flag=false;
        for(int i=1;i<=maxChoosableInteger;i++){
            if((mask&(1<<i))==0 && !dfs(curTotal+i,(mask|(1<<i)),desiredTotal,maxChoosableInteger)){
                flag=true;
                break;
            }
        }
        memo.put(mask,flag);
        return flag;
    }
}