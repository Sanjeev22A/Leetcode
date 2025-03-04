class Solution {
    Map<Integer,Integer> map;
    private boolean check(int n,int index){
        if(n==0){return true;}
        else if(n<0){return false;}
        else if(index>16){return false;}
        else{
            int val=map.get(index);
            if(val>n){return false;}
            else{
                return check(n-val,index+1)||check(n,index+1);
            }
        }
    }
    public boolean checkPowersOfThree(int n) {
        map=new HashMap<>();
        for(int i=0;i<=16;i++){
           map.put(i, (int) Math.pow(3, i));
        }
        return check(n,0);
    }
}