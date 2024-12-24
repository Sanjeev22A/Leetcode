class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashMap<Integer,Boolean> map1=new HashMap<>();
        HashMap<Integer,Boolean> map2=new HashMap<>();
        for(int a:nums1){
            if(!map1.containsKey(a)){
                map1.put(a,false);
            }
        }
        for(int a:nums2){
            if(!map2.containsKey(a)){
                map2.put(a,false);
            }
        }
        List<Integer> sol1=new ArrayList<>();
        List<Integer> sol2=new ArrayList<>();
        for(int a:nums1){
            if(!map2.containsKey(a) && map1.getOrDefault(a,true)==false){
                sol1.add(a);
                map1.put(a,true);
            }
        }
        for(int a:nums2){
            if(!map1.containsKey(a) && map2.getOrDefault(a,true)==false){
                sol2.add(a);
                map2.put(a,true);
            }
        }
        List<List<Integer>> result=new ArrayList<>();
        result.add(sol1);
        result.add(sol2);
        return result;
    }
}