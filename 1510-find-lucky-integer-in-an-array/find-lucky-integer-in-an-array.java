class Solution {
    public int findLucky(int[] arr) {
        Map<Integer,Integer> count=new HashMap<>();
        for(int a:arr){
            count.put(a,count.getOrDefault(a,0)+1);
        }
        int lucky=-1;
        for(Map.Entry<Integer,Integer> e:count.entrySet()){
            if(e.getKey()==e.getValue()){
                lucky=Math.max(e.getKey(),lucky);
            }
        }
        return lucky
        ;
    }

}