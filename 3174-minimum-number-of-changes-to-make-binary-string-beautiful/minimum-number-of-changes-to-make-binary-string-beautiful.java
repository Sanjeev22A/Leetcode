class Solution {
    public int minChanges(String s) {
        int changeCount=0;
        for(int i=0;i<s.length();){
            if(s.charAt(i)!=s.charAt(i+1)){
                changeCount++;
            }
           
            i=i+2;
    
        }
        return changeCount;
    }
}