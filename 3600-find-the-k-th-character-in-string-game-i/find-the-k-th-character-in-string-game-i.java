class Solution {
    String createNext(String cur){
        StringBuilder next=new StringBuilder();
        for(char c:cur.toCharArray()){
            int key=c-'a';
            key=(key+1)%26;
            next.append((char)('a'+(key)));
        }
        return next.toString();
    }
    public char kthCharacter(int k) {
        String cur="a";
        while(cur.length()<k){
            String next=createNext(cur);
            cur=cur+next;
        }
        return cur.charAt(k-1);
    }
}