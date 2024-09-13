class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> arr=new HashSet<>();
        for(int num:nums){
            if(arr.contains(num)){
                return true;
            }
            arr.add(num);
        }
        return false;
    }
}