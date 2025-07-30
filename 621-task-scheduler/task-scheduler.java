class Solution {
    public int leastInterval(char[] tasks, int n) {
        int max=0;
        int[] count=new int[26];
        for(char c:tasks){
            count[c-'A']++;
            max=Math.max(max,count[c-'A']);
        }
        int time=(max-1)*(n+1);
        for(int a:count){
            if(a==max){
                time++;
            }
        }
        return Math.max(tasks.length,time);
        
    }
}