class Solution {
    boolean isAnagram(int[] countS,int[] countP){
        for(int i=0;i<26;i++){
            if(countS[i]!=countP[i]){
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result=new ArrayList<>();
        if(p.length()>s.length()){
            return result;
        }
        int[] countP=new int[26];
        int[] countS=new int[26];
        for(char c:p.toCharArray()){
            countP[c-'a']++;
        }
        for(int i=0;i<p.length()-1;i++){
            char c=s.charAt(i);
            countS[c-'a']++;
        }
        int sub=p.length()-1;
        for(int i=p.length()-1;i<s.length();i++){
            char b=s.charAt(i);
            countS[b-'a']++;
            if(isAnagram(countS,countP)){
                result.add(i-sub);
            }
            char a=s.charAt(i-sub);
            countS[a-'a']--;
        }
        return result;
        
    }
}