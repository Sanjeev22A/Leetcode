class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int ans=0;
        ans=ans+Math.min(numOnes,k);
        
        k=Math.max(0,k-numOnes);
        //System.out.println(k);
        k=Math.max(0,k-numZeros);
        //System.out.println(k);
        ans=ans+Math.max(numNegOnes*-1,k*-1);

        return ans;
    }
}