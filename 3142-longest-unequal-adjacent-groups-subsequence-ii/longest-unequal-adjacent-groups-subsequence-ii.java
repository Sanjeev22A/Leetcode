class Solution {
    int findHamming(String a,String b){
        if(a.length()!=b.length()){
            return -1;

        }
        int cnt=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                cnt++;
            }
        }
        return cnt;
    }
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n=words.length;
        int[][] dp=new int[n][2];
        dp[0][0]=1;
        dp[0][1]=-1;
        for(int i=0;i<n;i++){
            dp[i][0]=1;
            dp[i][1]=-1;
        }
        for(int i=1;i<n;i++){
            boolean[] visited=new boolean[n];
            for(int j=i-1;j>=0;j--){
                if(visited[j]){
                    continue;
                }
                visited[j]=true;
               
                if(words[j].length()==words[i].length() && groups[j]!=groups[i] && findHamming(words[i],words[j])==1){
                    System.out.println("Here");
                    if(dp[j][0]+1>dp[i][0]){
                        dp[i][0]=dp[j][0]+1;
                        dp[i][1]=j;
                        /*
                        int pnt=dp[j][1];
                        boolean flag=true;
                        while(pnt!=-1){
                            visited[pnt]=true;
                            if(findHamming(words[pnt],words[j])!=1){
                                
                                flag=false;
                                break;
                            }
                            pnt=dp[pnt][1];
                        
                        }
                        if(flag){
                            dp[i][0]=dp[j][0]+1;
                            dp[i][1]=j;

                        }
                        */

                    }
                }
            }
        }
        int max=-1;
        int idx=-1;
        for(int i=0;i<n;i++){
            if(dp[i][0]>max){
                max=dp[i][0];
                idx=i;
            }
        }
        List<String> res=new ArrayList<>();
        while(idx!=-1){
            res.add(words[idx]);
            idx=dp[idx][1];
        }
        Collections.reverse(res);
        return res;

    }
}