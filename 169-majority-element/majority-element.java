class Solution {
    public int majorityElement(int[] nums) {
        //Using moore's voting algorithm
        int count=0,elem=-1;
        for(int a:nums){
            if(count==0){
                elem=a;
                count++;
            }else if(a==elem){
                count++;
            }else{
                count--;
            }
        }
        return elem;
    }
}