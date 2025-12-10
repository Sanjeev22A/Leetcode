class Solution {
    // Lets understand the trick here, only the Root (0th) element is open. If all other component must be opened this Root must be the least, if some other element is less than root we cant open it as we wont satisfy the opening condition
    int mod=(int)Math.pow(10,9)+7;
    int fact(int n){
        int ans=1;
        for(int i=n;i>=1;i--){
            ans=(int)(((long)ans*i)%mod);
        }
        return ans%mod;
    }
    public int countPermutations(int[] complexity) {
        int root=complexity[0];
        for(int i=1;i<complexity.length;i++){
            if(root>=complexity[i]){
                return 0;
            }
        }
        return fact(complexity.length-1);
    }
}