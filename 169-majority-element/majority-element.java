class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> count=new HashMap<>();
        int max=0;
        int elem=-1;
        for(int a:nums){
            count.put(a,count.getOrDefault(a,0)+1);
            if(max<count.get(a)){
                max=count.get(a);
                elem=a;
            }
            max=Math.max(max,count.get(a));
        }
        if(max>nums.length/2){
            return elem;
        }
        return -1;

    }
}