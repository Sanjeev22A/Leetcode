class Solution {
    public int minChanges(String s) {
        int changeCount=0;
        for(int i=0;i<s.length();){
            if(s.charAt(i)=='0' && s.charAt(i+1)=='1'){
                changeCount++;
            }
            else if(s.charAt(i)=='1' && s.charAt(i+1)=='0'){
                changeCount++;
            }
            i=i+2;
            System.out.println(i);
        }
        return changeCount;
    }
}