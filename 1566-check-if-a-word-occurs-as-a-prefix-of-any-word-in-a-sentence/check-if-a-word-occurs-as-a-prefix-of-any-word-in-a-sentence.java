class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] split=sentence.split("\\s+");
        int i=1;
        for(String w:split){
            //System.out.println(w);
            if(w.startsWith(searchWord)){

                return i;
            }
            i++;
        }
        return -1;
    }
}