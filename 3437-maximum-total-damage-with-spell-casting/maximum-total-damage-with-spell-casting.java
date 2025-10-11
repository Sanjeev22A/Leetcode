class Solution {
    public long maximumTotalDamage(int[] power) {
        TreeMap<Integer,Integer> count=new TreeMap<>();
        List<int[]> arr=new ArrayList<>();
        for(int a:power){
            count.put(a,count.getOrDefault(a,0)+1);
        }
        for(Map.Entry<Integer,Integer> e:count.entrySet()){
            int[] temp=new int[]{e.getKey(),e.getValue()};
            arr.add(temp);
        }
        long[] cache=new long[arr.size()];
        long maxAnswer=0;
        long maxPossible=0L;
        int j=0;
        for(int i=0;i<arr.size();i++){
            
            
            while(j<i && arr.get(j)[0]<arr.get(i)[0]-2){
                maxPossible=Math.max(maxPossible,cache[j]);
                j++;
            }
            cache[i]=maxPossible+(long)arr.get(i)[0]*(long)arr.get(i)[1];
            
            maxAnswer=Math.max(cache[i],maxAnswer);
        }
        return maxAnswer;

    }
}