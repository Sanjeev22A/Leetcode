class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer,Integer> freqMap=new HashMap<>();
        int minVal=Integer.MAX_VALUE;
        for(int a:basket1){
            freqMap.put(a,freqMap.getOrDefault(a,0)+1);
            minVal=Math.min(a,minVal);
        }
        for(int a:basket2){
            freqMap.put(a,freqMap.getOrDefault(a,0)-1);
            minVal=Math.min(a,minVal);
        }
        List<Integer> excess=new ArrayList<>();
        for(Map.Entry<Integer,Integer> e:freqMap.entrySet()){
            int val=Math.abs(e.getValue());
            if(val%2==1){
                return -1L;
            }
            for(int i=0;i<val/2;i++){
                excess.add(e.getKey());
            }
        }
        Collections.sort(excess);
        long ans=0L;
        for(int i=0;i<excess.size()/2;i++){
            
            ans+=(long)Math.min(2*minVal,excess.get(i));
        }
        return ans;
    }
}