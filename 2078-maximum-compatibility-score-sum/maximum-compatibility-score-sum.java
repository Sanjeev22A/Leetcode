class Solution {
    int[][] score;
    int maxVal;
    Map<Integer,Integer> memo;
    int dp(int studentUsed,int mentorUsed,int m){
        int key=(studentUsed<<m)+mentorUsed;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        if(studentUsed==maxVal || mentorUsed==maxVal){
            memo.put(key,0);
            return 0;
        }
        int maxScore=0;
        for(int i=0;i<m;i++){
            if((studentUsed & 1<<i) !=0){
                continue;
            }
            for(int j=0;j<m;j++){
                if((mentorUsed & 1<<j)==0){
                    int temp1=studentUsed | 1<<i;
                    int temp2=mentorUsed | 1<<j;
                    int curScore=this.score[i][j]+dp(temp1,temp2,m);
                    maxScore=Math.max(curScore,maxScore);
                }
            }
        }
        memo.put(key,maxScore);
        return maxScore;
    }
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        memo=new HashMap<>();
        int m=students.length;
        this.score=new int[m][m];
        maxVal=(1<<m)-1;
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                int val=0;
                for(int k=0;k<students[i].length;k++){
                    if(students[i][k]==mentors[j][k]){
                        val++;
                    }
                }
                score[i][j]=val; 
            }
        }

        return dp(0,0,m);
       
    }
}