class Solution {
    int idx(char c){
        return c-'a';
    }
    public int minimumPushes(String word) {
        Integer[] freq=new Integer[26];
        Arrays.fill(freq,0);
        for(char c:word.toCharArray()){
            freq[idx(c)]++;
        }
        Arrays.sort(freq,Collections.reverseOrder());
        int counter=0;
        int ans=0;
        for(int a:freq){
            ans+=(counter/8+1)*a;
            counter++;
        }
        return ans;
    }


}