class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] arr1=s1.split(" ");
        String[] arr2=s2.split(" ");
        HashMap<String,Integer> map1=new HashMap<>();
        HashMap<String,Integer> map2=new HashMap<>();

        for(String e:arr1){
            map1.put(e,map1.getOrDefault(e,0)+1);    
        }
        for(String e:arr2){
            map2.put(e,map2.getOrDefault(e,0)+1);
        }
        List<String> result=new ArrayList<>();
        for(Map.Entry<String,Integer> e:map1.entrySet()){
            if(e.getValue()==1 && !map2.containsKey(e.getKey())){
                result.add(e.getKey());
            }
        }
        for(Map.Entry<String,Integer> e:map2.entrySet()){
            if(e.getValue()==1 && !map1.containsKey(e.getKey())){
                result.add(e.getKey());
            }
        }
        return result.toArray(new String[0]);
    }
}