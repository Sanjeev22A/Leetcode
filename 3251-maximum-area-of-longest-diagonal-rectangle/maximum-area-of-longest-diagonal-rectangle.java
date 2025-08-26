class Solution {
    int diag(int a,int b){
        return a*a+b*b;
    }
    public int areaOfMaxDiagonal(int[][] dimensions) {
        Arrays.sort(dimensions,(a,b)->{
            int v1=diag(a[0],a[1]);
            int v2=diag(b[0],b[1]);
            int v3=a[0]*a[1];
            int v4=b[0]*b[1];
            if(v1!=v2){
                return v2-v1;
            }
            else{
                return v4-v3;
            }
        });
        return dimensions[0][0]*dimensions[0][1];
    }
}