class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();

        int ans=0;
        int i=0;
        for(int j=0;j<s.length();j++){
            char c=s.charAt(j);
            map.put(c,map.getOrDefault(c,0)+1);
            while(map.get(c)>2){
                char left=s.charAt(i);
                map.put(left,map.getOrDefault(left,0)-1);
                i++;
            }
            int curLength=j-i+1;
            ans=Math.max(ans,curLength);
        }
        return ans;
    }
}