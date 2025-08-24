class Solution {
    int min(int[] arr){
        int a=Integer.MAX_VALUE;
        for(int b:arr){
            a=Math.min(a,b);
        }
        return a;
    }
    public int minNumber(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        for(int a:nums1){
            set.add(a);
        }
        int min=Integer.MAX_VALUE;
        for(int a:nums2){
            if(set.contains(a)){
                min=Math.min(a,min);
            }
        
        }
        if(min!=Integer.MAX_VALUE){
            return min;
        }
        int min1=Integer.MAX_VALUE,min2=Integer.MAX_VALUE;
        min1=min(nums1);
        min2=min(nums2);
        
        if(min1>min2){
            int temp=min1;
            min1=min2;
            min2=temp;
        }
        return min1*10+min2;
    }
}