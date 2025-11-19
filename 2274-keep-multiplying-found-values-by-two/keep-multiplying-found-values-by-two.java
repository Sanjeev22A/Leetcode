class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> s=new HashSet<>();
        for(int a:nums){
            s.add(a);
        }
        while(s.contains(original)){
            original*=2;

        }
        return original;
    }
}