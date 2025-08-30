class Solution {
    String reverse(String word,int index){
        StringBuilder res=new StringBuilder();
        res.append(word.substring(0,index+1));
        res.reverse();
        res.append(word.substring(index+1));
        return res.toString();
    }
    public String reversePrefix(String word, char ch) {
        int index=word.indexOf(ch);
        if(index==-1){
            return word;
        }
        return reverse(word,index);
    }
}