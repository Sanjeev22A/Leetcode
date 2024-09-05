class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum=0,m=rolls.length;
        for(int roll:rolls){
            sum+=roll;
        }
        int total=(mean)*(n+m);
        int rem=total-sum;
        double remAvg=(double)(rem)/n;
        if(remAvg>6 || rem<n){
            return new int[0];
        }
        else{
            int arr[]=new int[n];
            int quotient=rem/n;
            int reminder=rem%n;
            for(int i=0;i<n;i++){
                arr[i]+=quotient;
                if(reminder>0){
                    arr[i]+=1;
                    reminder--;
                }
            }
            return arr;
        }
    }
}