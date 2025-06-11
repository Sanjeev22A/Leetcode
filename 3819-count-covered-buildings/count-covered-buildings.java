class Pair{
    int min,max;
    Pair(int min,int max){
        this.min=min;
        this.max=max;
    }
}
class Solution {
    int INF=Integer.MAX_VALUE;
    int NEG_INF=Integer.MIN_VALUE;
    public int countCoveredBuildings(int n, int[][] buildings) {
        
        Map<Integer,Pair> xdir=new HashMap<>();
        Map<Integer,Pair> ydir=new HashMap<>();
        for(int[] a:buildings){
            //Processing x direction
            if(!xdir.containsKey(a[0])){
                xdir.put(a[0],new Pair(a[1],a[1]));
            }
            else{
                Pair p=xdir.get(a[0]);
                xdir.put(a[0],new Pair(Math.min(a[1],p.min),Math.max(a[1],p.max)));
            }

            //Processing y direction
            if(!ydir.containsKey(a[1])){
                ydir.put(a[1],new Pair(a[0],a[0]));
            }else{
                Pair p=ydir.get(a[1]);
                ydir.put(a[1],new Pair(Math.min(a[0],p.min),Math.max(a[0],p.max)));
            }
        }
        int count=0;
        for(int[] a:buildings){
            Pair x=xdir.get(a[0]);
            Pair y=ydir.get(a[1]);
            if(x.min<a[1] && x.max>a[1] && y.min<a[0] && y.max>a[0]){
                count++;
            }
        }
        return count;
    }
}