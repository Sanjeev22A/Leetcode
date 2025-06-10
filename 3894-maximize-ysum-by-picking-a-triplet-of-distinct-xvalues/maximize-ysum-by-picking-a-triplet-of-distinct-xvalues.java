class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<x.length;i++){
            map.put(x[i],Math.max(map.getOrDefault(x[i],0),y[i]));

            
        }
        if(map.size()<3){
            return -1;
        }
        int a=0,b=0,c=0;
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            int d=e.getValue();
            
            if(d>=a){
                c=b;
                b=a;
                a=d;
            }
            else if(d>=b){
                c=b;
                b=d;
            }
            else if(d>=c){
                c=d;
            }
        }
        
        return a+b+c;

    }
}