class Solution {
    public int findKthPositive(int[] arr, int k) {
        Set<Integer> s=new HashSet<>();
        for(int a:arr){
            s.add(a);
        }
        int j=0;
        for(int i=1;i<1001+k;i++){
            if(!s.contains(i)){
                j++;
            }
            if(j==k){
                return i;
            }
        }
        return -1;
    }
}