class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> s=new HashSet<>();
        for(int a:nums){
            if(s.contains(a)){
                return a;
            }
            s.add(a);
        }
        return -1;
    }
}