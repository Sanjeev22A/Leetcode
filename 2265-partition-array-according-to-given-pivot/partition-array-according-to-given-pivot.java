class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] result=new int[nums.length];
        int lesser=0,greater=nums.length-1;
        for(int a:nums){
            if(a<pivot){
                result[lesser++]=a;
            }else if(a>pivot){
                result[greater--]=a;
            }
        }
        for(int i=lesser;i<=greater;i++){
            result[i]=pivot;
        }
        for(int i=greater+1,j=nums.length-1;i<j;i++,j--){
            int temp=result[i];
            result[i]=result[j];
            result[j]=temp;
        }
        return result;
    }
}