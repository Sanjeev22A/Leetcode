class Solution {
    boolean contains(String s){
        if(s.indexOf("AB")==-1 && s.indexOf("CD")==-1){
            return false;
        }
        return true;
    }
    public int minLength(String s) {
        while(contains(s)){
            s=s.replaceAll("AB","");
            s=s.replaceAll("CD","");
        }
        return s.length();
    }
}