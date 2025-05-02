class Solution {
    public String pushDominoes(String dominoes) {
        int n=dominoes.length();
        //We take right as positive
        //We take left as negative
        int[] left=new int[n];
        int[] right=new int[n];
        //Right account
        int force=0;
        for(int i=0;i<n;i++){
            if(dominoes.charAt(i)=='R'){
                force=n;
                right[i]=force;
            }
            else if(dominoes.charAt(i)=='L'){
                force=0;
            }
            else{
                force=Math.max(force-1,0);
                right[i]=force;
            }
        }
        force=0;
        for(int i=n-1;i>=0;i--){
            if(dominoes.charAt(i)=='L'){
                force=-n;
                left[i]=force;
            }
            else if(dominoes.charAt(i)=='R'){
                force=0;
            }
            else{
                force=Math.min(0,force+1);
                left[i]=force;
            }
        }
        StringBuilder res=new StringBuilder();
        for(int i=0;i<n;i++){
            int cur=left[i]+right[i];
            if(cur<0){
                res.append('L');
            }
            else if(cur>0){
                res.append('R');
            }else{
                res.append('.');
            }
        }
        return res.toString();
    }
}