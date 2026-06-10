class Solution {
    long operate(int[] arr,BinaryOperator<Long> func){
        if(arr==null || arr.length==0){
            return 0L;
        }
        long val=arr[0];
        for(int a:arr){
            val=func.apply((long)a,val);
        }
        return val;
    }
    long max(int[] arr){
        return operate(arr,Math::max);
    }

    long min(int[] arr){
        return operate(arr,Math::min);
    }
    public long maxTotalValue(int[] nums, int k) {
        
        long max=max(nums);
        long min=min(nums);
        return (long)k*(max-min);
    }
}