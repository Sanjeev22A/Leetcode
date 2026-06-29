class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int ans=0;
        for(String a:patterns){
            if(word.contains(a)){
                ans++;
            }
        }
        return ans;
    }
}