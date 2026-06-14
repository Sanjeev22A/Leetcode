class Solution {
    public int countPrefixes(String[] words, String s) {
        Map<String,Integer> map=new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        String t="";
        int total=0;
        for(char c:s.toCharArray()){
            t+=c;
            if(map.containsKey(t)){
                total+=map.get(t);
            }
        }
        return total;
    }
}