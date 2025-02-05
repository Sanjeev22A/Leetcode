class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int i=0,count=0;
        char[] arr1=new char[26];
        char[] arr2=new char[26];
        for(i=0;i<s1.length() && i<s2.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                count++;
                if(count>2){return false;}
            }
            arr1[s1.charAt(i)-'a']++;
            arr2[s2.charAt(i)-'a']++;
        }
        return Arrays.equals(arr1,arr2);
    }
}