class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> arr1=new ArrayList<>();
        List<Integer> arr2=new ArrayList<>();
        int top1=nums[0],top2=nums[1];
        arr1.add(top1);
        arr2.add(top2);
        for(int i=2;i<nums.length;i++){
            if(top1<=top2){
                top2=nums[i];
                arr2.add(top2);
            }else{
                top1=nums[i];
                arr1.add(top1);
            }
        }
        int i=0;
        for(int a:arr1){
            nums[i++]=a;
        }
        for(int a:arr2){
            nums[i++]=a;
        }
        return nums;
    }
}