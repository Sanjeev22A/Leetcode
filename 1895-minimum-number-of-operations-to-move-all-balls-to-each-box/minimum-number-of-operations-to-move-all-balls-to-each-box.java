class Solution {
    public int[] minOperations(String boxes) {
        int[] op=new int[boxes.length()];
        int i=0;
        for(char c:boxes.toCharArray()){
            if(c=='1'){
                for(int j=0;j<op.length;j++){
                    op[j]+=Math.abs(i-j);
                }
            }
            i++;
        }
        return op;
    }
}