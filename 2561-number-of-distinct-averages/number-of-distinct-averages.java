class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Double> s=new HashSet<>();
        int start=0,end=nums.length-1;
        int count=0;
        while(start<end){
            int a=nums[start];
            int b=nums[end];
            double avg=((double)a+(double)b)/2;
            if(!s.contains(avg)){
                s.add(avg);
                count++;
            }
            start++;
            end--;

        }
        return count;
    }
}