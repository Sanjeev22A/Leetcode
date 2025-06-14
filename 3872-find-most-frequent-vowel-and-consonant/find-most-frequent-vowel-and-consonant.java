class Solution {
    public int maxFreqSum(String s) {
        int[] a=new int[26];
        int vowelCount=0,consonantCount=0;
        for(char c:s.toCharArray()){
            a[c-'a']++;
            if(c=='a' || c=='e' || c=='o' || c=='i' || c=='u'){
                vowelCount=Math.max(vowelCount,a[c-'a']);
            }else{
                consonantCount=Math.max(consonantCount,a[c-'a']);
            }

        }
        return vowelCount+consonantCount;
    }
}