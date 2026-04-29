class Solution {
    private boolean similar(String s1,String s2){
        Set<Character> set=new HashSet<>();
        int uniqueCount=0;
        for(char c:s1.toCharArray()){
            if(!set.contains(c)){
                set.add(c);
                uniqueCount++;
            }
        }
        Set<Character> set2=new HashSet<>();
        for(char c:s2.toCharArray()){
            if(!set2.contains(c)){
                set2.add(c);
                if(!set.contains(c)){
                    return false;
                }
                uniqueCount--;
            }
        }
        return uniqueCount==0;
    }
    public int similarPairs(String[] words) {
        int count=0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(similar(words[i],words[j]))count++;
            }
        }
        return count;
    }
}