class Solution {
    public int numberOfSubstrings(String s) {
        int left=0,right=0,len=s.length();
        int total=0;
        int[] map=new int[3];
        while(right<len){
            char c=s.charAt(right);
            
            map[c-'a']++;
            while(hasAll(map)){
                total+=len-right;
                char d=s.charAt(left);
                map[d-'a']--;
                left++;
            }
            right++;
        }
        return total;

    }
    boolean hasAll(int[] map){
        return map[0]>0 && map[1]>0 && map[2]>0;
    }
}