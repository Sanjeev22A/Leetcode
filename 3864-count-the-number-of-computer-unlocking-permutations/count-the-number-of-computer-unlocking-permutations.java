class Solution {
    long mod = (int)1e9 + 7;
    long factorial(int n){
        long pr=1;
        for(int i=1;i<=n;i++){
            pr=(pr*i)%mod;
        }
        return pr%mod;
    }
    public int countPermutations(int[] complexity) {
        int root=complexity[0];
        int n=complexity.length;
        for(int i=1;i<complexity.length;i++){
            if(root>=complexity[i]){
                return 0;
            }
        }

        return (int)factorial(n-1);

    }
}