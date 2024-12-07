class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words=sentence.split("\\s+");
        int i=1;
        for(String a:words){
            if(a.startsWith(searchWord)){
                return i;
            }
            i++;
        }
        return -1;
    }
}