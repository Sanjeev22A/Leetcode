class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        String newString=s+s;
        if(newString.indexOf(goal)!=-1){
            return true;
        }
        return false;
    }
}