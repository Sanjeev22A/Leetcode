class Solution {
    int log(int n){
        int i=0;
        while(n>0){
            n>>=1;
            i++;
            System.out.println(n+":"+i);
        }
        return i;
    }
    int pow(int a){
        return 1<<a;
    }
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int a=log(n);
        System.out.println(a);
        return pow(a);
    }
}