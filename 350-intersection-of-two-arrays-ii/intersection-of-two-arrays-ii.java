class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map1=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();
        for(int a:nums1){
            map1.put(a,map1.getOrDefault(a,0)+1);
        } 
        for(int a:nums2){
            map2.put(a,map2.getOrDefault(a,0)+1);
        } 
        List<Integer> result=new ArrayList<>();
        for(Map.Entry<Integer,Integer> a:map1.entrySet()){
            int b=a.getKey();
            for(int i=0;i<Math.min(a.getValue(),map2.getOrDefault(b,0));i++){
                result.add(b);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}