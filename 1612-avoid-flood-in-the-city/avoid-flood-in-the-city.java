class Solution {
    public int[] avoidFlood(int[] rains) {
        int[] res=new int[rains.length];
        Arrays.fill(res,1);
        TreeSet<Integer> ts=new TreeSet<>();
        
        Map<Integer,Integer> fillMap=new HashMap<>();
        for(int i=0;i<rains.length;i++){
            if(rains[i]==0){
                ts.add(i);
            }else{
                res[i]=-1;
            }
        }
        for(int i=0;i<rains.length;i++){
            int a=rains[i];
            
            if(a!=0){
                if(fillMap.containsKey(a)){
                    int idx=fillMap.get(a);
                    Integer foundIdx=ts.higher(idx);
                    
                    if(foundIdx==null || foundIdx>i){
                        
                        return new int[0];
                    }
                    else{
                        ts.remove(foundIdx);
                        res[foundIdx]=a;
                    }

                }
                fillMap.put(a,i);
            }
        }
        return res;


    }
}