class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        HashSet<Integer> prefix=new HashSet<>();
        Map<Integer,Integer> suffix=new HashMap<>();

        for(int a:nums){
            suffix.put(a,suffix.getOrDefault(a,0)+1);
        }
        
        int[] result=new int[nums.length];
        int i=0;
        for(int a:nums){
            prefix.add(a);
            suffix.put(a,suffix.get(a)-1);
            if(suffix.get(a)==0){
                suffix.remove(a);
            }
            result[i++]=prefix.size()-suffix.size();
        }

        return result;
    }
}