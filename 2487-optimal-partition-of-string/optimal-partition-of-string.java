class Solution {
    public int partitionString(String s) {
        int[] count=new int[26];
        int counter=0;
        for(char c:s.toCharArray()){
            if(count[c-'a']>0){
                counter++;
                Arrays.fill(count,0);
                count[c-'a']++;
            }else{
                count[c-'a']++;
            }
        }
        
        return counter+1;
    }
}