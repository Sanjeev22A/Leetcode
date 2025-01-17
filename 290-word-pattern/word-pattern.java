class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] word=s.split("\\s+");
        Map<Character,String> map=new HashMap<>();
        Set<String> seen=new HashSet<>();
        if(pattern.length()!=word.length){return false;}
        int i=0;
        for(char c:pattern.toCharArray()){
            if(map.containsKey(c)){
                if(!map.get(c).equals(word[i])){return false;}
            }
            else{
                if(seen.contains(word[i])){
                    return false;
                }
                map.put(c,word[i]);
                seen.add(word[i]);
            }
            i++;
        }
        return true;
    }
}