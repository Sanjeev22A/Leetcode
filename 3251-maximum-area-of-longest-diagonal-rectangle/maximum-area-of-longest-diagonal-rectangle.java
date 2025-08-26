class Solution {
    int diag(int a,int b){
        return a*a+b*b;
    }
    int area(int a,int b){
        return a*b;
    }
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int bestArea=-1,bestDiag=-1;
        for(int[] a:dimensions){
            int d=diag(a[0],a[1]);
            int ar=area(a[0],a[1]);
            if(d>bestDiag){
                bestDiag=d;
                bestArea=ar;
            }
            if(d==bestDiag){
                bestArea=Math.max(ar,bestArea);
            }
        }
        return bestArea;
    }
}