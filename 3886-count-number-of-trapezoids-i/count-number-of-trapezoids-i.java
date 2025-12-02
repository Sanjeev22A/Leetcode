class Solution {
    public int countTrapezoids(int[][] points) {
        Map<Integer,Integer> pointMap=new HashMap<>();
        int MOD=(int)Math.pow(10,9)+7;
        
        int ans=0;
        for(int[] a:points){
            pointMap.put(a[1],pointMap.getOrDefault(a[1],0)+1);

        }
        Map<Integer,Long> lineMap=new HashMap<>();
        Long total=0L;
        for(Map.Entry<Integer,Integer> e:pointMap.entrySet()){
            int part1=e.getValue();

            long cur=(long)part1*(long)(part1-1)/2;
            //System.out.println(cur);
            total+=cur;
            
            lineMap.put(e.getKey(),cur%MOD);
        }
        for(Map.Entry<Integer,Long> e:lineMap.entrySet()){

            long p1=e.getValue();
            long res=total-p1;
            total-=p1;
            
            
            long holder=((res*p1)%MOD);
            ans=(int)(((long)ans+holder)%MOD);
        }

        return ans;
    }
}