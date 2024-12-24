class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        HashSet<Integer> set=new HashSet<>();
        for(int a:arr){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if(set.contains(e.getValue())){
                return false;
            }
            set.add(e.getValue());
        }
        return true;

    
    }
}