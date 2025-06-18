class Solution {
    public int thirdMax(int[] nums) {
        int max=Integer.MIN_VALUE;
        int second_max=Integer.MIN_VALUE;
        int third_max=Integer.MIN_VALUE;
        boolean key=false;
        HashSet<Integer> set=new HashSet<>();
        for(int a:nums){
            set.add(a);
            if(a==Integer.MIN_VALUE){
                key=true;
            }
            if(a>max){
                third_max=second_max;
                second_max=max;
                max=a;
        
            }
            else if(a>second_max && a<max){
                third_max=second_max;
                second_max=a;
            }else if(a>third_max && a<second_max){
                third_max=a;
            }
        }

        if(third_max==Integer.MIN_VALUE){
            if(key && set.size()>=3){
                return third_max;
            }
            return Math.max(second_max,max);
        }
        return third_max;
    }
}