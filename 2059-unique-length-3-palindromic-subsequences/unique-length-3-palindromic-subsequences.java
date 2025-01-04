class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] first=new int[26];
        int[] last=new int[26];
        Arrays.fill(first,-1);
        int i=0;
        for(char c:s.toCharArray()){
            int index=c-'a';
            if(first[index]==-1){
                first[index]=i;
            }
            last[index]=i;
            i++;
        }
        int ans=0;
        HashSet<Character> seen=new HashSet<>();
        for(char c:s.toCharArray()){
            if(first[c-'a']==-1){
                continue;
            }
            if(seen.contains(c)){
                continue;
            }
            seen.add(c);
            int index=c-'a';
            int lastIndex=last[index];
            int firstIndex=first[index];
            HashSet<Character> set=new HashSet<>();
            for(int j=firstIndex+1;j<lastIndex;j++){
                set.add(s.charAt(j));
            }
            ans+=set.size();
        }
        return ans;
    }
}