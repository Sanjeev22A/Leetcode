class Solution {
    Map<Integer,Boolean> map;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        map=new HashMap<>();
        if(desiredTotal==0){
            return true;
        }
        int a=maxChoosableInteger*(maxChoosableInteger+1)/2;
        System.out.println(a);
        if(a<desiredTotal){
            return false;
        }
        return dfs(0,0,desiredTotal,maxChoosableInteger);
    }

    boolean dfs(int mask,int currentTotal,int desiredTotal,int maxChoosableInteger){
        if(map.containsKey(mask)){
            return map.get(mask);
        }

        if(currentTotal>=desiredTotal){
            return false;
        }
        boolean flag=false;
        for(int i=1;i<=maxChoosableInteger;i++){
            if((mask&(1<<i))==0 && !dfs(mask|(1<<i),currentTotal+i,desiredTotal,maxChoosableInteger)){
                flag=true;
                break;
            }
        }
        map.put(mask,flag);
        return flag;
    }
}