class Solution {
    public long appealSum(String s) {
        int n=s.length();
        int[] lastPosition=new int[26];
        Arrays.fill(lastPosition,-1);
        long res=0;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            int lastIndex=lastPosition[c-'a'];
            lastPosition[c-'a']=i;
            int numberOfStartPositions=i-lastIndex;
            int endPositions=n-i;

            res+=(long)numberOfStartPositions*(long)endPositions;
        }
        return res;
    }
}