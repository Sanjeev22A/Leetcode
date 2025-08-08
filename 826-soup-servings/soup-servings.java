class Solution {
    Map<Long,Double> dp;
    double dfs(int a,int b){
        long key=(long)a<<32|b;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        if(a>0 && b==0){
            dp.put(key,0.0);
            return 0.0;
        }
        if(a==0 && b>0){
            dp.put(key,1.0);
            return 1.0;
        }
        if(a==0 && b==0){
            dp.put(key,0.5);
            return 0.5;
        }
        double val=0.25*dfs(Math.max(a-4,0),b)+0.25*dfs(Math.max(a-3,0),Math.max(b-1,0))+0.25*dfs(Math.max(a-2,0),Math.max(b-2,0))+0.25*dfs(Math.max(a-1,0),Math.max(b-3,0));
        dp.put(key,val);
        return val;
    }
    public double soupServings(int n) {
        if(n>=5000){
            return 1.0;
        }
        int scaled=(n+24)/25;
        //System.out.println(scaled);
        dp=new HashMap<>();
        return dfs(scaled,scaled);

    }
}