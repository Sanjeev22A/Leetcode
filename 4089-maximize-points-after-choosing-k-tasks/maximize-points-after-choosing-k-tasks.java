class Solution {
    public long maxPoints(int[] technique1, int[] technique2, int k) {
        long answer=0L;
        Integer[][] diff=new Integer[technique1.length][2];
        for(int i=0;i<technique1.length;i++){
            diff[i]=new Integer[]{technique1[i]-technique2[i],i};
        }
        Arrays.sort(diff,(a,b)->Integer.compare(b[0],a[0]));
        int i=0;
        for(;i<k;i++){
            answer+=technique1[diff[i][1]];
        }
        for(;i<technique1.length;i++){
            if(diff[i][0]>0){
                answer+=technique1[diff[i][1]];
            }else{
                answer+=technique2[diff[i][1]];
            }
        }
        return answer;
    }
}